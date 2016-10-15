package book_guide.exercises;

import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class DistanceConversion {

    public static void main(String[] args) {
        System.out.println("Enter a distance in meters.");
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        double meters = sc.nextDouble();
        int menuNum;
        do {
            System.out.println();
            System.out.println("Please choose from the following menu:");
            String menu = "1. Convert to kilometers" + "\n";
            menu += "2. Convert to inches" + "\n";
            menu += "3. Convert to feet" + "\n";
            menu += "4. Quit the program";
            System.out.println(menu);

            System.out.print("> ");
            menuNum = sc.nextInt();

            runConversion(menuNum, meters);
        } while (menuNum != 4);
    }

    private static void runConversion(int menuNum, double meters) {
        if (menuNum == 1) {
            showKilometers(meters);
        } else if (menuNum == 2) {
            showInches(meters);
        } else if (menuNum == 3) {
            showFeet(meters);
        } else if (menuNum == 4) {
            System.out.println("Bye!");
            System.exit(0);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

    }

    private static void showKilometers(double meters) {
        double kilometers = meters * 0.001;
        System.out.println(meters + " meters is " + kilometers + " kilometers");
    }

    private static void showInches(double meters) {
        double inches = meters * 39.37;
        System.out.println(meters + " meters is " + inches + " inches");
    }

    private static void showFeet(double meters) {
        double feet = meters * 3.281;
        System.out.println(meters + " meters is " + feet + " feet");
    }
}
