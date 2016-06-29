import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitRepo {
	WebDriver driver;
	
	   public SubmitRepo(WebDriver driver){
		   this.driver = driver;
	   }
By valid = By.xpath("//a[text()='vipul']");
				
	String username = "vipsharmavip";
	String userpass = "09720074556a";
    String gitinit = "git init";
	String gitadd = "git add README.txt";
	String commit = "git commit -m vipul";
	String remote = "git remote add origin https://github.com/vipsharmavip/";
	String push = "git push -u origin master";
	String disable = "git config --global credential.helper 'cache --timeout 7200'";
	ProcessStart proc;
	
	
	
	public void createFile(String reponame) throws FileNotFoundException, UnsupportedEncodingException{
		File file = new File("/home/vipulsharma/Desktop/Github/.git");
		 if(file.exists())
			file.delete();
		PrintWriter writer = new PrintWriter("README.txt", "UTF-8");
		writer.println("Vipul Sharma");
		writer.close();
		writer = new PrintWriter("/home/vipulsharma/Desktop/Github/shell.sh", "UTF-8");
		writer.println("cd /home/vipulsharma/Desktop/Github");
		writer.println(gitinit);
		writer.println(disable);
		writer.println(gitadd);
		writer.println(commit);
		writer.println(remote + reponame + ".git");
		writer.println(push);
		writer.println("sleep 1");
		writer.println(username);
		writer.println("sleep 1");
		writer.println(userpass);
		writer.close();
	}
	
	
	public void sleep(int value) throws InterruptedException{
		Thread.sleep(value);
	}
	
	 public boolean valid(){
		   return driver.findElement(valid).isDisplayed();
	   }
	 
	   public boolean clickValid(){
		   return this.valid();
	   }
	   
	public void submitRepo(String reponame) throws IOException, InterruptedException{  	
	     
		 this.createFile(reponame);
		 proc = new ProcessStart();		 
		 proc.runCommand();
		 Thread.sleep(2000);
		 driver.navigate().refresh();
		 Thread.sleep(2000);
		 driver.get("https://github.com/vipsharmavip/" + reponame);
		 Thread.sleep(2000);

	}
}
