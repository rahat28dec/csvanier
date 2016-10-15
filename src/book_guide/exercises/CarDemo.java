package book_guide.exercises;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class CarDemo {
    public static void main(String[] args) {
        Car myCar = new Car(2010, "Toyota", 120);
        // accelerate
        for(int i = 0; i < 5; i++) {
            myCar.accelerate();
            System.out.println(myCar.getSpeed());
        }       
        
        System.out.println();
        
        // brake
        for(int i = 0; i < 5; i++) {
            myCar.brake();
            System.out.println(myCar.getSpeed());
        }
    }
}
