package schoola.selenium.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import schoola.selenium.Properties.CheckOutParameters;

public class CheckOutHelper {
	
CheckOutParameters checkout =  new CheckOutParameters();

public void checkout(WebDriver driver) throws InterruptedException{
	driver.findElement(By.name("shipping-first-name")).clear();
    driver.findElement(By.name("shipping-first-name")).sendKeys(checkout.getshippingfirstname());
    Thread.sleep(1000);
    driver.findElement(By.name("shipping-last-name")).clear();
    driver.findElement(By.name("shipping-last-name")).sendKeys(checkout.getshippinglastname());
    Thread.sleep(1000);
    driver.findElement(By.name("shipping-address")).clear();
    driver.findElement(By.name("shipping-address")).sendKeys(checkout.getshippingaddress());
    Thread.sleep(1000);
    driver.findElement(By.name("shipping-city")).clear();
    driver.findElement(By.name("shipping-city")).sendKeys(checkout.getshippingcity());
    Thread.sleep(1000);
    WebElement dropdown =  driver.findElement(By.className("form-control"));
    Select city = new Select(dropdown);
    city.selectByVisibleText(checkout.getcity());
    Thread.sleep(1000);
    driver.findElement(By.name("shipping-zipcode")).clear();
    driver.findElement(By.name("shipping-zipcode")).sendKeys(checkout.getshippingzipcode());
    Thread.sleep(3000);
    //(driver.findElement(By.linkText("Edit")).isDisplayed()) {
    	//Thread.sleep(1000);
    //}
    //else {
    driver.findElement(By.id("cc-num")).clear();
    driver.findElement(By.id("cc-num")).sendKeys(checkout.getccnum());
    Thread.sleep(1000);
    WebElement dropdowndate =  driver.findElement(By.id("exp-mm"));
    Select date = new Select(dropdowndate);
    date.selectByValue(checkout.getdate());
    Thread.sleep(1000);
    WebElement dropdownyear =  driver.findElement(By.id("exp-yy"));
    Select year = new Select(dropdownyear);
    year.selectByVisibleText(checkout.getyear());
    Thread.sleep(1000);
    driver.findElement(By.id("security-code")).clear();
    driver.findElement(By.id("security-code")).sendKeys(checkout.getsecuritycode());	        
    Thread.sleep(1000);
    //}
    if (driver.findElement(By.id("save_card")).isSelected()) {
    	driver.findElement(By.id("save_card")).click();
    }
    else {
    	Thread.sleep(1000);
    }
    Thread.sleep(1000);
    
    if (driver.findElement(By.id("same-address-shipping")).isSelected()){
    	Thread.sleep(1000);
    }
    else {
    	driver.findElement(By.id("same-address-shipping")).click();
    }
    
}

public void purchasebutton(WebDriver driver){
	driver.findElement(By.id("purchase-button")).click();
}

}



