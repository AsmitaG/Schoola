package savysource.selenium.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelpers {
public void register(WebDriver driver) throws InterruptedException{
	driver.findElement(By.cssSelector(".roadblock-close")).click();
	driver.findElement(By.cssSelector("#loginColorBox")).click();
	Thread.sleep(3000);
	driver.findElement(By.cssSelector("#signin-email")).sendKeys("test@mailinator.com");
	driver.findElement(By.cssSelector("#signin-password")).sendKeys("test123");
	driver.findElement(By.id("overlay-login-submit")).click();
}
}
