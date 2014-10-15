package schoola.selenium.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class NavigationHelpers {
public void gotoGirlsMenu(WebDriver driver){
driver.findElement(By.cssSelector("#girl_sub .menu_overlay")).click();
}
public void gotoBoysMenu(WebDriver driver){
driver.findElement(By.cssSelector("#boy_sub .menu_overlay")).click();
}
public void gotoCollection(WebDriver driver,int number){
if(number==1){
driver.findElement(By.cssSelector("#featured_sub div ul li:nth-child(1) a img")).click();
}
if(number==2){
driver.findElement(By.cssSelector("#featured_sub div ul li:nth-child(2) a img")).click();
}
if(number==3){
driver.findElement(By.cssSelector("#featured_sub div ul li:nth-child(3) a img")).click();
}
if(number==4){
driver.findElement(By.cssSelector("#featured_sub div ul li:nth-child(4) a img")).click();
}
}
public void gotoSchool(WebDriver driver){
driver.findElement(By.linkText("Schools")).click();
}
}