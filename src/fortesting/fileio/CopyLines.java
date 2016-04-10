/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortesting.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class CopyLines {

    public static void main(String[] args) throws IOException {
        BufferedReader input = null;
        PrintWriter output = null;

        try {
            input = new BufferedReader(new FileReader("C:\\Users\\RAYMARTHINKPAD\\Documents\\NetBeansProjects\\OOP\\src\\fortesting\\fileio\\data\\data.txt"));
            output = new PrintWriter(new FileWriter("C:\\Users\\RAYMARTHINKPAD\\Documents\\NetBeansProjects\\OOP\\src\\fortesting\\fileio\\data\\data1.txt"));
            String l;
            while ((l = input.readLine()) != null) {
                output.println(l);
            }
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
