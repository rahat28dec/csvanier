/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class Employee {

    public Employee(String empName, int idNum) {
        this.employeeName = empName;
        this.idNumber = idNum;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getGrossPayPerEmployee() {
        return this.grossPayPerEmployee;
    }

    public void setGrossPayPerEmployee(double grossPay) {
        this.grossPayPerEmployee = grossPay;
    }

    private String employeeName;
    private int idNumber;
    private double hourlyRate;
    private double hoursWorked;
    private double grossPayPerEmployee;

    @Override
    public String toString() {
        return "Employee{" + "employeeName=" + employeeName + ", idNumber=" + idNumber + ", hourlyRate=" + hourlyRate + ", hoursWorked=" + hoursWorked + ", grossPayPerEmployee=" + grossPayPerEmployee + '}';
    }
    
    

}
