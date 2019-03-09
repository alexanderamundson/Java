
public class Process {
	private int PID;
	private int burstLength;
	private int priority;
	private String state;
	private int waitTime = 0;
	
	Process(int id, int burst, int priority) {
		this.PID=id;
		this.burstLength=burst;
		this.priority=priority;
	}
	
	int getID() {
		return this.PID;
	}
	
	void setID(int ID) {
		this.PID = ID;
	}
	
	int getBurstLength() {
		return this.burstLength;
	}
	
	void setBurstLength(int length) {
		this.burstLength = length;
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
	
	//increments the wait time by one
	void updateWaitTime() {
		this.waitTime++;
	}
	
	String snapshot() {
		return this.PID + "\t|" + this.priority
				+ "\t\t|" + this.burstLength;
	}
}
