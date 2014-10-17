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
	
	}


