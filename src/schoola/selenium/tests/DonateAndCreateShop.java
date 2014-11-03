package schoola.selenium.tests;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.SocialNWLoginHelpers;
import schoola.selenium.Helpers.TakeScreenshots;
import schoola.selenium.Properties.UTMParameters;

public class DonateAndCreateShop extends BaseSelenium{
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	UTMParameters utmparam = new UTMParameters();
	SoftAssert softAssert = new SoftAssert();
	BrowserHelper browser = new BrowserHelper();
	TakeScreenshots snap = new TakeScreenshots();
	String uniqueShopId;
	
	@Test(priority=1,enabled=true)
	public void DonateClothesHomePage() throws InterruptedException{
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		navHelper.gotoDonate(driver);
		Thread.sleep(2000);
		driver.findElement(By.id("search-zip")).sendKeys("10001");
		Thread.sleep(2000);
		driver.findElement(By.id("search-school")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.id("search-school")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("Test User");
		driver.findElement(By.id("school-relationship")).sendKeys("Friend of the School");
		driver.findElement(By.id("address")).sendKeys("New Street");
		driver.findElement(By.id("zip")).sendKeys("14744");
		driver.findElement(By.id("city")).sendKeys("New York");
		Thread.sleep(2000);
		driver.findElement(By.id("state_value")).sendKeys("N");
		Thread.sleep(2000);
		driver.findElement(By.id("state_value")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.id("state_value")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("team_value")).sendKeys("Pre-K");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();	
		String current_date = dateFormat.format(date);
		String email = "school"+current_date+"@mailinator.com";
		driver.findElement(By.cssSelector("div.input-element.input-block > #email")).sendKeys(email);
		driver.findElement(By.id("send-bag-btn")).click();
		Thread.sleep(2000);
		String confirmation1 = driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[2]/div/h2")).getText();		
		String confirmation2 = driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[2]/div/p")).getText();
		boolean button = driver.findElement(By.id("bk-to-home")).isDisplayed();
		driver.findElement(By.id("bk-to-home")).click();
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		
		softAssert.assertEquals(confirmation1, "Brilliant!", "Confirmation message is not displayed");
		softAssert.assertEquals(confirmation2, "You'll receive an email with an update on your bag shortly.", "Confirmation2 message is not displayed");
		softAssert.assertEquals(button, true, "Okay button is not displayed");
		softAssert.assertEquals(URL, "http://stage.schoola.com/", "Okay does not redirect to home page");
		softAssert.assertAll();
		
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=2,enabled=true)
	public void DonateClothesSchoolPage() throws InterruptedException{
		navHelper.gotoFeaturedSchool(driver);
		driver.findElement(By.xpath("(//a[contains(text(),'Donate')])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("name")).sendKeys("Test User");
		driver.findElement(By.id("school-relationship")).sendKeys("Friend of the School");
		driver.findElement(By.id("address")).sendKeys("10 Street Hill");
		driver.findElement(By.id("zip")).sendKeys("54855");
		driver.findElement(By.id("city")).sendKeys("Kansas City");
		Thread.sleep(2000);
		driver.findElement(By.id("state_value")).sendKeys("N");
		Thread.sleep(2000);
		driver.findElement(By.id("state_value")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.id("state_value")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();	
		String current_date = dateFormat.format(date);
		String email = "school"+current_date+"@mailinator.com";
		driver.findElement(By.cssSelector("div.input-element.input-block > #email")).sendKeys(email);
		driver.findElement(By.id("send-bag-btn")).click();
		
		Thread.sleep(2000);
		String confirmation1 = driver.findElement(By.xpath(".//*[@id='donate-tab']/h2")).getText();		
		String confirmation2 = driver.findElement(By.xpath(".//*[@id='donate-tab']/p")).getText();
		softAssert.assertEquals(confirmation1, "Brilliant!", "Confirmation message is not displayed");
		softAssert.assertEquals(confirmation2, "You'll receive an email with an update on your bag shortly.", "Confirmation2 message is not displayed");
		softAssert.assertAll();
		
		Thread.sleep(2000);
	}
	
	@Test(priority=3,enabled=true)
	public void CreateCustomShop() throws InterruptedException{
		navHelper.gotoCustomShopPage(driver);
		driver.findElement(By.xpath(".//*[@id='s-body']/div/div[2]/a[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("grownup_name")).sendKeys("My Child");
		driver.findElement(By.id("email_id")).sendKeys("newStore@mailinator.com");
		driver.findElement(By.id("search-zip")).sendKeys("10001");
		Thread.sleep(2000);
		driver.findElement(By.id("search-school")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(By.id("search-school")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("child_name")).sendKeys("John");
		driver.findElement(By.xpath(".//*[@id='labs-form']/div[1]/a[2]/span")).click();
		Thread.sleep(5000);	
		driver.findElement(By.xpath(".//*[@id='s-body']/div/div[2]/a[2]/span")).click();
		Thread.sleep(5000);	
		
		for(int i=1;i<=10;i++){
			String xpath = ".//*[@id='s-body']/div/div[3]/a["+i+"]";
			driver.findElement(By.xpath(xpath)).click();
			Thread.sleep(900);	
		}
		
		
		driver.findElement(By.xpath(".//*[@id='s-body']/div/div[2]/a[2]/span")).click();
		Thread.sleep(2000);
		
		for(int i=1;i<=6;i++){
			String xpath = ".//*[@id='s-body']/div/div[4]/ul/li["+i+"]/a/span";
			driver.findElement(By.xpath(xpath)).click();
			Thread.sleep(900);	
		}
		
		driver.findElement(By.xpath(".//*[@id='s-body']/div/div[2]/a[2]/span")).click();
		Thread.sleep(5000);
		
		for(int i=1;i<=6;i++){
			String xpath = ".//*[@id='s-body']/div/div[4]/a["+i+"]";
			driver.findElement(By.xpath(xpath)).click();
			Thread.sleep(900);	
		}
		
		driver.findElement(By.xpath(".//*[@id='s-body']/div/div[2]/a[2]/span")).click();
		Thread.sleep(7000);
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		softAssert.assertEquals(pageTitle, "John's Custom Shop is Open!", "Custom Shop creation failed");
		
		softAssert.assertAll();
		Thread.sleep(5000);
	}
	
	@Test(priority=4,enabled=true)
	public void VisitCustomShop() throws InterruptedException{
		String ShopUrl = driver.findElement(By.xpath(".//*[@id='s-body']/div/div[1]/div[2]/p")).getText();
		String[] part = ShopUrl.split("/");
		uniqueShopId = part[1];
		//System.out.println(uniqueShopId);
		ShopUrl = "http://stage."+ShopUrl;
		driver.findElement(By.xpath(".//*[@id='s-body']/div/div[3]/a[1]")).click();
		Thread.sleep(5000);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		String heading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		String pageUrl = driver.getCurrentUrl();
		
		softAssert.assertEquals(pageTitle, "John's Shop", "Cannot open custom shop page");
		softAssert.assertEquals(heading, "HAND-PICKED FOR JOHN", "Cannot open custom shop page");
		softAssert.assertEquals(ShopUrl, pageUrl, "User is taken to incorrect URL");
		
		softAssert.assertAll();
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	@Test(priority=5,enabled=true)
	public void ShareShopOnFacebook() throws InterruptedException, IOException{
		driver.findElement(By.id("share")).click();
		socialnwHelper.clickFBOrTWShare_button(driver, 1);
		snap.takeScreenshot(driver,"customShopFB.png");
		socialnwHelper.shareOnFacebook(driver);
		Thread.sleep(5000);
		String fbUrl = socialnwHelper.Get_SharedFacebookUrl(driver);
		softAssert.assertTrue(fbUrl.contains("utm_source="+utmparam.get_utmSourceSchoolFB()) , "Shared Facebook URL  does not contain correct utm_source parameter value");	  
		softAssert.assertTrue(fbUrl.contains("utm_medium="+utmparam.get_utmMediumShopFB()) , "Shared Facebook URL  does not contain correct utm_medium parameter value");
		softAssert.assertTrue(fbUrl.contains("utm_campaign="+utmparam.get_utmCampaignShopFB()) , "Shared Facebook URL  does not contain correct utm_campaign parameter");
		softAssert.assertTrue(fbUrl.contains(uniqueShopId) , "Shared Facebook URL  does not contain correct shopid");
		softAssert.assertAll();
		
		driver.navigate().back();
		Thread.sleep(2000);
	}
	
	@Test(priority=6,enabled=true)
	public void ShareShopOnTwitter() throws InterruptedException, IOException{
		driver.findElement(By.id("share")).click();
		socialnwHelper.clickFBOrTWShare_button(driver, 2);
		socialnwHelper.shareOnTwitter(driver);
		snap.takeScreenshot(driver,"customShopTW.png");
		Thread.sleep(5000);
		String twUrl = socialnwHelper.get_sharedTwitterURl(driver);
		softAssert.assertTrue(twUrl.contains("utm_source="+utmparam.get_utmSourceShopTW()) , "Shared Twitter URL  does not contain correct utm_source parameter value");	  
		softAssert.assertTrue(twUrl.contains("utm_medium="+utmparam.get_utmMediumShopTW()) , "Shared Twitter URL  does not contain correct utm_medium parameter value");
		softAssert.assertTrue(twUrl.contains("utm_campaign="+utmparam.get_utmCampaignSchoolTW()) , "Shared Twitter URL  does not contain correct utm_campaign parameter");
		softAssert.assertTrue(twUrl.contains(uniqueShopId) , "Shared Twitter URL  does not contain correct shopid");
		softAssert.assertAll();
		
		Thread.sleep(2000);
	}
	
	@AfterTest
    public void closeWindow(){
    	browser.tearDown(driver);
    }
}
