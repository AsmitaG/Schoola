package schoola.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.FilterHelpers;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;

public class FilterItems extends BaseSelenium {

	/**
	 * @param args
	 */
	LoginHelpers loginHelpers=new LoginHelpers();
	SoftAssert softAssert = new SoftAssert();
	NavigationHelpers navHelper = new NavigationHelpers();	
	FilterHelpers filterHelper = new FilterHelpers();
	
	@Test(priority=1)
	public void FilterByCategory() throws InterruptedException {
		driver.get("http://www.schoola.com");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement hover=driver.findElement(By.linkText("GIRLS"));
		Actions Builder = new Actions(driver);
		Builder.moveToElement(hover).build().perform();
		driver.findElement(By.linkText("Boots")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("ul.menu li#girl_sub.with-sub div.nav-sub div div.r a div.size-block div.t div h3")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		filterHelper.category1(driver);		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String category1 = filterHelper.category1_option1(driver);
		Thread.sleep(3000);
		String heading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		System.out.println("heading"+heading);
		softAssert.assertTrue(heading.contains(category1.toUpperCase()), "On clicking Category Tops - "+category1+" for Girls,Page heading did not match to category name");
		filterHelper.category1_option1(driver);
		Thread.sleep(2000);
		String category2 = filterHelper.category1_option2(driver);		
		Thread.sleep(3000);
		heading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		softAssert.assertTrue(heading.contains(category2.toUpperCase()), "On clicking Category Tops - "+category2+" for Girls,Page heading did not match to category name");
		softAssert.assertAll();
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
  }
	
	
	@Test(priority=2)
	public void FilterByBrand() throws InterruptedException {
		
		String brand1 = filterHelper.brand_option1(driver);
		System.out.println("BRAND"+brand1);
		Thread.sleep(2000);
		String heading = filterHelper.filterPageHeading(driver);		
		System.out.println("heading"+heading);
		softAssert.assertTrue(heading.contains(brand1.toUpperCase()), "On clicking Brand - "+brand1+" for Girls,Page heading did not match to brand name");
		softAssert.assertAll();
	 
	  
  }
	

}
