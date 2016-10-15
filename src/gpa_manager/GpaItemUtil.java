package gpa_manager;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 * No calculation here.
 */
public class GpaItemUtil {
    
    String[] acceptableLetterGradeCon = {"A+","A","A-","B+","B-"}; 
    public GpaItemUtil() {
    }

    /**
     * @param str is the string to format
     * @return Returns the lowercase
     */
    public String formatStrLower(String str) {
        return str.toLowerCase();
    }
    
    /**
     * @param str is the string to format
     * @return Returns the letter grade and
     * make it uppercase. Ex. A+, B-, A.
     */
    public String formatStrUpperLetterGrade(String str) {
        return str.substring(0, 2).toUpperCase();
    }

    /**
     * @param fileName
     * @return returns true if the filename 
     * extension is a txt or a csv
     */
    public boolean isTextCsv(String fileName) {
        boolean cond = false;
        if((fileName.endsWith(".txt")||fileName.endsWith(".csv"))
                && fileName.length() > 4) {
            cond = true;
        }
        return cond;
    }
    
    /**
     * @param str
     * @return returns true if the string
     * is a one length char either upper
     * or lower case
     */
    public boolean isOneLengthAnswer(String str) {
        return str.toLowerCase().length()==1;
    }
    
    /**
     * 
     * @param str
     * @return returns true if strictly a or b
     * is the answer
     */
    public boolean isAorBGradingSystem(String str) {
        return str.equals("a")||str.equals("b");
    }
    
    /**
     * 
     * @param str
     * @return returns true if strictly y or n
     * is the answer
     */
    public boolean isYorNGradingSystem(String str) {
        return str.equals("y")||str.equals("n");
    }
    
    /**
     * 
     * @param str
     * @return Returns the uni name
     * for chosen grading system
     */
    public String returnGradingSystem(String str) {
        if(str.equals("a")) {
            str = "Concordia";
        } else {
            str = "McGill";
        }
        return str;
    }
    
    /**
     * @param courseName
     * @return returns true if the course name
     * is valid and course name still not exist. 
     * Ex. ANTH 202
     */
    public boolean isCourseNameValid(String courseName) {
        boolean cond = false;
       
        if (courseName.length() == 8) {
            String courseAbrev = courseName.substring(0, 4);
            String courseNum = courseName.substring(5);
            if (courseAbrev.matches("[a-zA-z]+")
                    && courseNum.matches("[0-9]+")) {
            }
            cond = true;
        }
        return cond;
    }
    
    /**
     * 
     * @param num number to determine
     * @return true if num is an integer or a double
     */
    public boolean isDoubleIntValue(String num) {
        return num.matches("\\d+(\\.\\d+)?");
    }
    
    /**
     * Determine if the letter grade entered is 
     * valid. 
     * @param gs
     * @param letterGrade
     * @return returns true if the letter
     * grade entered is valid, otherwise 
     * return false
     */
    public boolean isLetterGradeValid(GradingSystem gs, String letterGrade) {
        boolean cond = false;
        if(gs.getGradingSystem().equals("a")) {
            for (String conLetterGrade : gs.conLetterGrade) {
                if (letterGrade.equals(conLetterGrade)) {
                    cond = true;
                    break;
                }
            }
        } else {
            for (String mcgLetterGrade : gs.mcgLetterGrade) {
                if (letterGrade.equals(mcgLetterGrade)) {
                    cond = true;
                    break;
                }
            }
        }
        return cond;
    }
    
    /**
     * Display the numerical letter grade
     * based on the grading system chosen
     * by the user.
     * @param gs 
     */
    public void determineLetterGrade(GradingSystem gs) {
        if(gs.getGradingSystem().equals("a")) {
            System.out.println(this.returnGradingSystem(gs.getGradingSystem()) 
                    + "'s letter grade: " + 
                Arrays.toString(gs.conLetterGrade).replaceAll("\\[|\\]", " "));
        } else {
            System.out.println(this.returnGradingSystem(gs.getGradingSystem()) 
                    + "'s numerical scale of grades: " + 
                Arrays.toString(gs.mcgLetterGrade).replaceAll("\\[|\\]", " "));
        }
    }

    /**
     * Round a value to two decimal
     * places. Used for grade points
     * and GPA.
     * @param num
     * @return 
     */
    public double round2DecPlaces(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
    
    

}
