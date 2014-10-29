package schoola.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.SocialNWLoginHelpers;

public class OtherTests extends BaseSelenium {
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	SoftAssert softAssert = new SoftAssert();
	BrowserHelper browser = new BrowserHelper();
	
	@Test(priority=1,enabled=true)
	public void Pagination() throws InterruptedException{
		driver.get("http://stage.schoola.com/stitch/shop/boys-high-schoola");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[3]/div/div[14]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		String page2 = driver.getCurrentUrl();
		driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[3]/div/div[14]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		String page3 = driver.getCurrentUrl();
		driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[3]/div/div[14]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		String page1 = driver.getCurrentUrl();
		
		softAssert.assertTrue(page2.contains("boys-high-schoola/page-2") , "Pagination not working");	  
		softAssert.assertTrue(page3.contains("boys-high-schoola/page-3") , "Pagination not working");
		softAssert.assertTrue(page1.contains("boys-high-schoola") , "Pagination not working");
		
		softAssert.assertAll();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2,enabled=true)
	public void searchKeywordJeans() throws InterruptedException{
		driver.findElement(By.id("header-quick-search")).sendKeys("Jeans");
		driver.findElement(By.id("header-icon-search")).click();
		Thread.sleep(1000);
		String pagetext = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		String productURL = driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div/a")).getAttribute("href");
				
		softAssert.assertEquals(pagetext, "SEARCH FOR \"JEANS\"", "Search title is incorrect on the page");
		softAssert.assertTrue(productURL.contains("jeans"), "incorrect product is displayed on search");
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=3,enabled=true)
	public void searchKeywordBoysTank() throws InterruptedException{
		driver.findElement(By.id("header-quick-search")).clear();
		driver.findElement(By.id("header-quick-search")).sendKeys("Boys Tank");
		driver.findElement(By.id("header-quick-search")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String pagetext = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		String productURL = driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div/a")).getAttribute("href");
		String category = driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/h3")).getText();
				
		softAssert.assertEquals(pagetext, "SEARCH FOR \"BOYS TANK\"", "Search title is incorrect on the page");
		softAssert.assertTrue(productURL.contains("tank"), "incorrect product is displayed on search");
		softAssert.assertTrue(category.contains("Boys"), "incorrect product is displayed on search");
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@AfterTest
    public void closeWindow(){
    	browser.tearDown(driver);
	}

}
