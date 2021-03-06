package BubbleSortPackage;
import java.lang.Math;

public class Dataset {
	private int values[];
	//Instantiates this.values with random number of elements
	public Dataset() {		
		this.values = new int[14];
		for (int i =0; i < 14; i++) {
			this.values[i] = (int) (Math.random() * 100) + 1;

		}
	}


	//Instantiates this.values with "length" values
	public Dataset(int numberOfValues) {
		this.values = new int[numberOfValues];
		for (int i =0; i < numberOfValues; i++) {
			this.values[i] = (int) (Math.random() * 100) + 1;
		}

	}


	//Returns the array of values in this data set
	public int[] getValues() {
		return this.values;
	}


	//@Overide
	public String toString() {
		String output = "";
		for (int i = 0; i < this.values.length; i++) {
			output += this.values[i];
		}
		return output;
	}
}