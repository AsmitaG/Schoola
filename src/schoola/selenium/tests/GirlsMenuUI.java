package schoola.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.TakeScreenshots;

public class GirlsMenuUI extends BaseSelenium {
	NavigationHelpers navHelper=new NavigationHelpers();
	SoftAssert softAssert = new SoftAssert();
	TakeScreenshots shot = new TakeScreenshots();
	
	@Test(priority=2,enabled=true)
	public void checkMenuLinks(){
		navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"GIRLS");
	
	    //pre-schoola
	    boolean linkPreSchoolaDisplayed = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[1]/div/div/div/h3")).isDisplayed();
	    String linkPreSchoola = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[1]/div/div/div/h3")).getText();
	    
	    //grade-schoola
	    boolean linkGradeSchoolaDisplayed = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[2]/div/div/div/h3")).isDisplayed();
	    String linkGradeSchoola = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[2]/div/div/div/h3")).getText();
	    
	    //high-schoola
	    boolean linkHighSchoolaDisplayed = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[3]/div/div/div/h3")).isDisplayed();
	    String linkHighSchoola = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[3]/div/div/div/h3")).getText();
	    
	    //dresses
	    boolean sectionDressesDisplayed = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[1]/div[1]/div/a")).isDisplayed();
	    String sectionDresses = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[1]/div[1]/div/a")).getText();
	    
	    //Tops
	    boolean sectionTopsDisplayed = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[1]/div[2]/div/a")).isDisplayed();
	    String sectionTops = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[1]/div[2]/div/a")).getText();
	    
	    //bottoms
	    boolean sectionBottomsDisplayed = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[2]/div[1]/div/a")).isDisplayed();
	    String sectionBottoms = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[2]/div[1]/div/a")).getText();
	    
	    //Footwear
	    boolean sectionFootwearDisplayed = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[2]/div[2]/div/a")).isDisplayed();
	    String sectionFootwear = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[2]/div[2]/div/a")).getText();
	    
	    //Accessories
	    boolean sectionAccessoriesDisplayed = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[3]/div[1]/div/a")).isDisplayed();
	    String sectionAccessories = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[3]/div[1]/div/a")).getText();
	    
	    //OuterWear
	    boolean sectionOuterwearDisplayed = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[3]/div[2]/div/a")).isDisplayed();
	    String sectionOuterwear = driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[3]/div[2]/div/a")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(linkPreSchoolaDisplayed, true, "PresSchoola link is not disaplyed under girls menu");
	    softAssert.assertEquals(linkPreSchoola, "Preschoola", "Link Text for Girls preschoola is not correct");
	    
	    softAssert.assertEquals(linkGradeSchoolaDisplayed, true, "GradeSchoola link is not disaplyed under girls menu");
	    softAssert.assertEquals(linkGradeSchoola, "Grade Schoola", "Link Text for Girls grade-schoola is not correct");
	    
	    softAssert.assertEquals(linkHighSchoolaDisplayed, true, "HighSchoola link is not disaplyed under girls menu");
	    softAssert.assertEquals(linkHighSchoola, "High Schoola", "Link Text for Girls high-schoola is not correct");	
	    
	    softAssert.assertEquals(sectionDressesDisplayed, true, "Dresses is not disaplyed under girls menu");
	    softAssert.assertEquals(sectionDresses, "Dresses", "Link Text for Girls Dresses is not correct");	
	    
	    softAssert.assertEquals(sectionTopsDisplayed, true, "Tops is not disaplyed under girls menu");
	    softAssert.assertEquals(sectionTops, "Tops", "Link Text for Girls tops is not correct");
	    
	    softAssert.assertEquals(sectionBottomsDisplayed, true, "Bottoms is not disaplyed under girls menu");
	    softAssert.assertEquals(sectionBottoms, "Bottoms", "Link Text for Girls bottoms is not correct");
	    
	    softAssert.assertEquals(sectionFootwearDisplayed, true, "Footwear is not disaplyed under girls menu");
	    softAssert.assertEquals(sectionFootwear, "Footwear", "Link Text for Girls Footwear is not correct");
	    
	    softAssert.assertEquals(sectionAccessoriesDisplayed, true, "Accessories is not disaplyed under girls menu");
	    softAssert.assertEquals(sectionAccessories, "Accessories", "Link Text for Girls Accessories is not correct");
	    
	    softAssert.assertEquals(sectionOuterwearDisplayed, true, "Outerwear is not disaplyed under girls menu");
	    softAssert.assertEquals(sectionOuterwear, "Outerwear", "Link Text for Girls Outerwears is not correct");
	    
	    softAssert.assertAll();
	    System.out.println("Case 1");
	    
	}

	@Test(priority=1,enabled=true)
	public void girlsPreSchoolaPage() throws InterruptedException{
		navHelper.gotohome(driver);
		Thread.sleep(5000);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"GIRLS");
		driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[1]/div/div/div/h3")).click();
		
		//Get Title
		String titlePreSchoolaPage = driver.getTitle();
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter = driver.findElement(By.xpath(".//*[@id='selection-peels']/li")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titlePreSchoolaPage, "Shop little girls gently used clothes", "Preschoola page is not displayed");
	    softAssert.assertEquals(pageheading, "GIRLS CLOTHES FOR 1-5 YEAR OLDS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter, "Preschoola Girls All", "Filter is in correct");
	    
	    softAssert.assertAll();
	    System.out.println("Case 2");
	}
	
	@Test(priority=3,enabled=false)
	public void girlsGradeSchoolaPage() throws InterruptedException{
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"GIRLS");
		driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[2]/div/div/div/h3")).click();
		
		//Get Title
		String titlegradeSchoolaPage = driver.getTitle();
		System.out.println(titlegradeSchoolaPage);
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter = driver.findElement(By.xpath(".//*[@id='selection-peels']/li")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titlegradeSchoolaPage, "Shop big girls gently used clothes", "Grade schoola page is not displayed");
	    softAssert.assertEquals(pageheading, "GIRLS CLOTHES FOR 6-12 YEAR OLDS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter, "Grade Schoola Girls All", "Filter is in correct");
	    
	    softAssert.assertAll();
	}

	@Test(priority=4,enabled=false)
	public void girlsHighSchoolaPage() throws InterruptedException{
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"GIRLS");
		driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[3]/div/div/div/h3")).click();
		
		//Get Title
		String titleHighSchoolaPage = driver.getTitle();
		System.out.println(titleHighSchoolaPage);
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter = driver.findElement(By.xpath(".//*[@id='selection-peels']/li")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titleHighSchoolaPage, "Shop teen girls gently used clothes", "High schoola page is not displayed");
	    softAssert.assertEquals(pageheading, "GIRLS CLOTHES FOR 13+ YEAR OLDS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter, "High Schoola Girls All", "Filter is in correct");
	    
	    softAssert.assertAll();
	}

	@Test(priority=5,enabled=false)
	public void girlsTops() throws InterruptedException{
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		navHelper.hoverOnMenu(driver,"GIRLS");
		driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[1]/div[2]/a/img")).click();
		
		//Get Title
		String titlePage = driver.getTitle();
		//System.out.println(titlePage);
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter1 = driver.findElement(By.xpath(".//*[@id='selection-peels']/li[1]")).getText();
	    String pagefilter2 = driver.findElement(By.xpath(".//*[@id='selection-peels']/li[2]")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titlePage, "Shop gently used girls tops", "Girls Tops page is not displayed");
	    softAssert.assertEquals(pageheading, "GIRLS TOPS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter1, "Girls", "Filter is incorrect");
	    softAssert.assertEquals(pagefilter2, "Tops", "Filter is incorrect");
	    
	    softAssert.assertAll();
	}

	@Test(priority=6,enabled=false)
	public void girlsBoots() throws InterruptedException{
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		navHelper.hoverOnMenu(driver,"GIRLS");
		driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[2]/div[2]/div[2]/div/ul/li[3]/a")).click();
		
		//Get Title
		String titlePage = driver.getTitle();
		System.out.println(titlePage);
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter1 = driver.findElement(By.xpath(".//*[@id='selection-peels']/li[1]")).getText();
	    String pagefilter2 = driver.findElement(By.xpath(".//*[@id='selection-peels']/li[2]")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titlePage, "Shop gently used girls boots", "Girls Boots page is not displayed");
	    softAssert.assertEquals(pageheading, "GIRLS BOOTS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter1, "Girls", "Filter is incorrect");
	    softAssert.assertEquals(pagefilter2, "Boot", "Filter is incorrect");
	    
	    softAssert.assertAll();
	    System.out.println("Case 6");
	}

}