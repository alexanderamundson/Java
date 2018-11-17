package SelectionSortPackage;

public class Selection_Sorter {

	//Sorts dataSet with selection sort
	public static void sortData(int [] dataSet) {
		displayUnsortedArray(dataSet);
		int minIndex;
		for (int i =0; i < dataSet.length - 1; i++) {
			minIndex = i;
			for (int j = i+1; j < dataSet.length; j++) {
				if (dataSet[j] < dataSet[minIndex]) {
					minIndex = j;
				}
				
			}
			int temp = dataSet[minIndex];
			
			dataSet[minIndex] = dataSet[i];
			dataSet[i] = temp;
			
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
