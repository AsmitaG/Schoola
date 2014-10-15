package schoola.selenium.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PurchaseHelpers {
public void clickItem(WebDriver driver,int numberOfItem){
driver.findElement(By.cssSelector(".s-card:nth-child("+numberOfItem+") .quick-look .layer")).click();
}
public void addToBag(WebDriver driver){
driver.findElement(By.cssSelector("#add-to-bag")).click();
}
}
