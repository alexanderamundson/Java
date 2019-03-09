//Alex Amundson
//CS 4  (operating systems)
//Assignment2 (CPU scheduling algorithms simulation)
import java.util.Random;
import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random randomGenerator = new Random();		
		ReadyQueue queue = new ReadyQueue(); 


		//create 5 random processes with distince IDs
		generate5processes(randomGenerator, queue);	
		//display initial snapshot of ready queue
		displayQueueSnapshot(queue);

		//Allow user to create new processes
		createNewProcess(scan, queue);



	}//end of main method


	private static void createNewProcess(Scanner scan, ReadyQueue queue) {
		boolean queueIsFull = false;
		boolean stop = false;
		while (!queueIsFull  ||  stop) {
			System.out.println("Would you like to create another process? (enter Y or N)");
			String input = scan.next();
			switch (input) {
			  case "Y": createUserProcess();
			    break;
			  case "N":  
				  stop = true;
				break;
			default: System.out.println("Invalid input! Enter capitol Y or N. Try Again");
			//call this method again
			  break;
			}
		}//end of while loop
	}


	//displays snapshot of initial 5 processes
	private static void displayQueueSnapshot(ReadyQueue queue) {
		System.out.println("Initial Snapshot\nID\tPriority\tBurstLength");
		for (int i =0; i < queue.size; i++) {
			System.out.println(queue.processList[i].snapshot());
		}
		System.out.println("----------------------------------------");
	}


	//generates initial 5 processes with distinct IDs
	private static void generate5processes(Random randomGenerator, ReadyQueue queue) {
		int randomID;
		int randomBurst =999;
		int randomPriority =999;
		while (queue.size < 5) {
			randomID = randomGenerator.nextInt(11) + 0;
			//System.out.println("ID " + randomID + " is available?  " + PIDavailable(randomID, queue));////
			if (PIDavailable(randomID, queue)) {
				randomBurst = randomGenerator.nextInt(80) + 21;
				randomPriority = randomGenerator.nextInt(10) + 1;
				Process p = new Process(randomID, randomBurst , randomPriority);
				queue.addProcess(p);
				//System.out.println("Added " + p.getID() + "\t-------queue size is now: " + queue.size);////
			}
		}//end of while loop
	} 


	//determines if 'id' is already assigned to an existing process
	static boolean PIDavailable(int id, ReadyQueue queue) {
		if (queue.isEmpty(queue)) {
			return true;
		}
		for (int i =0; i < queue.size; i++) {
			if (queue.processList[i].getID() == id) {
				return false;
			}
		}
		return true;
	}
	
	//Creates process based on user input
	private static void createUserProcess(Random randomGenerator, ReadyQueue queue) {
		int randomID;
		int randomBurst =999;
		int randomPriority =999;
		while (queue.size < 5) {
			randomID = randomGenerator.nextInt(11) + 0;
			//System.out.println("ID " + randomID + " is available?  " + PIDavailable(randomID, queue));////
			if (PIDavailable(randomID, queue)) {
				randomBurst = randomGenerator.nextInt(80) + 21;
				randomPriority = randomGenerator.nextInt(10) + 1;
				Process p = new Process(randomID, randomBurst , randomPriority);
				queue.addProcess(p);
				//System.out.println("Added " + p.getID() + "\t-------queue size is now: " + queue.size);////
			}
		}//end of while loop
	} 


}//end of Tester.java class
