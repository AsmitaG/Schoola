package schoola.selenium.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetUpURL {
	Properties prop = new Properties();
	String SetupURL;
	
	
	
	public SetUpURL() {	
		try
		{
			FileInputStream fileInput = new FileInputStream("SetUpURL.properties");
			prop.load(fileInput);
		}
		catch(IOException e){
			e.printStackTrace();
		} 	
	}
	
	public String getURL(){
		SetupURL = prop.getProperty("SetupURL");
		return SetupURL;
		
	}
}
