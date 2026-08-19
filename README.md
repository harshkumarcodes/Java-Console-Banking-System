# Java Console Banking System 🏦

A modular financial backend simulation built with Core Java and MySQL. This project demonstrates structured Object-Oriented Programming (OOPs) system designs and database integration using JDBC.

## 🚀 Features & Technical Highlights
* **Object-Oriented Programming:** Implemented strict data security using access modifiers and extended core banking instruments (e.g., `SavingsAccount`) via Inheritance.
* **Decoupled Architecture:** Separated financial workflows (deposits, withdrawals) into a DAO (`BankDAO.java`) to keep the driver application loop optimized and clean.
* **Database Synchronization:** Integrated **JDBC** to safely synchronize live runtime application states with a relational **MySQL** database architecture.

## 🛠️ Tech Stack
* **Language:** Java (Core Java, OOPs)
* **Database:** MySQL
* **API:** JDBC (Java Database Connectivity)

## ⚙️ How to Run
1. Run the SQL script provided in `database.sql` in your MySQL environment to set up the schema.
2. Add the `mysql-connector-j.jar` file to your project dependencies.
3. Update the database credentials (`USER` and `PASSWORD`) in `BankDAO.java`.
4. Run `Main.java` to start the console application execution loop.
