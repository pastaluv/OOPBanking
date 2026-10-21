
import java.util.Scanner;

class ATM {
    double balance = 5000.00;

    void checkBalance() {
        System.out.println("\nCurrent Balance: PHP " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Successfully deposited PHP " + amount);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrawn PHP " + amount);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATM myATM = new ATM();
        int choice;

        do {
            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    myATM.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: PHP ");
                    double depositAmount = input.nextDouble();
                    myATM.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: PHP ");
                    double withdrawAmount = input.nextDouble();
                    myATM.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        input.close();
        
        //oeujfjf
    }
}
