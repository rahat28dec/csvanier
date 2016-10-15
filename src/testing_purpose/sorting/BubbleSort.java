package testing_purpose.sorting;

import java.util.Arrays;

/**
 *
 * @author RAYMARTHINKPAD
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 6, 4, 2};
        System.out.println("original order: \t" + Arrays.toString(arr).replaceAll("\\D", " "));
        System.out.println("sorted ascending : \t" + Arrays.toString(bubblesort(arr)).replaceAll("\\D", " "));
    }
    /**
     * larger values “bubble” toward the end 
     * of the array with each pass.
     * @param arr
     * @return 
     */
    public static int[] bubblesort(int[] arr) {
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                int temp;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i]; // is holding the larger elem
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        
        return arr;
    }
}


