package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;



public class ConfigReader {
	
	private Properties prop;
	static Logger logger=Logger.getLogger(ConfigReader.class);
	
	public Properties init_prop() {
		
		prop=new Properties();
		try {
			FileInputStream fi=new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info(e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info(e);
			e.printStackTrace();
		}
		return prop;
	}
	

}
