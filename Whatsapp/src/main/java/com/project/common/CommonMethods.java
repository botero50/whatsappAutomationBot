package com.project.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods{
	public enum browserType{Firefox, Chrome, Iexplorer}
	public static WebDriver driver;
	
	public void openBrowser(browserType Browser)
	{
		switch (Browser)
		{
			case Firefox:
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		        driver = new FirefoxDriver();      
		        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				break;
			case Iexplorer:
				break;
			case Chrome:
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		        driver = new ChromeDriver();      
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				break;
			default:
				System.out.println( "Error: Browser not defined" );
		}
	}
	public void getUrl(String URL)
	{
		driver.get(URL);
	}
	
	public void CloseBrowser()
	{
		driver.quit();
	}
}
