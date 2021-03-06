package schoola.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.SocialNWLoginHelpers;

public class HomepageBodyLinks extends BaseSelenium{
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	BrowserHelper browser = new BrowserHelper();
	
	@Test(priority=1,enabled=true)
	public void TestForFallBrand() throws InterruptedException{
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		SoftAssert softAssert = new SoftAssert();
		String brand = driver.findElement(By.xpath("//div[@id='hp-content']/div[3]/div[2]/div/div/ul[2]/li/a")).getText();
		brand = brand.toUpperCase();
		driver.findElement(By.xpath("//div[@id='hp-content']/div[3]/div[2]/div/div/ul[2]/li/a")).click();
		Thread.sleep(2000);
		String brandPageTitle = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		Thread.sleep(2000);
		
		String brandnameForProduct = driver.findElement(By.xpath(".//*[@id='s-body']/div[2]/div[3]/div/div[1]/div[1]/div[2]/div[1]/div/a/img")).getAttribute("alt");
		brandnameForProduct = brandnameForProduct.toUpperCase();
		
		softAssert.assertEquals(brand, brandPageTitle, "Brand name does not match on brand page");
		softAssert.assertEquals(brand, brandnameForProduct, "Brand name does not match on brand page");
		
		softAssert.assertAll();
		Thread.sleep(4000);
	}
	
	@Test(priority=2,enabled=true)
	public void TestForFallStyles() throws InterruptedException{
		navHelper.gotohome(driver);
		SoftAssert softAssert = new SoftAssert();
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='hp-content']/div[3]/div[2]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		String style = driver.findElement(By.xpath(".//*[@id='hp-content']/div[3]/div[2]/div/div[2]/ul[1]/li[1]/a")).getText();
		style = style.toUpperCase();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='hp-content']/div[3]/div[2]/div/div[2]/ul[1]/li[1]/a")).click();
		Thread.sleep(5000);
		String stylePageTitle = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		System.out.println("here2");
		
			
		softAssert.assertEquals(style, stylePageTitle, "Style name does not match on brand page");
		
		softAssert.assertAll();
		
		Thread.sleep(2000);
	}
	
	@Test(priority=3,enabled=false)
	public void TestForDonateButton() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		Thread.sleep(5000);
		boolean button=driver.findElement(By.xpath("html/body/div[4]/header/div[2]/div/div/div[1]/div/div/a[1]")).isDisplayed();
		driver.findElement(By.xpath("html/body/div[4]/header/div[2]/div/div/div[1]/div/div/a[1]")).click();
		Thread.sleep(5000);
		
		boolean titleonDonatePage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).isDisplayed();
		String titletextonDonatePage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		String titleOfDonatePage = driver.getTitle();
		
		softAssert.assertEquals(button,true,"Donate button is not dispalyed on home page");
		softAssert.assertEquals(titleonDonatePage,true,"Title is not dispalyed on donate page");
		softAssert.assertEquals(titleOfDonatePage, "Send Me A Bag - School Stitch", "Incorrect page is displayed");
		softAssert.assertEquals(titletextonDonatePage, "School funds are in the bag!", "Incorrect page title is displayed");
		
		softAssert.assertAll();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=4,enabled=false)
	public void TestForShopButton() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		navHelper.gotohome(driver);
		Thread.sleep(2000);
		boolean button=driver.findElement(By.xpath("html/body/div[4]/header/div[2]/div/div/div[1]/div/div/a[2]")).isDisplayed();
		driver.findElement(By.xpath("html/body/div[4]/header/div[2]/div/div/div[1]/div/div/a[2]")).click();
		Thread.sleep(5000);
		boolean titleonShopPage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).isDisplayed();
		String titleTextOfShopPage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		 
		String titleOfShopPage = driver.getTitle();
				
		softAssert.assertEquals(button,true,"Shop button is not dispalyed on home page");
		softAssert.assertEquals(titleonShopPage,true,"Title is not dispalyed on shop page");
		softAssert.assertEquals(titleOfShopPage, "Shop gently used clothes", "Incorrect page is displayed");
		softAssert.assertEquals(titleTextOfShopPage, "GREAT CLOTHES THAT DO GOOD", "Incorrect page title is displayed");
		
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=5,enabled=true)
	public void TestHowItWorks() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		navHelper.gotohome(driver);
		Thread.sleep(2000);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean button = driver.findElement(By.cssSelector("div.how-it-works > p > a")).isDisplayed();
		driver.findElement(By.cssSelector("div.how-it-works > p > a")).click();
		Thread.sleep(5000);
		
		boolean titleonPage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).isDisplayed();
		String textonpage=driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		String titleOfPage = driver.getTitle();
		//System.out.println(titleOfPage);

		boolean shopbutton = driver.findElement(By.linkText("Shop to Help")).isDisplayed();
		boolean donatebutton = driver.findElement(By.linkText("Donate to Help")).isDisplayed();
		
		softAssert.assertEquals(button,true,"How it works button is not dispalyed on home page");
		softAssert.assertEquals(titleonPage,true,"Title is not dispalyed on shop page");
		softAssert.assertEquals(textonpage, "How Schoola Works", "Incorrect page title is displayed");
		softAssert.assertEquals(titleOfPage, "About Schoola Stitch", "Incorrect page is displayed");
		softAssert.assertEquals(shopbutton,true,"shop button is not displayed on How it works page");
		softAssert.assertEquals(donatebutton,true,"donate button is not displayed on How it works page");
		
		softAssert.assertAll();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=6,enabled=true)
	public void SeeTheirStory() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		Thread.sleep(5000);
		boolean button = driver.findElement(By.cssSelector("div.l > a.lazy_block > img.lazy_home")).isDisplayed();
		driver.findElement(By.cssSelector("div.l > a.lazy_block > img.lazy_home")).click();
		Thread.sleep(5000);
		
		String titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);
		
		softAssert.assertEquals(button,true,"See Their Story button is not dispalyed on home page");
		softAssert.assertEquals(titleOfPage, "Save Music and Art and Play at Kipp Academy Charter School", "Incorrect page is displayed");
		
		softAssert.assertAll();
		Thread.sleep(5000);
	}

	@Test(priority=7,enabled=false)
	public void CustomShop() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		Thread.sleep(5000);
		boolean button = driver.findElement(By.xpath(".//*[@id='hp-content']/div[1]/div[3]/a/img")).isDisplayed();
		driver.findElement(By.xpath(".//*[@id='hp-content']/div[1]/div[3]/a/img")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		String titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);
		
		boolean titleonPage = driver.findElement(By.xpath(".//*[@id='s-body']/div/div[1]/h1")).isDisplayed();
		String textonpage=driver.findElement(By.xpath(".//*[@id='s-body']/div/div[1]/h1")).getText();
		
		softAssert.assertEquals(button,true,"custom shop button is not dispalyed on home page");
		softAssert.assertEquals(titleonPage,true,"Title is not dispalyed on shop page");
		softAssert.assertEquals(textonpage, "You Deserve Your Very Own Shop!", "Incorrect page title is displayed");
		softAssert.assertEquals(titleOfPage, "Custom Shop: You Deserve Your Very Own Shop", "Incorrect page is displayed");
		
		softAssert.assertAll();
		Thread.sleep(2000);
		
	}
	
	@AfterTest
    public void closeWindow(){
    	browser.tearDown(driver);
    }
}


