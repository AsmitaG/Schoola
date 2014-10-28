package schoola.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.TakeScreenshots;

public class CollectionMenu extends BaseSelenium{
	NavigationHelpers navHelper=new NavigationHelpers();
	SoftAssert softAssert = new SoftAssert();
	TakeScreenshots shot = new TakeScreenshots();
	BrowserHelper browser = new BrowserHelper();
	
	@Test(priority=1,enabled=true)
	public void CustomShops() throws InterruptedException{
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"COLLECTIONS");
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("li > a > img.menu-link-img")).click();
		Thread.sleep(2000);
		
		String titlePage = driver.getTitle();
		System.out.println(titlePage);
		String pagetext = driver.findElement(By.xpath(".//*[@id='s-body']/div/div[1]/h1")).getText();
		
		softAssert.assertEquals(titlePage, "Custom Shop: You Deserve Your Very Own Shop", "Collection page is not displayed");
	    softAssert.assertEquals(pagetext, "You Deserve Your Very Own Shop!", "Heading is not correct");
	    
	    softAssert.assertAll();
	    Thread.sleep(5000);
	}
	
	@Test(priority=2,enabled=true)
	public void InStyle() throws InterruptedException{
		navHelper.hoverOnMenu(driver,"COLLECTIONS");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@alt='InStyle Collection']")).click();
		Thread.sleep(2000);
		
		String titlePage = driver.getTitle();
		System.out.println(titlePage);
		String pagetext = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		
		softAssert.assertEquals(titlePage, "Shop gently used instyle collection", "Collection page is not displayed");
	    softAssert.assertEquals(pagetext, "INSTYLE COLLECTION", "Heading is not correct");
	    
	    softAssert.assertAll();
	    Thread.sleep(5000);
		
	}
	
	@Test(priority=3,enabled=true)
	public void NewWithTag() throws InterruptedException{
		navHelper.hoverOnMenu(driver,"COLLECTIONS");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@alt='New with Tags']")).click();
		Thread.sleep(2000);
		
		String titlePage = driver.getTitle();
		System.out.println(titlePage);
		String pagetext = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		
		softAssert.assertEquals(titlePage, "Shop gently used tagged condition clothes", "Collection page is not displayed");
	    softAssert.assertEquals(pagetext, "TAGGED CONDITION", "Heading is not correct");
	    
	    softAssert.assertAll();
	    Thread.sleep(5000);
		
	}
	
	@Test(priority=4,enabled=true)
	public void ItemsWeLove() throws InterruptedException{
		navHelper.hoverOnMenu(driver,"COLLECTIONS");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@alt='Items we <3']")).click();
		Thread.sleep(2000);
		
		String titlePage = driver.getTitle();
		System.out.println(titlePage);
		String pagetext = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		
		softAssert.assertEquals(titlePage, "Shop gently used pieces we love clothes", "Collection page is not displayed");
	    softAssert.assertEquals(pagetext, "PIECES WE LOVE", "Heading is not correct");
	    
	    softAssert.assertAll();
	    Thread.sleep(5000);
		
	}
	
	@AfterTest
    public void closeWindow(){
    	browser.tearDown(driver);
	}
}
