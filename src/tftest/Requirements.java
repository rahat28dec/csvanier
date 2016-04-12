/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tftest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */

public class Requirements {
    public int numberStudents;
    public int numberQuestions;
    private Scanner dataFile;

    public int getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(int numberLines) {
        this.numberStudents = numberLines;
    }

    public int getNumberQuestions() {
        return numberQuestions;
    }

    public void setNumberQuestions(int numberQuestions) {
        this.numberQuestions = numberQuestions;
    }
    
    /**
     * Before processing the file validate first
     * if the file is empty or does not exist?
     * @param dataInput
     * @throws IOException 
     */
    public void processFile1(String dataInput) throws IOException {
        try {
            dataFile = new Scanner(new File(dataInput));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        // no error from here
        this.processPayroll1(dataInput);
        
    }

    public void processPayroll1(String datatxt) throws FileNotFoundException, IOException {
        /**
         * Reads the first line of a file and set the solution. 
         * The first line is the solution.
         */
        BufferedReader firstLine = new BufferedReader(new FileReader(datatxt));
        this.setNumberQuestions(firstLine.readLine().length());
        System.out.println("-" + this.getNumberQuestions());
        
        
        this.dataFile = new Scanner(firstLine);

        int numLines = 0;
        String line1 = null;
        while ((line1 = firstLine.readLine())!=null) {
            numLines++;
        }
        if (dataFile != null) {
            dataFile.close();
        }
        this.setNumberStudents(numLines);
        System.out.println("-" +this.getNumberStudents());
    }
    
    
    
}
