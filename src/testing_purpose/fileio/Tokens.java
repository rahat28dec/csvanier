/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_purpose.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class Tokens {
     public static void main(String[] args) throws IOException {
         Scanner s = null;
         try {
             s = new Scanner(new BufferedReader(new FileReader("data.txt")));
             while(s.hasNext()) {
                 System.out.println(s.next());
                 
             }
             
             
         } finally {
              if (s != null) {
                s.close();
            }
         }
     }
}
