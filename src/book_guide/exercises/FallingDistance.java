package book_guide.exercises;

import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class FallingDistance {
    private static final double GRAVITY = 9.8;
    private static final double DISTANCE_CONSTANT = 0.5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            System.out.print("Enter object's falling time in seconds: ");
            int t = sc.nextInt();
            double fd = fallingDistance(t);
            System.out.println(fd + " meters");
        }
        
    }

    private static double fallingDistance(int t) {
        return DISTANCE_CONSTANT * GRAVITY * Math.pow(t, 2);
    }
    
    
}
