//Alex Amundson
//CS 4345  (operating systems)
//Spring2019
//Assignment2 (CPU scheduling algorithms simulation)
public class nonPreemptivePriority {
	private ReadyQueue queue;
	float averageWaitTime;
	CPU_Core cpu2 = new CPU_Core("CPU  Core2");
	
	
	nonPreemptivePriority(ReadyQueue q){
		this.queue = q;
	}
	
	/*
	 * until readyQueue "is empty" (all processes are terminated)
	1. get highest priority in ready state

	2. run that process  (assign to CPU_Core)

	3.increment wait times of other processes

	4. terminate that process
	*/
	float run() {
		int times = 4;
		while (!this.queue.allTerminated()) { //runs until all processes have terminated
		   
			
	        Process next = this.queue.getNextProcess();
	        
	        next.executeProcess();
	        cpu2.setProcess(next);//assigns process "next" to the cpu
	        
	        incrementWaitTimes(next.getBurstLength());
	        next.terminateProcess();
		
		times--;
		}//end of while loop
		displayResults();
		return getAverageWait();
	}//end of run method

	/*
	 * Process getNextProcess() {
		int highest = this.queue.getHighestPriority();
		int nextProcess = 1000;//this.processList[this.front].getBurstLength();
		int times=0;
		for (int i =0; i < this.queue.size; i++) {
			if (this.queue.processList[i].getState() == "Ready") {//make sure its in Ready state!!!			
				if (  this.queue.processList[i].getPriority() == highest) {
					//if (times == 0 ) {
					 // nextProcess = i; times++; 
					//}
				}
			}
		}//end for loop
		this.queue.processList[nextProcess].terminateProcess();
		return this.queue.processList[nextProcess];
	}
	*/
	private void displayResults() {
		System.out.println("\n--------nonPreemptive Priority)--------");
		System.out.println("ID\tPriority\tBurstLength\tWaitTime");
		for(int i =0; i < this.queue.size; i++) {
			System.out.println( this.queue.processList[i].finalSnapshot());
		}
		System.out.println("Average Wait time: " + getAverageWait()  );
		
		
	}

	private float getAverageWait() {
		int totalWait = 0;
		float avgWait = 0;
		for(int i =0; i < this.queue.size; i++) {
			totalWait += this.queue.processList[i].getWaitTime();
		}
		avgWait = this.queue.size;
	    return avgWait;
	}
	
	
	
	void incrementWaitTimes(int waitTime) {
		for(int i =0; i < this.queue.size; i++) {
			if (this.queue.processList[i].getState() == "Ready") {
				this.queue.processList[i].updateWaitTime(waitTime);
				
			}
		}
	}
}
