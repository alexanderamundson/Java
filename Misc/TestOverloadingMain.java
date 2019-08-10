
public class TestOverloadingMain {
	public static void main(String[] args){System.out.println("main with String[]");}//correct  
	public static void main(String args){System.out.println("main with String");}  //main method not found error
	public static void main(){System.out.println("main without args");}  //main method not found error
		
}  