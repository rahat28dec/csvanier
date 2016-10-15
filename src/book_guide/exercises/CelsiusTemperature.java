package book_guide.exercises;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class CelsiusTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many times you would like to run this program?");
        int n_t = sc.nextInt();         // number of iterations
        int[] f_l = new int[n_t];       // fahrenheit list
        double[] c_l = new double[n_t]; // celsius list
        for(int i = 0; i < n_t; i++) {
            int num = i+1;
            System.out.print("Enter fahrenheit " + num + ": ");
            int fahrenheit = sc.nextInt();
            f_l[i] = fahrenheit;
            c_l[i] = celsius(fahrenheit);
        }
        displayTable(f_l, c_l);
    }
    
    public static double celsius(int f) {
        return 0.56 * (f - 32);
    }
    
    public static void displayTable(int[] f_l, double[] c_l) {
        System.out.println();
        System.out.println("Number"+"\t"+"Fahrenheit" + "\t" + "Celsius");
        for(int i = 0; i < f_l.length; i++) {
            int num = i+1;
            // Use String.format instead of decimal format: 
            // String.format("%,2.2f, arg")
            System.out.println(String.valueOf(num) + "\t" + f_l[i] + "\t\t" + String.format("%,2.2f", c_l[i]) + "\n");
        }
    }
}
