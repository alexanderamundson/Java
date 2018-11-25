package InsertionSortPackage;


public class Test_Insertion_Sorter {
	public static void main(String args[]) {

		Dataset data = new Dataset();
		
		InsertionSorter is = new InsertionSorter();
		is.sortData(data.getValues() ) ;
		
	}
}
