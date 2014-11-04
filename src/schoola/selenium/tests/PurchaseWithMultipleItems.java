package schoola.selenium.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.AssertionsCheckHelper;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.CheckOutHelper;
import schoola.selenium.Helpers.ItemClickHelper;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.PurchaseHelpers;
import schoola.selenium.Helpers.TakeScreenshots;

public class PurchaseWithMultipleItems extends BaseSelenium{
	NavigationHelpers navHelper=new NavigationHelpers();
	BrowserHelper browserhelper = new BrowserHelper();
	LoginHelpers loginhelpers = new LoginHelpers();
	PurchaseHelpers purchasehelpers = new PurchaseHelpers();
	AssertionsCheckHelper assertionshelper = new AssertionsCheckHelper();
	CheckOutHelper checkoutHelper = new CheckOutHelper();
	TakeScreenshots screenshot = new TakeScreenshots();
	ItemClickHelper itemclick = new ItemClickHelper();
	
	
	@BeforeTest
  public void OpenSchoola() throws InterruptedException, IOException {
		browserhelper.setUp(driver);
		loginhelpers.SignInClick(driver);
		Thread.sleep(2000);
		loginhelpers.login(driver);
		screenshot.takeScreenshot3(driver,"Login.png");
		Thread.sleep(2000);
		loginhelpers.loginsubmit(driver);
  }
	@Test
public void PuchasewithMultipleitems() throws InterruptedException, IOException {
	SoftAssert softAssert = new SoftAssert();
	Thread.sleep(1000);
	navHelper.gotoGirlsMenu(driver);
	purchasehelpers.hoverItemClick(driver);
	Thread.sleep(3000);
	screenshot.takeScreenshot3(driver,"Girls clothes page.png");
	
	String actualTitle = assertionshelper.girlsPageTitle(driver);
	String expectedTitle="GIRLS CLOTHES FOR 1-5 YEAR OLDS";
	System.out.println("Title on Page:" + actualTitle);
	Thread.sleep(1000);
	softAssert.assertEquals(actualTitle, expectedTitle, "You are not on the page that displays Girls Clothes For 1-5 Years Old");
	
	itemclick.clickItem4(driver);
	screenshot.takeScreenshot3(driver,"Item1 clicked.png");
	
	String Displayitem1price = assertionshelper.priceCheckOnDisplayPage(driver);
	System.out.println("---------Item 1----------");
	System.out.println("Price of item1 clicked on display page:" + Displayitem1price);
	String Displayitem1Title = assertionshelper.itemTitleonDiplaypage(driver);
	System.out.println("Title of item1 clicked on display page:" + Displayitem1Title);
	
	purchasehelpers.addToBag(driver);
	purchasehelpers.goToBag(driver);
	screenshot.takeScreenshot3(driver,"Bag with 1 item.png");
	
	String url1=driver.getCurrentUrl();
	softAssert.assertTrue(url1.contains("https"), "This is not a secure connection");
	
	String Bagitem1Title = assertionshelper.itemTitleinBag(driver);
	System.out.println("Title of the item1 in bag:" + Bagitem1Title);
	softAssert.assertEquals(Displayitem1Title, Bagitem1Title, "Title of Item1 on display page and in bag does not match");
	
	purchasehelpers.keepshopping1(driver);
	Thread.sleep(1000);
	String page2url = driver.getCurrentUrl();
	System.out.println("You are on second page with url:" + page2url);
	String page2= "page-2";
	softAssert.assertTrue(page2url.contains(page2),"You are not on the second page that displays Girls Clothes");
	
	itemclick.clickItem5(driver);
	screenshot.takeScreenshot3(driver,"Item2 clicked.png");
	
	String Displayitem2price = assertionshelper.priceCheckOnDisplayPage(driver);
	System.out.println("---------Item 2----------");
	System.out.println("Price of item2 clicked on display page:" + Displayitem2price);
	String Displayitem2Title= assertionshelper.itemTitleonDiplaypage(driver);
	System.out.println("Title of item2 clicked on display page:" + Displayitem2Title);
	
    purchasehelpers.addToBag(driver);
	purchasehelpers.goToBag(driver);
	screenshot.takeScreenshot3(driver,"Bag with multiple items.png");
	
	String url2=driver.getCurrentUrl();
	softAssert.assertTrue(url2.contains("https"), "This is not a secure connection");
	
	String Bagitem2Title = assertionshelper.itemTitleinBag(driver);
	System.out.println("Title of the item2 in bag:" + Bagitem2Title);
	softAssert.assertEquals(Displayitem2Title, Bagitem2Title, "Item Title on display page and in bag does not match");
	
    purchasehelpers.checkOut(driver);
    
    String url3=driver.getCurrentUrl();
	softAssert.assertTrue(url3.contains("https"), "This is not a secure connection");
    Thread.sleep(2000);
	
	
	checkoutHelper.checkout(driver);
	screenshot.takeScreenshot3(driver,"Checkout.png");
	Thread.sleep(1000);
	checkoutHelper.purchasebutton(driver);
	
	Thread.sleep(3000);
 
	String successmsg = assertionshelper.OrderSuccessMsg(driver);
	System.out.println("Order success message:" +successmsg);
	screenshot.takeScreenshot3(driver,"OrderSuccessMessage.png");
	softAssert.assertTrue(successmsg.contains("You'll soon receive a receipt for your purchase."), "Order Not Placed Successfully");
	String messagesplit[] = successmsg.split(" ");
	System.out.println("Your Order id is:" + messagesplit[4]);
	String pattern = "(^#)([a-zA-Z0-9]{8})(.*)";
	softAssert.assertTrue(messagesplit[4].matches(pattern),"Order number does not match the expected format");
	softAssert.assertAll();
	}
	
	@AfterTest
	  public void browserclose() {
    browserhelper.tearDown(driver);
	}
	
}

