package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterSection {
	@FindBy(xpath="//div[@role='filter_holder']/span")
	private WebElement filter;
	
	public WebElement getFilter()
	{
		return filter;
	}
	
	@FindBy(xpath="//span[text()=' All Chats']")
    private WebElement alchat;
	
	public WebElement getAllchat()
	{
		return alchat;
	}
	
	@FindBy(xpath="//li[text()='Unresponded Chats']")
    private WebElement unresponded;
	
	public WebElement getUnrespond()
	{
		return unresponded;
	}
	
	@FindBy(xpath="//li[text()='Unread Chats']")
    private WebElement unread;
	
	public WebElement getUnread()
	{
		return unread;
	}
	
	@FindBy(xpath="//li[text()='Closed Chats']")
    private WebElement close;
	
	public WebElement getClose()
	{
		return close;
	}
	
	@FindBy(xpath="//li[text()='Live Chats']")
    private WebElement live;
	
	public WebElement getLivechat()
	{
		return unresponded;
	}
	
	@FindBy(xpath="//img[@src='/static/sort.260d578a.svg']")
	private WebElement sort;
	
	public  WebElement getSorting()
	{
		return sort;
	}
	
	@FindBy(xpath="//span[text()='Newest']")
     private WebElement newest;
	
      public WebElement getNewest()
      {
    	  return newest;
      }
      
      @FindBy(xpath="//span[text()='Oldest']")
      private WebElement oldest;
 	
       public WebElement getOldest()
       {
     	  return oldest;
       }
       
       @FindBy(xpath="//div[@class='chatItem___1pptZ']//div[2]//div[2]")
       private WebElement timestamp;

       public  WebElement getTimeStamp()
       {
    	   return timestamp;
       }
       @FindBy(xpath="//div[@class='chatItem___1pptZ']//div[2]//div[2]")
       private WebElement time;
       
       public WebElement getTime()
       {
    	   return time;
       }
       @FindBy(xpath = "//span[text()='Close']")
       private WebElement getclose;
       
       public WebElement getFilterClose()
       {
    	   return getclose;
       }
       
       @FindBy(xpath = "//div[contains(@class,'chatItem')]")
       
       private WebElement chat;
       
       public  WebElement getChatSession()
       {
    	   return chat;
       }
       
       @FindBy(xpath = "//span[text()='Upload files']/..")
       private WebElement file;
       
       public WebElement getUploadFile()
       {
    	   return file ;
       }
       
}
