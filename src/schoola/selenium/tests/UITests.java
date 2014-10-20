package schoola.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.SocialNWLoginHelpers;

public class UITests extends BaseSelenium{
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority=1,enabled=false)
	public void TestForFallBrand(){
		navHelper.gotohome(driver);
		String brand = driver.findElement(By.xpath(".//*[@id='hp-content']/div[3]/div[2]/div/div[1]/ul[2]/li[1]/a")).getText();
		brand = brand.toUpperCase();
		driver.findElement(By.xpath(".//*[@id='hp-content']/div[3]/div[2]/div/div[1]/ul[2]/li[1]/a")).click();
		String brandPageTitle = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		
		String brandnameForProduct = driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[3]/div/div[1]/div[1]/div[2]/div[1]/div/a/img")).getAttribute("alt");
		brandnameForProduct = brandnameForProduct.toUpperCase();
		
		softAssert.assertEquals(brand, brandPageTitle, "Brand name does not match on brand page");
		softAssert.assertEquals(brand, brandnameForProduct, "Brand name does not match on brand page");
		
		softAssert.assertAll();
	}
	
	@Test(priority=2,enabled=false)
	public void TestForFallStyles() throws InterruptedException{
		navHelper.gotohome(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='hp-content']/div[3]/div[2]/div/ul/li[2]/a")).click();
		String style = driver.findElement(By.xpath(".//*[@id='hp-content']/div[3]/div[2]/div/div[2]/ul[1]/li[1]/a")).getText();
		style = style.toUpperCase();
		driver.findElement(By.xpath(".//*[@id='hp-content']/div[3]/div[2]/div/div[2]/ul[1]/li[1]/a")).click();
		String stylePageTitle = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		
			
		softAssert.assertEquals(style, stylePageTitle, "Style name does not match on brand page");
		
		softAssert.assertAll();
	}
	
	@Test(priority=3,enabled=true)
	public void TestForDonateButton(){
		navHelper.gotohome(driver);
				
		boolean button=driver.findElement(By.xpath("html/body/div[4]/header/div[2]/div/div/div[1]/div/div/a[1]")).isDisplayed();
		driver.findElement(By.xpath("html/body/div[4]/header/div[2]/div/div/div[1]/div/div/a[1]")).click();
		
		boolean titleonDonatePage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).isDisplayed();
		String titletextonDonatePage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		String titleOfDonatePage = driver.getTitle();
		
		softAssert.assertEquals(button,true,"Donate button is not dispalyed on home page");
		softAssert.assertEquals(titleonDonatePage,true,"Title is not dispalyed on donate page");
		softAssert.assertEquals(titleOfDonatePage, "Send Me A Bag - School Stitch", "Incorrect page is displayed");
		softAssert.assertEquals(titletextonDonatePage, "School funds are in the bag!", "Incorrect page title is displayed");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=4,enabled=false)
	public void TestForShopButton(){
		navHelper.gotohome(driver);
		
		boolean button=driver.findElement(By.xpath("html/body/div[4]/header/div[2]/div/div/div[1]/div/div/a[2]")).isDisplayed();
		driver.findElement(By.xpath("html/body/div[4]/header/div[2]/div/div/div[1]/div/div/a[2]")).click();
		
		boolean titleonShopPage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).isDisplayed();
		String titleTextOfShopPage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		 
		String titleOfShopPage = driver.getTitle();
				
		softAssert.assertEquals(button,true,"Shop button is not dispalyed on home page");
		softAssert.assertEquals(titleonShopPage,true,"Title is not dispalyed on shop page");
		softAssert.assertEquals(titleOfShopPage, "Shop gently used clothes", "Incorrect page is displayed");
		softAssert.assertEquals(titleTextOfShopPage, "GREAT CLOTHES THAT DO GOOD", "Incorrect page title is displayed");
		
		
		softAssert.assertAll();
	}
		
	
}


