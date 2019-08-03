import java.util.Scanner;
public class UnicodeASCII {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = getUserChoice(scanner);
			
		boolean tryAgain = true;
		while (tryAgain) {
			switch (choice) {
			case 0: tryAgain = false;  closeProgram(scanner);  
			case 1: ASCII_to_character(scanner);
			           choice = getUserChoice(scanner);
			           break;
			case 2: characterToUnicode(scanner); 
			           choice = getUserChoice(scanner);
			           break;
			case 3: ;
					   break;
			default: System.out.println("Must enter integer between 1 and _____ ");
					  break;
			
			}
		}
	}
	
    //Returns which option the user chooses
	private static int getUserChoice(Scanner scanner) {
		StringBuilder options = new StringBuilder("\n\n------------Options------------ ");
		options.append("\n0 -- to exit program\n1-- Convert ASCII number to char value");
		options.append("\n2-- Convert character to Unicode value");
		System.out.println(options);
		return scanner.nextInt();
	}
   
	//Prints the character that corresponds to the given ASCII number
	private static void ASCII_to_character(Scanner scan) {
		int ascii = Integer.parseInt( scan.next() );
		System.out.println("\nEnter an integer between 33 and 126");
		String output = Character.toString((char) ascii);
		System.out.printf("The ASCII value %d corresponds to the character: %8s", ascii, output);
	}
	
	//Prints the Unicode corresponding to character entered by user
	private static void characterToUnicode(Scanner scan) {
		System.out.println("\nEnter a single character");
		char input = scan.next().charAt(0);
		System.out.printf("The character '%c' corresponds to the Unicode value: %5d", input, (int)input );
		
	}
	
	//Terminates the program
	private static void closeProgram(Scanner scanner) {
		scanner.close();
		System.out.println("Successfully exiting current program and terminating running Java virtual machine");
		System.exit(0);
		
	}
}

	
	