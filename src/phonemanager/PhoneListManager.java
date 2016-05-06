package phonemanager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class PhoneListManager {

    private String fileName;
    private final ArrayList<PhoneItem> PI_ARRAY_LIST = new ArrayList();
    private final Scanner SCAN = new Scanner(System.in);
    PhoneItemUtil util = new PhoneItemUtil();
    private boolean isDone = false;

    /**
     * Loads the file if exist and reads the 
     * content, format it, and store it in
     * an array list of type PhoneItem
     * @throws IOException 
     */
    public void load() throws IOException {
        // scan for the file
        this.scan();
        
        // will store the contents here
        String line;
        
        try {
            FileReader readFile = new FileReader("data\\"+this.fileName);
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(readFile);
            
            System.out.println("Phone list loaded from file " + this.fileName);   
            
            PhoneItem phoneItem;
            while((line = bufferedReader.readLine())!=null) {
                phoneItem = this.formatData(line);
                this.PI_ARRAY_LIST.add(phoneItem);
            }
            
            
            bufferedReader.close();
            
        } catch (FileNotFoundException ex) {
            // if file not found do NOT create
            // continue the program, adding entries
            // to the list, and save later
            System.out.println("\n"+"File: '" + this.fileName + "' not found.");
        } 
        
        // sort the array list after retrieving the data
        Collections.sort(this.PI_ARRAY_LIST, (PhoneItem o1, PhoneItem o2) -> 
                o1.getName().compareToIgnoreCase(o2.getName()));
    }
    
    /**
     * Helper function to format the file
     * the result will be passed to an
     * ArrayList.
     * @param line
     * @return 
     */
    public PhoneItem formatData(String line) {
        String l = line.replaceAll("\\s", ",");
        String[] result = l.split("\\,");
        
        PhoneItem pi = new PhoneItem();
        
        for(int i = 0; i < result.length; i++) {
            pi = new PhoneItem(result[1], result[0]);
        }
        System.out.println(pi.toString());
        return pi;
    }
    
    /**
     * User entered command. 
     * @throws java.io.IOException 
     */
    public void command() throws IOException {
        String typedCommand;
        Scanner scanner;
        // isDone is initialize to false
        // isDone is true if command typed
        // is q
        while (!this.isDone) { 
            System.out.print("Command: ");
            scanner = new Scanner(System.in);
            typedCommand = scanner.next();
            // run the commands
            this.runCommand(this.util.formatStr(typedCommand));
        }
        
    }
    
    private void runCommand(String formattedCommand) {
        switch (formattedCommand) {
            case "p":
                this.print();
                break;
            case "s":
                this.phoneItemSize();
                break;
            case "l":
                this.lookup();
                break;
            case "i":
                this.insert();
                break;
            case "m":
                this.modify();
                break;            
            case "d":
                this.delete();
                break;
            case "q":
                this.quit();
                break;
            default:
                break;
        }
    }
    
    /**
     * Print the contents of the
     * list
     */
    public void print() {
        if(this.PI_ARRAY_LIST.isEmpty()) {
            System.out.println("Sorry, nothing to print" + "\n");
        } else {
            String out = "";
            for(int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
                out += String.format("%-15s%s", this.PI_ARRAY_LIST.get(i).getName(), 
                this.util.formatPhone(this.PI_ARRAY_LIST.get(i).getPhone())) + "\n";
            }
            System.out.println(out);
        } 
    }
    
    /**
     * Call the save method if input yields
     * y for yes, otherwise do not save the
     * file
     */
    private void quit() {
        System.out.print("Save changes to file (y/n)? ");
        String response = SCAN.next();
        if(this.util.formatStr(response).equals("y")) {
            this.save();
        } 
        this.isDone = true;
        System.out.println("Goodbye.");
    }
    
    /**
     * Search for an entry in the list, break
     * if found no need to continue
     */
    private void lookup() {
        System.out.print("Give name: ");
        String name = SCAN.next();
        int count = 0;
        for(int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
            if(name.equalsIgnoreCase(this.PI_ARRAY_LIST.get(i).getName())) {
                System.out.println("Given phone number: " + this.util.formatPhone(this.PI_ARRAY_LIST.get(i).getPhone()) + "\n");
                count++;
                break;
            }
        }
        if(count==0) {
             System.out.println("Sorry, '" + name + "' is not in the " + this.fileName + "\n");  
        }
        
    }
    /**
     * Insert an entry in the
     * list. 
     */
    private void insert() {
        System.out.print("Give name: ");
        String name = SCAN.next();
        if(!this.isExists(name)) {
            System.out.print("Give phone number: ");
            
            String phNumber = SCAN.next();
            if(this.util.validatePhNum(phNumber)) {
                this.PI_ARRAY_LIST.add(new PhoneItem(name, phNumber));
                // sort the array list after inserting a new data
                this.sortArrayList();
                System.out.println();   
            }
        } else {
            System.out.println("Sorry, '" + name + "' is already in the " 
                    + this.fileName + "\n");
        }
        
    }

    /**
     * Sort the array list using a PhoneItem property 
     * (name) to compare
     */
    public void sortArrayList() {
        Collections.sort(this.PI_ARRAY_LIST, (PhoneItem o1, PhoneItem o2) -> 
        o1.getName().compareToIgnoreCase(o2.getName()));
    }
    
    /**
     * Save after all the modification.
     * Create a file if not exists
     * and save the modification.
     */
    public void save() {
       try {
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter("data\\"+this.fileName));
            for (int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
                pw.write(this.PI_ARRAY_LIST.get(i).getPhone() + " " 
                        + this.PI_ARRAY_LIST.get(i).getName() + "\n");
            }
            pw.flush();
            pw.close();
            System.out.println("Saving data file to phone.txt....");
            System.out.println("Thank you for using the automated directory service.");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    /**
     * Modify an entry given a name 
     * to modify
     */
    private void modify() {
        System.out.print("Give name: ");
        String name = SCAN.next();
        if (this.isExists(name)) {
            System.out.print("Give new phone number: ");
            String newPhNum = SCAN.next();
            if (this.util.validatePhNum(newPhNum)) {
                for (int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
                    if (this.PI_ARRAY_LIST.get(i).getName().equals(name)) {
                        this.PI_ARRAY_LIST.get(i).setPhone(newPhNum);
                    }
                }
            }
            System.out.println();
        } else {
            System.out.println("Sorry, '" + name + "' is not in the " 
                    + this.fileName + "\n");
        }
    }
    
    /**
     * Delete an entry in the phone
     * list
     */
    private void delete() {
        System.out.print("Give name: ");
        String name = SCAN.next();
        if (this.isExists(name)) {
            for (int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
                if (this.PI_ARRAY_LIST.get(i).getName().equals(name)) {
                    this.PI_ARRAY_LIST.remove(this.PI_ARRAY_LIST.get(i));
                }
            }
            System.out.println("Entry deleted." + "\n");
        } else {
            System.out.println("Sorry, '" + name + "' is not in the " 
                    + this.fileName + "\n");
        }
    }

    /**
     * @param name the name to compare with
     * the list
     * @return returns true if it exists
     */
    public boolean isExists(String name) {
        int count = 0;
        for(int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
            if(name.equalsIgnoreCase(this.PI_ARRAY_LIST.get(i).getName())) {
                count++;
                break; //if found stop loop no need to continue
            }
        }
        return count==1;
    }

    /**
     * Call this to run the program
     * @throws IOException 
     */
    public void run() throws IOException {
        // load first
        this.load();
        // print the commands
        this.printHelp();
        // user must enter a command
        this.command();
    }

    /**
     * Show the commands that users can use.
     */
    public void printHelp() {
        System.out.println("\n"+"Enter one of the following commands and supply "
                + "the requested information"+"\n");
        String commands = "insert (i), lookup (l), size (s), modify (m), print (p), ";
        commands += "delete (d), quit (q). \n";
        System.out.println(commands);
    }

    /**
     * Prompt the user for the phone book file.
     * If exists load and save the contents to
     * PhoneItem, otherwise create the file.
     */
    public void scan() {
        System.out.println("Phone list Application Program");
        System.out.print("Enter the file name where the phone book is stored: ");
        this.fileName = SCAN.nextLine();
    }
    
    
    /**
     * Prints the size of the array list.
     */
    private void phoneItemSize() {
        System.out.println("number of phone list entries: "+this.PI_ARRAY_LIST.size() + "\n");
    }
}
