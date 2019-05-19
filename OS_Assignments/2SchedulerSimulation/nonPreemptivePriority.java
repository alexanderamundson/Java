//Alex Amundson
//CS 4345  (operating systems)
//Spring2019
//Assignment2 (CPU scheduling algorithms simulation)
public class nonPreemptivePriority {
	private ReadyQueue queue;
	float averageWaitTime;
	CPU_Core cpu2 = new CPU_Core("CPU  Core2");
	
	//constructor
	nonPreemptivePriority(ReadyQueue q){
		this.queue = q;
	}
	

	float run() {		
		while (!this.queue.allTerminated()) { //runs until all processes have terminated
	        Process next = this.queue.getNextProcess();
	        next.executeProcess();
	        cpu2.setProcess(next);//assigns process "next" to the cpu 2
	        incrementWaitTimes(next.getBurstLength());
	        next.terminateProcess();	
		}//end of while loop
		displayResults();
		return getAverageWait();
	}//end of run method


	private void displayResults() {
		System.out.println("\n--------|nonPreemptive Priority|--------");
		System.out.println("ID\tPriority\tBurstLength\tWaitTime");
		for(int i =0; i < this.queue.size; i++) {
			System.out.println( this.queue.processList[i].finalSnapshot());
		}
		System.out.println("-->Average Wait time for NPP: " + getAverageWait()  );		
		System.out.println("---------------------------------------------------");	
	}

	
	//Returns average wait time of processes in queue
	private float getAverageWait() {
		float totalWait = 0;
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
				
			}
		}
	}
}
