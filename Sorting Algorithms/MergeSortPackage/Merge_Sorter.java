package MergeSortPackage;

public class Merge_Sorter {

	//Sorts dataSet with merge sort
	public static void sortData(int [] dataSet) {
		displayUnsortedArray(dataSet);
		//MergeSort Algorithm goes here
		


		displaySortedArray(dataSet);
	}
	
	
	//displays the array before sorting
		static void displayUnsortedArray(int[] data) {
			System.out.println("\nArray BEFORE sorting: ");
			for (int i=0; i < data.length; i++) {
				System.out.print(data[i] + ", ");
			}
		}
	
	//displays the array after sorting
	static void displaySortedArray(int[] data) {
		System.out.println("\n\nArray AFTER sorting: ");
		for (int i=0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
	}
}
