package schoola.selenium.Helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import schoola.selenium.Properties.DirectorySettings;

public class TakeScreenshots {

	public void takeScreenshot(WebDriver driver,String filename) throws IOException{
		
		DirectorySettings dir = new DirectorySettings();
		String path=dir.getPathForSnapshot();
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		path = path + "\\"+ filename;
		System.out.println(path);
		FileUtils.copyFile(scrFile, new File(path));
	}
	
	
}
