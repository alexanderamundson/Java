//Alex Amundson
//CS 4345  (operating systems)
//Spring2019
//Assignment2 (CPU scheduling algorithms simulation)
public class RoundRobin {
	private int timeQuantum = 20;
	private ReadyQueue queue;
	float averageWaitTime;
	CPU_Core cpu3 = new CPU_Core("CPU Core3");
	
	RoundRobin(ReadyQueue q){
		this.queue = q;
	}
}
