package schoola.selenium.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class NavigationHelpers {

public void gotoGirlsMenu(WebDriver driver){
	WebElement hover=driver.findElement(By.linkText("GIRLS"));
	Actions Builder = new Actions(driver);
	Builder.moveToElement(hover).build().perform();
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
	WebElement hover1=driver.findElement(By.linkText("SCHOOLS"));
	Actions Builder = new Actions(driver);
	Builder.moveToElement(hover1).click().build().perform();
}

public void gotoReferralLink(WebDriver driver){
	driver.get("http://stage.schoola.com/stitch/referral");
}

public void gotoFeaturedSchool(WebDriver driver){
	driver.get("http://stage.schoola.com/schools/yick-wo-elementary-san-francisco-ca");
}


public void gotoStandardSchool(WebDriver driver){
	driver.get("http://stage.schoola.com/schools/devonshire-preschool-infant-care-chatsworth-ca");
}

public void gotohome(WebDriver driver){
	driver.get("http://stage.schoola.com");
}

public void hoverOnMenu(WebDriver driver,String menu){
	WebElement hover=driver.findElement(By.linkText(menu));
    Actions Builder = new Actions(driver);
    Builder.moveToElement(hover).build().perform();
}

public void goToGirlsPreSchoola(WebDriver driver){
	driver.findElement(By.cssSelector("ul.menu li#girl_sub.with-sub div.nav-sub div div.r a div.size-block div.t div h3")).click();
}

public void gotoDonate(WebDriver driver){
	driver.get("http://stage.schoola.com/stitch/requestbag/?q=v2");
}

public void gotoCustomShopPage(WebDriver driver){
	driver.get("http://stage.schoola.com/customshop/");
}

}