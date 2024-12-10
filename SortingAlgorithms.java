package testPackage;

import java.util.Arrays;


public class SortingAlgorithms {

		//taken from class notes
		//copies the randomised arrays to ensure constant input
		//this ensures proper benchmarking times
		//
	    public int[] copyArr(int[] src){ //copies array
	        int[] dest = new int[src.length];
	        System.arraycopy(src, 0, dest, 0, src.length);
	        return dest;
	    }
	    
	    public int[] randomArray(int n){ // creates random array
	        int[] array = new int[n];
	        for (int i = 0; i< n; i++){
	            array[i] = (int) (Math.random() * 100);
	        }
	        return array;
	    }
	    
	    public double benchmark(int reps, String algorithm, int size){
	        double total =0;
	        //int[] arr = randomArray(10000);
	        int[] arr = randomArray(size); //size is the same as arraySizes (in main) so it runs the different array sizes given
	        for (int i = 0; i<reps; i++){
	            int[] cloned = copyArr(arr); //clones array
	            long startTime = System.nanoTime(); //takes time as a start time
	           // radixSort(cloned);
	            
	            switch (algorithm) { //runs "algorithm" to run each sorting algorithm as specified in main
	            case "bubble":		 
	            	bubbleSort(cloned); //runs bubbleSort on cloned arrays
	            	break;
	            case "insertion":
	            	insertionSort(cloned); //runs insertionSort on cloned arrays
	            	break;
	            case "selection":
	            	selectionSort(cloned); // runs selectionSort on cloned arrays
	            	break;
	            case "merge":
	            	mergeSort(cloned, cloned.length); //runs mergeSort on cloned arrays
	            	break;
	            case "radix":
	            	radixSort(cloned); // runs radixSort on cloned arrays
	            	break;
	            default:
	            	throw new Error("Algorithm name: " + algorithm + " not found"); //if none of the above happens, output the error
	            }
	            
	            long endTime = System.nanoTime(); //takes time as the end time
	            long timeElapsed = endTime-startTime; //finds the time taken to run the switch statement by taking the start time away from the end time
	            double elapsedMillis = timeElapsed/1000000.0; //gets the time in milliseconds
	            total += elapsedMillis; //makes total equal to the time taken in milliseconds 
	            //System.out.println(Arrays.toString(cloned));

	        }
	        //System.out.println("it took " + total + " to run it " + reps + " times");
	        //System.out.println(Arrays.toString(arr));
	        return total/reps; //divides the time by reps to get the average time for each rep of the array
	    }
	    
	
	
	//TODO: BUBBLE SORT
	//Taken from notes
    public void bubbleSort(int[] arr){
      //  System.out.println("In the beginning" + Arrays.toString(arr));
        int n = arr.length;
        boolean swapped = false;
        do {
            swapped = false;
            for (int i=1; i<n; i++){
                if (arr[i-1] > arr[i]){ //checks if the left element is greater than the right element
                   // System.out.println(arr[i] + "and" + arr[i-1]);
                    int temp = arr[i-1]; //creates a temporary variable to hold a copy of the element while they swap places
                    arr[i-1] =arr[i];    
                    arr[i] = temp;
                    swapped = true;
                   // System.out.println(Arrays.toString(arr));
                }
            
            }
            n--; 
            //This "n--" turns this into a modified bubble sort, thus making it more efficient as the end of the array
            //is not sorted and does not need to be re-sorted

        } while (swapped);
        //System.out.print("Nothing was swapped, we are done");
    }

    	//TODO: INSERTION SORT
    	//Taken from notes
    	public void insertionSort(int[] arr) {
    		int i=1;
    		//System.out.println("In the beginning" + Arrays.toString( arr));
    		
    		while (i<arr.length) { //runs for the length of the array
    			int j=i;
    			while(j>0 && (arr[j-1]>arr[j])) { //looks through the array for an element smaller than the current [j] element
    				//System.out.println("Swapping" + arr[j] + "and" + arr[j-1]);
    				int temp = arr[j];  //creates a temporary variable to hold the element while they swap
    				arr[j] = arr[j-1];
    				arr[j-1] = temp;
    				//System.out.println("After the swap: " + Arrays.toString(arr));
    				j--;
    			}
    			i++;
    		}
    		//System.out.println("In the end" + Arrays.toString(arr));
    	}
    	
    	//TODO: SELECTION SORT
    	//Taken from notes
    	public void selectionSort(int arr[]) {
    		int n = arr.length;
    		
    		//System.out.println("unsorted: " + Arrays.toString(arr));
    		for (int i = 0; i<n-1; i++) {
    			
    			int minIndex = i;
    			for (int j=i+1; j<n; j++) { //finds the minimum index of the array for that loop
    			if (arr[j]< arr[minIndex]) {
    				minIndex = j;
    			}
    		}
    			int temp = arr[minIndex]; //creates a temporary variable to hold the value of the element while they swap
    			arr[minIndex] = arr[i];
    			arr[i] = temp;
    			
    			//int[] newArr = Arrays.copyOfRange(arr,  0,  i+1);
    			//System.out.println("Sorted sub list: " + Arrays.toString(newArr));
    		}
    		//System.out.println("sorted: " + Arrays.toString(arr));
    	}
    	
    	//TODO: MERGE SORT
    	//Taken from Nikhil Lohia's code on studyalgorithms.com 
    	public void mergeSort(int[] arr, int numberOfElements) {
    		if (numberOfElements<2) {
    			return; //if there's just one element, it can't be sorted, just return it
    		}
    		
    		int mid = numberOfElements/2; //creates two arrays that are divided from the original array
    		int[] leftArr = new int[mid];  
    		int[] rightArr = new int[numberOfElements-mid];
    		
    		for(int i=0; i<mid; i++) { //fills the left array with the first half of the original array
    			leftArr[i] = arr[i];
    		}
    		
    		for (int i=mid; i<numberOfElements; i++) { //fills the right array with the second half of the original array
    			rightArr[i-mid] = arr[i];
    		}
    		
    		mergeSort(leftArr, mid); //divides again
    		
    		mergeSort(rightArr, numberOfElements-mid); //divides again
    		
    		merge(arr, leftArr, rightArr, mid, numberOfElements-mid); //runs merge on the sub-arrays
    		}
    	
    	private void merge (int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
    		int i=0, j=0, k=0; // "i" is left array, "j" is right array, "k" is new array
    		
    		while (i<left && j<right) { //runs for the length of the sub-arrays
    			if (leftArr[i] <= rightArr[j]) { //if left element is less than right element, 
    				arr[k++] = leftArr[i++]; //make that the next element in new array and run again
    			}
    			else {
    				arr[k++] = rightArr[j++]; //otherwise make right element the next element in new array
    			}
    		}
    		
    		while (i<left) { //remaining values are put in new array (if the sub-arrays were not equal in size)
    			arr[k++] = leftArr[i++];
    		}
    		while (j<right) {
    			arr[k++] = rightArr[j++];
    		}
    	}
    	
    	//TODO: RADIXSORT
    	//Taken from Nikhil Lohia's code on studyalgorithms.com 
    	/*I removed the extra code that ensures correct sorting with negative
    	 * integers as I have not included that in any other algorithm */
    	//Counting Sort is used to sort each element at the digit level before moving to the next digit
    	//i.e. sorting the "1's" with counting sort before the "10's"
    	public void countingSort(int[] arr, int place) {
    		int size = arr.length;
    		int max = Arrays.stream(arr).max().getAsInt(); //check the maximum number we have
    		int[] output = new int[size+1]; //creates output array
    		int[] count = new int[max+1];  //creates array to count the times equal elements are found
    		
    		
    		for (int j : arr)
    			count[(j/place) % 10]++;
    		
    		for (int i=1; i<10; i++)
    			count[i] += count[i-1]; //this takes count of how many times each number between 1 and 10 appears in the array
    		
    		for (int i= size-1; i>=0; i--) {
    			output[count[(arr[i]/place) % 10] -1] = arr[i]; //this places the element in the output array at the last place it can be
    			count[(arr[i]/place) %10]--; //this reduces the count of the amount of times that element is found
    		}
    		System.arraycopy(output,  0,  arr,  0,  size);		
    	}
    	
    	public void radixSort(int[]arr) {
    		
    		int max = Arrays.stream(arr).max().getAsInt(); // checks the size of the maximum number we have so we can know how many times to sort
    		
    		for (int place = 1; max/place >0; place *=10)
    			countingSort(arr, place); //initialises counting sort for the current digits of elements
    		
    		
    		//System.out.println("Sorted :))");
    		
    		 
    		}
    	
    	
    	
    	
    	
    	
public static void main(String[] args){
	
	//These segments are to test the sorting algorithms separately
	//I used them to test that the algorithms were working before moving on
	
	/*SortingAlgorithms test = new SortingAlgorithms();
    int[] sampleArray = {5,1,4,2,8};
   test.bubbleSort(sampleArray);
  
   System.out.println("*******************INSERTION*********************");
   int[] secondArray = {6,8,2,3,9,5};
   test.insertionSort(secondArray);
   
   System.out.println("*******************SELECTION*********************");
   int[] SelectionArray = {9,2,8,4,2,6};
   test.selectionSort(SelectionArray);
   
   System.out.println("********************RADIX**************************");
   int[] radixArray = {87,287,7,3,98,90};
   System.out.println("Original array: " + Arrays.toString(radixArray));
   test.radixSort(radixArray);
   System.out.println("Sorted array: " + Arrays.toString(radixArray));
   
   //Radix sort time is more than counting sort but the bins are limited :))// 
   //Saves space//
   System.out.println("********************MERGE*************************");
   int[] mergeArray = {2,8,4,0,76,34,85};
   System.out.println("Original Array: " + Arrays.toString(mergeArray));
   test.mergeSort(mergeArray, 7);
   System.out.println("Sorted Array: " + Arrays.toString(mergeArray));*/

   SortingAlgorithms w = new SortingAlgorithms();
   
   //This is called back in the benchmark code with the "cases" in the switch statement
   String[] algorithmNames = {
		   "bubble",
		   "selection",
		   "insertion",
		   "merge",
		   "radix"
   };
   
   //This is the list of array sizes that each sort will have as size input 
   int[] arraySizes = {100, 250, 500, 750, 1000, 2500, 3750, 5000, 6250, 7500, 8750, 10000};
   
   
//   This is to warm up and stabilise the JVM performance to ensure correct times
//   This is because Java can take a while to warm up and it will affect the times
//   of the algorithms performed first and skew the data
//   There is no output as it is only to warm up the JVM and outputting the data
//   will slow down the program
//	 It is not timed and should not mess with any output times
   for (int i = 0; i < algorithmNames.length; i++) {
    String algorithm = algorithmNames[i];
    w.benchmark(5, algorithm, 1000);
   }
   
   	//This is the same as the warm up code above except its the shorter version
//   for(String algorithmName : algorithmNames) {
//	   w.benchmark(5, algorithmName, 1000);
//   }

   

   
   //This is the main code with two for-loops in it
   //It iterates through the sorting algorithms
   //The inside loop iterates first
   //This tests the current sorting "algorithm/algorithmNames" by using the copy of 
   //the randomised arrays from earlier as input (w.benchmark), with 10 reps each of the
   //different array sizes
   //Then once the inside for-loop is complete, it moves back to the outer loop which moves
   //to the next sorting algorithm, and completes the inside for-loop again
   //i.e. This code iterates over the sorting algorithms, testing each one 10 times with the 
   //array sizes from "arraySizes"
   for(int i=0; i<algorithmNames.length; i++) {
	   String algorithm = algorithmNames[i];
	   System.out.println("Algorithm: " + algorithm);
	   for(int j=0; j<arraySizes.length; j++) {
		   int size = arraySizes[j];
		   double averageTime = w.benchmark(10,  algorithm, size);
		   System.out.println("Size: " + size + ", Average Time: " +averageTime + " ms");
	   }
	   System.out.println();
   }
 
   //This is the same code as above but the shorter version
// for(String algorithm : algorithmNames) {
//   System.out.println("Algorithm: " + algorithm);
//   for(int size : arraySizes) {
//	   double averageTime = w.benchmark(10, algorithm, size);
//	   System.out.println("Size: " + size + ", Average Time: " +averageTime + " ms");
//   }   
//   System.out.println();
//}
   
}

}
