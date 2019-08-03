/**********
 * 
 * A shutdown hook is a piece of code that is executed when the JVM is shutting down.
 * A shutdown hook will run AFTER System.exit() is called
 * A shutdown hook can be used to save the state when the JVM is shutdown unexpectedly
*/

public class ShutdownHook { 
  public static void main(String[] args) { 
	  
	  Runtime.getRuntime().addShutdownHook(new Thread() { 
	      public void run() { 
	        System.out.println("Step 2:   Shutdown Hook runs");  
	      } 
	    }); 
	  System.out.println("Step 0.   Program is being executed...");
	  shutdownJVM();
  }//end of main method 
  
  public static void shutdownJVM() {
	  System.out.println("Step 1.    System.exit() is called");
	  System.exit(0);    
	  System.out.println("This statement will not be executed because +"
	                     		+ "it is after System.exit is called and NOT in the shutdown hook");
	
  }
} 