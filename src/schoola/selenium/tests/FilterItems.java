package schoola.selenium.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.FilterHelpers;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.TakeScreenshots;

public class FilterItems extends BaseSelenium {

	/**
	 * @param args
	 */
	BrowserHelper browserHelper = new BrowserHelper();
	
	NavigationHelpers navHelper = new NavigationHelpers();	
	FilterHelpers filterHelper = new FilterHelpers();
	TakeScreenshots takeScreenshot = new TakeScreenshots();
	
	@BeforeTest
	public void setUp(){
		browserHelper.setUp(driver);
	}
	
	@Test(priority=1)
	public void FilterByCategory() throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver, "GIRLS");		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		navHelper.goToGirlsPreSchoola(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		filterHelper.clearAllSelections(driver);		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		filterHelper.category1(driver);		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String category1 = filterHelper.category1_option1(driver);		
		System.out.println("category1 :"+category1);
		Thread.sleep(3000);
		takeScreenshot.takeScreenshot(driver, "FilterByTops1.png");
		String heading = filterHelper.filterPageHeading(driver);
		String currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertTrue(heading.contains(category1.toUpperCase()), "On clicking Category Tops - "+category1+" for Girls,Page heading did not match to category name");
		softAssert.assertEquals(currentSelection,category1, "On clicking Category Tops - "+category1+" , Your Selections does not match to selected category");
			
		filterHelper.clearAllSelections(driver);		
		Thread.sleep(2000);
		filterHelper.category1(driver);
		Thread.sleep(1000);
		String category2 = filterHelper.category1_option2(driver);	
		
		System.out.println("category2 :"+category2);
		Thread.sleep(2000);
		takeScreenshot.takeScreenshot(driver, "FilterByTops2.png");
		heading = filterHelper.filterPageHeading(driver);
		currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertTrue(heading.contains(category2.toUpperCase()), "On clicking Category Tops - "+category2+" for Girls,Page heading did not match to category name");
		softAssert.assertEquals(currentSelection,category2, "On clicking Category Tops - "+category2+" , Your Selections does not match to selected category");
		softAssert.assertAll();
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
  }
	
	
	@Test(priority=2)
	public void FilterByBrand() throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		String brand1 = filterHelper.brand_option1(driver);
		System.out.println("Brand 1 :"+brand1);
		Thread.sleep(2000);
		takeScreenshot.takeScreenshot(driver, "FilterByBrand1.png");
		String heading = filterHelper.filterPageHeading(driver);		
		
		String currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertTrue(heading.contains(brand1.toUpperCase()), "On clicking Brand - "+brand1+" for Girls,Page heading did not match to brand name");
		softAssert.assertEquals(currentSelection, brand1, "On clicking Brand -"+brand1+" , Your Selections does not match to selected brand name");
		softAssert.assertAll();
		
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
		
		brand1 = filterHelper.brand_option2(driver);
		takeScreenshot.takeScreenshot(driver, "FilterByBrand2.png");
		System.out.println("Brand 2 :"+brand1);
		Thread.sleep(2000);
		heading = filterHelper.filterPageHeading(driver);		
		
		
		currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertTrue(heading.contains(brand1.toUpperCase()), "On clicking Brand - "+brand1+" for Girls,Page heading did not match to brand name");
		softAssert.assertEquals(currentSelection, brand1, "On clicking Brand -"+brand1+" , Your Selections does not match to selected brand name");
		softAssert.assertAll();
		
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
	  
  }
	
	@Test(priority=3)
	public void FilterByPrice() throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		String price1 = filterHelper.price_option1(driver);
		System.out.println("Price 1 :"+price1);
		Thread.sleep(2000);
		takeScreenshot.takeScreenshot(driver, "FilterByPrice1.png");
		String heading = filterHelper.filterPageHeading(driver);		
		
		String currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertEquals(heading,"GREAT CLOTHES THAT DO GOOD", "On clicking Price - "+price1+" for Girls,Page heading did not match");
		softAssert.assertEquals(currentSelection, price1, "On clicking Price -"+price1+" , Your Selections does not match to selected price value");
		softAssert.assertAll();
	  
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
		
		price1 = filterHelper.price_option2(driver);
		takeScreenshot.takeScreenshot(driver, "FilterByPrice2.png");
		System.out.println("Price 2 :"+price1);
		Thread.sleep(2000);
		heading = filterHelper.filterPageHeading(driver);		
		
		currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertEquals(heading,"GREAT CLOTHES THAT DO GOOD", "On clicking Price - "+price1+" for Girls,Page heading did not match");
		softAssert.assertEquals(currentSelection, price1, "On clicking Price -"+price1+" , Your Selections does not match to selected price value");
		softAssert.assertAll();
	  
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
  }
	
	@Test(priority=4)
	public void FilterByColor() throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		String color1 = filterHelper.color_option1(driver);
		System.out.println("Color1 :"+color1);
		Thread.sleep(2000);
		takeScreenshot.takeScreenshot(driver, "FilterByColor1.png");
		String heading = filterHelper.filterPageHeading(driver);		
		
		String currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertEquals(heading,"GREAT CLOTHES THAT DO GOOD", "On clicking Color - "+color1+" for Girls,Page heading did not match");
		softAssert.assertEquals(currentSelection, color1, "On clicking Color -"+color1+" , Your Selections does not match to selected color name");
		softAssert.assertAll();
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
		
		color1 = filterHelper.color_option2(driver);
		System.out.println("Color2 :"+color1);
		Thread.sleep(2000);
		takeScreenshot.takeScreenshot(driver, "FilterByColor2.png");
		heading = filterHelper.filterPageHeading(driver);		
		
		currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertEquals(heading,"GREAT CLOTHES THAT DO GOOD", "On clicking Color - "+color1+" for Girls,Page heading did not match");
		softAssert.assertEquals(currentSelection, color1, "On clicking Color -"+color1+" , Your Selections does not match to selected color name");
		softAssert.assertAll();
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
  }
	
	@Test(priority=5)
	public void FilterByCondition() throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		String condition1 = filterHelper.condition_option1(driver);
		System.out.println("Condition1 :"+condition1);
		Thread.sleep(2000);
		takeScreenshot.takeScreenshot(driver, "FilterByCondition1.png");
		String heading = filterHelper.filterPageHeading(driver);		
		
		String currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertEquals(heading,"GREAT CLOTHES THAT DO GOOD", "On clicking Condition - "+condition1+" for Girls,Page heading did not match");
		softAssert.assertTrue(condition1.contains(currentSelection), "On clicking Condition -"+condition1+" , Your Selections does not match to selected condition value");
		softAssert.assertAll();
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
		
		condition1 = filterHelper.condition_option2(driver);
		System.out.println("Condition2 :"+condition1);
		Thread.sleep(2000);
		takeScreenshot.takeScreenshot(driver, "FilterByCondition2.png");
		heading = filterHelper.filterPageHeading(driver);		
		
		currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertEquals(heading,"GREAT CLOTHES THAT DO GOOD", "On clicking Condition - "+condition1+" for Girls,Page heading did not match");
		softAssert.assertTrue(condition1.contains(currentSelection), "On clicking Condition -"+condition1+" , Your Selections does not match to selected condition value");
		softAssert.assertAll();
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
  }
	
	@Test(priority=6)
	public void FilterByLook() throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		String look1 = filterHelper.look_option1(driver);
		System.out.println("Look1 :"+look1);
		Thread.sleep(2000);
		takeScreenshot.takeScreenshot(driver, "FilterByLook1.png");
		String heading = filterHelper.filterPageHeading(driver);		
		
		String currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertEquals(heading,"GREAT CLOTHES THAT DO GOOD", "On clicking Look - "+look1+" for Girls,Page heading did not match");
		softAssert.assertEquals(currentSelection,look1, "On clicking Look -"+look1+" , Your Selections does not match to selected look value");
		softAssert.assertAll();
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
		
		look1 = filterHelper.look_option2(driver);
		System.out.println("Look2 :"+look1);
		Thread.sleep(2000);
		takeScreenshot.takeScreenshot(driver, "FilterByLook2.png");
		heading = filterHelper.filterPageHeading(driver);		
		
		currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertEquals(heading,"GREAT CLOTHES THAT DO GOOD", "On clicking Look - "+look1+" for Girls,Page heading did not match");
		softAssert.assertEquals(currentSelection,look1, "On clicking Look -"+look1+" , Your Selections does not match to selected look value");
		softAssert.assertAll();
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
		
  }
	
	@Test(priority=7)
	public void FilterBySearch() throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		filterHelper.searchFilter(driver);
		Thread.sleep(3000);
		takeScreenshot.takeScreenshot(driver, "FilterBySearch1.png");
		String heading = filterHelper.filterPageHeading(driver);		
		
		String currentSelection = filterHelper.currentSelections(driver);
		softAssert.assertEquals(heading,"SEARCH FOR \"JEANS\"", "On Search by Jeans , page heading did not match");
		softAssert.assertEquals(currentSelection,"Jeans", "On search by Jeans, Your Selections does not match to the seacrhed value");
		softAssert.assertAll();
		filterHelper.clearAllSelections(driver);
		Thread.sleep(1000);
	
	}
	
	@AfterTest
	public void tearDown(){
		browserHelper.tearDown(driver);
	}

}
