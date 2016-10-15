package gpa_manager;

import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class GradingSystem {
    GpaItemUtil util = new GpaItemUtil();
    
    String[] conLetterGrade = 
    {"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F","NR"};
    
    String[] mcgLetterGrade = 
    {"A","A-","B+","B","B-","C+","C","D","F"};
    
    private String gradingSystem;

    public String getGradingSystem() {
        return gradingSystem;
    }

    public void setGradingSystem(String gradingSystem) {
        this.gradingSystem = gradingSystem;
    }

    public GradingSystem() {
    }
    
    public void askGradeSystem() {
        do {
            System.out.print("Enter grading system (a) Concordia or (b) McGill: ");
            Scanner scan = new Scanner(System.in);
            this.gradingSystem = scan.nextLine().toLowerCase();
        } while(!(this.util.isOneLengthAnswer(this.gradingSystem) && 
                this.util.isAorBGradingSystem(this.gradingSystem)));
        this.setGradingSystem(this.gradingSystem);
        System.out.println(this.util.returnGradingSystem(this.getGradingSystem()) 
                + " grading system will be use.");
    }
    
    public double calcGradePointsPerClass(
            String gradingSystem, 
            double courseCredit, 
            String letterGrade
    ) {
        double gpPerClass;
        if(this.getGradingSystem().equals("a")) {
            switch (letterGrade) {
                case "A+":
                    gpPerClass = (4.30 * courseCredit);
                    break;
                case "A":
                    gpPerClass = (4.00 * courseCredit);
                    break;
                case "A-":
                    gpPerClass = (3.70 * courseCredit);
                    break;
                case "B+":
                    gpPerClass = (3.30 * courseCredit);
                    break;
                case "B":
                    gpPerClass = (3.00 * courseCredit);
                    break;
                case "B-":
                    gpPerClass = (2.70 * courseCredit);
                    break;
                case "C+":
                    gpPerClass = (2.30 * courseCredit);
                    break;
                case "C":
                    gpPerClass = (2.00 * courseCredit);
                    break;
                case "C-":
                    gpPerClass = (1.70 * courseCredit);
                    break;
                case "D+":
                    gpPerClass = (1.30 * courseCredit);
                    break;
                case "D":
                    gpPerClass = (1.00 * courseCredit);
                    break;
                case "D-":
                    gpPerClass = (0.70 * courseCredit);
                    break;
                default:
                    gpPerClass = (0 * courseCredit);
                    break;
            }
        } else {
            switch (letterGrade) {
                case "A":
                    gpPerClass = (4.00 * courseCredit);
                    break;
                case "A-":
                    gpPerClass = (3.70 * courseCredit);
                    break;
                case "B+":
                    gpPerClass = (3.30 * courseCredit);
                    break;
                case "B":
                    gpPerClass = (3.00 * courseCredit);
                    break;
                case "B-":
                    gpPerClass = (2.70 * courseCredit);
                    break;
                case "C+":
                    gpPerClass = (2.30 * courseCredit);
                    break;
                case "C":
                    gpPerClass = (2.00 * courseCredit);
                    break;
                case "D":
                    gpPerClass = (1.00 * courseCredit);
                    break;
                default:
                    gpPerClass = (0 * courseCredit);
                    break;
            }
        }
        
        return gpPerClass;
    }
}
