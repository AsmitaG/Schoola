package schoola.selenium.tests;

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

public class ShareFeatureSchool extends BaseSelenium  {
	
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority=1)
	public void ShareSchoolOnTwitter(){
		navHelper.gotoFeaturedSchool(driver);
		driver.findElement(By.linkText("Share")).click();		
		driver.findElement(By.id("user_name")).sendKeys("TestUser");
		socialnwHelper.clickFBOrTWShare_button(driver, 2);
		
		socialnwHelper.shareOnTwitter(driver);
		String TWUrl = socialnwHelper.get_sharedTwitterURl(driver);
		System.out.println(" Shared TW URL : "+TWUrl);
		
		softAssert.assertTrue(TWUrl.contains("utm_source=twitter") , "Shared Twitter URL  does not contain correct utm_source parameter value");	  
		softAssert.assertTrue(TWUrl.contains("utm_medium=share") , "Shared Twitter URL  does not contain correct utm_medium parameter value");
		softAssert.assertTrue(TWUrl.contains("utm_campaign=school-page") , "Shared Twitter URL  does not contain correct utm_campaign parameter");
		
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void ShareSchoolOnFacebook(){
		navHelper.gotoFeaturedSchool(driver);
		driver.findElement(By.linkText("Share")).click();		
		driver.findElement(By.id("user_name")).sendKeys("TestUser");
		socialnwHelper.clickFBOrTWShare_button(driver, 1);
		
		socialnwHelper.shareOnFacebook(driver);
		String FBUrl = socialnwHelper.Get_SharedFacebookUrl(driver);
		System.out.println(" Shared FB URL : "+FBUrl);
		
		softAssert.assertTrue(FBUrl.contains("utm_source=facebook") , "Shared Twitter URL  does not contain correct utm_source parameter value");	  
		softAssert.assertTrue(FBUrl.contains("utm_medium=share") , "Shared Twitter URL  does not contain correct utm_medium parameter value");
		softAssert.assertTrue(FBUrl.contains("utm_campaign=school-page") , "Shared Twitter URL  does not contain correct utm_campaign parameter");
		
		softAssert.assertAll();
	}
	  
  }
  

