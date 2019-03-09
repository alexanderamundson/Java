//Ready queue holds all waiting processes
class ReadyQueue { 
	int front, rear, size; 
	int capacity = 11; 
	Process processList[]; 
	
	public ReadyQueue() { 
		front = this.size = 0; 
		rear = capacity - 1; 
		processList = new Process[11]; 
	} 
	
	 
	boolean isFull( ReadyQueue queue) {
		return (queue.capacity == queue.size); 
	} 
	
	
	boolean isEmpty( ReadyQueue queue) { 
		return (queue.size < 1); 
	} 
	
	 
	String addProcess( Process item) { 
		if (isFull(this)) 
			return "Ready Queue is full! Can't add process"; 
		this.rear = (this.rear + 1)%this.capacity; 
		this.processList[this.rear] = item; 
		this.size = this.size + 1; 
		return ("Process "+item.getID()+ " added to queue"); 
	} 
	
	
	Process removeProcess() { 
		if (isEmpty(this)) { 
			return null; 
		}	
		
		Process item = this.processList[this.front]; 
		this.front = (this.front + 1) % this.capacity; 
		this.size = this.size - 1; 
		return item; 
	} 
	
	 
	Process showFront() { 
		if (isEmpty(this)) 
			return null; 
		
		return this.processList[this.front]; 
	} 
		
	 
	Process showRear() { 
		if (isEmpty(this)) 
			return null; 
		
		return this.processList[this.rear]; 
	} 
} 
 
