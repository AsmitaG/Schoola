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
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class PurchaseWithInitialLogin extends BaseSelenium{
	NavigationHelpers navHelper=new NavigationHelpers();
	BrowserHelper browserhelper = new BrowserHelper();
	LoginHelpers loginhelpers = new LoginHelpers();
	PurchaseHelpers purchasehelpers = new PurchaseHelpers();
	AssertionsCheckHelper assertionshelper = new AssertionsCheckHelper();
	CheckOutHelper checkoutHelper = new CheckOutHelper();
	TakeScreenshots screenshot = new TakeScreenshots();
	ItemClickHelper itemclick = new ItemClickHelper();
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
  public void OpenSchoola() throws InterruptedException, IOException {
		browserhelper.setUp(driver);
		loginhelpers.SignInClick(driver);
		Thread.sleep(2000);
		loginhelpers.login(driver);
		screenshot.takeScreenshot1(driver,"Login.png");
		Thread.sleep(2000);
		loginhelpers.loginsubmit(driver);
  }
	@Test
public void PuchasewithInitialLogin() throws InterruptedException, IOException {
	Thread.sleep(1000);
	navHelper.gotoGirlsMenu(driver);
	purchasehelpers.hoverItemClick(driver);
	Thread.sleep(3000);
	screenshot.takeScreenshot1(driver,"Girls clothes page.png");
	
	String actualTitle = assertionshelper.girlsPageTitle(driver);
	String expectedTitle="GIRLS CLOTHES FOR 1-5 YEAR OLDS";
	System.out.println("Title on Page:" + actualTitle);
	Thread.sleep(1000);
	softAssert.assertEquals(actualTitle, expectedTitle, "You are not on the page that displays Girls Clothes For 1-5 Years Old");
	
	itemclick.clickItem3(driver);
	screenshot.takeScreenshot1(driver,"Item clicked.png");
	
	String Displayprice = assertionshelper.priceCheckOnDisplayPage(driver);
	System.out.println("Price of item clicked on display page:" + Displayprice);
	String DisplayitemTitle = assertionshelper.itemTitleonDiplaypage(driver);
	System.out.println("Title of item clicked on display page:" + DisplayitemTitle);
	
	Thread.sleep(1000);
	purchasehelpers.addToBag(driver);
	
	purchasehelpers.goToBag(driver);
	screenshot.takeScreenshot1(driver,"Bag.png");
	
	String url1=driver.getCurrentUrl();
	softAssert.assertTrue(url1.contains("https"), "This is not a secure connection");
	
	String BagitemTitle = assertionshelper.itemTitleinBag(driver);
	System.out.println("Title of the item in bag:" + BagitemTitle);
	softAssert.assertEquals(DisplayitemTitle, BagitemTitle, "Item Title on display page and in bag does not match");
	
	purchasehelpers.checkOut(driver);
	
	String url2=driver.getCurrentUrl();
	softAssert.assertTrue(url2.contains("https"), "This is not a secure connection");
	
	Thread.sleep(2000);
	
	String CheckoutItemTitle =assertionshelper.itemTitleonCheckoutPage(driver);
	System.out.println("Item Title on Checkout page:" + CheckoutItemTitle);
	String checkoutprice = assertionshelper.priceCheckOnCheckOutPage(driver);
	System.out.println("Price of the item on checkout page:" + checkoutprice);
	
	softAssert.assertEquals(checkoutprice, Displayprice, "Item Price on display page and checkout page does not match");
	softAssert.assertEquals(BagitemTitle, CheckoutItemTitle, "Item Title in Bag and on Checkout Page does not match");
	
	
	checkoutHelper.checkout(driver);
	screenshot.takeScreenshot1(driver,"Checkout.png");
	Thread.sleep(1000);
	checkoutHelper.purchasebutton(driver);
	
	Thread.sleep(3000);
 
	String successmsg = assertionshelper.OrderSuccessMsg(driver);
	System.out.println("Order success message:" +successmsg);
	screenshot.takeScreenshot1(driver,"OrderSuccessMessage.png");
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
