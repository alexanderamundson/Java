//Alex Amundson
//CS 4345  (operating systems)
//Spring2019
//Assignment2 (CPU scheduling algorithms simulation)

import java.util.ArrayList;
class ReadyQueue { 
	int front, rear, size; 
	int capacity = 11; 
	int highest = 10;
	Process processList[]; 
	
	float initial_size;
	float total_wait;
	
	public ReadyQueue() { 
		front = this.size = 0; 
		rear = capacity - 1; 
		processList = new Process[11]; 
	} 
	
	
	//Checks if Queue is filled to capacity
	boolean isFull( ReadyQueue queue) {
		return (queue.capacity == queue.size); 
	} 
	
	
	//Checks if queue is empty
	boolean isEmpty( ReadyQueue queue) { 
		return (queue.size < 1); 
	} 
	
	
	//Adds a Process to rear of ready queue
	String addProcess( Process item) { 
		if (isFull(this)) 
			return "Ready Queue is full! Can't add process"; 
		this.rear = (this.rear + 1)%this.capacity; 
		this.processList[this.rear] = item; 
		this.size = this.size + 1; 
		return ("Process "+item.getID()+ " added to queue"); 
	} 

	
	// Removes a process from the queue
	//And returns a duplicate of the removed process
	Process removeProcess() { 
		if (isEmpty(this)) { 
			return null; 
		}	
		Process proc = this.processList[this.front]; 
		this.front = (this.front + 1) % this.capacity; 
		this.size = this.size - 1; 
		return proc; 
	}
	
	
	//Returns a duplicate of process at front of queue
	Process peek() { 
		if (isEmpty(this)) { 
			return null; 
		}			
		Process proc = this.processList[this.front]; 
		return proc; 
	} 
	
	
	//Returns process with smallest burst length with given priority  (SJF)
    Process getShortestJob(int priority) {
		int shortestProcess = 1000;
		int times=0;
		for (int i =0; i < this.size; i++) {
			if (this.processList[i].getState() == "Ready") {
				if (  this.processList[i].getPriority() == priority) {
					if (times == 0 ) {
					  shortestProcess = i; times++; 
					}
					if (this.processList[i].getBurstLength() < this.processList[shortestProcess].getBurstLength()) {
						shortestProcess = i;
					}
				}
			}
		}
		this.processList[shortestProcess].terminateProcess();//technically not terminated just yet
		return this.processList[shortestProcess]; 
	} 
    
    
	//getHighest priority process in Ready state  (only for SJF)
    int getHighestPriority() {
    	int highest = 10;
    	for (int i =0; i < this.size; i++) {
			if (this.processList[i].getPriority() <= highest && this.processList[i].getState() == "Ready") {
				highest = this.processList[i].getPriority();
			}
		}
    	return highest;
    } 
    
    
    //Returns true if all processes are terminated
    boolean allTerminated() {
    	boolean notFinished = false;
    	for (int i =0; i < this.size; i++) {
			if (this.processList[i].getState() == "Terminated") {
				notFinished = true;
			} else {
				notFinished = false;
				return notFinished;
			}	
		}
    	return true;
    }
    
    
    //Returns Ready process with highest priority
    //This is invoked by nonPreemtivePriority.java
    Process getNextProcess() {
		int highest = this.getHighestPriority();
		int nextProcess = 1000;	
		for (int i =0; i < this.size; i++) {
			if (this.processList[i].getState() == "Ready") {		
				if (  this.processList[i].getPriority() == highest) {
					nextProcess = i; break;
				}
			}
		}
		this.processList[nextProcess].terminateProcess();
		return this.processList[nextProcess];
	}
    
    
    //Resets queue to its starting state
    void resetQueue() {
    	for (int i =0; i < this.size; i++) {
    		this.processList[i].setState("Ready");
    		this.processList[i].resetWaitTime();
    	}
    }
    
    
    //Returns the highest priority remaining in the ready queue
    int highestPriority() {
    	int highPriority = 10;
    	for (int i =0; i < this.size; i++) {
    		if (this.peek().getPriority() <= highPriority && this.peek().getState()=="Ready") {
				highPriority = this.peek().getPriority();
			}
    		this.addProcess(this.removeProcess());	
    	}
    	this.highest= highPriority;
    	return highPriority;
    } 

    
    //Iterates through the queue one time running the Round Robin algorithm
    //RoundRobin.java invokes this method repeatedly until all 
    //process have terminated (until the queue is empty )
    String runNextRRProcess() {
    	this.highest = this.highestPriority();//Finds the highest priority remaining 
		//System.out.println("\n**highest priority is " + this.highest);
		Process removed = null;
		boolean alreadyRemoved = true;
		int waitVal=20;//default burst time 
		String output="";
		for (int i =0; i < this.size; i++) {
				if (  this.peek().getPriority() == this.highestPriority() ) { 
					alreadyRemoved=true;
					waitVal = this.peek().executeBurst();//decrements remaining burst time 		
					RRwait(waitVal, this.peek().getID());//increment wait time of all other processes by 'waitVal'
					if (this.peek().getBurstLength() <=0) {
						alreadyRemoved=false;
						this.peek().setState("Terminated");
						removed = this.removeProcess();
						this.total_wait += removed.getWaitTime();
						output+=removed.RRsnapshot();
						//System.out.println("-"+ removed.getID()+ " was removed!!!!!");						
					}
				}
				if (alreadyRemoved) {
				    this.addProcess(  this.removeProcess()  );				    
				}
				alreadyRemoved=true;				
		}//end for loop
		return output;
	}
    
    
    //Increments wait time of processes after another process is executed
    //This is only used for the Round Robin algorithm
    void RRwait(int waitTime, int processID) {
    	ArrayList<Integer> m = new ArrayList<Integer>();   	
    	for (int i =0; i < this.capacity; i++) {
    		if (this.processList[i] != null && this.processList[i].getState() != "Terminated" ) {
    		   if (this.processList[i].getID() != processID && !m.contains(this.processList[i].getID())) {
    			   this.processList[i].updateWaitTime(waitTime);
    		    	m.add(   this.processList[i].getID()   );
    		   }
    	    }
    	}
    	m.clear();
    }

    
    //Display ID of each Process in this queue (For debugging purposes)
    //void displayQueue() {
    	//for (int i =0; i < this.size; i++) 
    		//System.out.print("\t"+this.processList[i].getID() ); 
    //	System.out.println();
    //}

}




 
