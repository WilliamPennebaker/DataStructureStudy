import java.util.Random;

/**
 * 
 * Arrays
 * 
 * An array organizes items sequentially, one after another in memory.
 * 
 * Each position in the array has an index, starting at 0.
 * 
 * Time complexitys (worst case):
 *  - Space O(n)
 *  - Lookup O(1)
 *  - Append O(1)
 *  - Insert O(n)
 *  - Delete O(n)
 * 
 * Strengths:
 *  - Fast lookups - Retreiving an element at a given index takes O(1) time regardless of the array size.
 *  - Fast appends - Adding an element at the end of the array would take O(1) time. (If the array has space.)
 * 
 * Weakness:
 *  - Fixed size - Need to specify how many elements to store in array, unless you're using a dynamic array.
 *  - Costly inserts and deletes - 
 */


public class ArraySorts {
    public static void main(String[] args) throws Exception {
        //Original array with a fixed size of ten.
        int arr[] = new int[10];
        //Using Random to fill array with random ints from 0-99.
        Random myRandom = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myRandom.nextInt(100);
        }
        //Cloning array so we can refer to it after being changed.
        int arrCopy[] = arr.clone();
        printArray(arr);
        System.out.println("After Insertion Sort:");
        //Running insertion sort
        insertionSort(arr);
        printArray(arr);
        

        System.out.println("~~~~~Copying Original Array~~~~~");
        arr = arrCopy.clone();
        printArray(arr);
        System.out.println("After Selection Sort:");
        //Running selection sort
        selectionSort(arr);
        printArray(arr);


        System.out.println("~~~~~Copying Original Array~~~~~");
        arr = arrCopy.clone();
        printArray(arr);
        System.out.println("After Bubble Sort:");
        //Running bubble sort
        bubbleSort(arr);
        printArray(arr);


        
    }

    /**
     * Insertion Sort Method
     * Insertion Sort divides the array into the "sorted" and "unsorted" subarrays.
     * Time Complexity:
     * Worst case scenario would be if the whole array is descending. In each iteration, we have to move the whole sorted
     * list by one, which would be O(n). So for each element of each array would bound us by O(n^2).
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            // Here we exit, J is either -1 or at the first elem where current > arr[j]
            arr[j+1] = current;
        }
    }

    /**
     * Selection Sort Method
     * Selection Sort divides the array into the "sorted" and "unsorted" subarrays by inserting the minimum elem of the 
     * unsorted array at the end of the sorted array.
     * Time Complexity:
     * O(n) for checking all of the elements. Finding the minimum of each elem of the array.
     * So in total this would be O(n^2).
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minId = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minId = j;
                }
            }
            // Swapping
            int temp = arr[i];
            arr[i] = min;
            arr[minId] = temp;
        }
    }

    /**
     * Smooth Sort Method
     * 
     */

    /**
     * Bubble Sort Method
     * Time complexity:
     * Always be O(n^2) here.
     * The while loop can run a maximum of n times. We iterate through the whole array n times, so this would be O(n^2).
     */
    public static void bubbleSort(int[] arr) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false; 
                }
            }
        }
    }

    /**
     * Shell Sort Method
     * 
     */

    /**
     * Merge Sort Method
     * 
     */

    /**
     * Quick Sort Method
     * 
     */

    /**
     * Heap Sort Method
     * 
     */

    /**
     * 
     * 
     */

    /**
     * Print Array Method
     * 
     */
    public static void printArray(int[] arr) {
        System.out.println("Our int array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
