package com.project.pages;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class MessagePage{
	private By byAllMessages = By.cssSelector(".message.message-chat.message-chat");
	private By byAllMessageText = By.cssSelector(".emojitext.selectable-text");
	private By byAllMessageDate = By.cssSelector(".message-datetime");
	private By byTxtMessage = By.cssSelector(".input-emoji>.input"); 
	private By byBtnSmile = By.cssSelector(".icon-smiley");
	private By byBtnEmojik = By.cssSelector(".e46.c6.emojik");
	private By byBtnSend = By.cssSelector(".icon.icon-send.compose-btn-send");
	
	public String[][] GetAllMessages(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		List<WebElement> myElements = driver.findElements(byAllMessages);
		String[][] Chat=new String[5][2];
		int Conteo=0;
		for (int i=myElements.size(); i>=0; i--) 
		{
			if(!myElements.get(i-1).getAttribute("class").toString().contains("message-out") && Conteo<5 )
			{
				Chat[Conteo][0] = myElements.get(i-1).findElement(byAllMessageText).getText();
				Chat[Conteo][1] = myElements.get(i-1).findElement(byAllMessageDate).getText();
				Conteo+=1;
			}
			else
			{
				break;
			}
		}
		return Chat;
	}
	public void SendMessage(WebDriver driver, String Message)
	{
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("document.getElementsByClassName('input')[1].innerHTML='" + Message + "';");
		driver.findElement(byTxtMessage).click();
		driver.findElement(byBtnSmile).click();
		driver.findElement(byBtnEmojik).click();
		driver.findElement(byBtnSend).click();
	}
}