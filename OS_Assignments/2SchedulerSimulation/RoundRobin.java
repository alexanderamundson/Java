
public class RoundRobin {
	private int timeQuantum = 20;
	private ReadyQueue queue;
	float averageWaitTime;
	CPU_Core cpu3 = new CPU_Core();
	
	RoundRobin(ReadyQueue q){
		this.queue = q;
	}
}
