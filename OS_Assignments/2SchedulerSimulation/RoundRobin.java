//Alex Amundson
//CS 4345  (operating systems)
//Spring2019
//Assignment2 (CPU scheduling algorithms simulation)
public class RoundRobin {
	//private int timeQuantum = 20;
	private ReadyQueue queue;
	float averageWaitTime;
	CPU_Core cpu3 = new CPU_Core("CPU Core3");
	
	RoundRobin(ReadyQueue q){
		this.queue = q;
	}
	
	//Runs Round Robin algorithm and returns average wait time
	float run() {
		String snapshot = "";
		while (  queue.size > 0) {//times>0){//isEmpty(queue)  ) { //runs until all processes have terminated
			 snapshot+= this.queue.runNextRRProcess();
		}//end of while loop
		displayResults(snapshot);
		return queue.total_wait / queue.initial_size;
	}//end of run method

	
	private void displayResults(String output) {
		System.out.println("\n--------|Round Robin)|--------");
		System.out.print("ID\tPriority\tBurstLength\tWaitTime");
		System.out.println(output);
	}
	
}
