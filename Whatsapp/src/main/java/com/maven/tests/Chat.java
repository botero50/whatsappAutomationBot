package com.maven.tests;
import com.project.pages.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.project.common.CommonMethods;
import com.project.common.publicData;

public class Chat extends CommonMethods implements publicData {
	
	@Before
	public void createEnvironment() 
	{
		openBrowser(browserType.Firefox);
	}
	
	@Test
	public void testingMessages() throws InterruptedException 
	{
		getUrl(publicData.EnvironmentURL);
		List<String> KnowUser = new ArrayList<String>(); 

		while(true)	
		{
			ChatPage chatPage = new ChatPage();
			try
			{
				List<WebElement> listofItems = chatPage.GetAllChats(driver);
	
				for (int i=0; i<listofItems.size(); i++)
				{
					listofItems.get(i).click();
					MessagePage messagePage = new MessagePage();
					if(KnowUser.contains(listofItems.get(i).findElement(By.cssSelector(".emojitext.ellipsify")).getText()))
					{
					   String[][]Messages = messagePage.GetAllMessages(driver);
					   String LastMessage="";
					   for(int Message=0;Message<Messages.length;Message++)
					   {
						   if (Messages[Message][0]!= null)
						   {
							   LastMessage = Messages[Message][0];
						   }
					   }
					   if(LastMessage.equals("1"))
					   {
						   messagePage.SendMessage(driver, "Press: 4. data generator ｜5. tv ｜ 6. Salomón");
					   }
					   if(LastMessage.equals("2"))
					   {
						   messagePage.SendMessage(driver, "Press: 6. Indexing database ｜8. lecture ");
					   }
					   if(LastMessage.equals("3"))
					   {
						   messagePage.SendMessage(driver, "Press: 9. add 1 + 1 ｜10. mult 1 * 1");
					   }
					   if(LastMessage.equals("4"))
					   {
						   messagePage.SendMessage(driver, "Your data will be reviewed");
					   }
					   if(LastMessage.equals("5"))
					   {
						   messagePage.SendMessage(driver, "Jack Sparrow");
					   }
					   if(LastMessage.equals("6"))
					   {
						   messagePage.SendMessage(driver, "Hi!, I am your phone automation");
					   }
					   if(LastMessage.equals("7"))
					   {
						   messagePage.SendMessage(driver, "16");
					   }
					   if(LastMessage.equals("8"))
					   {
						   messagePage.SendMessage(driver, "32 int, 16 out");
					   }
					   if(LastMessage.equals("9"))
					   {
						   messagePage.SendMessage(driver, "2");
					   }
					   if(LastMessage.equals("10"))
					   {
						   messagePage.SendMessage(driver, "0");
					   }
					}else
					{
						KnowUser.add(listofItems.get(i).findElement(By.cssSelector(".emojitext.ellipsify")).getText());	
						messagePage.SendMessage(driver, "Welcome to chat");
						messagePage.SendMessage(driver, "Press: 1. Support ｜ 2. General Service ｜ 3. Data");
					}
				}
			}catch(Exception ex){}
		}
	}
	
	@After
	public void destroyEnvironment() 
	{
		CloseBrowser();
	}
}
