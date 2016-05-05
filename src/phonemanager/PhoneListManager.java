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
    PhoneItem util = new PhoneItem();
    private boolean isDone = false;

    public void load() throws IOException {
        // scan for the file
        this.scan();
        
        // will store the contents here
        String line = null;
        
        try {
            FileReader readFile = new FileReader("data\\"+this.fileName);
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(readFile);
            
            System.out.println("Phone list loaded from file " + this.fileName);   
            
            PhoneItem phoneItem;
            phoneItem = new PhoneItem();
            while((line = bufferedReader.readLine())!=null) {
                phoneItem = this.formatData(line);
                this.PI_ARRAY_LIST.add(phoneItem);
            }
            
            // sort the array list after retrieving the data
            Collections.sort(this.PI_ARRAY_LIST, (PhoneItem o1, PhoneItem o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            
            bufferedReader.close();
            
        } catch (FileNotFoundException ex) {
            // if file not found do NOT create
            // continue the program, adding entries
            // to the list, and save later
            System.out.println("\n"+"File: '" + this.fileName + "' not found.");
        } 
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

        return pi;
    }
    
    /**
     * User entered command.
     * Command: s
     * return s
     * @return 
     * @throws java.io.IOException 
     */
    public void command() throws IOException {
        String typedCommand;
        Scanner scanner;
        while (!this.isDone) {
            System.out.print("Command: ");
            scanner = new Scanner(System.in);
            typedCommand = scanner.next();
            // rin the commands
            this.runCommand(this.formatStr(typedCommand));
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
    
    private void quit() {
        System.out.print("Save changes to file (y/n)? ");
        String response = SCAN.next();
        if(this.formatStr(response).equals("y")) {
            this.save();
        } 
        this.isDone = true;
        System.out.println("goodbye");
    }
    
    private void lookup() {
        System.out.print("Give name: ");
        String name = SCAN.next();
        int count = 0;
        for(int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
            if(name.equalsIgnoreCase(this.PI_ARRAY_LIST.get(i).getName())) {
                System.out.println("Given phone number: " + this.util.formatPhone(this.PI_ARRAY_LIST.get(i).getPhone()) + "\n");
                count++;
            }
        }
        if(count==0) {
             System.out.println("Sorry, '" + name + "' is not in the " + this.fileName + "\n");  
        }
        
    }
    
    private void insert() {
        System.out.print("Give name: ");
        String name = SCAN.next();
        if(!this.isExists(name)) {
            System.out.print("Give phone number: ");
            
            String phNumber = SCAN.next();
            if(this.validatePhNum(phNumber)) {
                this.PI_ARRAY_LIST.add(new PhoneItem(name, phNumber));
                // sort the array list after inserting new data
                this.sortArrayList();
                System.out.println();   
            }
        } else {
            System.out.println("Sorry, '" + name + "' is already in the " + this.fileName + "\n");
        }
        
    }

    public void sortArrayList() {
        Collections.sort(this.PI_ARRAY_LIST, (PhoneItem o1, PhoneItem o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }
    
    public void save() {
       try {
            PrintWriter pw = new PrintWriter(new FileWriter("data\\"+this.fileName));
            for (int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
                pw.write(this.PI_ARRAY_LIST.get(i).getPhone() + " " + this.PI_ARRAY_LIST.get(i).getName() + "\n");
            }
            pw.flush();
            pw.close();
            System.out.println("Saving data file to phone.txt....");
            System.out.println("Thank you for using the automated directory service.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void modify() {
        System.out.print("Give name: ");
        String name = SCAN.next();
        if (this.isExists(name)) {
            System.out.print("Give new phone number: ");
            String newPhNum = SCAN.next();
            if (this.validatePhNum(newPhNum)) {
                for (int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
                    if (this.PI_ARRAY_LIST.get(i).getName().equals(name)) {
                        this.PI_ARRAY_LIST.get(i).setPhone(newPhNum);
                    }
                }
            }
            System.out.println();
        } else {
            System.out.println("Sorry, '" + name + "' is not in the " + this.fileName + "\n");
        }
    }
    
    
    private void delete() {
    
    }

    public boolean isExists(String name) {
        int count = 0;
        for(int i = 0; i < this.PI_ARRAY_LIST.size(); i++) {
            if(name.equalsIgnoreCase(this.PI_ARRAY_LIST.get(i).getName())) {
                count++;
            }
        }
        return count==1;
    }
    
    public  boolean validatePhNum(String phNumber) { 
        if(!(phNumber.length()==10 && phNumber.matches(".*\\d"))) {
             System.out.println("Enter a valid 10 digit phone number." + "\n");
             return false;
        }
        return true;
    }

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
        System.out.println("\n"+"Enter one of the following commands and supply the requested information"+"\n");
        String commands = "insert (i), ";
        commands += "lookup (l), ";
        commands += "size (s), ";
        commands += "modify (m), ";
        commands += "print (p), ";
        commands += "delete (d), ";
        commands += "quit (q). \n";
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
     * Removes unnecessary chars
     * gets only the first char
     * and makes it lowercase
     * @param str
     * @return 
     */
    public String formatStr(String str) {
        return str.substring(0, 1).toLowerCase();
    }

    private void phoneItemSize() {
        System.out.println("number of phone list entries: "+this.PI_ARRAY_LIST.size() + "\n");
    }





}
