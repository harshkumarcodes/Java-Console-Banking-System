CREATE DATABASE banking_system;
USE banking_system;

CREATE TABLE accounts (
    account_number INT PRIMARY KEY AUTO_INCREMENT,
    account_holder VARCHAR(100) NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    balance DOUBLE NOT NULL DEFAULT 0.0
);

-- Optional: Insert a dummy account for testing
INSERT INTO accounts (account_holder, account_type, balance) VALUES ('Harsh Kumar', 'Savings', 5000.0);
