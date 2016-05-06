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
        String[] arr = {"jack", "adam", "betty", "tom"};
        //findElem(arr, 2);
        System.out.println("original order: \t" + Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("sorted : \t" + Arrays.toString(arr));
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
    
    public static void bubbleSort(Comparable[] array) {
        Comparable temp;
        for(int lastPos = array.length - 1; lastPos > 0; lastPos--) {
            for(int i = 0; i < lastPos; i++) {
                if(array[i].compareTo(array[i+1])>0) {
                    temp = array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                }
            }
        }
    }
}
