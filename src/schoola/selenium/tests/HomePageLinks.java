package schoola.selenium.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.SocialNWLoginHelpers;

public class HomePageLinks extends BaseSelenium{
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority=1,enabled=false)
	public void HowSchoolaWorks(){
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("How Schoola Works")).isDisplayed();
		driver.findElement(By.linkText("How Schoola Works")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -How Schoola Works- is not displayed on homepage");
		softAssert.assertEquals(title, "About Schoola Stitch", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "How Schoola Works", "Incorrect page text is displayed on page - How Schoola Works");
		
		softAssert.assertAll();
	}
	
	@Test(priority=2,enabled=false)
	public void OurStory(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Our Story")).isDisplayed();
		driver.findElement(By.linkText("Our Story")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Our Story- is not displayed on homepage");
		softAssert.assertEquals(title, "About Schoola", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Our Story", "Incorrect page text is displayed on page - Our Story");
		
		softAssert.assertAll();
	}
	
	@Test(priority=3,enabled=false)
	public void InthePress(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("In the Press")).isDisplayed();
		driver.findElement(By.linkText("In the Press")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='main-div']/div[3]/h3")).getText();
		
		softAssert.assertEquals(link, true, "Link -In the Press- is not displayed on homepage");
		softAssert.assertEquals(title, "Press | Schoola", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "People are Talking...", "Incorrect page text is displayed on page - In the Press");
		
		softAssert.assertAll();
	}
	
	@Test(priority=4,enabled=false)
	public void JobsAtSchoola(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Jobs at Schoola")).isDisplayed();
		driver.findElement(By.linkText("Jobs at Schoola")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath("html/body/div[1]/div[1]/h1")).getText();
		driver.close();
		driver.switchTo().window(parentWindow);
		
		softAssert.assertEquals(link, true, "Link -Jobs at Schoola- is not displayed on homepage");
		softAssert.assertEquals(title, "Schoola Coach | Schoola | Education - Teaching - Administration | Sales | Contract | Telecommute", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Schoola", "Incorrect page text is displayed on page - Jobs at Schoola");
		
		softAssert.assertAll();
	}

	@Test(priority=5,enabled=false)
	public void BecomeAnAffiliate(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Become an Affiliate")).isDisplayed();
		driver.findElement(By.linkText("Become an Affiliate")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Become an Affiliate- is not displayed on homepage");
		softAssert.assertEquals(title, "Schoola Affiliate Program", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "The Affiliate Program", "Incorrect page text is displayed on page - Become an Affiliate");
		
		softAssert.assertAll();
	}
	
	@Test(priority=6,enabled=true)
	public void TermsOfUse(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Terms of Use")).isDisplayed();
		driver.findElement(By.linkText("Terms of Use")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Terms of Use- is not displayed on homepage");
		softAssert.assertEquals(title, "Legal Information: Schoola", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Legal Information", "Incorrect page text is displayed on page - Terms of Use");
		
		softAssert.assertAll();
	}
	
	@Test(priority=7,enabled=false)
	public void PrivacyPolicy(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Privacy Policy")).isDisplayed();
		driver.findElement(By.linkText("Privacy Policy")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Privacy Policy- is not displayed on homepage");
		softAssert.assertEquals(title, "Privacy Policy: Schoola", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Privacy Policy", "Incorrect page text is displayed on page - Privacy Policy");
		
		softAssert.assertAll();
	}
}
