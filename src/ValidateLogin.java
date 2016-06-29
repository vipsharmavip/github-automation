import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ValidateLogin {

   WebDriver  driver;
   By sigin = By.linkText("Sign in");
   By username = By.id("login_field");
   By password = By.id("password");
   By login  = By.className("btn");
   By valid = By.className("btn");
   
   ValidateLogin(WebDriver driver){
	   this.driver = driver;
   }
   
   public void signIn(){
	   driver.findElement(sigin).click();
   }
   public void clickSignIn(){
	   this.signIn();
   }
   
   public void setUserName(String usrname){
	   driver.findElement(username).sendKeys(usrname);
   }
   public void setPassword(String pswd ){
	   driver.findElement(password).sendKeys(pswd);
   }
   public void login(){
	   driver.findElement(login).click();
   }
   public void clickLogin(){
	   this.login();
   }
   public boolean valid(){
	   return driver.findElement(valid).isDisplayed();
   }
   public boolean clickValid(){
	   return this.valid();
   }
   public void enterLoginPage(String usrname , String pswd){
	   this.clickSignIn();
	   this.setUserName(usrname);
	   this.setPassword(pswd);
       this.clickLogin(); 	   
   }
}