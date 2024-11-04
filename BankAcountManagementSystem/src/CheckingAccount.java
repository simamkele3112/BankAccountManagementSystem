/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author simam
 */
public class CheckingAccount extends Account {
    private final double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > (balance + overdraftLimit)) {
            throw new InsufficientFundsException("Withdrawal exceeds overdraft limit.");
        }
        balance -= amount;
        System.out.println("Checking Account: Withdrawn: " + amount + ", New Balance: " + balance);
    }
}
