package book_guide.exercises;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class PaintJob {
    static Scanner SC = new Scanner(System.in);
    static DecimalFormat twoDecimal = new DecimalFormat("#,##0.00");

    public static void main(String[] args) {
        int numberRooms;    
        double pricePerGallon;
        
        System.out.print("Enter the number of room(s): ");
        numberRooms = SC.nextInt();
        
        System.out.print("Enter the price of paint per gallon: $");
        pricePerGallon = SC.nextDouble();
        
        int totalWallSpace = 0;
        for(int i = 0; i < numberRooms; i++) {
            int roomNum = i+1;
            System.out.print("Enter the square feet of room # " + roomNum + ": ");
            double wallSpacePerRoom = SC.nextDouble();
            totalWallSpace += wallSpacePerRoom;
        }
        System.out.println("Total square feet: " + totalWallSpace);
        displayData(totalWallSpace, pricePerGallon);
        
    }
    
    public static void displayData(double totalWallSpace, double costOfPaint) {
        System.out.println();
        double numberOfGallonsReq = getNumberOfGallonsReq(totalWallSpace);
        double numberOfHoursReq = getNumberOfHoursReq(numberOfGallonsReq);
        double priceOfPaint = getCostOfPaint(numberOfGallonsReq, costOfPaint);
        double laborCharges = getLaborCharges(numberOfHoursReq);
        double totalCost = priceOfPaint + laborCharges;
        
        System.out.println("The number of gallons of paint required: " + twoDecimal.format(numberOfGallonsReq));
        System.out.println("The number of hours of labor required: " + twoDecimal.format(numberOfHoursReq));
        System.out.println("The cost of the paint: " + twoDecimal.format(priceOfPaint));
        System.out.println("The labor charges: " + twoDecimal.format(laborCharges));
        System.out.println("The total cost of the paint job: " + twoDecimal.format(totalCost));
    }
    
    public static double getNumberOfGallonsReq(double totalSquareFeet) {
        return totalSquareFeet / 115.00;
    }
    
    public static double getNumberOfHoursReq(double numGallonsReq) {
        return numGallonsReq * 8.00;
    }
    
    public static double getCostOfPaint(double numGallonsReq, double costOfPaint) {
        return numGallonsReq * costOfPaint;
    }
    
    public static double getLaborCharges(double hoursReq) {
        return hoursReq * 18.00;
    }
    
    public static double getTotalCost(double costOfPaint, double laborCharges) {
        return costOfPaint + laborCharges;
    }
}
