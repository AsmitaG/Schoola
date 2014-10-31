package schoola.selenium.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VideoUrls {
	
	Properties prop = new Properties();
	private String videourl1;
	private String videourl2;
	private String videourl3;
	
	public VideoUrls() {	
		try
		{
			FileInputStream fileInput = new FileInputStream("VideoUrl.properties");
			prop.load(fileInput);
		}
		catch(IOException e){
			e.printStackTrace();
		} 	
	}
	
	public String SaveArtUrl() {
		videourl1 = prop.getProperty("videourl1");
		return videourl1;
	}
	
	public String SavePEUrl() {
		videourl3 = prop.getProperty("videourl2");
		return videourl3;
	}

	
	public String SaveMusicUrl() {
		videourl2 = prop.getProperty("videourl3");
		return videourl2;
	}

	
}
