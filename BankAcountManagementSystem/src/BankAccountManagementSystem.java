import java.util.Scanner;

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some accounts
        CheckingAccount checking = new CheckingAccount("CHK123", 1000, 200);
        SavingsAccount savings = new SavingsAccount("SAV456", 2000, 0.03);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Deposit to Checking"); 
            System.out.println("2. Withdraw from Checking");
            System.out.println("3. Deposit to Savings");
            System.out.println("4. Apply Interest to Savings");
            System.out.println("5. Exit"); 
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    checking.deposit(depositAmount);
                }
                case 2 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    try {
                        checking.withdraw(withdrawalAmount);
                    } catch (InsufficientFundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Enter deposit amount: ");
                    double savingsDeposit = scanner.nextDouble();
                    savings.deposit(savingsDeposit);
                }
                case 4 -> savings.applyInterest();
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }
}