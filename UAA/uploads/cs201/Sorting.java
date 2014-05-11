/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classexamples;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author rnixon
 */
public class Sorting {
    
    private static final int ARRAY_LENGTH = 100;
    
    public static void sortExample() {
        //First, we get the array
        int[] ary = makeArray();
        
        //And see what values we got
        System.out.println("Unsorted array:");
        printArray(ary);
        
        //Next, we sort the array in place (remember ByReference)
        sortArray(ary);
        
        //Or, we could sort it using a Java utility class
        //This method uses a derivative of QuickSort, a much more
        //efficient sorting method
        Arrays.sort(ary);
        
        //And see what values we got
        System.out.println("Sorted array: ");
        printArray(ary);
    }
    
    /**
     * Demonstrates multiple methods of initializing arrays.
     * 
     * @return A new unsorted integer array
     */
    private static int[] makeArray() {
        //Instantiate the array the long way
        int[] newArray = new int[6];
        newArray[0] = 1;
        newArray[1] = 6;
        newArray[2] = 2;
        newArray[3] = 5;
        newArray[4] = 8;
        newArray[5] = 4;
        
        //For this small example, here's a better way
        int[] newArray2 = { 1, 6, 2, 5, 8, 4 };
        
        //Or if we're going programmatic...
        int[] newArray3 = new int[ARRAY_LENGTH];
        Random rnd = new Random();
        
        for(int cnt = 0; cnt < newArray3.length; cnt++) {
            newArray3[cnt] = rnd.nextInt(newArray3.length);
        }
        
        return newArray3;
    }
    
    /**
     * Prints all elements of an integer array.
     * 
     * @param ary The array to be printed
     */
    private static void printArray(int[] ary) {
        for(int item : ary) {
            System.out.println(item);
        }
    }
    
    /**
     * Uses SelectionSort to sort array elements in-place
     * @param ary The array to be sorted
     */
    public static void sortArray(int[] ary) {
        //This method is known as SelectionSort
        
        for(int target = 0; target < ary.length - 1; target++) {
            for(int search = 1; search < ary.length; search++) {
                if(ary[target] < ary[search]) {
                    int tmp = ary[target];
                    ary[target] = ary[search];
                    ary[search] = tmp;
                    
                }
            }
        }
        
    }
}
