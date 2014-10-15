package schoola.selenium.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.LoginHelpers;

public class Register extends BaseSelenium {
	BrowserHelper browserHelper=new BrowserHelper();
	LoginHelpers loginHelpers=new LoginHelpers();
@Test
public void testRegister() throws InterruptedException{
	loginHelpers.register(driver);
}
@AfterTest
public void tearDown(){

	browserHelper.tearDown(driver);
}
}
