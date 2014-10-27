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

public class BoysMenuUI extends BaseSelenium {
	NavigationHelpers navHelper=new NavigationHelpers();
	SoftAssert softAssert = new SoftAssert();
	TakeScreenshots shot = new TakeScreenshots();
	BrowserHelper browser = new BrowserHelper();
	
	@Test(priority=1,enabled=true)
	public void checkMenuLinks() throws InterruptedException{
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"BOYS");
		Thread.sleep(5000);
	    
	    //pre-schoola
	    boolean linkPreSchoolaDisplayed = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[1]/div/a[1]/div/div/div/h3")).isDisplayed();
	    String linkPreSchoola = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[1]/div/a[1]/div/div/div/h3")).getText();
	    
	    //grade-schoola
	    boolean linkGradeSchoolaDisplayed = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[1]/div/a[2]/div/div/div/h3")).isDisplayed();
	    String linkGradeSchoola = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[1]/div/a[2]/div/div/div/h3")).getText();
	    
	    //high-schoola
	    boolean linkHighSchoolaDisplayed = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[1]/div/a[3]/div/div/div/h3")).isDisplayed();
	    String linkHighSchoola = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[1]/div/a[3]/div/div/div/h3")).getText();
	    
	    //Jeans
	    boolean sectionJeansDisplayed = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[1]/div[1]/div/a")).isDisplayed();
	    String sectionJeans = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[1]/div[1]/div/a")).getText();
	    
	    //Tops
	    boolean sectionTopsDisplayed = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[1]/div[2]/div/a")).isDisplayed();
	    String sectionTops = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[1]/div[2]/div/a")).getText();
	    
	    //bottoms
	    boolean sectionBottomsDisplayed = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[2]/div[1]/div/a")).isDisplayed();
	    String sectionBottoms = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[2]/div[1]/div/a")).getText();
	    
	    //Footwear
	    boolean sectionFootwearDisplayed = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[2]/div[2]/div/a")).isDisplayed();
	    String sectionFootwear = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[2]/div[2]/div/a")).getText();
	    
	    //Accessories
	    boolean sectionAccessoriesDisplayed = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[3]/div[1]/div/a")).isDisplayed();
	    String sectionAccessories = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[3]/div[1]/div/a")).getText();
	    
	    //OuterWear
	    boolean sectionOuterwearDisplayed = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[3]/div[2]/div/a")).isDisplayed();
	    String sectionOuterwear = driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[3]/div[2]/div/a")).getText();
	    
	    Thread.sleep(5000);
	    
	    //Assertions
	    softAssert.assertEquals(linkPreSchoolaDisplayed, true, "PresSchoola link is not disaplyed under boys menu");
	    softAssert.assertEquals(linkPreSchoola, "Preschoola", "Link Text for Boys preschoola is not correct");
	    
	    softAssert.assertEquals(linkGradeSchoolaDisplayed, true, "GradeSchoola link is not disaplyed under Boys menu");
	    softAssert.assertEquals(linkGradeSchoola, "Grade Schoola", "Link Text for Boys grade-schoola is not correct");
	    
	    softAssert.assertEquals(linkHighSchoolaDisplayed, true, "HighSchoola link is not disaplyed under Boys menu");
	    softAssert.assertEquals(linkHighSchoola, "High Schoola", "Link Text for Boys high-schoola is not correct");	
	    
	    softAssert.assertEquals(sectionJeansDisplayed, true, "Jeans is not disaplyed under boys menu");
	    softAssert.assertEquals(sectionJeans, "Jeans", "Link Text for Boys Jeans is not correct");	
	    
	    softAssert.assertEquals(sectionTopsDisplayed, true, "Tops is not disaplyed under Boys menu");
	    softAssert.assertEquals(sectionTops, "Tops", "Link Text for Boys tops is not correct");
	    
	    softAssert.assertEquals(sectionBottomsDisplayed, true, "Bottoms is not disaplyed under Boys menu");
	    softAssert.assertEquals(sectionBottoms, "Bottoms", "Link Text for Boys bottoms is not correct");
	    
	    softAssert.assertEquals(sectionFootwearDisplayed, true, "Footwear is not disaplyed under Boys menu");
	    softAssert.assertEquals(sectionFootwear, "Footwear", "Link Text for Boys Footwear is not correct");
	    
	    softAssert.assertEquals(sectionAccessoriesDisplayed, true, "Accessories is not disaplyed under Boys menu");
	    softAssert.assertEquals(sectionAccessories, "Accessories", "Link Text for Boys Accessories is not correct");
	    
	    softAssert.assertEquals(sectionOuterwearDisplayed, true, "Outerwear is not disaplyed under Boys menu");
	    softAssert.assertEquals(sectionOuterwear, "Outerwear", "Link Text for Boys Outerwears is not correct");
	    
	    softAssert.assertAll();
	    
	    Thread.sleep(5000);
	    
	}

	@Test(priority=2,enabled=true)
	public void BoysPreSchoolaPage() throws InterruptedException{
		navHelper.gotohome(driver);
		Thread.sleep(2000);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"BOYS");
		driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[1]/div/a[1]/div/div/div/h3")).click();
		Thread.sleep(5000);
		
		//Get Title
		String titlePreSchoolaPage = driver.getTitle();
		//System.out.println(titlePreSchoolaPage);
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter = driver.findElement(By.xpath(".//*[@id='selection-peels']/li")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titlePreSchoolaPage, "Shop little boys gently used clothes", "Preschoola page is not displayed");
	    softAssert.assertEquals(pageheading, "BOYS CLOTHES FOR 1-5 YEAR OLDS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter, "Preschoola Boys All", "Filter is in correct");
	    
	    softAssert.assertAll();
	    Thread.sleep(5000);
	}
	
	@Test(priority=3,enabled=true)
	public void BoysGradeSchoolaPage() throws InterruptedException{
		//navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"BOYS");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[1]/div/a[2]/div/div/div/h3")).click();
		Thread.sleep(5000);
		
		//Get Title
		String titlegradeSchoolaPage = driver.getTitle();
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter = driver.findElement(By.xpath(".//*[@id='selection-peels']/li")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titlegradeSchoolaPage, "Shop big boys gently used clothes", "Grade schoola page is not displayed");
	    softAssert.assertEquals(pageheading, "BOYS CLOTHES FOR 6-12 YEAR OLDS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter, "Grade Schoola Boys All", "Filter is in correct");
	    
	    softAssert.assertAll();
	    Thread.sleep(5000);
	}

	@Test(priority=4,enabled=true)
	public void BoysHighSchoolaPage() throws InterruptedException{
		//navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"BOYS");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[1]/div/a[3]/div/div/div/h3")).click();
		Thread.sleep(3000);
		
		//Get Title
		String titleHighSchoolaPage = driver.getTitle();
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter = driver.findElement(By.xpath(".//*[@id='selection-peels']/li")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titleHighSchoolaPage, "Shop teen boys gently used clothes", "High schoola page is not displayed");
	    softAssert.assertEquals(pageheading, "BOYS CLOTHES FOR 13+ YEAR OLDS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter, "High Schoola Boys All", "Filter is in correct");
	    
	    softAssert.assertAll();
	    Thread.sleep(5000);
	}

	@Test(priority=5,enabled=true)
	public void BoysTops() throws InterruptedException{
		//navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"BOYS");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[1]/div[2]/a/img")).click();
		Thread.sleep(4000);
		
		//Get Title
		String titlePage = driver.getTitle();
		//System.out.println(titlePage);
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter1 = driver.findElement(By.xpath(".//*[@id='selection-peels']/li[1]")).getText();
	    String pagefilter2 = driver.findElement(By.xpath(".//*[@id='selection-peels']/li[2]")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titlePage, "Shop gently used boys tops", "Boys Tops page is not displayed");
	    softAssert.assertEquals(pageheading, "BOYS TOPS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter1, "Boys", "Filter is incorrect");
	    softAssert.assertEquals(pagefilter2, "Tops", "Filter is incorrect");
	    
	    softAssert.assertAll();
	    Thread.sleep(5000);
	}

	@Test(priority=6,enabled=true)
	public void BoysBoots() throws InterruptedException{
		//navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navHelper.hoverOnMenu(driver,"BOYS");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='boy_sub']/div/div[2]/div[2]/div[2]/div/ul/li[3]/a")).click();
		Thread.sleep(5000);
		
		//Get Title
		String titlePage = driver.getTitle();
		//System.out.println(titlePage);
	    
	    //Get Heading
	    String pageheading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	    
	    //Get Auto Filter
	    String pagefilter1 = driver.findElement(By.xpath(".//*[@id='selection-peels']/li[1]")).getText();
	    String pagefilter2 = driver.findElement(By.xpath(".//*[@id='selection-peels']/li[2]")).getText();
	    
	    //Assertions
	    softAssert.assertEquals(titlePage, "Shop boys gently used boots", "Boys boots page is not displayed");
	    softAssert.assertEquals(pageheading, "BOYS BOOTS", "Heading is not correct");
	    softAssert.assertEquals(pagefilter1, "Boys", "Filter is incorrect");
	    softAssert.assertEquals(pagefilter2, "Boot", "Filter is incorrect");
	    
	    softAssert.assertAll();
	    Thread.sleep(2000);
	}

	@AfterTest
    public void closeWindow(){
    	browser.tearDown(driver);
    }

}
