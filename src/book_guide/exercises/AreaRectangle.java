package book_guide.exercises;

import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class AreaRectangle {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        double len = getLength();
        double width = getWidth();
        double area = getArea(len, width);
        displayData(len, width, area);
    }
    public static double getLength() {
        System.out.print("Enter the rectangle's length: ");
        return sc.nextDouble();
    }
    public static double getWidth() {
        System.out.print("Enter the rectangle's width: ");
        return sc.nextDouble();
    }
    public static double getArea(double len, double width) {
        return len*width;
    }
    public static void displayData(double len, double width, double area) {
        System.out.println("The length of the rectangle is " + len);
        System.out.println("The width of the rectangle is " + width);
        System.out.println("Its area is " + area);
    }
}
