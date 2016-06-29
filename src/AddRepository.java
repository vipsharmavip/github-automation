import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRepository {
 
	
	WebDriver  driver;
	
	By login  = By.partialLinkText("New repository");	
	By reponame = By.id("repository_name");
	By checkreadme = By.id("repository_auto_init"); 		
	By createrepo = By.cssSelector("#new_repository > div.with-permission-fields > button");
	
	  public AddRepository( WebDriver driver ){
		   this.driver = driver;
	  }
	  
	  public void createRepository(){
		   driver.findElement(login).click();
	  }
	  
	 public void clickOnCreateRepository(){
		 this.createRepository();
	 }
	 public  void enterNameRepo(String repname ){
		 driver.findElement(reponame).sendKeys(repname);
	 }
	 public void clickEnterNameRepo(String repname){
		 this.enterNameRepo(repname);
	 }
	 public void checkReadMe(){
		 driver.findElement(checkreadme).click();
	 }
	 public void clickCheckReadMe(){
		 this.checkReadMe();
	 }
	 public void createRepo(){
		 driver.findElement(createrepo).click();
	 }
	 public void clickCreateRepo(){
		 this.createRepo();
	 }
	 
	 public String check(String reponame){
		 return driver.findElement(By.linkText(reponame)).getText();
	 }
	 public String clickCheck( String reponame ){
		 return this.check(reponame);
	 }
	 public String addRepo(String reponame){
		 this.clickOnCreateRepository();
		 this.clickEnterNameRepo(reponame);
		 this.clickCreateRepo();
		 return this.clickCheck(reponame);
	 }
	 
}
