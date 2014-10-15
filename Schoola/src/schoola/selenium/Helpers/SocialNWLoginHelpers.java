package schoola.selenium.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SocialNWLoginHelpers {
	
	public void gotoFacebookLogin(WebDriver driver){
		driver.findElement(By.cssSelector("div.share-and-activity div.s-sharing-box div.social-block div a.btn btn-facebook")).click();
	}		
	
}
