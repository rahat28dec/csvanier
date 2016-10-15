package book_guide.exercises;

import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class FreezingBoilingDemo {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        FreezingBoiling fb = new FreezingBoiling();
        System.out.print("Enter the temperature: ");
        int temp = sc.nextInt();
        fb.setTemperature(temp);
        if(fb.isEthylFreezing()) {
            System.out.println("The ethyl will freeze"); 
        }
        if(fb.isEthylBoiling()) {
            System.out.println("The ethyl will boil"); 
        }
        if(fb.isOxygenBoiling()) {
            System.out.println("The oxygen will boil"); 
        }
        if(fb.isOxygenFreezing()) {
            System.out.println("The oxygen will freeze"); 
        }
        if(fb.isWaterBoiling()) {
            System.out.println("The water will boil"); 
        }
        if(fb.isWaterFreezing()) {
            System.out.println("The water will freeze"); 
        }
        
        
    }
}
