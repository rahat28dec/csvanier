/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tftest;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class TFtestDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = "test1.csv";
        
//        Requirements r = new Requirements();
//        r.processFile1(fileName);
//        
//        
        ProcessData pd = new ProcessData();
        pd.processFile(fileName);
    }
}
