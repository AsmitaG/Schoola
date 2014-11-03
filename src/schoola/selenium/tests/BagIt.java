package schoola.selenium.tests;

 
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.AssertionsCheckHelper;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.ItemClickHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.PurchaseHelpers;
import schoola.selenium.Helpers.TakeScreenshots;

public class BagIt extends BaseSelenium {
	NavigationHelpers navHelper=new NavigationHelpers();
	BrowserHelper browserhelper = new BrowserHelper();
	LoginHelpers loginhelpers = new LoginHelpers();
	PurchaseHelpers purchasehelpers = new PurchaseHelpers();
	AssertionsCheckHelper assertionshelper = new AssertionsCheckHelper();
	TakeScreenshots screenshot = new TakeScreenshots();
	ItemClickHelper itemclick = new ItemClickHelper();
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	  public void OpenSchoola() throws InterruptedException, IOException {
			browserhelper.setUp(driver);
			loginhelpers.SignInClick(driver);
			Thread.sleep(2000);
			loginhelpers.login(driver);
			Thread.sleep(2000);
			screenshot.takeScreenshot5(driver,"Login.png");
			loginhelpers.loginsubmit(driver);
	}
	
	@Test(priority=1)
	   public void BagItfromHomePage()throws InterruptedException, IOException {
		  Thread.sleep(1000);
		  //driver.manage().window().setPosition(new Point(0, 0));
		  //driver.manage().window().setSize(new Dimension(1100, 800));
		  Thread.sleep(1000);
		  WebDriverWait wait = new WebDriverWait(driver, 40);
		  
			purchasehelpers.quickview(driver);
			screenshot.takeScreenshot5(driver,"QuickLookHomePage.png");
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String itemTitle = assertionshelper.BagItitemTitle(driver);
			purchasehelpers.bagit(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);			
			screenshot.takeScreenshot5(driver,"BagItHomePage.png");
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			purchasehelpers.shoppingbag(driver);
			screenshot.takeScreenshot5(driver,"ShoppingBagHomepage.png");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String itemTitle1 = assertionshelper.itemTitleinBag(driver);
			softAssert.assertEquals(itemTitle, itemTitle1, "For BagIt from Home page ,Item Title on display page & in Shopping Bag does not match");
			}
	
	
	@Test (priority=2)
	  public void BagItfromListingPage()throws InterruptedException, IOException {
		 	browserhelper.setUp(driver);
		 	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			navHelper.gotoGirlsMenu(driver);
			purchasehelpers.hoverItemClick(driver);
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.className("category-drawer-trigger")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			purchasehelpers.quickview(driver);
			screenshot.takeScreenshot5(driver,"QuickLookListPage.png");
			
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String itemTitle = assertionshelper.BagItitemTitle(driver);
			
			purchasehelpers.bagit(driver);
			screenshot.takeScreenshot5(driver,"BagItListPage.png");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			purchasehelpers.shoppingbag(driver);
			screenshot.takeScreenshot5(driver,"ShoppingBagListPage.png");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String itemTitle1 = assertionshelper.itemTitleinBag(driver);
			softAssert.assertEquals(itemTitle, itemTitle1, "For BagIt from Listing page , Item Title on display page & in Shopping Bag does not match");
			
			
			}
	
	@Test(priority=3)
	public void BagItfromSchoolPage()throws InterruptedException, IOException {
		     browserhelper.setUp(driver);
		     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			navHelper.gotoSchool(driver);
			/* driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			purchasehelpers.schoolclick(driver);*/
		     navHelper.gotoFeaturedSchool(driver);
		     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			screenshot.takeScreenshot5(driver,"School.png");
			purchasehelpers.quickview(driver);
			screenshot.takeScreenshot5(driver,"QuickLookSchoolPage.png");
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String itemTitle = assertionshelper.BagItitemTitle(driver);
			
			purchasehelpers.bagit(driver);
			screenshot.takeScreenshot5(driver,"BagItSchoolPage.png");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			purchasehelpers.shoppingbag(driver);
			screenshot.takeScreenshot5(driver,"ShoppingBagSchoolPage.png");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String itemTitle1 = assertionshelper.itemTitleinBag(driver);
			softAssert.assertEquals(itemTitle, itemTitle1, "For BagIt from School page , Item Title on display page & in Shopping Bag does not match");
			
	}
	
	
	@Test(priority=4)
	   public void BagItfromSimilarItems()throws InterruptedException, IOException {
			browserhelper.setUp(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			navHelper.gotoGirlsMenu(driver);
			purchasehelpers.hoverItemClick(driver);
			Thread.sleep(1000);
			itemclick.clickItem6(driver);
			purchasehelpers.quickview(driver);
			screenshot.takeScreenshot5(driver,"QuickLookSimilarItems.png");
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String itemTitle = assertionshelper.BagItitemTitle(driver);
			
			purchasehelpers.bagit(driver);
			screenshot.takeScreenshot5(driver,"BagItSimilarItems.png");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			purchasehelpers.shoppingbag(driver);
			screenshot.takeScreenshot5(driver,"ShoppingBagSimilarItems.png");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String itemTitle1 = assertionshelper.itemTitleinBag(driver);
			softAssert.assertEquals(itemTitle, itemTitle1, "For BagIt from Similar items page , Item Title on display page & in Shopping Bag does not match");
			
		}
	@AfterTest
	  public void browserclose() {
  browserhelper.tearDown(driver);
	}
}
