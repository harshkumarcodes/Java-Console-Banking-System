package src;

import java.sql.*;

public class BankDAO {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/banking_system";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // Apne local DB ka password yaha assume kar lena

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Decoupled function for Deposit
    public void deposit(int accountNumber, double amount) {
        String query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountNumber);
            int rows = pstmt.executeUpdate();
            
            if (rows > 0) {
                System.out.println("✅ Deposit successful! Amount: ₹" + amount);
            } else {
                System.out.println("❌ Account not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Decoupled function for Withdrawal
    public void withdraw(int accountNumber, double amount) {
        String checkQuery = "SELECT balance FROM accounts WHERE account_number = ?";
        String updateQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            
            checkStmt.setInt(1, accountNumber);
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");
                if (currentBalance >= amount) {
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setDouble(1, amount);
                        updateStmt.setInt(2, accountNumber);
                        updateStmt.executeUpdate();
                        System.out.println("✅ Withdrawal successful! Amount: ₹" + amount);
                    }
                } else {
                    System.out.println("❌ Insufficient balance!");
                }
            } else {
                System.out.println("❌ Account not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch Balance
    public void checkBalance(int accountNumber) {
        String query = "SELECT * FROM accounts WHERE account_number = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                SavingsAccount acc = new SavingsAccount(
                        rs.getInt("account_number"),
                        rs.getString("account_holder"),
                        rs.getDouble("balance"),
                        4.0 // Assuming 4% standard interest
                );
                acc.displayAccountDetails();
            } else {
                System.out.println("❌ Account not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
