package schoola.selenium.Helpers;

import org.openqa.selenium.WebDriver;

import schoola.selenium.Properties.UserEmail;

public class BrowserHelper {
	
	UserEmail helper = new UserEmail();
	
public void tearDown(WebDriver driver){
	driver.quit();
}

public void setUp(WebDriver driver){
	String url = helper.get_homeurl();
	driver.get(url);
	/*if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed()) {
		driver.findElement(By.cssSelector(".roadblock-close")).click();
	}*/
	driver.manage().window().maximize();
}
}
