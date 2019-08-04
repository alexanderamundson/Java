import java.util.Scanner;
public class BaseConversion {
	public static void main(String arguments []) {
		see();
	}


	private static void see() {
		Scanner scanner = new Scanner(System.in);
		int choice = getUserChoice(scanner);
		boolean tryAgain = true;
		while (tryAgain) {
			switch (choice) {
			case 0:   closeProgram(scanner);  
			case 1:   decimalToHex(scanner);
				choice = getUserChoice(scanner);
				break;
			default: System.out.println("Must enter integer between 0 and 3 ");
			choice = getUserChoice(scanner);
			break;
			}
		}
	}


	//Returns the integer which corresponds to the method the
	//user wants to run
	private static int getUserChoice(Scanner scanner) {
		StringBuilder options = new StringBuilder("\n\n------------Options------------ ");
		options.append("\n0 -- to exit program\n1-- Convert decimal to hexadecimal value");
		System.out.println(options);
		return scanner.nextInt();
	}
    
	
	//Converts input decimal number to hexadecimal
	private static void decimalToHex(Scanner scanner) {
		System.out.println("Enter a positive integer number: ");
		StringBuilder hex = new StringBuilder();
		int input = scanner.nextInt();
		int decimal = input;
		while (decimal != 0) {
			int remainder = decimal % 16;
			char hexDigit = remainder < 10 ? ( (char)(remainder + '0') ) : ((char)(remainder - 10 + 'A'));
			hex.append(hexDigit);
			decimal /= 16;
		}
		System.out.printf("%d in decimal is %s in hexadecimal", input, hex.reverse());
	}

	//Terminates the program
	private static void closeProgram(Scanner scanner) {
		scanner.close();
		System.out.println("Successfully exiting current program and terminating running Java virtual machine");
		System.exit(0);
	}
}
