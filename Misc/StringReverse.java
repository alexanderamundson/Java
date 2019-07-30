//Provides several ways to reverse a string
public class StringReverse {

	public static void main(String[] args) {
	  System.out.println(reverseWithStringBuilderMethods("Not a palindrome"));
	  System.out.println(reverseWithStringBuilderManually("was it a car or a cat I saw"));
	  System.out.println(reverseStringManually("was it a car or a cat I saw"));
	  
	}	
	
	//reverses string with StringBuilder methods
	private static String reverseWithStringBuilderMethods(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
	//reverses string manually with StringBuilder
	private static String reverseWithStringBuilderManually(String str) {
		StringBuilder string = new StringBuilder();
	
		for (int i=str.length() - 1; i >= 0; i-- ) {
			string.append(str.charAt(i));
		}
		return string.toString();
	}
	
	
	//reverse string manually as string object
	private static String reverseStringManually(String str) {	
		String reversedString = "";
		char temp;
		for (int i = str.length() -1; i >= 0; i--) {
			reversedString += str.charAt(i) ;//creates a new String object in memory each time			
		}
		return reversedString;
	}
}
//When performing operations on as string, the use of StringBuilder is preferred
//because it is mutable. A normal String object is immutable, therefore each time
//a String is changed, it creates a new reference in memory for a new object.