package schoola.selenium.Helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseHelpers  {
	
/*public void popuphandle(WebDriver driver)
{
driver.findElement(By.cssSelector(".roadblock-close")).click();
}
*/
	
public void hoverItemClick(WebDriver driver){
driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[1]/div/img")).click();	
}
	
public void addToBag(WebDriver driver){
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.findElement(By.id("add-to-bag")).click();
}

public void goToBag(WebDriver driver){
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
driver.findElement(By.xpath(".//*[@id='s-body']/div/div[2]/div[1]/div/div[3]/div[3]/a[5]")).click();	
}

public void keepshopping1(WebDriver driver){
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div#s-body div.clearfix div.c div.cart-block div.cart-detail div.btn-action a.btn")).click();
///html/body/div[3]/div[3]/div/div[2]/div[2]/div/div/div[2]/a
}

public void keepshopping2(WebDriver driver){
driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div.s-container div#s-body div.primary-block div.item-detail-wrapper div.m-block div.m-top div.cta-block div.b-block a.btn")).click();
}

public void checkOut(WebDriver driver){
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
driver.findElement(By.id("checkout-button")).click();
}

public void bagit(WebDriver driver){
driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div.s-container div#s-body div.primary-block div.item-detail-wrapper div.similar-block div#quick_look_data.quick-preview div.qp-info-block div.qp-info a.btn")).click();
}

public void quickview(WebDriver driver) throws InterruptedException {
//driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div.s-container div#s-body div.primary-block div.item-detail-wrapper div.similar-block div.list ul li div.xs-card div.quick-look div a.btn")).click();
	WebElement hover=driver.findElement(By.cssSelector("html body.stitch div.img-screen div#hp-content.s-container div.stuff-block div.card-block div.bx-wrapper div.bx-viewport div.bxslider div.s-card div.card-img-block div.quick-look a.layer"));
	//WebElement hover1=driver.findElement(By.cssSelector("html body.stitch div.img-screen div#hp-content.s-container div.stuff-block div.card-block div.bx-wrapper div.bx-viewport div.bxslider div.s-card div.card-img-block div.quick-look div a.btn"));
	Actions Builder = new Actions(driver);
	Builder.moveToElement(hover).perform();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement quick = driver.findElement(By.linkText("Quick Look"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)");
	
	//wait.until(ExpectedConditions.visibilityOf(quick));
	//Builder.moveToElement(hover1).build().perform();
	//Thread.sleep(1000);
	quick.click();
}

public void schoolclick(WebDriver driver){
driver.findElement(By.cssSelector("html body.stitch div.img-screen div.s-container div#s-body section#featured div.bx-wrapper div.bx-viewport ul.carousel li div.carousel-item div.img-block a img")).click();
}
}
