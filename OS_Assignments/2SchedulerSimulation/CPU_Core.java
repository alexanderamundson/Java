
public class CPU_Core {
	private Process executingProcess;
	
	CPU_Core() {
		this.executingProcess=null;
	}
	
	//Assigns a process to the CPU
	void setProcess(Process process) { 
		this.executingProcess = process;
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
