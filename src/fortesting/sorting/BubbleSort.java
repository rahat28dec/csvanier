/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortesting.sorting;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,2,9,7,6,8};
        System.out.println("original array: "+Arrays.toString(arr));

        System.out.println("result: "+Arrays.toString(bubblesort(arr)));
    }
    /**
     * larger values “bubble” toward the end 
     * of the array with each pass.
     * @param arr
     * @return 
     */
    public static int[] bubblesort(int[] arr) {
        
        
        for( int i = 0; i < arr.length-1; i++) {
            // if current element is larger
            // than the next elem, swap
            // otherwise do nothing increment index
            // the larger element is shifted to the right
            int temp;
            boolean cond = false;
            if(arr[i]>arr[i+1]) {
//                System.out.println("arr[index]>arr[index+1]:\t" + arr[i] + ">" + arr[i+1]);
                temp = arr[i]; // is holding the larger elem
                arr[i] = arr[i+1];
                arr[i+1]=temp;
                cond=true;
            }
//            System.out.println("index:" + i + " " + Arrays.toString(arr) + " swap " + cond);
        }
        
        for(int i = arr.length-1; i > 0; i--) {
            int temp;
            if(arr[i]<arr[i-1]) {
                temp = arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp;
            }
        } 
        return arr;
    }
}


