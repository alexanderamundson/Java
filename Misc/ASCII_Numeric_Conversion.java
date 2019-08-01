import java.util.Scanner;
public class ASCII_Numeric_Conversion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an integer between 33 and 126");
		int input = Integer.parseInt( scanner.next() );
		
		ASCII_to_character(input);	
	}
   
	//Prints the character that corresponds to the given ASCII number
	private static void ASCII_to_character(int ascii) {
		String output = Character.toString((char) ascii);
		System.out.printf("The ASCII value %d corresponds to the character: %8s", ascii, output);
	}
}

	
	
