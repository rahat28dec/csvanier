/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvdemo;

import java.io.BufferedReader;
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
public class ProcessData {

    private final ArrayList<Employee> empArrL = new ArrayList();
    /**
     * 1. scan the file 
     * 2. read the file 
     * 3. break into tokens 
     * 4. store tokens 
     * 5. manipulate data
     */
    private Scanner dataFile;

    /**
     * Scan the file, if the file do not exist then print no such file.
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    public void processPayroll(String fileName) throws FileNotFoundException, IOException {
        this.dataFile = null;

        try {
            // read the content and store it here
            dataFile = new Scanner(new BufferedReader(new FileReader(fileName)));
            Employee out;

            while (dataFile.hasNext()) {
                
                /**
                 * Store data to be processed by
                 * the method storeEmployee
                 */
                out = this.storeProcessedEmpData(dataFile);
                
                // For testing
                //this.displayToString(out);
                
                /**
                 * Store Employee object into an
                 * array list.
                 */
                this.empArrL.add(out);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("No such file '"
                    + fileName + "' in the directory.");
        } finally {
            if (dataFile != null) {
                dataFile.close();
            }
        }
    }

    /**
     * Using split function to break a sentence
     * into a basic tokens
     * @param dataFile
     * @return 
     */
    public Employee storeProcessedEmpData(Scanner dataFile) {
        String l = dataFile.nextLine();
        String[] result = l.split("\\,");
        System.out.println(Arrays.toString(result));
        Employee emp = null;
        
        /**
         * Since we know index of each
         * Employee properties, we can
         * assign
         */
        for(int i = 0; i < result.length; i++) {
            emp = new Employee(result[0].concat(" ").concat(result[1]), Integer.parseInt(result[2]));
            emp.setHourlyRate(Double.parseDouble(result[3]));
            emp.setHoursWorked(Double.parseDouble(result[4]));
            
            double grossPayPerEmp = emp.getHourlyRate()*emp.getHoursWorked();
            emp.setGrossPayPerEmployee(grossPayPerEmp);
        }
        
        return emp;
        
    }

    /**
     * Displays total gross pay for all employees. 
     * @param t
     * @return 
     */
    public double totalGrossPay(ArrayList<Employee> t) {
        double total = 0.0;
        for (int i = 0; i < t.size(); i++) {
            total += t.get(i).getGrossPayPerEmployee();
        }
        return total;
    }

    /**
     * Displays total number of hours worked for all employee. 
     * @param t
     * @return 
     */
    public double totalNumHoursWorked(ArrayList<Employee> t) {
        double total = 0.0;
        for (int i = 0; i < t.size(); i++) {
            total += t.get(i).getHoursWorked();
        }
        return total;
    }
    
    /**
     * The average pay per work which is
     * the value in (a) divided by the value in (b).
     * @return 
     */
    public double avgPayPerWork() {
        return this.totalGrossPay(this.empArrL)/this.totalNumHoursWorked(this.empArrL);
    }

    /**
     * (a) Displays total gross pay for all employees. 
     * (b) Displays total number of hours worked for all employee. 
     * (c) The average pay per work which is
     * the value in (a) divided by the value in (b).
     *
     */
    public void displayOuput() {
        System.out.println("Total gross pay for all employees: " + String.format("%,2.2f", this.totalGrossPay(this.empArrL)));
        System.out.println("Displays total number of hours worked for all employee: " + String.format("%,2.2f", this.totalNumHoursWorked(this.empArrL)));
        System.out.println("The average pay per work: " + String.format("%,2.2f", this.avgPayPerWork()));

    }
    
    public void displayToString(Employee e) {
        System.out.println(e.toString());
    }

}
