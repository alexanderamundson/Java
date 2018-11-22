package BubbleSortPackage;

public class BubbleSorter {

	public static void sortData(int [] array) {
		displayUnsortedArray(array);
		for (int i=0; i < array.length; i++ ) {
			for (int j =0; j < array.length - i - 1; j++) {
				if (array[j] > array[j+1]) {
					int temp=array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		displaySortedArray(array);
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
		System.out.println("\n\nArray AFTER Bubble Sort: ");
		for (int i=0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
	}

}
