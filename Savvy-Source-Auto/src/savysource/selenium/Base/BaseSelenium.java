package savysource.selenium.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import savysource.selenium.Helpers.BrowserHelper;

public class BaseSelenium {
  public WebDriver driver;

public BaseSelenium() {
	// TODO Auto-generated constructor stub
	
	BrowserHelper browser=new BrowserHelper();
	driver= new FirefoxDriver();
	browser.setUp(driver);
	
	
}

}
