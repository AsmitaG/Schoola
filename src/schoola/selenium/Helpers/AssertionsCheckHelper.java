package schoola.selenium.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssertionsCheckHelper {
	
public String girlsPageTitle(WebDriver driver){
	String actualTitle = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
	return actualTitle;
}

public String itemTitleonDiplaypage(WebDriver driver){
	String actualitemTitle = driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div.s-container div#s-body div.primary-block div.item-detail-wrapper div.m-block div.m-top div.m-top-1 h1")).getText();
	return actualitemTitle;
}

public String itemTitleonCheckOutpage(WebDriver driver){
	String ExpecteditemTitle = driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div#s-body div.clearfix div.c div.cart-block ul.list-cart li div.list-cart-item div h3")).getText();	
    return ExpecteditemTitle;
}



public String priceCheckOnDisplayPage(WebDriver driver){
String totalvalue =  driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div.s-container div#s-body div.primary-block div.item-detail-wrapper div.m-block div.m-top div.cta-block div.p-block.final p.p")).getText();
return totalvalue;
}

public String priceCheckOnCheckOutPage(WebDriver driver){
String totalprice = driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div#s-body div.clearfix div.c div.cart-block div.cart-detail div.clearfix div.cart-total-price div#subtotal span")).getText();
return totalprice;
}


public String OrderSuccessMsg(WebDriver driver){
String successmsg=driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div#s-body div.intro p")).getText();	
return successmsg;
}

}
