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



public class PurchaseWithLoginDuringCheckout extends BaseSelenium  {
	NavigationHelpers navHelper=new NavigationHelpers();
	BrowserHelper browserhelper = new BrowserHelper();
	LoginHelpers loginhelpers = new LoginHelpers();
	PurchaseHelpers purchasehelpers = new PurchaseHelpers();
	AssertionsCheckHelper assertionshelper = new AssertionsCheckHelper();
	CheckOutHelper checkoutHelper = new CheckOutHelper();
	TakeScreenshots screenshot = new TakeScreenshots();
	ItemClickHelper itemclick = new ItemClickHelper();
	
	
	@BeforeTest
  public void OpenSchoola() throws InterruptedException {
		browserhelper.setUp(driver);
		//purchasehelpers.popuphandle(driver);
  }
	@Test
	public void PuchasewithLoginDuringCheckout() throws InterruptedException, IOException {
	SoftAssert softAssert = new SoftAssert();
	Thread.sleep(1000);
	navHelper.gotoGirlsMenu(driver);
	purchasehelpers.hoverItemClick(driver);
	Thread.sleep(3000);
	screenshot.takeScreenshot2(driver,"Girls clothes page.png");
	
	String actualTitle = assertionshelper.girlsPageTitle(driver);
	String expectedTitle="GIRLS CLOTHES FOR 1-5 YEAR OLDS";
	System.out.println("Title on Page:" + actualTitle);
	Thread.sleep(1000);
	softAssert.assertEquals(actualTitle, expectedTitle, "You are not on the page that displays Girls Clothes For 1-5 Years Old");
	
	itemclick.clickItem1(driver);
	screenshot.takeScreenshot2(driver,"Item clicked.png");
	
	String Displayprice = assertionshelper.priceCheckOnDisplayPage(driver);
	System.out.println("Price of item clicked on display page:" + Displayprice);
	String DisplayitemTitle = assertionshelper.itemTitleonDiplaypage(driver);
	System.out.println("Title of item clicked on display page:" + DisplayitemTitle);
	
	purchasehelpers.addToBag(driver);
	
	purchasehelpers.goToBag(driver);
	screenshot.takeScreenshot2(driver,"Bag.png");
	
	String url1=driver.getCurrentUrl();
	softAssert.assertTrue(url1.contains("https"), "This is not a secure connection");
	
	String BagitemTitle = assertionshelper.itemTitleinBag(driver);
	System.out.println("Title of the item clicked in bag:" + BagitemTitle);
	softAssert.assertEquals(DisplayitemTitle, BagitemTitle, "Item Title on display page and in bag does not match");
	
	purchasehelpers.checkOut(driver);
	
	String url2=driver.getCurrentUrl();
	softAssert.assertTrue(url2.contains("https"), "This is not a secure connection");
	
	Thread.sleep(2000);
	loginhelpers.login(driver);
	screenshot.takeScreenshot2(driver,"LoginDuringCheckout.png");
	loginhelpers.loginsubmit(driver);
	
	
	String CheckoutItemTitle =assertionshelper.itemTitleonCheckoutPage(driver);
	System.out.println("Item Title on Checkout page:" + CheckoutItemTitle);
	String checkoutprice = assertionshelper.priceCheckOnCheckOutPage(driver);
	System.out.println("Price of the item on checkout page:" + checkoutprice);
	
	softAssert.assertEquals(checkoutprice, Displayprice, "Item Price on display page and checkout page does not match");
	softAssert.assertEquals(BagitemTitle, CheckoutItemTitle, "Item Title in Bag and on Checkout Page does not match");
	
	
	checkoutHelper.checkout(driver);
	screenshot.takeScreenshot2(driver,"Checkout.png");
	checkoutHelper.purchasebutton(driver);	
	
	
	Thread.sleep(3000);
 
	String successmsg = assertionshelper.OrderSuccessMsg(driver);
	System.out.println("Order success message:" +successmsg);
	screenshot.takeScreenshot2(driver,"OrderSuccessMessage.png");
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
