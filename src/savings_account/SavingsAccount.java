package savings_account;

/**
 *
 * @author RAYMARTHINKPAD
 */
/**
   The BankAccount class simulates a bank account.
*/

public class SavingsAccount
{
   private double balance;      // Account balance
   private double interestRate;
   private double totalInterest;

   public SavingsAccount(double startBalance)
   {
      balance = startBalance;
   }

   public void setInterestRate(double b)
   {
	  interestRate = b;
   }


   public void doDeposit(double amounta)
   {
      balance += amounta;
   }

   public void doWithdrawal(double amount)
   {
      balance -= amount;
   }

   public double addInterest()
   {
	   totalInterest = balance * ((interestRate/100)/12);
	   balance += totalInterest;
	   return totalInterest;
   }

   public double getBalance()
   {
      return balance;
   }
}
