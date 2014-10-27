package schoola.selenium.tests;

import java.util.Set;
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

public class HomePageLinks extends BaseSelenium{
	NavigationHelpers navHelper=new NavigationHelpers();
	SocialNWLoginHelpers socialnwHelper = new SocialNWLoginHelpers();
	LoginHelpers loginHelper = new LoginHelpers();
	SoftAssert softAssert = new SoftAssert();
	BrowserHelper browser = new BrowserHelper();
	
	@Test(priority=1,enabled=true)
	public void HowSchoolaWorks() throws InterruptedException{
		if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("How Schoola Works")).isDisplayed();
		driver.findElement(By.linkText("How Schoola Works")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -How Schoola Works- is not displayed on homepage");
		softAssert.assertEquals(title, "About Schoola Stitch", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "How Schoola Works", "Incorrect page text is displayed on page - How Schoola Works");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=2,enabled=true)
	public void OurStory() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		boolean link = driver.findElement(By.linkText("Our Story")).isDisplayed();
		driver.findElement(By.linkText("Our Story")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Our Story- is not displayed on homepage");
		softAssert.assertEquals(title, "About Schoola", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Our Story", "Incorrect page text is displayed on page - Our Story");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=3,enabled=true)
	public void InthePress() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("In the Press")).isDisplayed();
		driver.findElement(By.linkText("In the Press")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='main-div']/div[3]/h3")).getText();
		
		softAssert.assertEquals(link, true, "Link -In the Press- is not displayed on homepage");
		softAssert.assertEquals(title, "Press | Schoola", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "People are Talking...", "Incorrect page text is displayed on page - In the Press");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=4,enabled=true)
	public void JobsAtSchoola() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Jobs at Schoola")).isDisplayed();
		driver.findElement(By.linkText("Jobs at Schoola")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		Thread.sleep(4000);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		String textonpage = driver.findElement(By.xpath("html/body/div[1]/div[1]/h1")).getText();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentWindow);
		
		softAssert.assertEquals(link, true, "Link -Jobs at Schoola- is not displayed on homepage");
		softAssert.assertEquals(title, "Schoola Coach | Schoola | Education - Teaching - Administration | Sales | Contract | Telecommute", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Schoola", "Incorrect page text is displayed on page - Jobs at Schoola");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}

	@Test(priority=5,enabled=true)
	public void BecomeAnAffiliate() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Become an Affiliate")).isDisplayed();
		driver.findElement(By.linkText("Become an Affiliate")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String title = driver.getTitle();
		Thread.sleep(2000);
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Become an Affiliate- is not displayed on homepage");
		softAssert.assertEquals(title, "Schoola Affiliate Program", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "The Affiliate Program", "Incorrect page text is displayed on page - Become an Affiliate");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=6,enabled=true)
	public void TermsOfUse() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Terms of Use")).isDisplayed();
		driver.findElement(By.linkText("Terms of Use")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Terms of Use- is not displayed on homepage");
		softAssert.assertEquals(title, "Legal Information: Schoola", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Legal Information", "Incorrect page text is displayed on page - Terms of Use");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=7,enabled=true)
	public void PrivacyPolicy() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Privacy Policy")).isDisplayed();
		driver.findElement(By.linkText("Privacy Policy")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Privacy Policy- is not displayed on homepage");
		softAssert.assertEquals(title, "Privacy Policy: Schoola", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Privacy Policy", "Incorrect page text is displayed on page - Privacy Policy");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=8,enabled=true)
	public void DonateClothes() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Donate Clothes")).isDisplayed();
		driver.findElement(By.linkText("Donate Clothes")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/div[2]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Donate Clothes- is not displayed on homepage");
		softAssert.assertEquals(title, "Send Me A Bag - School Stitch", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "School funds are in the bag!", "Incorrect page text is displayed on page - Donate Clothes");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=9,enabled=true)
	public void FindYourSchool() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Find Your School")).isDisplayed();
		driver.findElement(By.linkText("Find Your School")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='featured']/div[1]/h2")).getText();
		
		softAssert.assertEquals(link, true, "Link -Find Your School- is not displayed on homepage");
		softAssert.assertEquals(title, "Schoola: Shop, Donate and Share for your School", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Featured Schools", "Incorrect page text is displayed on page - Find Your School");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=14,enabled=true)
	public void ReferAFriend() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Refer a Friend, Get $15")).isDisplayed();
		driver.findElement(By.linkText("Refer a Friend, Get $15")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		driver.findElement(By.id("signin-email")).sendKeys("test@test123.com");
		driver.findElement(By.id("signin-password")).sendKeys("test@test123.com");
		driver.findElement(By.id("overlay-login-submit")).click();
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		
		
		softAssert.assertEquals(link, true, "Link -Refer a Friend, Get $15- is not displayed on homepage");
		softAssert.assertEquals(title, "Stitch Referral - Schoola", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "$15 for You. $15 for your Friend. 40% to Schools.", "Incorrect page text is displayed on page - Refer a Friend, Get $15");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}

	@Test(priority=10,enabled=true)
	public void SchoolaOffers() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Schoola Offers")).isDisplayed();
		driver.findElement(By.linkText("Schoola Offers")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='editable-page-title']/p")).getText();
		
		softAssert.assertEquals(link, true, "Link -Schoola Offers- is not displayed on homepage");
		softAssert.assertEquals(title, "Schoola: Let's Start Something.", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Schoola is the easiest and quickest way to raise money for your school.", "Incorrect page text is displayed on page - Schoola Offers");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=11,enabled=true)
	public void GrabOurApp() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Grab Our App")).isDisplayed();
		driver.findElement(By.linkText("Grab Our App")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		Thread.sleep(5000);
		String URL = driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(parentWindow);
		
		softAssert.assertEquals(link, true, "Link -Grab Our App- is not displayed on homepage");
		softAssert.assertEquals(URL,"https://appsto.re/us/FtYYX.i", "Incorrect page is displayed");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
	@Test(priority=12,enabled=true)
	public void StoreCatalog() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Store Catalog")).isDisplayed();
		driver.findElement(By.linkText("Store Catalog")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='s-body']/div/div/div/div[1]/h1")).getText();
		
		softAssert.assertEquals(link, true, "Link -Store Catalog- is not displayed on homepage");
		softAssert.assertEquals(title, "Stitch catalog", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "Stitch Catalog", "Incorrect page text is displayed on page - Store Catalog");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}

	@Test(priority=13,enabled=true)
	public void SchoolaBlog() throws InterruptedException{
		navHelper.gotohome(driver);
		//if (driver.findElement(By.cssSelector(".roadblock-close")).isDisplayed())
			//driver.findElement(By.cssSelector(".roadblock-close")).click();
		
		boolean link = driver.findElement(By.linkText("Schoola Blog")).isDisplayed();
		driver.findElement(By.linkText("Schoola Blog")).click();
		
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles){
			if (handle != parentWindow){
				driver.switchTo().window(handle);
			}
		}
		Thread.sleep(2000);
		
		String title = driver.getTitle();
		System.out.println(title);
		String textonpage = driver.findElement(By.xpath(".//*[@id='masthead']/div/div/div/h1/a")).getText();
		driver.close();
		driver.switchTo().window(parentWindow);
		
		softAssert.assertEquals(link, true, "Link -Schoola Blog- is not displayed on homepage");
		softAssert.assertEquals(title, "The Schoola Blog | Let's turn adorable outgrown clothes into school programs!", "Incorrect page is displayed");
		softAssert.assertEquals(textonpage, "THE SCHOOLA BLOG", "Incorrect page text is displayed on page - Schoola Blog");
		
		softAssert.assertAll();
		Thread.sleep(2000);
	}
	
    @AfterTest
    public void closeWindow(){
    	browser.tearDown(driver);
    }
	
}
