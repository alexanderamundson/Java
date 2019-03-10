// Java program for array implementation of queue 

// A class to represent a queue 
class ReadyQueue { 
	int front, rear, size; 
	int capacity = 11; 
	Process processList[]; 
	
	public ReadyQueue() { 
		front = this.size = 0; 
		rear = capacity - 1; 
		processList = new Process[11]; 
	} 
	
	// Queue is full when size becomes equal to 
	// the capacity 
	boolean isFull( ReadyQueue queue) {
		return (queue.capacity == queue.size); 
	} 
	
	// Queue is empty when size is 0 
	boolean isEmpty( ReadyQueue queue) { 
		return (queue.size < 1); 
	} 
	
	// Method to add an item to the queue. 
	// It changes rear and size 
	String addProcess( Process item) { 
		if (isFull(this)) 
			return "Ready Queue is full! Can't add process"; 
		this.rear = (this.rear + 1)%this.capacity; 
		this.processList[this.rear] = item; 
		this.size = this.size + 1; 
		return ("Process "+item.getID()+ " added to queue"); 
	} 
	
	// Method to remove an item from queue. 
	// It changes front and size 
	Process removeProcess() { 
		if (isEmpty(this)) { 
			return null; 
		}	
		
		Process proc = this.processList[this.front]; 
		this.front = (this.front + 1) % this.capacity; 
		this.size = this.size - 1; 
		return proc; 
	} 
	
	// Method to get front of queue 
	Process showFront() { 
		if (isEmpty(this)) 
			return null; 
		
		return this.processList[this.front]; 
	} 
		
	// Method to get rear of queue 
	Process showRear() { 
		if (isEmpty(this)) 
			return null; 
		
		return this.processList[this.rear]; 
	} 
	
	//getShortestjob with given priority  (SJF)
    Process getShortestJob(int priority) {
		int shortestProcess = 1000;//this.processList[this.front].getBurstLength();
		int times=0;
		for (int i =0; i < this.size; i++) {
			if (this.processList[i].getState() == "Ready") {//make sure its in Ready state!!!
				
				if (  this.processList[i].getPriority() == priority) {
					if (times == 0 ) {
					  shortestProcess = i; times++; 
					}
					//System.out.println(this.processList[i].getBurstLength() < this.processList[shortestProcess].getBurstLength());
					if (this.processList[i].getBurstLength() < this.processList[shortestProcess].getBurstLength()) {//make sure its in Ready state!!!
						//System.out.println("DOES THIS EVER RUN???");
						shortestProcess = i;
					}
				}
			}
			
		}
		System.out.println("Next is: " + this.processList[shortestProcess].getID() + " with priority: "+ this.processList[shortestProcess].getPriority());
		this.processList[shortestProcess].terminateProcess();//technically not terminated just yet
		return this.processList[shortestProcess]; 
	} 
    
    //getShortestjob
    Process getShortestJob() {
		int shortestProcess = 0;//this.processList[this.front].getBurstLength();
		for (int i =0; i < this.size; i++) {
			if (this.processList[i].getBurstLength() < shortestProcess) {//make sure its in Ready state!!!
				shortestProcess = i;
			}
			//ime += readyQueue.processList[i].getBurstLength(); 
			//System.out.println("Total Burst time: " + time + " ----after process" + readyQueue.processList[i].getID());	
		}
		return this.processList[shortestProcess]; 
	} 
	
	//getHighest priority process in Ready state   (SJF)
    int getHighestPriority() {
    	int highest = 10;
    	for (int i =0; i < this.size; i++) {
			if (this.processList[i].getPriority() <= highest && this.processList[i].getState() == "Ready") {
				highest = this.processList[i].getPriority();
				//System.out.println("HIGHEST PRIORITY IS: " + highest);
			}
		}
    	return highest;
    } 
    
    //returns true if all processes are terminated
    boolean allTerminated() {
    	boolean finished = false;
    	for (int i =0; i < this.size; i++) {
			if (this.processList[i].getState() == "Terminated") {
				finished = true;
			} else {
				finished = false;
				return false;
			}	
		}
    	return true;
    }
    
} 
 
