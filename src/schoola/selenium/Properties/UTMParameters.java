package schoola.selenium.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UTMParameters {

	/**
	 * @param args
	 */
		Properties prop = new Properties();
		private String utm_source_ref_fb;
		private String utm_medium_ref_fb;
		private String utm_campaign_ref_fb;
		private String utm_source_ref_tw;
		private String utm_medium_ref_tw;
		private String utm_campaign_ref_tw;
		
		public UTMParameters() {	
			try
			{
				FileInputStream fileInput = new FileInputStream("UTM_parameters.properties");
				prop.load(fileInput);
			}
			catch(IOException e){
				e.printStackTrace();
			} 	
		}
		
		public String get_utmSourceFB() {
			utm_source_ref_fb = prop.getProperty("utm_source_ref_fb");
			return utm_source_ref_fb;
		}
		
		public String get_utmMediumRefFB() {
			utm_medium_ref_fb = prop.getProperty("utm_medium_ref_fb");
			return utm_medium_ref_fb;
		}

		public String get_utmCampaignRefFB() {
			utm_campaign_ref_fb = prop.getProperty("utm_campaign_ref_fb");
			return utm_campaign_ref_fb;
		}
		
		public String get_utmSourceTW() {
			utm_source_ref_tw = prop.getProperty("utm_source_ref_tw");
			return utm_source_ref_tw;
		}
		
		public String get_utmMediumRefTW() {
			utm_medium_ref_tw = prop.getProperty("utm_medium_ref_tw");
			return utm_medium_ref_tw;
		}
		
		public String get_utmCampaignRefTW() {
			utm_campaign_ref_tw = prop.getProperty("utm_campaign_ref_tw");
			return utm_campaign_ref_tw;
		}
				
}
