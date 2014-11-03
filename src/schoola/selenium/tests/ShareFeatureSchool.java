package schoola.selenium.tests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import  org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.SocialNWLoginHelpers;
import schoola.selenium.Helpers.TakeScreenshots;
import schoola.selenium.Properties.UTMParameters;

public class ShareFeatureSchool extends BaseSelenium  {
	
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	UTMParameters utmparam = new UTMParameters();
	TakeScreenshots snap = new TakeScreenshots();
	BrowserHelper browser = new BrowserHelper();
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority=1,enabled=true)
	public void ShareSchoolOnTwitter() throws IOException, InterruptedException{
		navHelper.gotoFeaturedSchool(driver);
		driver.findElement(By.linkText("Share")).click();		
		driver.findElement(By.id("user_name")).sendKeys("TestUser");
		socialnwHelper.clickFBOrTWShare_button(driver, 2);
		
		
		socialnwHelper.shareOnTwitter(driver);
		snap.takeScreenshot(driver, "FeatureSchoolTW.png");
		String TWUrl = socialnwHelper.get_sharedTwitterURl(driver);
		System.out.println(" Shared TW URL : "+TWUrl);
		
		softAssert.assertTrue(TWUrl.contains("utm_source="+utmparam.get_utmSourceSchoolTW()) , "Shared Twitter URL  does not contain correct utm_source parameter value");	  
		softAssert.assertTrue(TWUrl.contains("utm_medium="+utmparam.get_utmMediumSchoolTW()) , "Shared Twitter URL  does not contain correct utm_medium parameter value");
		softAssert.assertTrue(TWUrl.contains("utm_campaign="+utmparam.get_utmCampaignSchoolTW()) , "Shared Twitter URL  does not contain correct utm_campaign parameter");
		
		softAssert.assertAll();
		Thread.sleep(5000);
	}
	
	@Test(priority=2,enabled=true)
	public void ShareSchoolOnFacebook() throws InterruptedException, IOException{
		navHelper.gotoFeaturedSchool(driver);
		driver.findElement(By.linkText("Share")).click();		
		driver.findElement(By.id("user_name")).sendKeys("TestUser");
		socialnwHelper.clickFBOrTWShare_button(driver, 1);
		
		socialnwHelper.shareOnFacebook(driver);
		snap.takeScreenshot(driver, "FeatureSchoolFB.png");
		String FBUrl = socialnwHelper.Get_SharedFacebookUrl(driver);
		System.out.println(" Shared FB URL : "+FBUrl);
		
		softAssert.assertTrue(FBUrl.contains("utm_source="+utmparam.get_utmSourceShopFB()) , "Shared Twitter URL  does not contain correct utm_source parameter value");	  
		softAssert.assertTrue(FBUrl.contains("utm_medium="+utmparam.get_utmMediumSchoolFB()) , "Shared Twitter URL  does not contain correct utm_medium parameter value");
		softAssert.assertTrue(FBUrl.contains("utm_campaign="+utmparam.get_utmCampaignSchoolFB()) , "Shared Twitter URL  does not contain correct utm_campaign parameter");
		
		softAssert.assertAll();
	}
	
	@AfterTest
    public void closeWindow(){
    	browser.tearDown(driver);
	}
	  
  }
  

