package com.nopcommerce.utilitizes;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src=new File ("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUserEmail()
	{
		String username=pro.getProperty("useremail");
		return username;
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String getChromeDriver()
	{
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	public String getEdgeDriver()
	{
		String edge=pro.getProperty("edgepath");
		return edge;
	}
}
