package schoola.selenium.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.AssertionsCheckHelper;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.CheckOutHelper;
import schoola.selenium.Helpers.Itemcode;
import schoola.selenium.Helpers.LoginHelpers;
import schoola.selenium.Helpers.NavigationHelpers;
import schoola.selenium.Helpers.PurchaseHelpers;



public class PurchaseWithoutInitialLogin extends BaseSelenium  {
	NavigationHelpers navHelper=new NavigationHelpers();
	BrowserHelper browserhelper = new BrowserHelper();
	LoginHelpers loginhelpers = new LoginHelpers();
	PurchaseHelpers purchasehelpers = new PurchaseHelpers();
	AssertionsCheckHelper assertionshelper = new AssertionsCheckHelper();
	CheckOutHelper checkoutHelper = new CheckOutHelper();
	Itemcode ItemCode = new Itemcode();
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
  public void OpenSchoola() throws InterruptedException {
		browserhelper.setUp(driver);
		//purchasehelpers.popuphandle(driver);
  }
	@Test
	public void PuchaseWithoutLogin() throws InterruptedException {
	Thread.sleep(1000);
	navHelper.gotoGirlsMenu(driver);
	purchasehelpers.hoverItemClick(driver);
	
	String actualTitle = assertionshelper.girlsPageTitle(driver);
	String expectedTitle="GIRLS CLOTHES FOR 1-5 YEAR OLDS";
	System.out.println(expectedTitle);
	Thread.sleep(1000);
	softAssert.assertEquals(actualTitle, expectedTitle, "Welcome Title On Girls Page As Expected");
	
	purchasehelpers.clickItem(driver);
	
	String displayprice = assertionshelper.priceCheckOnDisplayPage(driver);
	System.out.println(displayprice);
	String actualitemTitle = assertionshelper.itemTitleonDiplaypage(driver);
	System.out.println(actualitemTitle);
	purchasehelpers.addToBag(driver);
	purchasehelpers.goToBag(driver);
	
	String ExpecteditemTitle = assertionshelper.itemTitleonCheckOutpage(driver);
	System.out.println(ExpecteditemTitle);
	softAssert.assertEquals(actualitemTitle, ExpecteditemTitle, "Item Title on display page and checkout page does not match");
	
	purchasehelpers.checkOutPage(driver);
	
	Thread.sleep(2000);
	loginhelpers.checkoutlogin(driver);
	
	String checkoutprice = assertionshelper.priceCheckOnCheckOutPage(driver);
	System.out.println(checkoutprice);
	
	softAssert.assertEquals(checkoutprice, displayprice, "Item Price on display page and checkout page does not match");
	
	checkoutHelper.checkout(driver);
	
	
	String successmsg = assertionshelper.OrderSuccessMsg(driver);
	System.out.println(successmsg);
	//String expectedSuccessMsg = "You'll soon receive a receipt for your purchase.";
	softAssert.assertTrue(successmsg.contains("You'll soon receive a receipt for your purchase."), "Order Placed Successfully");
	softAssert.assertAll();
	
	}
	@AfterTest
	  public void browserclose() {
    browserhelper.tearDown(driver);
	}
	
}
