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
        int[] arr = {3,2,7,8,9,1};
        System.out.println("original array: "+Arrays.toString(arr));

        System.out.println(Arrays.toString(bubblesort(arr)));
    }
    /**
     * larger values “bubble” toward the end 
     * of the array with each pass.
     * @param arr
     * @return 
     */
    public static int[] bubblesort(int[] arr) {
        
        int temp;
        for( int i = 0; i < arr.length-1; i++) {
            // if current element is larger
            // than the next elem, swap
            // otherwise do nothing increment index
            // the larger element is shifted to the right
            boolean cond = false;
            if(arr[i]>arr[i+1]) {
//                System.out.println("arr[index]>arr[index+1]:\t" + arr[i] + ">" + arr[i+1]);
                temp = arr[i]; // is holding the larger elem
                arr[i] = arr[i+1];
                arr[i+1]=temp;
                cond=true;
            }
            System.out.println("index:" + i + " " + Arrays.toString(arr) + " swap " + cond);
        }
        return arr;
    }
}

/**
 * 7 2 3 8 9 1
 * int i = 0;
 * array length - 1 = 5
 * 0 < 5
 * arr[0]:7 > arr[0+1]:2
 * temp = arr[0]:7 -> gets the larger elem
 * arr[0] = arr[0+1] -> swap
 * arr[0]   is now 2
 * arr[0+1] = temp:7
 * arr[1] is now 7 
 * i++
 * 
 * i = 1
 * 1 < 5
 * arr[1]:7 > arr[1+1]:3
 * temp = arr[1]:7
 * arr[1] = arr[1+1] -> swap 7 and 3
 * arr[2] = temp:7
 */
