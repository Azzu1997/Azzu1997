package com.ninza_hrm.utilityclasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility
{
	public String   ReadTheDataFromThePropertyFile(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\propertyfile.properties");
		Properties pobj = new Properties();
		pobj.load(file);
		String value= pobj.getProperty(key);
		return value;
		}
	
	
}
