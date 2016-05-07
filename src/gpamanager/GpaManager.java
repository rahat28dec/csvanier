package gpamanager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import phonemanager.PhoneItem;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class GpaManager {    
    GradingSystem gs = new GradingSystem();
    GpaItemUtil util = new GpaItemUtil();
    private String fileName;
    private boolean isDone = false;
    private final Scanner scan = new Scanner(System.in);

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void run() {
        // ask which grading system
        this.gs.askGradeSystem();
        // ask for the file to store data
        this.load();
        // run commands
        this.command();
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
        this.askGpaFile();
        // will store the contents here
        String line;
        GpaItem gpaItem;
        try {
            FileReader fr = new FileReader("data\\"+this.getFileName());
            BufferedReader br;
            br = new BufferedReader(fr);
            while((line = br.readLine())!=null) {
                gpaItem = this.formatData(line);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println();
            System.out.println("File " + this.getFileName() + " not found.");
            System.out.println("Please try again.");
            System.out.println(fnfe);
        } catch (IOException ex) {
            Logger.getLogger(GpaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void printHelp() {
        System.out.println();
        System.out.println("Enter one of the following commands."); 
        System.out.print("add (a), search (s), print (p), modify (m), "
                + "delete (d), quit (q).");
    }

    private void command() {
        this.printHelp();
        System.out.println("\n");
        while(!this.isDone) {
            String command;
            System.out.print("Command: ");
            command = scan.nextLine();
            this.runCommand(this.util.formatStr(command));
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
            default:
                break;
        }
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
            gpaItem = new GpaItem(courseName, courseDesc, courseCredit, letterGrade);
            
        }

        System.out.println(gpaItem.toString());
        
        return gpaItem;
    }
    
    private void save() {
    }
    
    private void insert() {
        
    }
    
    private void quit() {
        String response;
        String formatResponse;
        do {
            System.out.print("Save changes to " + this.getFileName() + " (y/n)? ");   
            response = scan.nextLine();
            formatResponse = this.util.formatStr(response); 
        } while(!(formatResponse.equals("y")||formatResponse.equals("n")));
        if(formatResponse.equals("y")) {
            this.save();
        }
        this.isDone = true;
    }
}
