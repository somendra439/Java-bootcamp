import java.util.Scanner;

public class AtmSystem {
    static int pin = 4321;
    static double userAccountBalance = 10000;
    static double atmMachineBalance = 5000;  // Assume ATM has 50,000 at the start
    static final double MAX_DEPOSIT_LIMIT = 50000;  // Maximum deposit limit per transaction

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your ATM PIN: ");

        if (sc.hasNextInt()) {
            int userPin = sc.nextInt();

            if (userPin == pin) {
                System.out.println("Welcome to ATM");
                boolean exit = false;

                while (!exit) {
                    System.out.println("Choose an option: ");
                    System.out.println("1. Withdraw");
                    System.out.println("2. Deposit");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Exit");
                    
                    if (sc.hasNextInt()) {
                        int option = sc.nextInt();

                        switch (option) {
                            case 1: 
                                handleWithdrawal(sc);
                                break;
                            case 2: 
                                handleDeposit(sc);
                                break;
                            case 3: 
                                System.out.println("User account balance: " + userAccountBalance);
                                System.out.println("ATM machine balance: " + atmMachineBalance);
                                break;
                            case 4: 
                                exit = true;
                                System.out.println("Thank you for using the ATM.");
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please select a numeric option.");
                        sc.next();
                    }
                }
            } else {
                System.out.println("Invalid PIN.");
            }
        } else {
            System.out.println("Invalid input. Please enter a numeric PIN.");
        }

        sc.close();
    }

    public static void handleWithdrawal(Scanner sc) {
        System.out.println("Please enter the amount to withdraw: ");
        if (sc.hasNextInt()) {
            int amount = sc.nextInt();
            if (amount > 0 && amount <= userAccountBalance && amount <= atmMachineBalance) {
                userAccountBalance -= amount;  // Update user account balance
                atmMachineBalance -= amount;   // Update ATM machine balance
                System.out.println("Amount withdrawn: " + amount);
                System.out.println("Please collect your money.");
                System.out.println("Withdrawal successful. Remaining user balance: " + userAccountBalance);
                System.out.println("Remaining ATM balance: " + atmMachineBalance);
            } else if (amount > atmMachineBalance) {
                System.out.println("ATM has insufficient funds for this withdrawal.");
            } else if (amount > userAccountBalance) {
                System.out.println("Insufficient balance in your account.");
            } else {
                System.out.println("Invalid amount. Please enter a positive amount.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid amount.");
            sc.next(); 
        }
    }

    public static void handleDeposit(Scanner sc) {
        System.out.println("Please enter the amount to deposit (Maximum allowed is " + MAX_DEPOSIT_LIMIT + "): ");
        if (sc.hasNextInt()) {
            int amount = sc.nextInt();
            if (amount > 0 && amount <= MAX_DEPOSIT_LIMIT) {
                userAccountBalance += amount;  // Update user account balance
                atmMachineBalance += amount;   // Update ATM machine balance
                System.out.println("Amount deposited: " + amount);
                System.out.println("Deposit successful. New user balance: " + userAccountBalance);
                System.out.println("New ATM balance: " + atmMachineBalance);
            } else if (amount > MAX_DEPOSIT_LIMIT) {
                System.out.println("Deposit failed. Maximum deposit limit is " + MAX_DEPOSIT_LIMIT + ".");
            } else {
                System.out.println("Invalid amount. Please enter a positive amount.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid amount.");
            sc.next();
        }
    }
}