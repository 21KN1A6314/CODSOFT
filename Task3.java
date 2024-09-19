import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double checkBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        double balance = bankAccount.checkBalance();
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        try {
            double amount = scanner.nextDouble();
            if (bankAccount.withdraw(amount)) {
                System.out.printf("Successfully withdrew $%.2f.%n", amount);
            } else {
                System.out.println("Error: Insufficient funds or invalid amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        try {
            double amount = scanner.nextDouble();
            if (bankAccount.deposit(amount)) {
                System.out.printf("Successfully deposited $%.2f.%n", amount);
            } else {
                System.out.println("Error: Deposit amount must be greater than zero.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        }
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Please select an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial balance for your account: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.run();
    }
}
