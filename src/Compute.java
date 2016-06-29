import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Compute {
  
	
   
	String username = "vipsharmavip@gmail.com";
	String userpass = "------------------"; // Enter your password , and username 
	WebDriver driver;
    ValidateLogin login;
    AddRepository addrepo;
    ProcessStart proc;
    SubmitRepo repo;
    String repo_name = "Automated-repository";
    String fromrepo;
    String timestamp;
    String url = "https://github.com/vipsharmavip/";
    		
    @BeforeClass
    public  void setUp(){
 System.setProperty("webdriver.chrome.driver", "/home/vipulsharma/Downloads/chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://github.com/");
	  proc = new ProcessStart();
	  timestamp = proc.generateTimeStamp();
   }
    
  
     @Test
     public void Step01_validateLogin() throws IOException, InterruptedException{
     login  =  new ValidateLogin(driver);
	  login.enterLoginPage( username , userpass );
	  Assert.assertEquals( login.clickValid() , true , "Unable to login");
	  Reporter.log("Login successful");
	  
     }
	  

   @Test
   public void Step02_validAddRepository() throws IOException, InterruptedException{
	   
	  addrepo = new AddRepository(driver);
     fromrepo = addrepo.addRepo(repo_name + timestamp);
     Assert.assertEquals( fromrepo  , repo_name + timestamp , "Repository not created");
     Reporter.log("Repository" + " " + repo_name + " " + "created");
   }
   
   @Test
   public void Step03_validateCommit() throws IOException, InterruptedException{
   
     repo = new SubmitRepo(driver);
     repo.submitRepo(repo_name + timestamp);
     Thread.sleep(1000);
     Assert.assertEquals( repo.clickValid()  , true  , "Repository not submitted");
     Reporter.log("Repository" + " " + repo_name + timestamp + " " + "submitted successfuly");
   
   } 
 
  
}
