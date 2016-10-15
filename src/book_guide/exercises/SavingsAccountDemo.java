package book_guide.exercises;

import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class SavingsAccountDemo {

    static Scanner input = new Scanner(System.in);
    static double startBalance;
    static double annualInterestRate;
    static int months;

    public static void main(String[] args) {
        double depositAmount;
        double withdrawAmount;

        prompt();

        SavingsAccount sa = new SavingsAccount(startBalance, annualInterestRate);
        for (int i = 1; i <= months; i++) {

            System.out.print("Enter amount to deposit for the month " + i + ":$");
            depositAmount = input.nextDouble();
            sa.deposit(depositAmount);

            System.out.print("Enter amount to withdraw for the month " + i + ":$");
            withdrawAmount = input.nextDouble();
            sa.withdraw(withdrawAmount);

            sa.addMontlyInterest();
        }
        System.out.println();
        System.out.println(displayData(sa));
    }

    public static String displayData(SavingsAccount sa) {
        // EndingBalance = ((TotalDeposited + startingBalance) - (totalWithdrawn)) + interestEarned. 
        String output = "The ending balance is: $" + String.format("%.2f", sa.getBalance()) + "\n";
        output += "The amount of deposits: $" + String.format("%.2f", sa.getTotalDeposits()) + "\n";
        output += "The amount of withdrawals: $" + String.format("%.2f", sa.getTotalWithdrawals()) + "\n";
        output += "Total interest earned: $" + String.format("%.2f", sa.getTotalInterests());
        return output;
    }

    public static void prompt() {
        System.out.print("Enter starting balance: $");
        startBalance = input.nextDouble();

        System.out.print("Enter annual interest rate as percent: ");
        annualInterestRate = input.nextDouble();

        System.out.print("Enter the number of months since the account is opened: ");
        months = input.nextInt();
    }
}
