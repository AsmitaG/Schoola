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
	if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
		driver.findElement(By.cssSelector(".roadblock-close")).click();
	driver.findElement(By.cssSelector("#loginColorBox")).click();
	Thread.sleep(3000);
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();	
	String current_date = dateFormat.format(date);
	email = userdetails.get_schoolaemail()+current_date+"@"+userdetails.get_schemaildomain();
	System.out.println("EMAIl"+email);	
	driver.findElement(By.cssSelector("#signin-email")).sendKeys(email);
	driver.findElement(By.cssSelector("#signin-password")).sendKeys(userdetails.get_schoolapwd());
	driver.findElement(By.id("overlay-login-submit")).click();
}

public void login(WebDriver driver) throws InterruptedException{
	if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
		driver.findElement(By.cssSelector(".roadblock-close")).click();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("#loginColorBox")).click();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.id("signin-email")).sendKeys(email);
	driver.findElement(By.id("signin-password")).sendKeys(userdetails.get_schoolapwd());
	Thread.sleep(3000);
	driver.findElement(By.id("overlay-login-submit")).click();

}


}
