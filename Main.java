//importing required classes and packages
import java.util.Scanner;

//Bank Account class
class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    //constructor
    public BankAccount(String accountNumber, String ownerName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialDeposit;
    }

    //Deposit method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Your new balance is: " + balance);
    }

    //Withdraw method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: " + balance);
        }
    }

    //Check balance method
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            //Display options
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit funds");
            System.out.println("3. Withdraw");
            System.out.println("4. Check account balance");
            System.out.println("5. Exit.");
            System.out.print("Choose an option: ");
            
            //Capture user's option
            int choice = scanner.nextInt();

            switch (choice) {
                //Create account option selected
                case 1:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.next();
                    System.out.print("Enter owner name: ");
                    String owner = scanner.next();
                    System.out.print("Enter initial deposit: ");
                    double deposit = scanner.nextDouble();
                    account = new BankAccount(accNum, owner, deposit);
                    System.out.println("Account created successfully. Your account number is: " + accNum);
                    break;

                //Deposit money option
                case 2:
                    if (account != null) {
                        System.out.print("Enter your deposit ammount: ");
                        double depAmount = scanner.nextDouble();
                        account.deposit(depAmount);
                    }
                    else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                //Withdraw money option
                case 3:
                    if (account != null) {
                        System.out.print("Enter your withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                //Check balance option
                case 4:
                    if (account != null) {
                        account.checkBalance();
                    }
                    else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                //Exit option
                case 5:
                    System.out.println("Thank you for using our banking system!");
                    scanner.close();
                    return;

                //Catch invalid options
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
