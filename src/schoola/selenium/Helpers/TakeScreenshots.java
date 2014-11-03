package schoola.selenium.Helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import schoola.selenium.Properties.DirectorySettings;

public class TakeScreenshots {
	DirectorySettings dir = new DirectorySettings();
	
public void takeScreenshot(WebDriver driver,String filename) throws IOException{
		
		
		String path=dir.getPathForSnapshot();
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		path = path + "\\"+ filename;
		System.out.println(path);
		FileUtils.copyFile(scrFile, new File(path));
	}

public void takeScreenshot1(WebDriver driver,String filename) throws IOException{
		
		
		String path1=dir.getPath1ForSnapshot();
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		path1 = path1 + "\\"+ filename;
		System.out.println(path1);
		FileUtils.copyFile(scrFile, new File(path1));
	}
	
public void takeScreenshot2(WebDriver driver,String filename) throws IOException{
		
		
		String path2=dir.getPath2ForSnapshot();
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		path2 = path2 + "\\"+ filename;
		System.out.println(path2);
		FileUtils.copyFile(scrFile, new File(path2));
	}

public void takeScreenshot3(WebDriver driver,String filename) throws IOException{
	
	
	String path3=dir.getPath3ForSnapshot();
	
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	path3 = path3 + "\\"+ filename;
	System.out.println(path3);
	FileUtils.copyFile(scrFile, new File(path3));
}

public void takeScreenshot4(WebDriver driver,String filename) throws IOException{
	
	String path4 = dir.getPath4ForSnapshot();
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	path4 = path4 + "\\"+ filename;
	System.out.println(path4);
	FileUtils.copyFile(scrFile, new File(path4));
}

public void takeScreenshot5(WebDriver driver,String filename) throws IOException{
	
	String path5 = dir.getPath5ForSnapshot();
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	path5 = path5 + "\\"+ filename;
	System.out.println(path5);
	FileUtils.copyFile(scrFile, new File(path5));
}
	
}
