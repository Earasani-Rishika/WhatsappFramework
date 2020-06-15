package com.Functionalty;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Base.DriverBase;
import com.Pages.WhatsAppHomePage;


public class Whatsapp 
{
	public static WebDriver driver;

	public static File propFile = new File("/Users/rishiv/eclipse-workspace/WhatsappFramework/src/main/resources/DataFiles/WhatsappProperties");
	public static Properties prop;
	public static final String currentDir = System.getProperty("user.dir");
	public static String log4jPath = currentDir+"/src/main/resources/DataFiles/log4j.properties";
	public static Logger log = Logger.getLogger("Report");
	
	
	@BeforeSuite
	public static void setup() throws Exception
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		String browser = prop.getProperty("browser");
		driver = DriverBase.Browser(driver,browser);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		PropertyConfigurator.configure(log4jPath);
		listeners listen = new listeners();
		listeners listen1 = new listeners(driver);
		
	}
	
	@Test
	public void openWhatsapp() throws InterruptedException
	{
		WhatsAppHomePage wh = new WhatsAppHomePage(driver);
		wh.verifyWhatsappHomePage();
		wh.findunreadmessagescount();
	}
	
	@AfterSuite
	public void tearDown()
	{
		//driver.quit();

	}
}
