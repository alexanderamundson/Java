
public class DisplayPatterns {
    public static void main(String args []) {
    	patternA(6);
    	patternB(6);
    }
    
    private static void patternA(int length) {
    	System.out.println("\n-----------Pattern A---------------");
    	for (int r = 0; r < length + 1; r++) {
    		for (int c = 1; c <= r; c++) {
    			System.out.print(c + " ");
    		}
    		System.out.println();
    	}
    }
    
    private static void patternB(int length) {
    	System.out.println("\n-----------Pattern B---------------");
    	for (int r = length; r > 0; r--) {
    		for (int c =1; c <= r; c++) {
    			System.out.print(c + " ");
    		}
    		System.out.println();
    	}
    }
    
}
