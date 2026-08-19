package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankDAO bankDAO = new BankDAO(); // Decoupled Data Access Object
        boolean isRunning = true;

        System.out.println("🏦 Welcome to Java Console Banking System");

        while (isRunning) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    bankDAO.checkBalance(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int depAcc = scanner.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depAmt = scanner.nextDouble();
                    bankDAO.deposit(depAcc, depAmt);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int withAcc = scanner.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withAmt = scanner.nextDouble();
                    bankDAO.withdraw(withAcc, withAmt);
                    break;
                case 4:
                    System.out.println("Exiting System... Thank you for banking with us! 🚀");
                    isRunning = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}
