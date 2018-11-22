package BubbleSortPackage;

public class Test_Bubble_Sorter {
	public static void main(String args[]) {

		Dataset data = new Dataset();
		
		BubbleSorter bs = new BubbleSorter();
		bs.sortData(data.getValues() ) ;
		
	}
}
