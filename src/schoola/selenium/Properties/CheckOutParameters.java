package schoola.selenium.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CheckOutParameters {

	Properties prop = new Properties();
	String shippingfirstname;
	String shippinglastname;
	String shippingaddress;
	String shippingcity;	
	String city;
	String shippingzipcode;
	String ccnum;
	String date;
	String year;
	String securitycode;
	
	
	public CheckOutParameters() {	
		try
		{
			FileInputStream fileInput = new FileInputStream("CheckOut.properties");
			prop.load(fileInput);
		}
		catch(IOException e){
			e.printStackTrace();
		} 	
	}
	
	public String getshippingfirstname(){
		shippingfirstname = prop.getProperty("shipping-first-name");
		return shippingfirstname;
	}
		
		public String getshippinglastname(){
		shippinglastname = prop.getProperty("shipping-last-name");
		return shippinglastname;
		
	}
		
	public String getshippingaddress(){
		shippingaddress = prop.getProperty("shipping-address");
		return shippingaddress;
		}
	
	public String getshippingcity(){
		shippingcity= prop.getProperty("shipping-city");
		return shippingcity;
		
	}
	
	
	public String getcity(){
		city = prop.getProperty("city");
		return city;
		
	}
	
	public String getshippingzipcode(){
		shippingzipcode = prop.getProperty("shipping-zipcode");
		return shippingzipcode;
		
	}
	
	public String getccnum(){
		ccnum = prop.getProperty("cc-num");
		return ccnum;
		
	}
	
	public String getdate(){
		date = prop.getProperty("date");
		return date;
		
	}
	
	public String getyear(){
		year = prop.getProperty("year");
		return year;
		
	}
	
	public String getsecuritycode(){
		securitycode = prop.getProperty("security-code");
		return securitycode;
		
	}
	
}

	
	
	
	

