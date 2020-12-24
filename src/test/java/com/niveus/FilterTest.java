package com.niveus;

import org.openqa.selenium.JavascriptExecutor;
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

	@Test(priority = 5)
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
	
		
		 wait.until(ExpectedConditions.visibilityOf(filter.getFilter()));
	        
			boolean resl = filter.getFilter().isEnabled();
	        while(resl==true)
	        {
	        	try
	        	{
	        		
	        	
			if(resl)
			{

			filter.getFilter().click();
	       					
			resl=false;
			
			break;	
			}
	        	}
	        catch (Exception e) 
	        	{
					
	        	}
	        }
	        int count=0;
	        while(count==0)
	        {
	        try
	        {
				
	        filter.getAllchat().click();

			homepge.getChatsesion().isDisplayed();
			count++;
	        }
	        catch (Exception e) 
	        {
	        	
			}
	        }



			/*
			 * WebDriverWait hme = new WebDriverWait(driver, 10);
			 * 
			 * hme.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
			 */
		String chat = homepge.getChatsesion().getText();

		Reporter.log(chat, true);

		String newtime = "";
		String StrOld = "";

		if (chat.equalsIgnoreCase("ago")) {
			Reporter.log("First time stmp is  displayed........###########", true);
			newtime = filter.getTimeStamp().getText();
		} else {
			Reporter.log("second time stamp is taken.........############", true);
			StrOld = filter.getTime().getText();
			newtime = StrOld;

		}

		Reporter.log(newtime, true);
		try
		{
		filter.getFilterClose().click();
		}
		catch(Exception e)
		{
			
		}

		WebDriverWait p = new WebDriverWait(driver, 10);

		p.until(ExpectedConditions.visibilityOf(filter.getSorting()));

		filter.getSorting().click();

		try
		{
		WebDriverWait q = new WebDriverWait(driver, 10);

		q.until(ExpectedConditions.visibilityOf(filter.getNewest()));

		}
		catch (Exception e) 
		{
			
		}
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("arguments[0].click();", filter.getNewest());

		WebDriverWait www = new WebDriverWait(driver, 10);
		www.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
		String oldtime = "";
		if (chat.contains("old")) {
			oldtime = filter.getTime().getText();
		} else {
			String time = filter.getTimeStamp().getText();
			oldtime = time;

		}

		Reporter.log(oldtime, true);

		Assert.assertNotEquals(newtime, oldtime);

		Reporter.log("filter is sucessfully applied", true);

		Reporter.log("Filter Test is sucessfully done ############################# TEST IS PASS", true);
	}
}
