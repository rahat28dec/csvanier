/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class PayrollDemo extends ProcessData {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ProcessData pd = new ProcessData();
        pd.processPayroll("data.txt");
        pd.displayOuput();
    }
}
