package schoola.selenium.Helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import schoola.selenium.Properties.UserEmail;

public class LoginHelpers {
	
	static UserEmail userdetails = new UserEmail();
	static String  email=userdetails.get_schoolaemail()+"@"+userdetails.get_schemaildomain();
	
public void SignInClick(WebDriver driver){
		driver.findElement(By.id("loginColorBox")).click();	
}
	
public void register(WebDriver driver) throws InterruptedException {
	//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed()) {
		//driver.findElement(By.cssSelector(".roadblock-close")).click();
	//}
	Thread.sleep(3000);
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();	
	String current_date = dateFormat.format(date);
	email = userdetails.get_schoolaemail()+current_date+"@"+userdetails.get_schemaildomain();
	System.out.println("Registered Email:" +email);
	Thread.sleep(1000);
	driver.findElement(By.id("switch-to-register")).click();
	driver.findElement(By.id("first-name")).sendKeys(userdetails.get_userfname());
	driver.findElement(By.id("last-name")).sendKeys(userdetails.get_userlname());
	driver.findElement(By.id("register-email")).sendKeys(email);
	driver.findElement(By.id("register-password")).sendKeys(userdetails.get_schoolapwd());
}

public void registersubmit(WebDriver driver) {
	driver.findElement(By.id("register-user")).click();
	}

public void logout(WebDriver driver){
	driver.findElement(By.linkText(userdetails.get_userfname()+" "+userdetails.get_userlname())).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.linkText("SIGN OUT")).click();
}

public void login(WebDriver driver) throws InterruptedException{

	/*if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed()) {
		System.out.println("IN IF");
		driver.findElement(By.cssSelector(".roadblock-close")).click();
	}*/
		System.out.println("Logged in Email:" +email);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
	    driver.findElement(By.xpath("//*[@id='signin-email']")).sendKeys(email);;
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='signin-password']")).sendKeys(userdetails.get_schoolapwd());
	    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		}

public void loginsubmit(WebDriver driver) {
	driver.findElement(By.id("overlay-login-submit")).click();	
	}
    




}
