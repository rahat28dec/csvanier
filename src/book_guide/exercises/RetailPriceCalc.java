package book_guide.exercises;

import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class RetailPriceCalc {
    public static void main(String[] args) {
        asks();
    }
    public static void asks() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item's wholesale cost: ");
        double itemCost = sc.nextDouble();
        System.out.print("Enter its markup percentage: ");
        int markup = sc.nextInt();
        System.out.println(calculateRetail(itemCost, markup));
    }
    
    public static double calculateRetail(double cost, int markup) {
        // revenue = cost + cost * markup / 100
        return cost + cost * markup / 100;
    }
}
