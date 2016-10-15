package savings_account;

/**
 *
 * @author RAYMARTHINKPAD
 */
import javax.swing.JOptionPane; // For the JOptionPane class
import java.text.DecimalFormat; // For the DecimalFormat class

/**
 * This program demonstrates the BankAccount class.
 */
public class SavingsAccountDemo {

    public static void main(String[] args) {

        double totalDeposit = 0.0;
        double totalWithdraw = 0.0;
        double interest = 0.0;

        int count = 0;
        int i;

        // Create a DecimalFormat object for displaying dollars.
        DecimalFormat dollar = new DecimalFormat("#,###.00");

        // Get annual int. rate
        String strInterestRate = JOptionPane.showInputDialog("Enter annual interest rate as percent: ");
        double rate = Double.parseDouble(strInterestRate);

        // Get the starting balance.
        String strBalance = JOptionPane.showInputDialog("Enter starting balance: ");
        double startBalance = Double.parseDouble(strBalance);

        // Create a BankAccount object.
        SavingsAccount account = new SavingsAccount(startBalance);

        // Get number of months.
        String strMonths = JOptionPane.showInputDialog(null, "Enter number of months since account opened: ");
        int numMonths = Integer.parseInt(strMonths);

        JOptionPane.showMessageDialog(null, "\nYou will be asked to enter\n"
                + "deposit and withdrawal for each month\n"
                + "for " + strMonths + " months.\n");

        account.setInterestRate(rate);

        for (i = 1; i <= numMonths; i++) {
            count++;

            // Get the amount of pay.
            String strDeposit = JOptionPane.showInputDialog("Enter deposit for month-" + count + ": ");
            double deposit = Double.parseDouble(strDeposit);
            account.doDeposit(deposit);

            // Withdraw some cash from the account.
            String strWithdraw = JOptionPane.showInputDialog("Enter withdrawal for month-" + count + ": ");
            double withdraw = Double.parseDouble(strWithdraw);
            account.doWithdrawal(withdraw);

            interest = account.addInterest();

            totalDeposit += deposit;
            totalWithdraw += withdraw;

            JOptionPane.showMessageDialog(null, "\nFor month-" + count + ":\n"
                    + "Deposit is: $" + dollar.format(deposit)
                    + "\nWithdrawal is: $" + dollar.format(withdraw)
                    + "\nMonth interest is: $" + dollar.format(interest)
                    + "\nBalance is: $" + dollar.format(account.getBalance()));
            System.out.println();

        }
        
        double endingBalance = account.getBalance();
        double b = interest + account.addInterest();

        JOptionPane.showMessageDialog(null, "For " + strMonths + " month" + "\n"
                + "Ending balance is: $" + dollar.format(endingBalance) + "\n"
                + "Total for deposit is: $" + dollar.format(totalDeposit) + "\n"
                + "Total for withdrawal is: $" + dollar.format(totalWithdraw) + "\n"
                + "Total for interest is: $" + dollar.format(b));        //$21.60

        count++;
        System.exit(0);
    }
}
