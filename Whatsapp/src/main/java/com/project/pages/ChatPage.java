package com.project.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChatPage{
	private By byAllChats = By.cssSelector(".unread.chat");

	
	public List<WebElement> GetAllChats(WebDriver driver)
	{
		List<WebElement> myElements = driver.findElements(byAllChats);
		return myElements;
	}
}