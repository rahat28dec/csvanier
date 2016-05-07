package gpamanager;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class GpaItemUtil {

    public GpaItemUtil() {
    }

    public String formatStr(String str) {
        return str.substring(0, 1).toLowerCase();
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
     * 
     * @param courseCredit
     * @param letterGrade
     * @param uni
     * @return Returns grade points for a course
     * given a course credit, letter grade, and grading system
     */
    public double calcGradePoints(
            int courseCredit, 
            String letterGrade, 
            GradingSystem uni) {
        double calculatedGradePoints = 0.0;
        if(uni.getGradingSystem().equals("a")){
            if((letterGrade).equals("a+")) {
                calculatedGradePoints = 4.00 * courseCredit;
            } else if(this.formatStr(letterGrade).equals("a")) {
                
            }
        } else {
            
        }
        return calculatedGradePoints;
    }
    // GpaItem item = new GpaItem("anth 209","introduction to culture",3,"b+", this.gs);
    // System.out.println(util.calcGradePoints(3, "a", gs));

}
