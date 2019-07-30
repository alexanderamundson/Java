
public class ArrayPractice1 {
	public static void main (String [] args) {
		//1D arrays
		unionOf2Arrays();
		intersectionOf2Arrays();
		displayMaximumMinimumForm();
		//2D arrays
		transpose2DArray();

	}

	//Displays the union of 2 arrays
	//(arrays are sorted and contain no duplicate elements)
	private static void unionOf2Arrays() {
		System.out.println("-----UNION OF TWO ARRAYS-----");
		int[] array1 = {0,1, 2, 4, 6 };
		int[] array2 = {2, 3, 5, 6, 7, 9, 11 };
		displayArray(array1, "Array1"); displayArray(array2, "Array2");
		int counter1 = 0;//counter variable for array1
		int counter2 = 0;//counter for array2
		System.out.println("Union of Array1 and Array2: ");
		//Iterate until you have gone through all elements in the shorter array
		while ( (counter1 < array1.length) && (counter2 < array2.length) ) {
			if (array1[counter1] < array2[counter2]) {
				System.out.print(array1[counter1]  + ", ");
				counter1++;
			} else if (array2[counter2] < array1[counter1]) {
				System.out.print(array2[counter2]  + ", ");
				counter2++;
			} else if (array2[counter2] == array1[counter1])   {
				System.out.print(array2[counter2]  + ", ");
				counter1++; counter2++;//increment BOTH counter1 and counter2
			}			
		}
		//Print out remaining elements in longer array
		while (counter1 < array1.length) {
			System.out.print(array1[counter1] + ", ");
			counter1++;
		}
		while (counter2 < array2.length) {
			System.out.print(array2[counter2] + ", ");
			counter2++;
		}
		System.out.println("\n__________________________________");
	}//end of UnionOf2Arrays method


	//Displays the intersection of 2 arrays
	//(arrays are in ascending order and contain no duplicate elements )
	private static void intersectionOf2Arrays() {
		System.out.println("-----INTERSECTION OF TWO ARRAYS-----");
		int[] arr1 = {0,1,3,4,6,8};
		int[] arr2 = {2,3,4,5,6,7,9};
		displayArray(arr1, "Array1"); displayArray(arr2, "Array 2");//display both arrays
		int counter1 = 0, counter2 = 0; //counter variable for each array
		//Iterate until you get to end of shorter array 
		while (counter1 < arr1.length && counter2 < arr2.length) {
			if (arr1[counter1] < arr2[counter2] ) {
				counter1++;
			} else if (arr2[counter2] < arr1[counter1] ) {
				counter2++;
			} else { // if arr2[counter2] == arr1[counter1], then that number is in both arrays
				System.out.println(arr1[counter1] + " is in both arrays");
				counter1++;   counter2++;//increment BOTH counter1 and counter2
			}
		}	
		System.out.println("____________________________________");
	}//end of intersectionOf2Arrays method


	//Displays given array in max-min form as follows:
	//    {largest#, smallest#, 2ndLargest#, 2ndSmallest# ... }
	// The array is sorted 	
	private static void displayMaximumMinimumForm() {
		System.out.println("-----MaxMinForm-----");
		int[] array = {1,2,3,4,5,6,7,8,9,10,11};
		displayArray(array, "Array:");
		int[] minMaxArray = new int[array.length];
		int counter=0,   min = 0;
		int max = array.length - 1;
 
		//runs until minMaxArray is full
		while (true) {				
			minMaxArray[counter++]  = array[max--];//add max element
			//if counter==array.length, then minMaxArray is full
			if (counter == array.length ) { //check if you have iterated through each element in the array
				break;//break out of loop when minMaxArray is full
			}
			minMaxArray[counter++] = array[min++];//add min element
			if (counter == array.length ) {
				break;
			}			
		}
		displayArray(minMaxArray, "Array in Max-Min form");
		System.out.println("\n__________________________________");
	}//end of maxMinForm method

	
	//Transposes an matrix (2D array)
	//(all rows have 'n' elements and all columns have 'm' elements)
	private static void transpose2DArray() {
		System.out.println("-----Transpose-----");
		int [][] array = {  {1,2,3,4},
			                      {5,6,7,8},
			                      {9,10,11,12}   };
		display2DArray(array, "Before transposing:");
		int [][] transpose = new int [array[0].length][array.length];
		for (int r = 0; r < array.length; r++) {
			for (int c = 0;  c < array[r].length; c++) {
				transpose[c][r] = array[r][c];		
			}
		}
		//display transpose array on screen
		display2DArray(transpose, "After transposing:");
		System.out.println("\n__________________________________");
	}//end of transpose 2D array method
	
	
	//Displays the input array 'arr'
	private static void displayArray(int[] arr) {
		for (Integer I: arr) {
			System.out.print(I + ", ");
		}
		System.out.println();
	}//end of displayArray(int[]) method

	
	//Displays the input array 'arr' and its name
	private static void displayArray(int[] array, String arrayName) {
		System.out.print(arrayName + ":   ");
		for (Integer I: array) {
			System.out.print(I + ", ");
		}
		System.out.println();
	}//end of displayArray(int[] , String) method 
	
	
	//Displays the given 2D array and a message 
	private static void display2DArray(int[][] array, String message) {	
		System.out.println(message);
		for (int[] row: array) {
			for (int column = 0; column < row.length; column++) {
			  System.out.print(row[column] + ", ");
			} 
			System.out.println();
		}
	}//end of display2DArray method
}