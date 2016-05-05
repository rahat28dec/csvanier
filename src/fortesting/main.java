/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortesting;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class main {
    public static String formatStr(String str) {
        return str.substring(0, 0).toLowerCase();
    }
    
    public static boolean validatePhNum(String phNumber) {
        return phNumber.length()==10 && phNumber.matches(".*\\d");
    }
    public static void main(String[] args) {
//        String insert = "Insert";
//        System.out.println("formated string: " + formatStr(insert));
//        
//        String phNumber = "123456789z";
//        System.out.println((phNumber.length()));
//        System.out.println("is valid : " + validatePhNum(phNumber));
        int[] arr = {5,6,4,2,1,7,8,9};
        findElem(arr, 2);
    }
    
    public static void findElem(int[] arr, int find) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println("index: "+i);
            if(arr[i]==find) {
                System.out.println("Found!");
//                break;
            }
        }
    }
}
