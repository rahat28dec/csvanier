package book_guide.exercises;

import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class FreezingBoiling {
    private int temperature;
    
    public FreezingBoiling() {}
    
    public FreezingBoiling(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    
    public boolean isEthylFreezing() {
        return this.temperature <= -173;
    }
    
    public boolean isEthylBoiling() {
        return this.temperature >= 172;
    }
    
    public boolean isOxygenFreezing() {
        return this.temperature <= -362;
    }
    
    public boolean isOxygenBoiling() {
        return this.temperature >= -306;
    }
    
    public boolean isWaterFreezing() {
        return this.temperature <= 32;
    }
    
    public boolean isWaterBoiling() {
        return this.temperature >= 212;
    }
    
    
}
