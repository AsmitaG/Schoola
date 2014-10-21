package schoola.selenium.Helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseHelpers  {
	
/*public void popuphandle(WebDriver driver)
{
driver.findElement(By.cssSelector(".roadblock-close")).click();
}
*/
	Itemcode ItemCode = new Itemcode();
public void hoverItemClick(WebDriver driver){
driver.findElement(By.xpath(".//*[@id='girl_sub']/div/div[1]/div/a[1]/div/img")).click();	
}
	
public void clickItem(WebDriver driver){
//driver.findElement(By.cssSelector(".s-card:nth-child("+numberOfItem+") .quick-look .layer")).click();
	String itemcode = ItemCode.getitemcode();
	String iurl = "http://stage.schoola.com/stitch/products/";
	String URL = iurl+itemcode;
	driver.get(URL);
}

public void addToBag(WebDriver driver){
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.findElement(By.id("add-to-bag")).click();
}

public void goToBag(WebDriver driver){
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
driver.findElement(By.xpath(".//*[@id='s-body']/div/div[2]/div[1]/div/div[3]/div[3]/a[5]")).click();	
}

public void checkOutPage(WebDriver driver){
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
driver.findElement(By.id("checkout-button")).click();
}

}
