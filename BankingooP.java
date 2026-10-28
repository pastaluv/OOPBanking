import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class BankAccount {
    protected double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void displayDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        System.out.println("Date and Time: " + now.format(format));
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Successfully deposited: " + amount);
        checkBalance();
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
        displayDateTime();
    }
}

class ATM extends BankAccount {

    ATM(double balance) {
        super(balance);
    }

    void displayMenu() {
        System.out.println("\n=== ATM MACHINE ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(5000);
        int choice;
        double amount;

        do {
            atm.displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}