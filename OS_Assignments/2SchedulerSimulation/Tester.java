//Alex Amundson
//CS 4  (operating systems)
//Assignment2 (CPU scheduling algorithms simulation)
import java.util.Random;
import java.util.Scanner;
public class Tester {
	public static Scanner scan = new Scanner(System.in);
	public static Random randomGenerator = new Random();		
	public static ReadyQueue readyQueue = new ReadyQueue(); 


	public static void main(String[] args) {
		//create 5 random processes with distince IDs
		generate5processes();	
		//display initial snapshot of ready queue
		displayQueueSnapshot();

		//Allow user to create new processes
		createNewProcesses();
		
		int processingTime = getTotalBurstTimes();

		//(i) Non-preemptive SJF
		SJF runSJF = new SJF(readyQueue);
		runSJF.run();
		/*
		//(ii) Non-preemptive priority
		nonPreemptivePriority runNPP = new nonPreemptivePriority(readyQueue);
		//(iii) round robin with time quantum 20.
		RoundRobin runRR = new RoundRobin(readyQueue);
		*/
	}//end of main method


	private static void createNewProcesses() {
		boolean queueIsNotFull = true;
		boolean stop = false;
		while (!stop && queueIsNotFull ) {
			System.out.println("Would you like to create another process? (enter Y or N)");
			String input = scan.next();
			switch (input) {
			case "Y": createUserProcess();
						  if ( readyQueue.isFull(readyQueue) ) {//ensure queue is not already full
							  queueIsNotFull=false;
							  System.out.println("Ready Queue is at max capacity");
						  }
				break;
			case "N":  
				stop = true; 
				break;
			default: System.out.println("Invalid input! Enter capitol Y or N. Try Again!");
			//call this method again
			break;
			}
		}//end of while loop
		System.out.println("\n\nDone with creating processes...heres a new snapshot: " );
		displayQueueSnapshot();
	}


	//displays snapshot of initial 5 processes
	private static void displayQueueSnapshot() {
		System.out.println("\nID\tPriority\tBurstLength");
		for (int i =0; i < readyQueue.size; i++) {
			System.out.println(readyQueue.processList[i].snapshot());
		}
		System.out.println("----------------------------------------");
	}


	//generates initial 5 processes with distinct IDs
	private static void generate5processes() {
		int randomID;
		int randomBurst =999;
		int randomPriority =999;
		while (readyQueue.size < 5) {
			randomID = randomGenerator.nextInt(11) + 0;
			//System.out.println("ID " + randomID + " is available?  " + PIDavailable(randomID, queue));////
			if (PIDavailable(randomID)) {
				randomBurst = randomGenerator.nextInt(80) + 21;
				randomPriority = randomGenerator.nextInt(10) + 1;
				Process p = new Process(randomID, randomBurst , randomPriority);
				readyQueue.addProcess(p);
				//System.out.println("Added " + p.getID() + "\t-------queue size is now: " + queue.size);////
			}
		}//end of while loop
	} 


	//determines if 'id' is already assigned to an existing process
	static boolean PIDavailable(int id) {
		if (!(id >= 0 && id <= 10)) {
			System.out.println("!!!Error!!! --- ID must be 0 - 10");
			return false;
		}
		if (readyQueue.isEmpty(readyQueue)) {
			return true;
		}
		for (int i =0; i < readyQueue.size; i++) {
			if (readyQueue.processList[i].getID() == id) {
				return false;
			}
		}
		return true;
	}

	//Creates process based on user input
	private static void createUserProcess() {
		int userID, userBurst, userPriority;
		boolean keepTrying = true;//, priorityValidated = false, burstValidated = false;
		
		while (keepTrying) {
			System.out.println("Enter a Process ID ( 0-10)" );
			userID = scan.nextInt();
			System.out.println("ID " + userID + " is available?  " + PIDavailable(userID));////
			if (PIDavailable(userID)) {//Check if user inputs valid ID
				keepTrying = false;
				userBurst = validateBurstLength();
				userPriority = validatePriority();
				Process p = new Process(userID, userBurst , userPriority);
				readyQueue.addProcess(p);
				System.out.println("\n\n!USER Added process " + p.getID() + "---queue size is now: " + readyQueue.size);////

			} else {
				System.out.println("Try again!");
		    }//end of if-else statement 
		} 

	}//end of createUserProcess method

	
	//validates user inputs burst length between 20-100
	static int validateBurstLength() {
		boolean burstValidated = false;	
		int input; int userBurst = 100;
		while (!burstValidated) {//runs until user inputs valid burst length
			System.out.println("Enter a Process Burst Length ( 20-100)" );
			input = scan.nextInt();
			if (input >= 20 && input <= 100) {
				burstValidated= true;
				userBurst = input;   
			} else {
				System.out.println("Must be integer between 20-100. Try again");
			}
		}
		return userBurst;
	}
	
	//validates user inputs priority between 1-10
	static int validatePriority() {
		boolean priorityValidated = false;	
		int input; int userPriority = 10;
		while (!priorityValidated) {//runs until user inputs valid priority
			System.out.println("Enter a Priority (1 - 10)" );
			input = scan.nextInt();
			if (input >= 1 && input <= 10) {
				priorityValidated= true;
				userPriority = input;   
			} else {
				System.out.println("Must be integer between 1-10. Try again");
			}
		}
		return userPriority;
	}

	static int getTotalBurstTimes() {
		int time=0;
		for (int i =0; i < readyQueue.size; i++) {
			time += readyQueue.processList[i].getBurstLength(); 
			//System.out.println("Total Burst time: " + time + " ----after process" + readyQueue.processList[i].getID());	
		}
	    return time;
	}


}//end of Tester.java class
