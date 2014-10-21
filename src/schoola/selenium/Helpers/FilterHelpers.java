package schoola.selenium.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterHelpers {
	
	public void category1(WebDriver driver){
		driver.findElement(By.cssSelector("div.search-sb div.filter-block ul.filter-sub-block li a.expander span.plus")).click();
	}
	
	public String category1_option1(WebDriver driver){
		String category = driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[1]/ul/li[1]/ul/li[1]")).getText();
		driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[1]/ul/li[1]/ul/li[1]")).click();
		
		return category;
	}
	
	public String category1_option2(WebDriver driver){
		String category = driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[1]/ul/li[1]/ul/li[2]")).getText();
		
		driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[1]/ul/li[1]/ul/li[2]")).click();
		
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
	
	public String brand_option2(WebDriver driver){
		String brand1 = driver.findElement(By.xpath("//*[@id='brand-list']/li[2]")).getText();
		driver.findElement(By.xpath("//*[@id='brand-list']/li[2]")).click();
		return brand1;
	}
	
	public String price_option1(WebDriver driver){
		String price1 = driver.findElement(By.xpath("//*[@id='price-field']/ul/li[1]")).getText();
		driver.findElement(By.xpath("//*[@id='price-field']/ul/li[1]")).click();
		return price1;
	}
	
	public String price_option2(WebDriver driver){
		String price1 = driver.findElement(By.xpath("//*[@id='price-field']/ul/li[2]")).getText();
		driver.findElement(By.xpath("//*[@id='price-field']/ul/li[2]")).click();
		return price1;
	}
	
	public String color_option1(WebDriver driver){
		String color1 = driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[4]/div/ul[1]/li[1]/span")).getAttribute("title");
		driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[4]/div/ul[1]/li[1]")).click();
		return color1;
	}
	
	public String color_option2(WebDriver driver){
		String color1= driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[4]/div/ul[1]/li[2]/span")).getAttribute("title");
		driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[4]/div/ul[1]/li[2]")).click();
		return color1;
	}
	
	public String condition_option1(WebDriver driver){
		String condition1 = driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[5]/ul[1]/li[1]")).getText();
		driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[5]/ul[1]/li[1]")).click();
		return condition1;
	}
	
	public String condition_option2(WebDriver driver){
		String condition1 = driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[5]/ul[1]/li[2]")).getText();
		driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[5]/ul[1]/li[2]")).click();
		return condition1;
	}
	
	public String look_option1(WebDriver driver){
		String look1 = driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[6]/ul[1]/li[1]")).getText();
		driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[6]/ul[1]/li[1]")).click();
		return look1;
	}
	
	public String look_option2(WebDriver driver){
		String look1 = driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[6]/ul[1]/li[2]")).getText();
		driver.findElement(By.xpath("//div[@id='s-body']/div[2]/div[2]/div[2]/div[6]/ul[1]/li[2]")).click();
		return look1;
	}
	
	public String filterPageHeading(WebDriver driver){
		String heading = driver.findElement(By.xpath(".//*[@id='s-body']/div[1]/h1")).getText();
		return heading;
	}
	
	public String currentSelections(WebDriver driver){
		String currentSelection = driver.findElement(By.xpath(".//*[@id='selection-peels']/li")).getText();
		return currentSelection;
	}
	
}
