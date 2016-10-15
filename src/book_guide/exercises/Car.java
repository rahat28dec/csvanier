package book_guide.exercises;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class Car {
    private int yearModel;
    private String make;
    private int speed;
    
    public Car(int yearModel, String make) {
        this.yearModel = yearModel;
        this.make = make;
        this.speed = 0;
               
    }
    
    public Car(int yearModel, String make, int speed) {
        this.yearModel = yearModel;
        this.make = make;
        this.speed = speed;
               
    }
    
    public int getYearModel() {
        return this.yearModel;
    }
    
    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }
    
    public String getMake() {
        return this.make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void accelerate() {
        this.speed += 5;
    }
    
    public void brake() {
        this.speed -= 5;
    }
}
