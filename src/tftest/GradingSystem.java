/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tftest;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class GradingSystem {    
    public final int PERCENT_100 = 100;
    
    public char[] getSolution() {
        return solution;
    }

    public void setSolution(char[] solution) {
        this.solution = solution;
    }
    
    public int getTestScore() {
        return this.testScore * 2;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }
    
    public char letterGrade(int score) {
        char sc;
        if(grade(score)>=90) {
            sc = 'A';
        } else if(grade(score)<90 && grade(score) >= 80) {
            sc = 'B';
        } else if(grade(score)<80 && grade(score) >= 70) {
            sc = 'C';
        } else if(grade(score)<70 && grade(score) >= 60) {
            sc = 'D';
        } else {
            sc = 'F';
        }
        return sc;
    }
    
    public int grade(int score) {
        return (score * this.PERCENT_100)/this.getTestScore();
    }
    
    
    
    private int testScore;
    private int numQuestions;
    private char[] solution;
}
