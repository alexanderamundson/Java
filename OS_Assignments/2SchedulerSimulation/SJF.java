
public class SJF {
	private ReadyQueue queue;
	float averageWaitTime;
	CPU_Core cpu1 = new CPU_Core();
	
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
	void run() {
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
		System.out.println("--------------- ALL DONE\n  HERE's what happened");
		System.out.println("\nID\tPriority\tBurstLength\tWaitTime");
		for(int i =0; i < this.queue.size; i++) {
			System.out.println( this.queue.processList[i].finalSnapshot());
		}
	}//end of run method
	
	
	
	void incrementWaitTimes(int waitTime) {
		for(int i =0; i < this.queue.size; i++) {
			if (this.queue.processList[i].getState() == "Ready") {
				this.queue.processList[i].updateWaitTime(waitTime);
				//System.out.println(this.queue.processList[i].getID() + "@@ has waited "+ this.queue.processList[i].getWaitTime());
			}
		}
	}
	
	
}
