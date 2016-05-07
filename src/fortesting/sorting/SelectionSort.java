package fortesting.sorting;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class SelectionSort {
    public static void main(String[] args){
        int[] array = { 5, 7, 2, 8, 9, 1};
        System.out.println(Arrays.toString(selectionSort(array)));
    }
    
    public static int[] selectionSort(int[] array) {
        int temp;
        int min;
        for(int i = 0; i < array.length; i++) {
            min = array[i];
            if(min<array[i+1]) {
                
            }
        }
        return array;
    }
}
