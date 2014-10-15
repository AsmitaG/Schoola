package savysource.selenium.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper {
public void tearDown(WebDriver driver){
	driver.quit();
}
public void setUp(WebDriver driver){
	driver.get("http://stage.schoola.com/");
}
}
