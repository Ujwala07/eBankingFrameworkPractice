package ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() 
	{
		File src=new File("./Configuration/config.properties");
		
		try
		{
		FileInputStream fis=new FileInputStream(src);
		prop=new Properties();
		prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured during fetching global properties "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String baseURL=prop.getProperty("baseURL");
		return baseURL;
	}
	
	public String getUserName()
	{
		String userName=prop.getProperty("userName");
		return userName;
	}
	
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}

}
