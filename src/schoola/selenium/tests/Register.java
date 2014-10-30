package schoola.selenium.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Properties.UserEmail;

public class Register extends BaseSelenium {
	BrowserHelper browserHelper=new BrowserHelper();
	LoginHelpers loginHelpers=new LoginHelpers();
		
	
	@BeforeTest
	public void Login() throws InterruptedException {
		
		browserHelper.setUp(driver);
		
	}	
@Test(priority=1)
public void testRegister() throws InterruptedException, IOException{
	loginHelpers.register(driver);	
}

@Test(priority=2)
public void testLogin() throws InterruptedException, IOException{
	
	loginHelpers.login(driver);
}

@AfterTest
public void tearDown(){
	browserHelper.tearDown(driver);
}
}
