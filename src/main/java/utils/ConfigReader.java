package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigReader {
	
	Properties pro;
	WebDriver driver;
	String env;
	
	
	public ConfigReader() throws Exception {

		String path = ".\\src\\main\\resources\\appConfig\\qa.Properties";

		FileInputStream fis = new FileInputStream(path);
		pro = new Properties();
		pro.load(fis);	
	}
	
	public String getEnvURL() {
		return pro.getProperty("url");
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	
	public String getUserName() {
		return pro.getProperty("username");
	}
	
	public String getUserPassword() {
		return pro.getProperty("password");
	}

}
