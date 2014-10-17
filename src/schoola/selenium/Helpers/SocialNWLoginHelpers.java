package schoola.selenium.Helpers;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SocialNWLoginHelpers {
	
	private static final String TimeSpan = null;

	public void shareOnFacebook(WebDriver driver){
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		driver.findElement(By.id("email")).sendKeys("agsavy1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("testuser123");
		driver.findElement(By.id("u_0_1")).click();
		driver.findElement(By.id("feedform_user_message")).sendKeys("Test Post");
		driver.findElement(By.id("u_0_2")).click();
		driver.switchTo().window(parentWindow);
	}
	
	public String Get_SharedFacebookUrl(WebDriver driver){
		driver.get("www.facebook.com");	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("div#u_ps_0_0_2 div.clearfix div.lfloat span div._6ks a div._6l-")).click();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		String FBUrl = driver.getCurrentUrl();
		return FBUrl;
	}
	
	public void clickFBOrTWShare_button(WebDriver driver,int n){
		//driver.findElement(By.linkText("Share")).click();		
		//driver.findElement(By.id("user_name")).sendKeys("TestUser");
		if (n==1)
			driver.findElement(By.cssSelector("a.btn.btn-facebook > strong")).click();
		else
			driver.findElement(By.cssSelector("a.btn.btn-twitter > strong")).click();
	}
	
	public void shareOnTwitter(WebDriver driver){
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		driver.findElement(By.id("username_or_email")).sendKeys("KjameskJamesjamesk@outlook.com");
		driver.findElement(By.id("password")).sendKeys("school123");
		String tweet = driver.findElement(By.id("status")).getAttribute("value");
		driver.findElement(By.id("status")).clear();
		String[] link = tweet.split("!");
		tweet = link[1];
		Date date = new Date();
		String current_date = date.toString();
		tweet = tweet + "\n" + current_date;
		driver.findElement(By.id("status")).sendKeys(tweet);
		driver.findElement(By.xpath("//input[@value='Sign in and Tweet']")).click();
		driver.findElement(By.xpath("//input[@value='Tweet']")).click();
		driver.switchTo().window(parentWindow);
	}
	
	public String get_sharedTwitterURl(WebDriver driver){
		driver.get("https://www.twitter.com");
		driver.findElement(By.cssSelector("span.js-display-url")).click();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}   
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Boolean element = wait.until(ExpectedConditions.titleContains("Schoola"));
		String tw_url=driver.getCurrentUrl();
		return tw_url;
	}
	
	
}
