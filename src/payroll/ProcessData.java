/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

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
        fileName = "data.txt";
        PrintWriter output = null;

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
     * Breaks a line of input into a usable data to be stored in an Employee
     * class.
     *
     * @param dataFile
     * @return
     */
    public Employee storeProcessedEmpData(Scanner dataFile) {

        //reads file one per line
        //breaks each char into a token
        String l = dataFile.nextLine();
        StringTokenizer token = new StringTokenizer(l);

        String fName = token.nextToken();
        String lName = token.nextToken();
        String fullName = fName.concat(" ").concat(lName);
        int idNum = Integer.parseInt(token.nextToken());

        // Call Employee class to store each employee
        Employee emp = new Employee(fullName, idNum);

        double hourlyRate = Double.parseDouble(token.nextToken());
        double hoursWorked = Double.parseDouble(token.nextToken());

        emp.setHourlyRate(hourlyRate);
        emp.setHoursWorked(hoursWorked);

        double grossPayPerEmp = hourlyRate * hoursWorked;
        emp.setGrossPayPerEmployee(grossPayPerEmp);

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

}
