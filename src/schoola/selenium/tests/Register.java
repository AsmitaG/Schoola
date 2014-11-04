package schoola.selenium.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Properties.UserEmail;

public class Register extends BaseSelenium {
	BrowserHelper browserHelper=new BrowserHelper();
	LoginHelpers loginHelpers=new LoginHelpers();
	UserEmail userdetails = new UserEmail();
	
	@BeforeTest
	public void Login() throws InterruptedException {
		browserHelper.setUp(driver);
		
	}
	
	@Test(priority=1)
	public void testRegister() throws InterruptedException, IOException{
		SoftAssert softAssert = new SoftAssert();
		loginHelpers.SignInClick(driver);
		loginHelpers.register(driver);	
		loginHelpers.registersubmit(driver);
		Thread.sleep(4000);
		String text = driver.findElement(By.linkText(userdetails.get_userfname()+" "+userdetails.get_userlname())).getText();
		softAssert.assertEquals(text ,userdetails.get_userfname()+" "+userdetails.get_userlname(), "User is not registered");
		softAssert.assertAll();
		Thread.sleep(2000);
		loginHelpers.logout(driver);
	}

	@Test(priority=2)
	public void testLogin() throws InterruptedException, IOException{
		SoftAssert softAssert = new SoftAssert();
		loginHelpers.SignInClick(driver);
		loginHelpers.login(driver);
		loginHelpers.loginsubmit(driver);
		Thread.sleep(3000);
		String text = driver.findElement(By.linkText(userdetails.get_userfname()+" "+userdetails.get_userlname())).getText();
		softAssert.assertEquals(text ,userdetails.get_userfname()+" "+userdetails.get_userlname(), "User is not logged in");
		softAssert.assertAll();
	}
	
	@AfterTest
	public void tearDown(){
		browserHelper.tearDown(driver);
	}
}
