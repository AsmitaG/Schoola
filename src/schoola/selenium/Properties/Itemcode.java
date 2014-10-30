package schoola.selenium.Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Itemcode {

	Properties prop = new Properties();
	String itemcodevalue1;
	String itemcodevalue2;
	String itemcodevalue3;
	String itemcodevalue4;
	String itemcodevalue5;
	String itemcodevalue6;
	
	
	public Itemcode() {	
		try
		{
			FileInputStream fileInput = new FileInputStream("Itemcode.properties");
			prop.load(fileInput);
		}
		catch(IOException e){
			e.printStackTrace();
		} 	
	}
	
	public String getitemcode1(){
		itemcodevalue1 = prop.getProperty("itemcode1");
		return itemcodevalue1;
		
	}
	
	public String getitemcode2(){
		itemcodevalue2 = prop.getProperty("itemcode2");
		return itemcodevalue2;
		
	}
	
	public String getitemcode3(){
		itemcodevalue3 = prop.getProperty("itemcode3");
		return itemcodevalue3;
		
	}
	
	public String getitemcode4(){
		itemcodevalue4 = prop.getProperty("itemcode4");
		return itemcodevalue4;
		
	}
	
	public String getitemcode5(){
		itemcodevalue5 = prop.getProperty("itemcode5");
		return itemcodevalue5;
		
	}
	
	public String getitemcode6(){
		itemcodevalue6 = prop.getProperty("itemcode6");
		return itemcodevalue6;
		
	}
	
	
	
	
}
