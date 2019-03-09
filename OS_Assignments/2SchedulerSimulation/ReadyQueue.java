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
		
		Process item = this.processList[this.front]; 
		this.front = (this.front + 1) % this.capacity; 
		this.size = this.size - 1; 
		return item; 
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
} 
 
