package schoola.selenium.Helpers;

import org.openqa.selenium.WebDriver;

import schoola.selenium.Properties.Itemcode;

public class ItemClickHelper {

Itemcode ItemCode = new Itemcode();
String iurl = "http://stage.schoola.com/stitch/products/";
	
	public void clickItem1(WebDriver driver){
		//driver.findElement(By.cssSelector(".s-card:nth-child("+numberOfItem+") .quick-look .layer")).click();
			String itemcode1 = ItemCode.getitemcode1();
			String URL1 = iurl+itemcode1;
			driver.get(URL1);
		}
	
	public void clickItem2(WebDriver driver){
		//driver.findElement(By.cssSelector(".s-card:nth-child("+numberOfItem+") .quick-look .layer")).click();
			String itemcode2 = ItemCode.getitemcode2();
			String URL2 = iurl+itemcode2;
			driver.get(URL2);
		}
	
	public void clickItem3(WebDriver driver){
		//driver.findElement(By.cssSelector(".s-card:nth-child("+numberOfItem+") .quick-look .layer")).click();
			String itemcode3 = ItemCode.getitemcode3();
			String URL3 = iurl+itemcode3;
			driver.get(URL3);
		}
	
	public void clickItem4(WebDriver driver){
		//driver.findElement(By.cssSelector(".s-card:nth-child("+numberOfItem+") .quick-look .layer")).click();
			String itemcode4 = ItemCode.getitemcode4();
			String URL4 = iurl+itemcode4;
			driver.get(URL4);
		}
	
	public void clickItem5(WebDriver driver){
		//driver.findElement(By.cssSelector(".s-card:nth-child("+numberOfItem+") .quick-look .layer")).click();
			String itemcode5 = ItemCode.getitemcode5();
			String URL5 = iurl+itemcode5;
			driver.get(URL5);
		}
	
	public void clickItem6(WebDriver driver){
		//driver.findElement(By.cssSelector(".s-card:nth-child("+numberOfItem+") .quick-look .layer")).click();
			String itemcode6 = ItemCode.getitemcode6();
			String URL6 = iurl+itemcode6;
			driver.get(URL6);
		}
	
}
