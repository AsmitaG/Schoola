package schoola.selenium.Helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import schoola.selenium.Properties.UserEmail;

public class LoginHelpers {
	
	UserEmail userdetails = new UserEmail();
	static String  email="123";
	

	
public void register(WebDriver driver) throws InterruptedException {
	if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed()) {
		driver.findElement(By.cssSelector(".roadblock-close")).click();
	}
	driver.findElement(By.cssSelector("#loginColorBox")).click();
	Thread.sleep(3000);
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();	
	String current_date = dateFormat.format(date);
	email = userdetails.get_schoolaemail()+current_date+"@"+userdetails.get_schemaildomain();
	System.out.println("Registered Email"+email);
	
	driver.findElement(By.linkText("here")).click();
	driver.findElement(By.id("first-name")).sendKeys(userdetails.get_userfname());
	driver.findElement(By.id("last-name")).sendKeys(userdetails.get_userlname());
	driver.findElement(By.id("register-email")).sendKeys(email);
	driver.findElement(By.id("register-password")).sendKeys(userdetails.get_schoolapwd());
	driver.findElement(By.id("register-user")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.linkText(userdetails.get_userfname()+" "+userdetails.get_userlname())).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.linkText("SIGN OUT")).click();
}

public void login(WebDriver driver) throws InterruptedException{

	/*if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed()) {
		System.out.println("IN IF");
		driver.findElement(By.cssSelector(".roadblock-close")).click();
	}*/
		System.out.println("Logged in Email"+email);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		driver.findElement(By.cssSelector("#loginColorBox")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("signin-email")).sendKeys(email);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("signin-password")).sendKeys(userdetails.get_schoolapwd());
		Thread.sleep(3000);
		driver.findElement(By.id("overlay-login-submit")).click();	

}


}
