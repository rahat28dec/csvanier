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

        bubblesort(arr);
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
    
    public static int[] bubblesort(int[] arr) {
        int lastPos;
        int index;
        // minus 1 since we adding + 1 at index
        // also to avoid out of bounds error
        for ( lastPos = arr.length - 1; lastPos >= 0; lastPos--) {
            // we are basically shifting larger
            // elements to the right
            // after the shift decrement lastPos by 1
            // so we don't touch those elements
            // anymore, we sort what we have left
            // controlled by the lastPos index
            // each time we pass the array
            // we are shifting the larger elements
            // to the right until until we reach
            // 0
            
            // example: { 5, 9, 4, 2, 1, 7 }
            
            // first iteration is
            //  from 0 to 4
            //    we shift #9 all the way to the right
            //      { 5, 4, 2, 1, 7, 9 }
            
            // second iteration is
            //  from 0 to 3
            //    we shift #5 all the way to the right
            //      { 4, 2, 1, 5, 7, 9 }
            
            // third iteration is 
            //  from 0 to 2
            //    we shift #4 all the way to the right
            //      { 2, 1, 4, 5, 7, 9 }

            // fourth iteration is 
            //  from 0 to 1
            //    we shift #2 all the way to the right
            //      { 1, 2, 4, 5, 7, 9 }
            
            // after each iteration
            // we are shifting the larger elements 
            // to the right
            // so we are left with small range each pass
            
            for ( index = 0; index < lastPos; index++) {
                
                
                
                int temp;
                boolean cond = false;
                if (arr[index] > arr[index + 1]) {
                    temp = arr[index]; // is holding the larger elem
                    arr[index] = arr[index + 1];
                    arr[index + 1] = temp;
                    cond = true;
                }
                System.out.println("index:" + index + " " + Arrays.toString(arr) + " swap " + cond);
            }

        }
        return arr;
    }
}
