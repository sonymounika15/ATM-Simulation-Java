import java.util.Scanner;

class ATM {

    private double balance;
    private int pin;

    ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
            System.out.println("New Balance: ₹" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash.");
            System.out.println("Remaining Balance: ₹" + balance);
        }
    }
}

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATM atm = new ATM(10000, 1234);

        System.out.println("================================");
        System.out.println("       ATM SIMULATION");
        System.out.println("================================");

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (!atm.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN.");
            System.out.println("Transaction cancelled.");
            sc.close();
            return;
        }

        System.out.println("Login successful!");

        int choice;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}