package schoola.selenium.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserEmail {

	/**
	 * @param args
	 */
		Properties prop = new Properties();
		private String schoolaemail;
		private String schoolapwd;
		private String schemaildomain;
		private String fbemail;
		private String fbpwd;
		private String twemail;
		private String twpwd;
		private String storedEmail;
		
		public UserEmail() {	
			try
			{
				FileInputStream fileInput = new FileInputStream("UserEmails.properties");
				prop.load(fileInput);
			}
			catch(IOException e){
				e.printStackTrace();
			} 	
		}
				
		public String get_schoolaemail() {
			schoolaemail = prop.getProperty("schoolaemail");
			return schoolaemail;
		}
		
		public String get_storedEmail() {
			storedEmail = prop.getProperty("storedEmail");
			return storedEmail;
		}

		public String get_schoolapwd() {
			schoolapwd = prop.getProperty("schoolapwd");
			return schoolapwd;
		}
		
		public String get_schemaildomain() {
			schemaildomain = prop.getProperty("schemaildomain");
			return schemaildomain;
		}
		
		public String get_fbemail() {
			fbemail = prop.getProperty("fbemail");
			return fbemail;
		}
		
		public String get_fbpwd() {
			fbpwd = prop.getProperty("fbpwd");
			return fbpwd;
		}
		
		public String get_twemail() {
			twemail = prop.getProperty("twemail");
			return twemail;
		}
		
		public String get_twpwd() {
			twpwd = prop.getProperty("twpwd");
			return twpwd;
		}



}
