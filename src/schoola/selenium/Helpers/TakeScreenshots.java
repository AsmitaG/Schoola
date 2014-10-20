package schoola.selenium.Helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshots {

	public void takeScreenshot(WebDriver driver,String filename) throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\aditya_ballikar\\Downloads\\" + filename;
		FileUtils.copyFile(scrFile, new File(path));
	}
	
	
}
