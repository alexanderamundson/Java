package MergeSortPackage;


public class Test_Merge_Sorter {
	public static void main(String args[]) {

		Dataset data = new Dataset(5);
		
		Merge_Sorter ms = new Merge_Sorter();
		ms.sortData(data.getValues() ) ;
		
	}
}
