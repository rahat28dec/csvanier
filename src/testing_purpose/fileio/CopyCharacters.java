/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_purpose.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class CopyCharacters {


    
    public static void main(String[] args) throws IOException {

        FileReader input = null;
        FileWriter output = null;
        
        String inputFile = "C:\\Users\\RAYMARTHINKPAD\\Documents\\NetBeansProjects\\OOP\\src\\fortesting\\fileio\\data\\data.txt";
        String outputFile = "C:\\Users\\RAYMARTHINKPAD\\Documents\\NetBeansProjects\\OOP\\src\\fortesting\\fileio\\data\\data1.txt";

        try {

            input = new FileReader(inputFile);
            output = new FileWriter(outputFile);
            int c;
            while ((c = input.read()) != -1) {
                output.write(c);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + inputFile + "'");

        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}
