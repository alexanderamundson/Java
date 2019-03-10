
public class CPU_Core {
	private Process executingProcess;
	private String name;
	
	CPU_Core(String name) {
		this.executingProcess=null;
		this.name = name;
	}
	
	//Assigns a process to the CPU
	void setProcess(Process process) { 
		this.executingProcess = process;
		System.out.println("Process " + this.executingProcess.getID()+ " with priority " + this.executingProcess.getPriority() + " is running on " + this.name);
	}
	
	//returns snapshot of process being executed
	String processSnapshot() {
		if (this.executingProcess != null) {
			return this.executingProcess.snapshot();
		}else { 
			return "------------------------------";
		}
	}	

}
