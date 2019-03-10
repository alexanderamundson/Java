
public class nonPreemptivePriority {
	private ReadyQueue queue;
	float averageWaitTime;
	CPU_Core cpu2 = new CPU_Core();
	
	
	nonPreemptivePriority(ReadyQueue q){
		this.queue = q;
	}

}
