package schoola.selenium.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import schoola.selenium.Base.BaseSelenium;
import schoola.selenium.Helpers.BrowserHelper;
import schoola.selenium.Helpers.TakeScreenshots;
import schoola.selenium.Helpers.VideoPageHelpers;
import schoola.selenium.Properties.VideoUrls;

public class PlayVideo extends BaseSelenium {
	
	VideoUrls video1 = new VideoUrls();
	VideoPageHelpers video2 = new VideoPageHelpers();
	BrowserHelper browserHelper=new BrowserHelper();
	TakeScreenshots takeScreenshot = new TakeScreenshots();
	
@Test(priority=1)
public void TestVideoSaveArt() throws InterruptedException, IOException{
	SoftAssert softAssert = new SoftAssert();
	driver.get(video1.SaveArtUrl());
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	takeScreenshot.takeScreenshot(driver, "PlayVideo1.png");
	video2.PlayVideobutton(driver);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
    Thread.sleep(2000);
    takeScreenshot.takeScreenshot(driver, "PlayVideo2.png");
	driver.switchTo().frame("yt-player");
	WebElement Playbutton = video2.PlayVideoOnOff(driver);
	String playValue = Playbutton.getAttribute("aria-label");
	System.out.println("Play button value :"+playValue);
	if(playValue.equals("Play")) {
		Playbutton.click();
		playValue = Playbutton.getAttribute("aria-label");
	}
	System.out.println("Play button value :"+playValue);
	Thread.sleep(5000);
	softAssert.assertEquals(playValue,"Pause" , "SaveArt Page Video is not getting played");
	softAssert.assertAll();
	
}

@Test(priority=2)
public void TestVideoSavePE() throws InterruptedException, IOException{
	SoftAssert softAssert = new SoftAssert();
	driver.get(video1.SavePEUrl());
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    takeScreenshot.takeScreenshot(driver, "PlayVideo3.png");
	video2.PlayVideobutton(driver);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
    Thread.sleep(2000);
    takeScreenshot.takeScreenshot(driver, "PlayVideo4.png");
	driver.switchTo().frame("yt-player");
	WebElement Playbutton = video2.PlayVideoOnOff(driver);
	String playValue = Playbutton.getAttribute("aria-label");
	System.out.println("Play button value :"+playValue);
	if(playValue.equals("Play")) {
		Playbutton.click();
		playValue = Playbutton.getAttribute("aria-label");
	}
	System.out.println("Play button value :"+playValue);
	Thread.sleep(5000);
	softAssert.assertEquals(playValue,"Pause" , "SaveArt Page Video is not getting played");
	softAssert.assertAll();
}

@Test(priority=3)
public void TestVideoSaveMusic() throws InterruptedException, IOException{
	SoftAssert softAssert = new SoftAssert();
	driver.get(video1.SaveMusicUrl());
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    takeScreenshot.takeScreenshot(driver, "PlayVideo5.png");
	video2.PlayVideobutton(driver);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
    Thread.sleep(2000);
    takeScreenshot.takeScreenshot(driver, "PlayVideo6.png");
	driver.switchTo().frame("yt-player");
	WebElement Playbutton = video2.PlayVideoOnOff(driver);
	String playValue = Playbutton.getAttribute("aria-label");
	System.out.println("Play button value :"+playValue);
	if(playValue.equals("Play")) {
		Playbutton.click();
		playValue = Playbutton.getAttribute("aria-label");
	}
	System.out.println("Play button value :"+playValue);
	Thread.sleep(5000);
	softAssert.assertEquals(playValue,"Pause" , "SaveArt Page Video is not getting played");
	softAssert.assertAll();
	softAssert.assertAll();
}

@AfterTest
public void tearDown(){
	browserHelper.tearDown(driver);
}
}

