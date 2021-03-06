/*Instructions:
 * Use multithreading to calculate the sum of values in the rows and columns of a 2d array.
 * The 2d array will be provided in a text file. The user must enter the text file's name.
 */ 
//Alexander Amundson
//Operating Systems
//Spring 2019
//Assignment 1   Multithreading 
import java.util.*;
import java.io.*;

public class Amundson1 {
	public static void main(String [] args) {
		int count = 0, numRows = 0, numColumns = 0;    
		ArrayList<Float> numbers = null; 
		try {
			// Scan for name of input file
			Scanner user = new Scanner( System.in ); 
			String  inputFile;
			System.out.println("Enter input file name with extension (e.g. rowcolumn.txt): ");
			inputFile= user.next();
			Scanner reader = new Scanner(new File(inputFile));

			String a=null; //will store each row of numbers in input file
			numbers = new ArrayList<Float>();

			//store input numbers into arraylist - "numbers"
			//and calculate # of rows and columns - "numRows", "numColumns"
			while (reader.hasNextLine() ) {
				a =  reader.nextLine();
				numRows++;
				String[] num = a.split("\\s+");
				for (int i=0; i < num.length; i++) {
					count++;  
					numbers.add(Float.parseFloat(num[i]) );
				}
				numColumns = count;
				count = 0;
			}
			user.close();
			reader.close();

		} catch (Exception e){
			System.out.println("Sorry, something went wrong.");
			e.printStackTrace();
		}  

		//Transfer numbers into a 2d array - "inArr"
		float [][] inArr = new float [numRows][numColumns];
		int counter=0;
		for (int r=0; r < numRows; r++ ) {
			for (int c=0; c < numColumns; c++ ) {
				inArr[r][c] = numbers.get(counter);
				counter++;
			}	
		}// "inArr" now has all numbers in it  

		RowSum i = new RowSum(inArr, numRows, numColumns);
		i.start();
		ColumnSum j = new ColumnSum(inArr, numRows, numColumns);
		j.start();
	}//end of main method


	static class RowSum extends Thread{
		float [][] data = null;
		float sum;
		int rows;
		int columns;
        
		//constructor
		public RowSum ( float[][] input, int rows, int columns){
			this.data = input;
			this.rows = rows;
			this.columns = columns;
		}
		
		public void run() {
			for (int r=0; r < rows; r++) {
				for (int c=0; c < columns; c++) {
					sum += data[r][c];
				}
				System.out.println("Row Thread "+ (r+1) + " calculates the row " + (r+1) + " sum as: " + sum);
				sum -= sum;//reset sum to zero
			}
		}
	}
	
	static class ColumnSum extends Thread{
		float [][] data = null;
		float sum;
		int rows;
		int columns;

		//constructor
		public ColumnSum ( float[][] input, int rows, int columns){
			this.data = input;
			this.rows = rows;
			this.columns = columns;
		}
		
		public void run() {
			for (int c=0; c < columns; c++) {
			    for (int r=0; r < rows; r++) {
					sum += data[r][c];
				}
				System.out.println("\tColumn Thread "+ (c+1) + " calculates the column " + (c+1) + " sum as: " + sum);
				sum -= sum;//reset sum to zero
			}
		}
	}
}
