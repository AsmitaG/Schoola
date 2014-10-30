package schoola.selenium.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import schoola.selenium.Helpers.BrowserHelper;

public class BaseSelenium {
  public WebDriver driver;
  BrowserHelper browserHelper =new BrowserHelper();
  
  @Parameters("browser")
	  
  @BeforeTest
  // Passing Browser parameter from TestNG xml
  
  public void beforeTest(String browser){
	 // If the browser is Firefox, then do this
	  if(browser.equalsIgnoreCase("firefox")){
	      driver = new FirefoxDriver();
	      
	  }// If browser is IE, then do this
	  else if (browser.equalsIgnoreCase("ie")){ 
	      // Here I am setting up the path for my IEDriver
	      System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer.exe");
	      driver = new InternetExplorerDriver();
	  } 
	  // Doesn't the browser type, lauch the Website
	  browserHelper.setUp(driver);
	  }	
}
