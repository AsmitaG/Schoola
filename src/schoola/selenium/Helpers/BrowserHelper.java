package schoola.selenium.Helpers;

import org.openqa.selenium.WebDriver;

import schoola.selenium.Properties.SetUpURL;

public class BrowserHelper {
	
	SetUpURL helper = new SetUpURL();
	
public void tearDown(WebDriver driver){
	driver.quit();
}

public void setUp(WebDriver driver){
	String url = helper.getURL();
	driver.get(url);
	/*if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed()) {
		driver.findElement(By.cssSelector(".roadblock-close")).click();
	}*/
	driver.manage().window().maximize();
}
}
