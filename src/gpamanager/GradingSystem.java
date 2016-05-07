package gpamanager;

import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class GradingSystem {
    GpaItemUtil util = new GpaItemUtil();
    private String gradingSystem;

    public String getGradingSystem() {
        return gradingSystem;
    }

    public void setGradingSystem(String gradingSystem) {
        this.gradingSystem = gradingSystem;
    }

    // given letter grade for a course
    // return the grade points of that
    // course
    
    // two  grading system, concordia and mcgill
    // if user choses concordia
    // the program will use
    // concordia grading system
    public GradingSystem() {
    }
    
    public void askGradeSystem() {
        do {
            System.out.print("Enter grading system (a) Concordia or (b) McGill: ");
            Scanner scan = new Scanner(System.in);
            this.gradingSystem = scan.nextLine();
        } while(!(this.gradingSystem.equals("a")||
                this.gradingSystem.equals("b")||
                this.gradingSystem.equalsIgnoreCase("concordia")||
                this.gradingSystem.equalsIgnoreCase("mcgill")));
        this.setGradingSystem(this.gradingSystem);
        System.out.println(this.uniGradingSystem(this.getGradingSystem()) + " grading system will be use.");
    }
    
    public String uniGradingSystem(String str) {
        if(str.equals("a")) {
            str = "Concordia";
        } else {
            str = "McGill";
        }
        return str;
    }
    
}
