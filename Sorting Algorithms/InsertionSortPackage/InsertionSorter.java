package InsertionSortPackage;

public class InsertionSorter {
	//Sorts dataSet with insertion sort
	public static void sortData(int [] dataSet) {
		displayUnsortedArray(dataSet);
		
		int val=0;
		int count=0;
		for (int i=1; i < dataSet.length; i++) {
			
		}
		
		
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
	


