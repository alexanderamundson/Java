//Alex Amundson
//CS 4345  (operating systems)
//Spring2019
//Assignment2 (CPU scheduling algorithms simulation)
public class SJF {
	private ReadyQueue queue;
	float averageWaitTime;
	CPU_Core cpu1 = new CPU_Core("CPU Core1");
	
	//Constructor
	SJF(ReadyQueue q){
		this.queue = q;
	}
	
    //Runs the Shortest Job First (SJF) algorithm 
	float run() {
		while (!this.queue.allTerminated()) { //runs until all processes have terminated
			int highest = this.queue.getHighestPriority();
	        Process next = this.queue.getShortestJob(highest);
	        next.executeProcess();
	        cpu1.setProcess(next);//assigns process "next" to the cpu
	        incrementWaitTimes(next.getBurstLength());
	        next.terminateProcess();		
		}//end of while loop
		displayResults();
		return getAverageWait();
	}//end of run method

	
	private void displayResults() {
		System.out.println("\n--------|ShortestJobFirst (with priority)|--------");
		System.out.println("ID\tPriority\tBurstLength\tWaitTime");
		for(int i =0; i < this.queue.size; i++) {
			System.out.println( this.queue.processList[i].finalSnapshot());
		}
		System.out.println("-->Average Wait time for SJF: " + getAverageWait()  );
		System.out.println("---------------------------------------------------");	
	}

	
	//Returns average wait for processes 
	private float getAverageWait() {
		float totalWait = 0;
		//float avgWait = 0;
		for(int i =0; i < this.queue.size; i++) {
			totalWait += this.queue.processList[i].getWaitTime();
		}
		return totalWait / this.queue.size;
	}
	
	
	//Increments wait time of processes in Ready queue
	void incrementWaitTimes(int waitTime) {
		for(int i =0; i < this.queue.size; i++) {
			if (this.queue.processList[i].getState() == "Ready") {
				this.queue.processList[i].updateWaitTime(waitTime);
				//System.out.println(this.queue.processList[i].getID() + "has waited "+ this.queue.processList[i].getWaitTime());
			}
		}
	}
	
}
