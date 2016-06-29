import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessStart {
	Process process;
	
	public String timeStamp(){
		return new SimpleDateFormat("dd.HH.mm.ss").format(new Date());
	}
	
	public String generateTimeStamp(){
		return this.timeStamp();
	}
	public void runCommand() throws IOException, InterruptedException{
	  process = new ProcessBuilder("/home/vipulsharma/Desktop/Github/shell.sh").start();
	}

}
