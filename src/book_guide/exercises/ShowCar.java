package book_guide.exercises;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class ShowCar {
    public static void main(String[] args) {
        System.out.println(showCar("New York", 2));
    }
    public static String showCar(String str, int n) {
        return String.valueOf(str.charAt(n));
    }
}
