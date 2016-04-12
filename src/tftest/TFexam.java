/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tftest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class TFexam {

    public TFexam(String stuId, char[] stuResponse, int studentScore) {
        this.studentID = stuId;
        this.studentResponse = stuResponse;
        this.studentScores = studentScore;
    }
    
    public TFexam(String stuId, char[] stuResponse) {
        this.studentID = stuId;
        this.studentResponse = stuResponse;
    }
    
    public TFexam(String stuId, char[] stuResponse, int studentScore, char grade) {
        this.studentID = stuId;
        this.studentResponse = stuResponse;
        this.studentScores = studentScore;
        this.studentGrade = grade;
    }

    

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public char[] getStudentResponse() {
        return studentResponse;
    }

    public void setStudentResponse(char[] studentResponse) {
        this.studentResponse = studentResponse;
    }

    public int getStudentScores() {
        return studentScores;
    }

    public void setStudentScores(int studentScores) {
        this.studentScores = studentScores;
    }
    public char getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(char studentGrade) {
        this.studentGrade = studentGrade;
    }


    private String studentID;
    private char[] studentResponse;
    private int studentScores;
    private char studentGrade;

    @Override
    public String toString() {
        return "TFexam{" + "studentID=" + studentID + ", studentResponse=" + Arrays.toString(studentResponse) + ", studentScores=" + studentScores + ", studentGrade=" + studentGrade + '}';
    }
    
    public String modifiedToString() {
        return studentID + "\t" + Arrays.toString(studentResponse) + "\t" + studentScores + "\t" + studentGrade;
    }





}
