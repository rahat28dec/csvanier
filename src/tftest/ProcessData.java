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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class ProcessData extends GradingSystem {
    
    private Scanner dataFile;
    private final int NUM_STUDENT = 200;
    private int[] wrongAnswer = new int[20];
    private TFexam tf1 = null;

    /**
     * Before processing the file validate 
     * first if the file is empty or does
     * not exist?
     *
     * @param dataInput
     * @throws IOException
     */
    public void processFile(String dataInput) throws IOException {
        try {
            dataFile = new Scanner(new File(dataInput));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        // no error from here
        this.processPayroll(dataInput);

    }

    public void processPayroll(String datatxt) throws FileNotFoundException, IOException {
        
        
        TFexam tf;

        /**
         * Reads the first line of a file and set the solution. 
         * The first line is the solution.
         */
        BufferedReader firstLine = new BufferedReader(new FileReader(datatxt));
        this.setSolution(firstLine.readLine().toCharArray());

        this.dataFile = new Scanner(firstLine);

        // Test score is total of points you can get from
        // the test. One question is worth 2 points
        // 20 questions = 40 points total
        this.setTestScore(this.getSolution().length);

        while (dataFile.hasNextLine()) {
            // pass the scanned fille into the TFexam class
            // to be process
            tf = this.processData(dataFile);
        }
        if (dataFile != null) {
            dataFile.close();
        }

    }

    /**
     * Returns an employee instance
     * along with its properties.
     * @param data
     * @return 
     */
    private TFexam processData(Scanner data) {
        String l = data.nextLine();
        String[] result = l.split("\\,");
        
        for (int i = 0; i < result.length; i++) {
            // first element is the id
            String studentId = result[0];
            // second element is the response
            String response = result[1];
            // convert it to char array
            char[] responseCh = response.toCharArray();
            
            tf1 = new TFexam(
                    studentId,  
                    responseCh,
                    this.studentScore(responseCh),
                    this.letterGrade(this.studentScore(responseCh)
            ));

        }
        System.out.println(tf1.modifiedToString());
        this.printResult();
        return tf1;
    }

    public int studentScore(char[] res) {
        char[] sol = this.getSolution();
        int sc = 0;
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] == res[i]) {
                sc += 2;
            } else if (res[i] != 'F' && res[i] != 'T') {
                // accumulate the wrong answer for each 
                // student
                this.wrongAnswer[i]++;
            } else {
                sc--;
                this.wrongAnswer[i]++;
            }

        }

        return sc;
    }
    
    public void printResult() {
        char[] sol = this.getSolution();
        
        for (int i = 0; i < this.getSolution().length; i++) {
            String trueFalse = new String(sol);
            System.out.println(this.wrongAnswer[i]);

        }
    }

    

    

}
