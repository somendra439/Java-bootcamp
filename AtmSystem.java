package org.example;


import java.sql.*;
import java.util.Scanner;

public class AtmSystem
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_sgvu";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Somu@000";

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Welcome to the ATM System");
            while (true)
            {
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                if (choice == 1)
                {
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    if (login(connection, username, password))
                    {
                        System.out.println(" login success ");
                        userMenu(connection, username);

                    } else {
                        System.out.println("Invalid credentials. Try again.");
                    }
                } else if (choice == 2) {
                    System.out.println("Thank you for using the ATM System.");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static boolean login(Connection connection, String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void userMenu(Connection connection, String username) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance(connection, username);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(connection, username, withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if(depositAmount <= 40000)
                    {
                        deposit(connection, username, depositAmount);
                    }
                    else
                    {
                        System.out.println(" deposit limit is 40000 only, please  ");
                    }
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance(Connection connection, String username) {
        try {
            String query = "SELECT balance FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                System.out.println("Your balance is: Rs. " + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void withdraw(Connection connection, String username, double amount) {
        try {
            connection.setAutoCommit(false);
            String query = "UPDATE users SET balance = balance - ? WHERE username = ? AND balance >= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, username);
            preparedStatement.setDouble(3, amount);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully withdrew: Rs. " + amount);
            } else {
                System.out.println("Insufficient funds.");
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private static void deposit(Connection connection, String username, double amount) {
        try {
            String query = "UPDATE users SET balance = balance + ? WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

            System.out.println("Successfully deposited: Rs. " + amount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
