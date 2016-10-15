/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpa_manager;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class GpaItem {
    GpaItemUtil util = new GpaItemUtil();
    
    public GpaItem() { }
    
    public GpaItem(
            String courseName, 
            String courseDesc, 
            double courseCredit, 
            String letterGrade
    ) {
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.courseCredit = courseCredit;
        this.letterGrade = letterGrade;
    }

//    @Override
//    public String toString() {
//        return "GpaItem{" + "courseName=" + courseName + ", courseDesc=" 
//                + courseDesc + ", courseCredit=" + courseCredit 
//                + ", letterGrade=" + letterGrade + '}';
//    }
    
    public GpaItem(
            String courseName, 
            String courseDesc, 
            double courseCredit, 
            String letterGrade,
            double gradePoints
    ) {
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.courseCredit = courseCredit;
        this.letterGrade = letterGrade;
        this.gradePoints = gradePoints;
    }

    @Override
    public String toString() {
        return "GpaItem{" + "courseName=" + courseName + ", courseDesc=" + courseDesc + ", courseCredit=" + courseCredit + ", letterGrade=" + letterGrade + ", gradePoints=" + gradePoints + '}';
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(double courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public double getGradePoints() {
        return gradePoints;
    }

    public void setGradePoints(double gradePoints) {
        this.gradePoints = gradePoints;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    private double gpa;
    private String courseName;
    private String courseDesc;
    private double courseCredit;
    private String letterGrade;
    private double gradePoints;

}
