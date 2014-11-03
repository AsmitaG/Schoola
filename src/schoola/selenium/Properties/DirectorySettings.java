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
	
	public String getPath1ForSnapshot(){
		snapshotPath = prop.getProperty("path1");
		return snapshotPath;
	}
	
	public String getPath2ForSnapshot(){
		snapshotPath = prop.getProperty("path2");
		return snapshotPath;
	}
	
	public String getPath3ForSnapshot(){
		snapshotPath = prop.getProperty("path3");
		return snapshotPath;
	}
	
	public String getPath4ForSnapshot(){
		snapshotPath = prop.getProperty("path4");
		return snapshotPath;
	}
	
	public String getPath5ForSnapshot(){
		snapshotPath = prop.getProperty("path5");
		return snapshotPath;
	}
	
	


}
