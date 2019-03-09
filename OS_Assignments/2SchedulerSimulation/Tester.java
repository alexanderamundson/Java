
public class Tester {

	public static void main(String[] args) 
	{ 
		ReadyQueue queue = new ReadyQueue(); 
		
		//create 5 random processes
		
			
		queue.addProcess(10); 
		queue.addProcess(20); 
		queue.addProcess(30); 
		queue.addProcess(40); 
		
		System.out.println(queue.removeProcess() + 
					" dequeued from queue\n"); 
		
		System.out.println("Front item is " + 
							queue.front()); 
		
		System.out.println("Rear item is " + 
								queue.rear()); 
	} 
}
