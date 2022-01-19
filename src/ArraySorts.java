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
    public static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // calculating lengths
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
    
        // creating temporary subarrays
        int leftarr[] = new int [lengthLeft];
        int rightarr[] = new int [lengthRight];
    
        // copying our sorted subarrays into temporaries
        for (int i = 0; i < lengthLeft; i++)
            leftarr[i] = arr[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightarr[i] = arr[mid+i+1];
    
        // iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;
    
        // copying from leftArray and rightArray back into array
        for (int i = left; i < right + 1; i++) {
            // if there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftarr[leftIndex] < rightarr[rightIndex]) {
                    arr[i] = leftarr[leftIndex];
                    leftIndex++;
                }
                else {
                    arr[i] = rightarr[rightIndex];
                    rightIndex++;
                }
            }
            // if all the elements have been copied from rightArray, copy the rest of leftArray
            else if (leftIndex < lengthLeft) {
                arr[i] = leftarr[leftIndex];
                leftIndex++;
            }
            // if all the elements have been copied from leftArray, copy the rest of rightArray
            else if (rightIndex < lengthRight) {
                arr[i] = rightarr[rightIndex];
                rightIndex++;
            }
        }
    }
    /**
     * Quick Sort Method
     * 
     */
    public static int partition(int[] arr, int begin, int end) {
        int pivot = end;
    
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;
    
        return counter;
    }
    
    public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot-1);
        quickSort(arr, pivot+1, end);
    }
     
    /**
     * Heap Sort Method
     * 
     */
    public static void heapify(int[] arr, int length, int i) {
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int largest = i;
    
        // if the left child is larger than parent
        if (leftChild < length && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
    
        // if the right child is larger than parent
        if (rightChild < length && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
    
        // if a swap needs to occur
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, length, largest);
        }
    }
    
    public static void heapSort(int[] arr) {
        if (arr.length == 0) return;
    
        // Building the heap
        int length = arr.length;
        // we're going from the first non-leaf to the root
        for (int i = length / 2-1; i >= 0; i--)
            heapify(arr, length, i);
    
        for (int i = length-1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
    
            heapify(arr, i, 0);
        }
    }

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
