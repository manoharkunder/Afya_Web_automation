package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FilterTest extends Base {
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	FileLib flib = new FileLib();
	public ProfilePage propage;
	public DoctorRolesPage docpage;
	Utility ut = new Utility();

	@Test()
	public void filterValidationTest() throws Exception {

		test = extent.createTest("6.FilterTest", "This test case is to check whether Filter is working");

		logp = PageFactory.initElements(driver, LoginPage.class);
		card = PageFactory.initElements(driver, Carddetails.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		propage = PageFactory.initElements(driver, ProfilePage.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		Reporter.log("FilterTest Testcase is runnng..........", true);
		WebDriverWait wait00 = new WebDriverWait(driver, 10);
		wait00.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");
		Reporter.log("Login page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));

		logp.getUsername().sendKeys("test2prasanna@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");

		logp.getpswdview().click();

		for (int i = 0; i <= 10; i++) {
			try {
				boolean res = logp.getloginbtn().isEnabled();
				if (res == true) {
					logp.getloginbtn().click();

					break;
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		try {
			Thread.sleep(2000);
			if (logp.getloginAlert().isEnabled()) {

				if (true) {
					Reporter.log("Login Alert Popup is displayed......", true);

					logp.getloginAlert().click();

				}

			}
		} catch (Exception e) {

			Reporter.log("No Alert Popup...............", true);

		}

		WebDriverWait waitt = new WebDriverWait(driver, 10);
		waitt.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider()));
		
		ut.moveToElement(driver, docpage.getSubProvider());

		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));

		logp.getproficPic().click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		logp.getcloseProfile().click();

		Reporter.log("sucessfully logedin and Home page is displayed", true);
	
		/*
		 * wait.until(ExpectedConditions.visibilityOf(filter.getFilter()));
		 * 
		 * boolean resl = filter.getFilter().isEnabled(); while(resl==true) { try {
		 * 
		 * 
		 * if(resl) {
		 * 
		 * filter.getFilter().click();
		 * 
		 * resl=false;
		 * 
		 * break; } } catch (Exception e) {
		 * 
		 * } } int count=0; while(count==0) { try {
		 * 
		 * filter.getAllchat().click();
		 * 
		 * homepge.getChatsesion().isDisplayed(); count++; } catch (Exception e) {
		 * 
		 * } }
		 */

			Utility.isElementPresnt(driver, "//div[@role='filter_holder']/span", 12).click();
			;
			/*
			 * wait2.until(ExpectedConditions.visibilityOf(filter.getFilter()));
			 * 
			 * boolean resl = filter.getFilter().isEnabled();
			 * 
			 * while (count >= 0) {
			 * 
			 * if (resl == true) {
			 * 
			 * Thread.sleep(2000); WebDriverWait w1 = new WebDriverWait(driver, 100);
			 * w1.until(ExpectedConditions.visibilityOf(filter.getFilter()));
			 * 
			 * JavascriptExecutor ex = (JavascriptExecutor) driver;
			 * ex.executeScript("arguments[0].click();", filter.getFilter());
			 * 
			 * break; } else { count++; } }
			 * 
			 * Thread.sleep(4000);
			 */

			// filter.getAllchat().click();
			
			try
			{

			Utility.isElementPresnt(driver, "//span[text()=' All Chats']", 10).click();
			
			}
			catch (Exception e)
			{
				Reporter.log("error is displaying");
			}
			/*
			 * try { WebDriverWait up = new WebDriverWait(driver, 30);
			 * up.until(ExpectedConditions.visibilityOf(landpage.getChatsesion())); } catch
			 * (Exception e)
			 * 
			 * { e.printStackTrace(); }
			 */
	        Thread.sleep(2000);
	        
			String chat=Utility.isElementPresnt(driver, "//li[@id='chat_session_items']", 10).getText();
			
			Reporter.log("chat session is sucessfully displayed in Add specialty..>>>>>>>>>>>", true);




			/*
			 * WebDriverWait hme = new WebDriverWait(driver, 10);
			 * 
			 * hme.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
			 */
//		String chat = homepge.getChatsesion().getText();

		Reporter.log(chat, true);

		String newtime = "";
		String StrOld = "";

		if (chat.equalsIgnoreCase("ago")) {
			Reporter.log("First time stmp is  displayed........###########", true);
			newtime=Utility.isElementPresnt(driver, "//div[@class='chatItem___1pptZ']//div[2]//div[2]", 10).getText();
		//	newtime = filter.getTimeStamp().getText();
		} else {
			Reporter.log("second time stamp is taken.........############", true);
			//StrOld = filter.getTime().getText();
			StrOld=Utility.isElementPresnt(driver, "//div[@class='chatItem___1pptZ']//div[2]//div[2]", 10).getText();
			newtime = StrOld;

		}

		Reporter.log(newtime, true);
		try
		{
	//	filter.getFilterClose().click();
		Utility.isElementPresnt(driver, "//span[text()='Close']", 10).click();
		}
		catch(Exception e)
		{
			
		}
		
		  WebDriverWait p = new WebDriverWait(driver, 10);
		  
		  p.until(ExpectedConditions.visibilityOf(filter.getSorting()));
		  
		   
		Utility.isElementPresnt(driver, "//img[@src='/static/sort.260d578a.svg']", 10).click();
		
	//	filter.getSorting().click();

		try
		{
			/*
			 * WebDriverWait q = new WebDriverWait(driver, 10);
			 * 
			 * q.until(ExpectedConditions.visibilityOf(filter.getNewest()));
			 */
			
			Utility.isElementPresnt(driver, "//span[text()='Newest']", 10).click();

		}
		catch (Exception e) 
		{
			
		}
		
		/*
		 * JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		 * ex1.executeScript("arguments[0].click();", filter.getNewest());
		 * 
		 * 
		 * WebDriverWait www = new WebDriverWait(driver, 10);
		 * www.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
		 */
		
	    Thread.sleep(2000);
		Utility.isElementPresnt(driver, "//li[@id='chat_session_items']", 10).getText();
				
				Reporter.log("chat session is sucessfully displayed in Add specialty..>>>>>>>>>>>", true);
		
		
		String oldtime = "";
		if (chat.contains("old")) {
			//oldtime = filter.getTime().getText();
			Thread.sleep(2000);
			oldtime=Utility.isElementPresnt(driver, "//div[@class='chatItem___1pptZ']//div[2]//div[2]", 10).getText();

		} else {
			Thread.sleep(2000);
		//	String time = filter.getTimeStamp().getText();
			String time=Utility.isElementPresnt(driver, "//div[@class='chatItem___1pptZ']//div[2]//div[2]", 10).getText();
			
			oldtime = time;

		}

		Reporter.log(oldtime, true);

		Assert.assertNotEquals(newtime, oldtime);

		Reporter.log("filter is sucessfully applied", true);

		Reporter.log("Filter Test is sucessfully done ############################# TEST IS PASS", true);
	}
}
