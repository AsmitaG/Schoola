package schoola.selenium.Helpers;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SocialLogInForSchool {
	
	public void shareOnFacebook(WebDriver driver){
		driver.findElement(By.linkText("Share")).click();		
		driver.findElement(By.id("user_name")).sendKeys("TestUser");
		driver.findElement(By.cssSelector("a.btn.btn-facebook > strong")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		driver.findElement(By.id("email")).sendKeys("KjameskJamesjamesk@outlook.com");
		driver.findElement(By.id("pass")).sendKeys("school123");
		driver.findElement(By.id("u_0_1")).click();
		driver.findElement(By.id("feedform_user_message")).sendKeys("Test Post");
		driver.findElement(By.id("u_0_2")).click();
		driver.switchTo().window(parentWindow);
	}
	
	public void shareOnTwitter(WebDriver driver){
		driver.findElement(By.linkText("Share")).click();		
		driver.findElement(By.id("user_name")).sendKeys("TestUser");
		driver.findElement(By.id("twbtn")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		driver.findElement(By.id("username_or_email")).sendKeys("KjameskJamesjamesk@outlook.com");
		driver.findElement(By.id("password")).sendKeys("school123");
		driver.findElement(By.xpath("//input[@value='Sign in and Tweet']")).click();
		driver.findElement(By.xpath("//input[@value='Tweet']")).click();
		driver.switchTo().window(parentWindow);
		
	}
	
	
}
