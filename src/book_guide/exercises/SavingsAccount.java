package book_guide.exercises;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class SavingsAccount {

    private double balance;
    private double annualInterestRate;
    private double totalInterests;
    private double totalWithdrawals;

    public SavingsAccount(double startingBalance, double annualInterestRate) {
        this.balance = startingBalance;
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(double amount) {
        totalDeposits += amount;
        balance += amount;
    }

    public void withdraw(double amount) {
        totalWithdrawals -= amount;
        balance -= amount;
    }

    public void addMontlyInterest() {
        double monthlyInterest = balance * ((annualInterestRate / 100) / 12);
        totalInterests += monthlyInterest;
        balance += monthlyInterest;
    }

    public double getBalance() {
        return balance;
    }

    public double getTotalInterests() {
        return totalInterests;
    }

    public double getTotalWithdrawals() {
        return totalWithdrawals;
    }

    public double getTotalDeposits() {
        return totalDeposits;
    }
    private double totalDeposits;

}
