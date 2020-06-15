package com.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhatsAppHomePage 
{
	
	Properties prop1 = new Properties();
	public WebDriver driver;
	public WhatsAppHomePage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	{
		//defining object repository properties file to get object repository
		try
		  {
			File objRepPropFile = new File("/Users/rishiv/Documents/Project/DataDrivenFramework/src/main/resources/DataFiles/WhatsappObjectRepositoryProperties");
			FileInputStream orfis = new FileInputStream(objRepPropFile);
			//Properties prop1 = new Properties();
			prop1.load(orfis);
		   }
		catch(Exception e)
		  {
			System.out.println(e.getMessage());
		  }
		
		
	}
	//properties of elements
	String chatTxt = prop1.getProperty("whatsapp.homePage.chat.xpath");
	By chatTxtLocator = By.xpath(chatTxt);
	
	String unreadMessagesCountTxt=prop1.getProperty("whatsapp.homePage.unreadmessagescount.xpath");
	By unreadMessagesCountLocator=By.xpath(unreadMessagesCountTxt);
	
	String messageSenderTxt=prop1.getProperty("whatsapp.homepage.messagesender.xpath");
	By messageSenderLocator=By.xpath(messageSenderTxt);
	
	String unreadMessagesClickTxt=prop1.getProperty("whatsapp.homepage.clickthemessage2");
	By unreadMessagesClickLocator=By.xpath(unreadMessagesClickTxt);
	
	String unreadMessagesTxt=prop1.getProperty("whatsapp.homepage.unreadmeassages.xpath");
	By unreadMessagesLocator=By.xpath(unreadMessagesTxt);
	
	public void verifyHomePage() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(chatTxtLocator).isDisplayed();
		System.out.println("Homepgae verified");
	}
	
	public void unreadmessagescount() throws InterruptedException
	{
		int size = driver.findElements(unreadMessagesCountLocator).size();
		System.out.println("size is " +size);
		for(int i=0;i<size;i++)
		{
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			Thread.sleep(5000);
			System.out.println("text in unreadMessagesClickLocator is" +unreadMessagesClickTxt);
			//WebDriverWait wait = new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.elementToBeClickable(unreadMessagesClickLocator));
			//js.executeScript("arguments[0].click();",driver.findElement(unreadMessagesClickLocator));
			String messageSender = driver.findElement(messageSenderLocator).getText();
			driver.findElement(unreadMessagesClickLocator).click();
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(unreadMessagesLocator));
			String unreadMessage=driver.findElement(unreadMessagesLocator).getText();
			System.out.println("Message sent by" +messageSender + " and the message is :"+unreadMessage);
		}
	}
	
	public void verifyWhatsappHomePage() throws InterruptedException
	{
		verifyHomePage();
	}
	
	public void findunreadmessagescount() throws InterruptedException
	{
		unreadmessagescount();
		
	}
}
