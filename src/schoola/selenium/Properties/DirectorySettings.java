package schoola.selenium.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DirectorySettings {

	Properties prop = new Properties();
	private String snapshotPath;
	
	public DirectorySettings() {	
		try
		{
			FileInputStream fileInput = new FileInputStream("Directory.properties");
			prop.load(fileInput);
		}
		catch(IOException e){
			e.printStackTrace();
		} 	
	}
	
	public String getPathForSnapshot(){
		snapshotPath = prop.getProperty("path");
		return snapshotPath;
	}
}
