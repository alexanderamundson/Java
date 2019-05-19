//Alex Amundson
//CS 4345  (operating systems)
//Spring2019
//Assignment2 (CPU scheduling algorithms simulation)
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Tester {
	public static Scanner scan = new Scanner(System.in);
	public static Random randomGenerator = new Random();		
	public static ReadyQueue readyQueue = new ReadyQueue(); 

	public static void main(String[] args) {
		try {
		//create 5 random processes with distinct IDs
		generate5processes();	
		
		//display initial snapshot of ready queue
		displayQueueSnapshot();

		//Allow user to create new processes
		createNewProcesses();
		
		// Run  Non-preemptive SJF
		SJF runSJF = new SJF(readyQueue);
		System.out.println("Starting Shortest Job First Algorithm"  );
		float SJFAvgWait = runSJF.run();
		readyQueue.resetQueue();
		
		//Run  Non-preemptive priority
		nonPreemptivePriority runNPP = new nonPreemptivePriority(readyQueue);
		System.out.println("Starting Non-Preemptive Priority Algorithm"  );
		float NPPAvgWait = runNPP.run();
		readyQueue.resetQueue();
		
		//Run round robin with time quantum 20.
		RoundRobin runRR = new RoundRobin(readyQueue);
		System.out.println("Starting Round Robin"  );
		float RRAvgWait =  runRR.run();
		System.out.println("-->Average Wait time for RR " +  RRAvgWait   );//invoke run method in Round Robing .java
		
		//Display average wait of all three algorithms
		displayAscending(SJFAvgWait, NPPAvgWait, RRAvgWait);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end of main method

	
	//Asks user if he/she wants to create new process (until queue is full)
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
		if (readyQueue.size > 5) {//if user creates additional processes, display new snapshot
		  System.out.println("\nDone with creating processes...heres a new snapshot: " );
		  displayQueueSnapshot();
		}
		readyQueue.initial_size=readyQueue.size;
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
			if (PIDavailable(randomID)) {
				randomBurst = randomGenerator.nextInt(80) + 21;
				randomPriority = randomGenerator.nextInt(10) + 1;
				Process p = new Process(randomID, randomBurst , randomPriority);
				readyQueue.addProcess(p);
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
		boolean keepTrying = true;
		while (keepTrying) {
			System.out.println("Enter a Process ID ( 0-10)" );
			userID = scan.nextInt();//User must enter int or Execption will ocurr
			if (PIDavailable(userID)) {//Check if user inputs valid ID
				keepTrying = false;
				userBurst = validateBurstLength();
				userPriority = validatePriority();
				Process p = new Process(userID, userBurst , userPriority);
				readyQueue.addProcess(p);
				System.out.println("\nYou Created process " + p.getID() + "---queue size is now: " + readyQueue.size);////
			} else {
				System.out.println("Try again!");
		    }//end of if-else statement 
		} 
	}//end of createUserProcess method

	
	//Validates user inputs burst length between 20-100
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

		
	//Display average wait time for each algorithm
	static void displayAscending(float SJF, float NPP, float RR){
		System.out.println("\nAlgorithms  from lowest to highest average waiting time.");	
		ArrayList<Float> b = new ArrayList<Float>();
		b.add(SJF); b.add(NPP); b.add(RR);
		ArrayList<String> value = new ArrayList<String>();
	    value.add("SJF average wait--"); value.add("NPP average wait--"); value.add("RR average wait--");
		while (!b.isEmpty()) {
		  int i;
	      i = minIndex(b);
	      System.out.println(value.get(i)+  b.get(i) );
	      b.remove(i);
	      value.remove(i);
	    }
	}
   
	
	//returns index of minimum value in list
	static int minIndex (ArrayList<Float> list) {
		  return list.indexOf (Collections.min(list)); 
     }

}//end of Tester.java class
