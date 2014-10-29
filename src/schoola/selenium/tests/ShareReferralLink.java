package schoola.selenium.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import  org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.SocialNWLoginHelpers;
import schoola.selenium.Helpers.TakeScreenshots;

public class ShareReferralLink extends BaseSelenium  {
	
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	SoftAssert softAssert = new SoftAssert();
	TakeScreenshots takeScreenshot = new TakeScreenshots();
	
	@BeforeTest
	public void Login() throws InterruptedException {
		loginHelper.login(driver);
	}
	
	@Test(enabled=false)
	public void ShareReferralOnFacebook() throws InterruptedException, IOException {
	  navHelper.gotoReferralLink(driver);
	  socialnwHelper.clickFBOrTWShare_button(driver, 1);
	  takeScreenshot.takeScreenshot(driver, "ShareReferralFB1.png");
	  
	  socialnwHelper.shareOnFacebook(driver);
	  takeScreenshot.takeScreenshot(driver, "facebook2.png");
	  String FBUrl = socialnwHelper.Get_SharedFacebookUrl(driver);	
	  System.out.println(" Shared FB URL : "+FBUrl);
	 
	  softAssert.assertTrue(FBUrl.contains("utm_source=facebook") , "Shared Facebook URL  does not contain correct utm_source parameter value");	  
	  softAssert.assertTrue(FBUrl.contains("utm_medium=referral") , "Shared Facebook URL  does not contain correct utm_medium parameter value");
	  softAssert.assertTrue(FBUrl.contains("utm_campaign=share") , "Shared Facebook URL  does not contain correct utm_campaign parameter");
	 
	  softAssert.assertAll();
	
	  
  }
	
	@Test
	public void ShareSchoolOnTwitter() throws IOException, InterruptedException{
		navHelper.gotoReferralLink(driver);
		socialnwHelper.clickFBOrTWShare_button(driver, 2);
		
		socialnwHelper.shareOnTwitter(driver);
		takeScreenshot.takeScreenshot(driver, "ShareReferralTW1.png");
		String TWUrl = socialnwHelper.get_sharedTwitterURl(driver);
		System.out.println(" Shared TW URL : "+TWUrl);
		
		softAssert.assertTrue(TWUrl.contains("utm_source=twitter") , "Shared Twitter URL  does not contain correct utm_source parameter value");	  
		softAssert.assertTrue(TWUrl.contains("utm_medium=raf") , "Shared Twitter URL  does not contain correct utm_medium parameter value");
		softAssert.assertTrue(TWUrl.contains("utm_campaign=share") , "Shared Twitter URL  does not contain correct utm_campaign parameter");
		
		softAssert.assertAll();
	}
	
  
}
