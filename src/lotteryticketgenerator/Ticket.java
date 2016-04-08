package lotteryticketgenerator;

import java.util.ArrayList;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class Ticket {
    private final String ownerName;
    private final int numSelection;
    ArrayList<Selection> userSelection;
    private Selection winner;
    
    /**
     * Returns the winning draw 
     * generated from selection 
     * class.
     * @return 
     */
    public Selection winningDraw() {
        return this.winner;
    }
    /**
     * Set the winning draw from the
     * main.
     * @param winner 
     */
    public void setWinningDraw(Selection winner) {
        this.winner = winner;
    }
    /**
     * Default constructor with
     * Selection class default
     * values.
     * @param ownerName
     * @param k
     */
    public Ticket(String ownerName, int k) {
        this(ownerName, k, 6, 1, 49);
    }    

    /**
     * Generates a list of Selection one per line, 
     * depends on the user number of selection(s).
     * @param ownerName
     * @param k size of Selection
     * @param n number of elements
     * @param low min integer in the selection
     * @param high max integer in the selection
     */
    public Ticket(String ownerName, int k, int n, int low, int high) {
        //initialize the size of Ticket
        this.userSelection = new ArrayList(k);
        this.ownerName = ownerName;
        this.numSelection = k;
        for(int i = 0; i < this.numSelection; i++) {
            /**
             * Make a new selection based on
             * the number of selection
             * given by the user.
             */
            this.userSelection.add(new Selection(n,low,high));
        }
    }
    
     
    
    /**
     * Return the summary of prizes.
     * Each selection prizes computed
     * here and printed.
     * @return 
     */
    public String summaryPrizes() {
        double prize;
        String output;
        output = "Selection(s)" + "\t\t" + "Prize" + "\n";
        output += "-----------" + "\t\t" + "-----" + "\n";
        for (int i = 0; i < this.userSelection.size(); i++) {
            prize = this.userSelection.get(i).match(this.winner);
            
            output += this.userSelection.get(i) + "\t$";
            output += String.format("%,2.2f", this.computePrize(prize)) + "\n";
        }
        
        return output;
    }
    
     public double totalPrize() {
        double total = 0.0;
        double prize;
        for (int i = 0; i < this.userSelection.size(); i++) {
            prize = this.userSelection.get(i).match(this.winner);
            total += this.computePrize(prize);
        }
        return total;
    }
    
    /**
     * The prizes are computed by 
     * the formula: m * 10^m.
     * @param p
     * @return 
     */
    public double computePrize(double p) {
        return  p * Math.pow(10, p);
    }
    
    /**
    * Header output
    */
    public void header() {
        System.out.println("Payout Prize Result");
        System.out.println("-------------------");
        System.out.println("Ticket owner: " + this.ownerName);
        System.out.println("Selection(s): " + this.numSelection);
        System.out.println("Winning draw: " + this.winner);
        System.out.println("Total prize: $" + this.totalPrize() + "\n");
        System.out.println("Summary of prizes: " + "\n");
    }
    
    @Override
    public String toString() {
        return this.stringRepresentation();
    }
    
    public String stringRepresentation(){
        String output = "";
        this.header();
        
        output += this.summaryPrizes();
        return output;
    }
    





    
    

}
