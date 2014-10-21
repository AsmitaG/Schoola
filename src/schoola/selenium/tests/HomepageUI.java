package schoola.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.SocialNWLoginHelpers;

public class HomepageUI extends BaseSelenium{
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
	
	@Test(priority=3,enabled=false)
	public void TestForDonateButton(){
		navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
				
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
	
	@Test(priority=5,enabled=false)
	public void TestHowItWorks(){
		navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean button = driver.findElement(By.cssSelector("div.how-it-works > p > a")).isDisplayed();
		driver.findElement(By.cssSelector("div.how-it-works > p > a")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
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
		
	}
	
	@Test(priority=6,enabled=false)
	public void SeeTheirStory(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean button = driver.findElement(By.cssSelector("div.l > a.lazy_block > img.lazy_home")).isDisplayed();
		driver.findElement(By.cssSelector("div.l > a.lazy_block > img.lazy_home")).click();
		
		String titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);
		
		softAssert.assertEquals(button,true,"See Their Story button is not dispalyed on home page");
		softAssert.assertEquals(titleOfPage, "Save Music and Art and Play at Kipp Academy Charter School", "Incorrect page is displayed");
		
		softAssert.assertAll();
	}
	
	@Test(priority=7,enabled=false)
	public void NewwithTags(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean button = driver.findElement(By.cssSelector("div.r > a.lazy_block > img.lazy_home")).isDisplayed();
		driver.findElement(By.cssSelector("div.r > a.lazy_block > img.lazy_home")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		boolean titleonPage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).isDisplayed();
		String textonpage=driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		
		String titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);
		
		String filter = driver.findElement(By.xpath(".//*[@id='selection-peels']/li")).getText();
		
		softAssert.assertEquals(button,true,"New With Tags button is not dispalyed on home page");
		softAssert.assertEquals(titleonPage,true,"Title is not dispalyed on shop page");
		softAssert.assertEquals(textonpage, "TAGGED CONDITION", "Incorrect page title is displayed");
		softAssert.assertEquals(titleOfPage, "Shop gently used tagged condition clothes", "Incorrect page is displayed");
		softAssert.assertEquals(filter, "New with tags", "Incorrect page is displayed");

		softAssert.assertAll();
		
	}
	
	@Test(priority=8,enabled=false)
	public void FindYourSchool(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean button = driver.findElement(By.cssSelector("img.lazy_home")).isDisplayed();
		driver.findElement(By.cssSelector("img.lazy_home")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);
		
		boolean titleonPage = driver.findElement(By.xpath(".//*[@id='featured']/div[1]/h2")).isDisplayed();
		String textonpage=driver.findElement(By.xpath(".//*[@id='featured']/div[1]/h2")).getText();
		
		boolean findschool = driver.findElement(By.xpath(".//*[@id='search-school']/div[1]/h2")).isDisplayed();
		String textfind=driver.findElement(By.xpath(".//*[@id='search-school']/div[1]/h2")).getText();
		
		softAssert.assertEquals(button,true,"Find School button is not dispalyed on home page");
		softAssert.assertEquals(titleonPage,true,"Title is not dispalyed on shop page");
		softAssert.assertEquals(textonpage, "Featured Schools", "Incorrect page title is displayed");
		softAssert.assertEquals(findschool,true,"Title is not dispalyed on shop page");
		softAssert.assertEquals(textfind, "Find Your School", "Incorrect page text is displayed");
		softAssert.assertEquals(titleOfPage, "Schoola: Shop, Donate and Share for your School", "Incorrect page is displayed");
		
		softAssert.assertAll();
	}
	
	@Test(priority=9,enabled=false)
	public void ItemsUnderFive(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean button = driver.findElement(By.xpath(".//*[@id='hp-content']/div[1]/div[2]/a/img")).isDisplayed();
		driver.findElement(By.xpath(".//*[@id='hp-content']/div[1]/div[2]/a/img")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);
		
		boolean titleonPage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).isDisplayed();
		String textonpage=driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		
		String filter = driver.findElement(By.xpath(".//*[@id='selection-peels']/li")).getText();
		
		softAssert.assertEquals(button,true,"Under $5 button is not dispalyed on home page");
		softAssert.assertEquals(titleonPage,true,"Title is not dispalyed on shop page");
		softAssert.assertEquals(textonpage, "ITEMS UNDER $5", "Incorrect page title is displayed");
		softAssert.assertEquals(titleOfPage, "Shop gently used clothes under $5", "Incorrect page is displayed");
		softAssert.assertEquals(filter, "Under $5", "Incorrect page is displayed");

		softAssert.assertAll();
		
	}
	
	@Test(priority=10,enabled=true)
	public void CustomShop(){
		//navHelper.gotohome(driver);
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean button = driver.findElement(By.xpath(".//*[@id='hp-content']/div[1]/div[3]/a/img")).isDisplayed();
		driver.findElement(By.xpath(".//*[@id='hp-content']/div[1]/div[3]/a/img")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);
		
		boolean titleonPage = driver.findElement(By.xpath(".//*[@id='s-body']/div/div[1]/h1")).isDisplayed();
		String textonpage=driver.findElement(By.xpath(".//*[@id='s-body']/div/div[1]/h1")).getText();
		
		softAssert.assertEquals(button,true,"custom shop button is not dispalyed on home page");
		softAssert.assertEquals(titleonPage,true,"Title is not dispalyed on shop page");
		softAssert.assertEquals(textonpage, "You Deserve Your Very Own Shop!", "Incorrect page title is displayed");
		softAssert.assertEquals(titleOfPage, "Custom Shop: You Deserve Your Very Own Shop", "Incorrect page is displayed");
		
		softAssert.assertAll();
		
	}
}


