import java.util.Random;
public class Tester {

	public static void main(String[] args) {
		Random randomGenerator = new Random();
		
		ReadyQueue queue = new ReadyQueue(); 
		
		//create 5 random processes
		
		int times = 5;
		int randomID;
		int randomBurst =999;
		int randomPriority =999;
		while (queue.size < 5) {
		  randomID = randomGenerator.nextInt(11) + 0;
		  System.out.println("ID " + randomID + " is available?  " + PIDavailable(randomID, queue));
		  if (PIDavailable(randomID, queue)) {
			  randomBurst = randomGenerator.nextInt(80) + 21;
			  randomPriority = randomGenerator.nextInt(10) + 1;
			  Process p = new Process(randomID, randomBurst , randomPriority);
			  queue.addProcess(p);
			  System.out.println("Added " + p.getID() + "\t-------" + queue.size);
		  }
		 
		}	
		System.out.println("PID\tPriority\tBurstLength");
		//for (Process p: queue.processList) {
		//	System.out.println(p.snapshot());
		//}
		for (int i =0; i < queue.size; i++) {
			System.out.println(queue.processList[i].snapshot());
			
		}
		
	} 
	
	
	
	static boolean PIDavailable(int id, ReadyQueue queue) {
		if (queue.isEmpty(queue)) {
			return true;
		}
		for (int i =0; i < queue.size; i++) {
			if (queue.processList[i].getID() == id) {
				return false;
			}
		}
		/*for (Process p: queue.processList) {
			if (p.getID() == id) {
				return false;
			}
		}
		*/
		return true;
	}
}
