package schoola.selenium.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideoPageHelpers {
	
	
	public void PlayVideobutton(WebDriver driver){
		driver.findElement(By.cssSelector("div.yt-video-block div.s-container a.play-video")).click();		
		
	}
	
	public WebElement PlayVideoOnOff(WebDriver driver) throws InterruptedException{
		
		WebElement Playbutton =	driver.findElement(By.cssSelector("div.html5-video-controls div.html5-player-chrome div.ytp-button"));
		
		return Playbutton;
	}

}
