//Alex Amundson
//CS 4345  (operating systems)
//Spring2019
//Assignment2 (CPU scheduling algorithms simulation)
public class Process {
	private int PID;
	private int burstLength;
	private int initialBurst;
	private int priority;
	private String state;
	private int waitTime = 0;
	
	Process(int id, int burst, int priority) {
		this.PID=id;
		this.burstLength=burst;
		this.initialBurst=burst;
		this.priority=priority;
		this.state = "Ready";
	}
	
	int getID() {
		return this.PID;
	}
	
	int getBurstLength() {
		return this.burstLength;
	}
	
	int getInitialBurstLength() {
		return this.initialBurst;
	}
	
	void setBurstLength(int length) {
		this.burstLength -= length;
	}
	
	int getPriority() {
		return this.priority;
	}
	
	void setPriority(int priority) {
		this.priority= priority;
	}
	
	String getState() {
		return state;
	}

	void setState(String state) {
		this.state = state;
	}
	
	void terminateProcess() {
		this.state = "Terminated";
	}
	
	//For SJF and NPP
	void executeProcess() {
		this.state = "Executing";
	}
	
	
	//For RR
	int executeBurst() {
		int b= this.burstLength;
		this.state = "Executing";
		System.out.println("  Executing  process " + this.getID() +"  on cpu core 3 bc " +this.getPriority() + " is highest priority" );
		if (this.burstLength >= 20) {
		    this.setBurstLength(20);
		    this.setState("Ready");//Changes state back to Ready 
		} else {
			this.setBurstLength(this.getBurstLength());
		}
		//System.out.println("Remaining burst time on " + this.getID() + " is " + this.getBurstLength() );
		if (this.getBurstLength() <=0) {
			this.terminateProcess();
			System.out.println("Terminated " + this.getID() + " bc remaining burst is " + this.getBurstLength() );
		}
		if (b < 20)
			return b;//returns the length of burst just completed
		return 20;
	}
	
	//increments the wait time by one
	void resetWaitTime() {
	  this.waitTime = 0;
	} 
		
	void updateWaitTime(int waitingTime) {
		this.waitTime+= waitingTime;
	}
	
	void setWaitTime(int waitingTime) {
		this.waitTime = waitingTime;
	}
	
	int getWaitTime() {
		return this.waitTime;
	}
	
	String snapshot() {
		return this.PID + "\t|" + this.priority
				+ "\t\t|" + this.burstLength;
	}
	
	//Returns final snapshot for  SJF and NPP
	String finalSnapshot() {
		return this.PID + "\t|" + this.priority
				+ "\t\t|" + this.burstLength + "\t\t\t" + this.waitTime;
	}
	
	//Returns final snapshot for RR
	String RRsnapshot() {
		return "\n"+this.PID + "\t|" + this.priority
				+ "\t\t|" + this.initialBurst + "\t\t\t|" + this.waitTime;
	}
}
