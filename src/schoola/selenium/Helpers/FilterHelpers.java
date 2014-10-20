package schoola.selenium.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterHelpers {
	
	public void category1(WebDriver driver){
		driver.findElement(By.cssSelector("div.search-sb div.filter-block ul.filter-sub-block li a.expander span.plus")).click();
	}
	
	public String category1_option1(WebDriver driver){
		String category = driver.findElement(By.xpath("//*[@id='s-body']/div[2]/div[2]/div[3]/div[1]/ul/li[1]/ul/li[1]")).getText();
		driver.findElement(By.xpath("//*[@id='s-body']/div[2]/div[2]/div[3]/div[1]/ul/li[1]/ul/li[1]")).click();
		return category;
	}
	
	public String category1_option2(WebDriver driver){
		String category = driver.findElement(By.xpath("//*[@id='s-body']/div[2]/div[2]/div[3]/div[1]/ul/li[1]/ul/li[2]")).getText();
		driver.findElement(By.xpath("//*[@id='s-body']/div[2]/div[2]/div[3]/div[1]/ul/li[1]/ul/li[2]")).click();
		return category;
	}
	
	public void clearAllSelections(WebDriver driver){
		driver.findElement(By.linkText("Clear all selections")).click();
	}
	
	public String brand_option1(WebDriver driver){
		String brand1 = driver.findElement(By.xpath("//*[@id='brand-list']/li[1]")).getText();
		driver.findElement(By.xpath("//*[@id='brand-list']/li[1]")).click();
		return brand1;
	}
	
	public String filterPageHeading(WebDriver driver){
		String heading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		return heading;
	}
	
	
	
}
