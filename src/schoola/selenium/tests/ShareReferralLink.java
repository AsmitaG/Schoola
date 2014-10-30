package schoola.selenium.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.SocialNWLoginHelpers;
import schoola.selenium.Helpers.TakeScreenshots;
import schoola.selenium.Properties.UTMParameters;

public class ShareReferralLink extends BaseSelenium  {
	
	BrowserHelper browserhelper = new BrowserHelper();
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	UTMParameters utmparam = new UTMParameters();
	SoftAssert softAssert = new SoftAssert();
	TakeScreenshots takeScreenshot = new TakeScreenshots();
	
	@BeforeTest
	public void Login() throws InterruptedException {
		browserhelper.setUp(driver);
		loginHelper.login(driver);
	}
	
	@Test(priority=1)
	public void ShareReferralOnFacebook() throws InterruptedException, IOException {
	  navHelper.gotoReferralLink(driver);
	  socialnwHelper.clickFBOrTWShare_button(driver, 1);
	  takeScreenshot.takeScreenshot(driver, "ShareReferralFB1.png");
	  
	  socialnwHelper.shareOnFacebook(driver);	  
	  String FBUrl = socialnwHelper.Get_SharedFacebookUrl(driver);	
	  takeScreenshot.takeScreenshot(driver, "ShareReferralFB4.png");
	  System.out.println(" Shared FB URL : "+FBUrl);
	 
	  softAssert.assertTrue(FBUrl.contains("utm_source="+utmparam.get_utmSourceFB()) , "Shared Facebook URL  does not contain correct utm_source parameter value");	  
	  softAssert.assertTrue(FBUrl.contains("utm_medium="+utmparam.get_utmMediumRefFB()) , "Shared Facebook URL  does not contain correct utm_medium parameter value");
	  softAssert.assertTrue(FBUrl.contains("utm_campaign="+utmparam.get_utmCampaignRefFB()) , "Shared Facebook URL  does not contain correct utm_campaign parameter");
	 
	  softAssert.assertAll();
	
	  
  }
	
	@Test(priority=2)
	public void ShareSchoolOnTwitter() throws IOException, InterruptedException{
		navHelper.gotoReferralLink(driver);
		socialnwHelper.clickFBOrTWShare_button(driver, 2);
		
		socialnwHelper.shareOnTwitter(driver);
		
		String TWUrl = socialnwHelper.get_sharedTwitterURl(driver);
		System.out.println(" Shared TW URL : "+TWUrl);
		takeScreenshot.takeScreenshot(driver, "ShareReferralTW3.png");
		softAssert.assertTrue(TWUrl.contains("utm_source="+utmparam.get_utmSourceTW()) , "Shared Twitter URL  does not contain correct utm_source parameter value");	  
		softAssert.assertTrue(TWUrl.contains("utm_medium="+utmparam.get_utmMediumRefTW()) , "Shared Twitter URL  does not contain correct utm_medium parameter value");
		softAssert.assertTrue(TWUrl.contains("utm_campaign="+utmparam.get_utmCampaignRefTW()) , "Shared Twitter URL  does not contain correct utm_campaign parameter");
		
		softAssert.assertAll();
	}
	@AfterTest
	public void tearDown(){
		browserhelper.tearDown(driver);
	}
  
}
