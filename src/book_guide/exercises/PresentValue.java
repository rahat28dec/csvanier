package book_guide.exercises;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class PresentValue {

    public static void main(String[] args) {
        System.out.println(presentValue(10000, 1.0, 12));
    }

    public static double presentValue(double futureVal, double interestRate, int numYears) {
        return futureVal / Math.pow(1 + interestRate, numYears);
    }
}
