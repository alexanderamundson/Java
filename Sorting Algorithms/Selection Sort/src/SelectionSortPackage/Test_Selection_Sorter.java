package SelectionSortPackage;


public class Test_Selection_Sorter {
	public static void main(String args[]) {

		Dataset data = new Dataset(5);
		
		Selection_Sorter ss = new Selection_Sorter();
		 ss.sortData(data.getValues() ) ;
		
	}
}
