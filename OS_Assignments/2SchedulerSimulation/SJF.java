//Alex Amundson
//CS 4345  (operating systems)
//Spring2019
//Assignment2 (CPU scheduling algorithms simulation)
public class SJF {
	private ReadyQueue queue;
	float averageWaitTime;
	CPU_Core cpu1 = new CPU_Core("CPU Core1");
	
	SJF(ReadyQueue q){
		this.queue = q;
	}
	
	/*
	 * until readyQueue "is empty" (all processes are terminated)
	1. get highest priority in ready state

	2. get shortest with such priority in ready state

	3. run that process  (assign to CPU_Core)

	4.increment wait times of other processes

	5. terminate that process
	*/
	float run() {
		int times = 4;
		while (!this.queue.allTerminated()) { //runs until all processes have terminated
		   
			int highest = this.queue.getHighestPriority();
			//System.out.println("HIGHEST PRIORITY shld be lw" + highest);
	        Process next = this.queue.getShortestJob(highest);
	        //System.out.println("About to run process: " + next.getID() + "----burst" + next.getBurstLength());
	        next.executeProcess();
	        cpu1.setProcess(next);//assigns process "next" to the cpu
	        
	        incrementWaitTimes(next.getBurstLength());
	        next.terminateProcess();
		
		times--;
		}//end of while loop
		displayResults();
		return getAverageWait();
	}//end of run method

	private void displayResults() {
		System.out.println("\n--------ShortestJobFirst (with priority)--------");
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
				//System.out.println(this.queue.processList[i].getID() + "@@ has waited "+ this.queue.processList[i].getWaitTime());
			}
		}
	}
	
	
}
