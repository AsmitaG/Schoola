package schoola.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.TakeScreenshots;

public class SchoolMenu extends BaseSelenium{
	NavigationHelpers navHelper=new NavigationHelpers();
	SoftAssert softAssert = new SoftAssert();
	TakeScreenshots shot = new TakeScreenshots();
	BrowserHelper browser = new BrowserHelper();
	
	@Test(priority=1,enabled=true)
	public void GotoFindSchool() throws InterruptedException{
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		navHelper.hoverOnMenu(driver,"SCHOOLS");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Find Your School")).click();
		Thread.sleep(2000);
		
		String pageTitle = driver.getTitle();
		
		softAssert.assertEquals(pageTitle, "Schoola: Shop, Donate and Share for your School", "Find page is not displayed");
		softAssert.assertAll();
		Thread.sleep(4000);
	}
	
	@Test(priority=2,enabled=true)
	public void SearchSchoolZip() throws InterruptedException{
		driver.findElement(By.id("school_search_text")).sendKeys("10001");
		driver.findElement(By.id("findschool")).click();
		Thread.sleep(5000);
		
		boolean searchresults = driver.findElement(By.xpath(".//*[@id='search-school']/div[3]/ul[1]/li[1]/div/div[1]/a/img")).isDisplayed();
		String schoolname = driver.findElement(By.xpath(".//*[@id='search-school']/div[3]/ul[1]/li[1]/div/div[2]/p[1]/a")).getText();
		
		String ExpectedTitle = "Save Music and Art and Play at " + schoolname;
		
		driver.findElement(By.xpath(".//*[@id='search-school']/div[3]/ul[1]/li[1]/div/div[1]/a/img")).click();
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		String pageSchoolName = driver.findElement(By.xpath(".//*[@id='main-board-box']/div/h1")).getText();
		Thread.sleep(2000);
		
		softAssert.assertEquals(searchresults,true,"Search by zip failed");
		softAssert.assertEquals(pageTitle,ExpectedTitle,"incorrect school page is dispalyed");
		softAssert.assertEquals(pageSchoolName,schoolname,"incorrect school name is dispalyed on school page");
		
		softAssert.assertAll();
		Thread.sleep(4000);
	}
	
	@Test(priority=3,enabled=true)
	public void SearchSchoolTown() throws InterruptedException{
		driver.get("http://stage.schoola.com/schools");
		Thread.sleep(5000);
		driver.findElement(By.id("school_search_text")).clear();
		driver.findElement(By.id("school_search_text")).sendKeys("Littleton");
		Thread.sleep(5000);
		driver.findElement(By.id("findschool")).click();
		Thread.sleep(5000);
		
		boolean searchresults = driver.findElement(By.xpath(".//*[@id='search-school']/div[3]/ul[1]/li[1]/div/div[1]/a/img")).isDisplayed();
		String schoolname = driver.findElement(By.xpath(".//*[@id='search-school']/div[3]/ul[1]/li[1]/div/div[2]/p[1]/a")).getText();
		String address = driver.findElement(By.xpath(".//*[@id='search-school']/div[3]/ul[1]/li[1]/div/div[2]/p[2]")).getText();
		System.out.println(address);
		Thread.sleep(2000);
		
		String ExpectedTitle = "Save Music and Art and Play at " + schoolname;
		
		driver.findElement(By.xpath(".//*[@id='search-school']/div[3]/ul[1]/li[1]/div/div[1]/a/img")).click();
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		String pageSchoolName = driver.findElement(By.xpath(".//*[@id='main-board-box']/div/h1")).getText();
		Thread.sleep(2000);
		
		softAssert.assertEquals(searchresults,true,"Search by zip failed");
		softAssert.assertEquals(pageTitle,ExpectedTitle,"incorrect school page is dispalyed");
		softAssert.assertTrue(address.contains("Littleton"),"Search is not showing correct results");
		softAssert.assertEquals(pageSchoolName,schoolname,"incorrect school name is dispalyed on school page");
		
		softAssert.assertAll();
		Thread.sleep(5000);
	}
	
	@Test(priority=4,enabled=true)
	public void SearchSchoolName() throws InterruptedException{
		String schoolname ="Sheltering Arms Childrens Service";
		driver.get("http://stage.schoola.com/schools");
		Thread.sleep(5000);
		driver.findElement(By.id("school_search_text")).clear();
		driver.findElement(By.id("school_search_text")).sendKeys(schoolname);
		Thread.sleep(5000);
		driver.findElement(By.id("findschool")).click();
		Thread.sleep(5000);
		
		String ExpectedTitle = "Save Music and Art and Play at " + schoolname;
		
		String pageTitle = driver.getTitle();
		String pageSchoolName = driver.findElement(By.xpath(".//*[@id='main-board-box']/div/h1")).getText();
		Thread.sleep(2000);
				
		softAssert.assertEquals(pageTitle,ExpectedTitle,"incorrect school page is dispalyed");
		softAssert.assertEquals(pageSchoolName,schoolname,"incorrect school name is dispalyed on school page");
		
		softAssert.assertAll();
	}
	
	@AfterTest
    public void closeWindow(){
    	browser.tearDown(driver);
	}
}
