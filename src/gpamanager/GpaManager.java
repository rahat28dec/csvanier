package gpamanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 *
 * @author RAYMARTHINKPAD
 */
public class GpaManager {    
    GradingSystem gs = new GradingSystem();
    GpaItemUtil util = new GpaItemUtil();
    List<GpaItem> gpaArrayList = new ArrayList();
    private String fileName;
    private boolean isDone = false;
    private final Scanner scan = new Scanner(System.in);
    String outputFormat = "%-20s%35s%20s%25s%15s";
    String header = String.format(this.outputFormat, 
                    "Class", 
                    "Description", 
                    "Units", 
                    "Grade", 
                    "Grade Points") 
                    + "\n";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void run() {
        ///////////////////////////
        // ask which grading system
        this.gs.askGradeSystem();
        ///////////////////////////
       

        /////////////////////////////////
        // load the data and populate the
        // the list
        this.load();
        /////////////////////////////////
        
        
        ///////////////////////////
        // run commands
        this.command();
        ///////////////////////////
    }

    private void askGpaFile() {
        do {
            System.out.println();
            System.out.println("Enter the file name where the GPA data is stored.");
            System.out.print("It must be .txt file or a .csv file: ");
            this.fileName = scan.nextLine();
        } while(!this.util.isTextCsv(this.fileName));
        this.setFileName(this.fileName);
    }
    
    private void load() {
       
        ///////////////////////////////////
        this.askGpaFile();
        ///////////////////////////////////

        String line;
        GpaItem gpaItem;
        try {
            
            ////////////////////////////////////////////////////////////////////
            // create the folder if not exits
            
//            String gradingSysFolder = 
//                    this.util.returnGradingSystem(
//                            this.gs.getGradingSystem()
//                    ).toLowerCase();
            String gradingSysFolder = this.returnGradingSysFolder(this.gs);

            File gradingSysFolderDir = new File("dist\\"+gradingSysFolder);
            if(!gradingSysFolderDir.exists()) {
                System.out.println("creating directory: " + gradingSysFolder);
                boolean result = false;

                try{
                    gradingSysFolderDir.mkdir();
                    result = true;
                } catch(SecurityException se){
                    //handle it
                    System.out.println(se);
                }        
                if(result) {    
                    System.out.println(gradingSysFolder+" directory created");  
                }
            }
            ////////////////////////////////////////////////////////////////////
            
            FileReader fr = new FileReader("dist\\"+gradingSysFolder+"\\"+this.getFileName());
            BufferedReader br;
            br = new BufferedReader(fr);
            while((line = br.readLine())!=null) {
                gpaItem = this.formatData(line);
                this.gpaArrayList.add(gpaItem);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println();
            System.out.println("The file '" + this.getFileName() + "' not found.");
            System.out.println(this.fileName + " created.");
        } catch (IOException ex) {
            Logger.getLogger(GpaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(this.gpaArrayList);
        Collections.sort(this.gpaArrayList, (GpaItem a, GpaItem b)->
                a.getCourseName().compareToIgnoreCase(b.getCourseName()));
        
    }
    
    /**
     * This will return a string a chosen grading system
     * that will be use to create a directory to
     * store file
     * @param gs to get the grading system
     * @return return the string grading system in lowercase
     */
    public String returnGradingSysFolder(GradingSystem gs) {
        return this.util.returnGradingSystem(gs.getGradingSystem()).toLowerCase();
    }
    
    private GpaItem formatData(String line) {
        String l = line.replaceAll("\\s", ",");
        String[] result = l.split("\\,");
        
        GpaItem gpaItem = new GpaItem();
        ArrayList<String> arrayListStr = new ArrayList();
        for(int i = 0; i < result.length; i++) {
            String courseName = result[0].concat(" " + result[1]);
            String letterGrade = result[result.length-1]; 
            double courseCredit = Double.parseDouble(result[result.length-2]);
            
            // remove unnecessary elements only the course
            // description left
            if(i != 0 && i != 1 && i != result.length-1 && i != result.length-2) {
                arrayListStr.add(result[i]);
            }
            // joined the array list
            String courseDesc = String.join(" ", arrayListStr);
            
            // calculate grade points 
            double gradePoints = this.gs.calcGradePointsPerClass(
                                    this.gs.getGradingSystem(), 
                                    courseCredit, 
                                    letterGrade
            );
            
            // set the properties
            gpaItem = new GpaItem(
                    courseName, 
                    courseDesc, 
                    courseCredit, 
                    letterGrade,
                    this.util.round2DecPlaces(gradePoints)
            );
            
        }
//        System.out.println(gpaItem.toString());
        
        return gpaItem;
    }
    
    public void printHelp() {
        System.out.println();
        System.out.println("Enter one of the following commands."); 
        System.out.print("insert (i), search (s), print (p), modify (m), "
                + "delete (d), quit (q).");
    }

    private void command() {
        this.printHelp();
        System.out.println("\n");
        while(!this.isDone) {
            String command;
            System.out.print("Command: ");
            command = scan.nextLine().toLowerCase();
            if(this.util.isOneLengthAnswer(command)) {
                this.runCommand(this.util.formatStrLower(command));   
            }
        }
    }

    private void runCommand(String command) {
        switch (command) {
            case "q":
                this.quit();
                break;
            case "i":
                this.insert();
                break;
            case "p":
                this.print();
                break;
            case "s":
                this.search();
                break;
            case "d":
                this.delete();
                break;
            case "m":
                this.modify();
                break;
            default:
                break;
        }
    }
    
    private void save() {
        try {
            
//            String gradingSysFolder = 
//                    this.util.returnGradingSystem(
//                            this.gs.getGradingSystem()
//                    ).toLowerCase();
            String gradingSysFolder = this.returnGradingSysFolder(this.gs);
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter("dist\\"+gradingSysFolder+"\\"+this.fileName));
            for(int i = 0; i < this.gpaArrayList.size(); i++) {
                pw.write(
                        this.gpaArrayList.get(i).getCourseName() + " " + 
                        this.gpaArrayList.get(i).getCourseDesc() + " " + 
                        this.gpaArrayList.get(i).getCourseCredit() + " " +
                        this.gpaArrayList.get(i).getLetterGrade() + "\n"
                );
            }
            pw.flush();
            pw.close();
            System.out.println("Saving data file to "+this.fileName+"....");
            System.out.println("Thank you for using the automated directory service.");
        } catch(Exception ex) {
            System.out.println(ex);
        }    
    }
    
    private void insert() {
        String courseName;
        String courseDesc;
        String courseCredit;
        double courseCreditDbl;
        String letterGrade;
        
        //////////////////////////////////////////////////////
        System.out.println("Enter a 4 letters course name and 3 "
                + "digits course number.");
        System.out.print("Example ABCD 123 > ");
        courseName = scan.nextLine();
        //////////////////////////////////////////////////////
        
        
        if(this.isExistCourseName(courseName)) {
           System.out.println("This course already exist."); 
        } else {
            if(!(this.util.isCourseNameValid(courseName))) {
                System.out.println("The course you entered is not valid."); 
                System.out.println("Please try again."); 
            } else {
                
                //////////////////////////////////////////////////////
                System.out.print("Enter course description > ");
                courseDesc = scan.nextLine();
                //////////////////////////////////////////////////////
                
                
                //////////////////////////////////////////////////////
                System.out.print("Enter course credits > ");
                courseCredit = scan.nextLine();
                //////////////////////////////////////////////////////
                
                
                if(!this.util.isDoubleIntValue(courseCredit)) {
                    System.out.println("Please enter a valid number [0-9].");
                } else {
                    
                    courseCreditDbl = Double.parseDouble(courseCredit);
                    //////////////////////////////////////////////////////
                    this.util.determineLetterGrade(this.gs);
                    System.out.print("Please enter a letter grade (see above) > ");
                    letterGrade = scan.nextLine().toUpperCase();
                    //////////////////////////////////////////////////////
                    
                    if(!this.util.isLetterGradeValid(this.gs, letterGrade)) {
                        System.out.println("Enter a valid letter grade "
                                + "(see above) and try again.");
                    } else {
                        // everything is good here
                        // you can now add the item
                        double gradePoints = this.gs.calcGradePointsPerClass(
                                    this.gs.getGradingSystem(), 
                                    courseCreditDbl, 
                                    letterGrade
                        );
                        
                        GpaItem item = new GpaItem(
                                courseName.toUpperCase(), 
                                courseDesc.toUpperCase(), 
                                courseCreditDbl, 
                                letterGrade,
                                this.util.round2DecPlaces(gradePoints)
                        );
                        this.gpaArrayList.add(item);
                    }
                }
            }
        }
    }
    
    public boolean isExistCourseName(String courseName) {
        boolean cond = false;
        for(int i = 0; i < this.gpaArrayList.size(); i++) {
            if(courseName.equalsIgnoreCase(
                    this.gpaArrayList.get(i).getCourseName()
            )) {
                cond = true;
                break;
            }
        }
        return cond;
    }
    
    private void print() {
        if(this.gpaArrayList.isEmpty()) {
            System.out.println("Sorry, nothing to print.");
        } else {
            String out = "";
            double courseCreditTotal = 0;
            double gradePointsTotal = 0;
            
            
            for(int i = 0; i < this.gpaArrayList.size(); i++) {
                // to calculate GPA
                courseCreditTotal += gpaArrayList.get(i).getCourseCredit();
                gradePointsTotal += gpaArrayList.get(i).getGradePoints();
                
                
                out += String.format(this.outputFormat, 
                        gpaArrayList.get(i).getCourseName(), 
                        gpaArrayList.get(i).getCourseDesc(),
                        String.valueOf(gpaArrayList.get(i).getCourseCredit()),
                        gpaArrayList.get(i).getLetterGrade(),
                        String.valueOf(gpaArrayList.get(i).getGradePoints())) 
                        + "\n";
            }
            System.out.println(this.header+out);
            System.out.println("GPA: " + this.calculateGPA(courseCreditTotal, 
                    gradePointsTotal) + "\n") ;

        }
    }
    
    private void quit() {
        String response;
        do {
            System.out.print("Save changes to " + this.getFileName() + " (y/n)? ");   
            response = scan.nextLine().toLowerCase();
            
        } while(!(this.util.isYorNGradingSystem(response)
                && this.util.isOneLengthAnswer(response)));
        
        if(response.equals("y")) {
            this.save();
        }
        this.isDone = true;
    }

    private double calculateGPA(
            double courseCreditTotal, 
            double gradePointsTotal
    ) {
        return this.util.round2DecPlaces(gradePointsTotal/courseCreditTotal);
    }

    private void search() {
        String courseNameToSearch;
        if (this.gpaArrayList.isEmpty()) {
            System.out.println("Sorry, nothing to search.");
        } else {
            System.out.println("Enter the course name to search.");
            System.out.print("Example ABCD 123 > ");
            courseNameToSearch = scan.nextLine().toUpperCase();
            String out = null;
            if (this.isExist(courseNameToSearch)) {
                for (int i = 0; i < this.gpaArrayList.size(); i++) {
                    if (courseNameToSearch.equals(this.gpaArrayList.get(i).getCourseName())) {
                        out = String.format(this.outputFormat,
                                gpaArrayList.get(i).getCourseName(),
                                gpaArrayList.get(i).getCourseDesc(),
                                String.valueOf(gpaArrayList.get(i).getCourseCredit()),
                                gpaArrayList.get(i).getLetterGrade(),
                                String.valueOf(gpaArrayList.get(i).getGradePoints()))
                                + "\n";
                        break;
                    }
                }
                System.out.println(this.header + out);
            } else {
                System.out.println("Sorry, '" + courseNameToSearch
                        + "' is not in the " + this.fileName + "\n");
            }
        }
    }

    private void delete() {
        String courseToDelete;
        if (this.gpaArrayList.isEmpty()) {
            System.out.println("Sorry, nothing to delete.");
        } else {
            System.out.println("Enter the course name to delete.");
            System.out.print("Example ABCD 123 > ");
            courseToDelete = scan.nextLine().toUpperCase();
            if (this.isExist(courseToDelete)) {
                for (int i = 0; i < this.gpaArrayList.size(); i++) {
                    if (courseToDelete.equals(this.gpaArrayList.get(i).getCourseName())) {
                        this.gpaArrayList.remove(this.gpaArrayList.get(i));
                    }
                }
                System.out.println("Course deleted.");
                System.out.println();
            } else {
                System.out.println("This course does not exist.");
                System.out.println();
            }
        }
    }
    
    private void modify() {
        String courseToModify;
        if(this.gpaArrayList.isEmpty()) {
            System.out.println("Sorry, nothing to modify.");
        } else {
            //////////////////////////////////////////////////////
            System.out.println("Enter the course name to modify.");
            System.out.print("Example ABCD 123 > ");
            courseToModify = scan.nextLine().toUpperCase();
            //////////////////////////////////////////////////////
            
            if (this.isExist(courseToModify)) {
                for(int i = 0; i < this.gpaArrayList.size(); i++) {
                    if(courseToModify.equals(this.gpaArrayList.get(i).getCourseName())) {
                        
                        //////////////////////////////////////////////////////
                        System.out.print("Enter new course description: ");
                        String newCourseDesc = scan.nextLine().toUpperCase();
                        //////////////////////////////////////////////////////
                        
                        
                        System.out.print("Enter course credit: ");
                        String courseCredit = scan.nextLine();
                        if(this.util.isDoubleIntValue(courseCredit)) {
                            
                            this.util.determineLetterGrade(this.gs);
                            System.out.print("Enter numerical letter grade: ");
                            String letterGrade = scan.nextLine().toUpperCase();
                            if(this.util.isLetterGradeValid(this.gs, letterGrade)) {
                                double gradePoints = this.gs.calcGradePointsPerClass(
                                                this.gs.getGradingSystem(), 
                                                Double.parseDouble(courseCredit), 
                                                letterGrade
                                        );
                                this.gpaArrayList.get(i).setCourseDesc(newCourseDesc);
                                this.gpaArrayList.get(i).setCourseCredit(Double.parseDouble(courseCredit));
                                this.gpaArrayList.get(i).setLetterGrade(letterGrade);
                                this.gpaArrayList.get(i).setGradePoints(this.util.round2DecPlaces(gradePoints));
                                
                            } else {
                                System.out.println("Please enter a valid letter grade.");
                                System.out.println("See above.");
                            }
                            
                        } else {
                            System.out.println("Invalid course credit. Please try again.");
                            System.out.println();
                        }
                    }
                }
            } else {
                System.out.println("This course does not exist.");
                System.out.println();
            }
        }
    }
    
    /**
     * @param courseName
     * @return return true if count is 1,
     * otherwise return false count is 0
     */
    public boolean isExist(String courseName) {
        int count = 0;
        for(int i = 0; i < this.gpaArrayList.size(); i++) {
            if(courseName.equals(this.gpaArrayList.get(i).getCourseName())) {
                count++;
                break;
            }
        }
        return count==1;
    }

}
 