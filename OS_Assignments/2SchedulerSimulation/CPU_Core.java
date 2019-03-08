
public class CPU_Core {
	private Process executingProcess;
	
	
	void setProcess(Process process) { 
		this.executingProcess = process;
	}
	
	String snapshot() {
		if (this.executingProcess != null) {
			return this.executingProcess.;
		}else { 
			return "------------------------------";
		}
	}	

}
