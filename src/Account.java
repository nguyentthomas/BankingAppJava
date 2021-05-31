import java.util.Scanner;

public class Account {
    //Class Variables
    double balance;
    double previousTransaction;
    String customerName;
    String customerID;

    //Class Constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //Function for Depositing Money
    void deposit(double amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Method for withdrawing money
    void withdraw(double amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //Function showing previous transaction(s)?
    //TODO: Make it into a log of previous transactions
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0 ) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    //Function calculateInterest()
    void calculateInterest(int years){
        double interestRate = .0185; //e.g. 1.85% p.a.
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    //Function showing the main menu
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + " !. (ID: #" + customerID + ")");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A: Check Account Balance");
        System.out.println("B: Deposit Funds");
        System.out.println("C: Withdraw Funds");
        System.out.println("D: View Previous Transaction"); //TODO: Show log of transactions or another feature
        System.out.println("E: Interest Calculator");
        System.out.println("F: Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                //Case A: allows user to check account balance
                case 'A':
                    System.out.println();
                    System.out.println("-------------------");
                    System.out.println("You selected A: Check Account Balance");
                    System.out.println();
                    System.out.println("This account's current balance = $" + balance);
                    System.out.println();
                    System.out.println("-------------------");
                    System.out.println();
                    break;

                    //Case B: deposits
                case 'B':
                    System.out.println("Enter amount to deposit:");
                    double amountDeposit = scanner.nextDouble();
                    deposit(amountDeposit);
                    System.out.println();
                    break;

                //Case C: withdraws
                case 'C':
                    System.out.println("Enter amount to withdraw:");
                    double amountWithdraw = scanner.nextDouble();
                    withdraw(amountWithdraw);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("-------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println();
                    System.out.println("Enter how many years of accrued interest");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    System.out.println();
                    break;

                case 'F':
                    System.out.println("==========================");
                    break;

                default:
                    System.out.println("Error: Invalid Option. Please enter A, B, C, D, E or F.");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us today!");
    }
}
