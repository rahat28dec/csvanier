/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortesting;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class main {
    public static void main(String[] args) {
        int[] arr = {5,9,4,2,1,7};
        //findElem(arr, 2);
        System.out.println("original order: \t" + Arrays.toString(arr));
        isTextCsv("1.csv");

    }
    
    public static void findElem(int[] arr, int find) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println("index: "+i);
            if(arr[i]==find) {
                System.out.println("Found!");
                break;
            }
        }
    }
    
    public static boolean isTextCsv(String fileName) {
        boolean cond = false;
        if(fileName.endsWith(".txt")||fileName.endsWith(".cvs")) {
            cond = true;
        }
        return cond;
    }
    
    
}
