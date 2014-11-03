package schoola.selenium.Helpers;

import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import schoola.selenium.Properties.UserEmail;

public class SocialNWLoginHelpers {
	
	UserEmail userEmail = new UserEmail();
	TakeScreenshots takeScreenshot = new TakeScreenshots();
	
	public void shareOnFacebook(WebDriver driver) throws InterruptedException{
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys(userEmail.get_fbemail());
		driver.findElement(By.id("pass")).sendKeys(userEmail.get_fbpwd());
		driver.findElement(By.id("u_0_1")).click();
		driver.findElement(By.id("feedform_user_message")).sendKeys("Test Post");
		driver.findElement(By.id("u_0_2")).click();
		driver.switchTo().window(parentWindow);
	}
	
	public String Get_SharedFacebookUrl(WebDriver driver) throws IOException{
		driver.get("www.facebook.com");	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		takeScreenshot.takeScreenshot(driver, "ShareReferralFB3.png");
		driver.findElement(By.linkText(userEmail.get_fbusername())).click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//driver.findElement(By.xpath(".//*[@id='blueBarNAXAnchor']/div[1]/div/div/div[1]/ul/li[1]/a")).click();
		//driver.findElement(By.cssSelector("div._6l-.__c_")).click();
		
		driver.findElement(By.cssSelector("a._52c6")).click();		
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		String FBUrl = driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(parentWindow);
		return FBUrl;
	}
	
	public void clickFBOrTWShare_button(WebDriver driver,int n){
		//driver.findElement(By.linkText("Share")).click();		
		//driver.findElement(By.id("user_name")).sendKeys("TestUser");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
		driver.findElement(By.id("username_or_email")).sendKeys(userEmail.get_twemail());
		driver.findElement(By.id("password")).sendKeys(userEmail.get_twpwd());
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
	
	public String get_sharedTwitterURl(WebDriver driver) throws InterruptedException, IOException{
		driver.get("https://www.twitter.com");
		takeScreenshot.takeScreenshot(driver, "ShareReferralTW2.png");
		driver.findElement(By.cssSelector("span.js-display-url")).click();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}   
		
		/*WebDriverWait wait = new WebDriverWait(driver, 40);
		Boolean element = wait.until(ExpectedConditions.titleContains("Schoola"));*/
		Thread.sleep(5000);
		String tw_url=driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(parentWindow);
		return tw_url;
	}
	
	
}
