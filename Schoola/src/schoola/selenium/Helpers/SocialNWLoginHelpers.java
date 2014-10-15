package schoola.selenium.Helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SocialNWLoginHelpers {
	
	public void goToShareOnFacebook_button(WebDriver driver){
		driver.findElement(By.cssSelector("div#s-body div.w div.w_r div.share-and-activity div.s-sharing-box div.social-block div a.btn")).click();
	}
	
	public void Login_ShareOnFacebook(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("agsavy1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("testuser123");
		driver.findElement(By.id("u_0_1")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("u_0_2")).click();		
	}
	
	
	
}
