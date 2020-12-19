package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ParticipantTest extends Base {
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public ProfilePage propage;
	public HomePage homepge;
	public CloseCode close;
	public FilterSection filter;

	@Test()
	public void participantValidationTest() throws Exception {
		
		test=extent.createTest("8.ParticipantTest","This test case is to check whether ParticipantTest is working");

		
		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		filter = PageFactory.initElements(driver, FilterSection.class);

		close = PageFactory.initElements(driver, CloseCode.class);

		Reporter.log("Participant Testcase is runnng..........",true);

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed", true);

		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));
		logp.getUsername().sendKeys("test2prasanna@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");
		logp.getpswdview().click();


		for(int i=0;i<=10;i++)
		{
		try
		{
		boolean res = logp.getloginbtn().isEnabled();
	
		if(res==true)
		{
			logp.getloginbtn().click();

			break;
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();

		}
		}
		
		WebDriverWait wait2 = new WebDriverWait(driver, 50);

		wait2.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider()));

		ut.moveToElement(driver, docpage.getSubProvider());

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");
		Assert.assertTrue(flag);
		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);

		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	
		  int count=0;
			
			
			boolean resl = filter.getFilter().isEnabled();
			while(count>=0)
			{
			
			if(resl==true)
			{

			     WebDriverWait w1=new WebDriverWait(driver, 100);
			     w1.until(ExpectedConditions.visibilityOf(filter.getFilter()));
			    
			     JavascriptExecutor ex = (JavascriptExecutor)driver;
			     ex.executeScript("arguments[0].click();", filter.getFilter());
			     
			   			       break;
			}
			else
			{
	     count++;
			}
			}
			/*
			 * WebDriverWait pp=new WebDriverWait(driver, 30);
			 * pp.until(ExpectedConditions.elementToBeClickable(filter.getAllchat()));
			 * 
			 */
			
			Thread.sleep(4000);
			filter.getAllchat().click();
			
			
         WebDriverWait w=new WebDriverWait(driver, 100);
         w.until(ExpectedConditions.elementToBeClickable(homepge.getChatsesion()));
		
         int cnt=0;
 	    while(cnt>=0)
 	    {
 	    	try
 	    	{
 	    		homepge.getChatsesion().isDisplayed();
 	    		homepge.getChatsesion().click();
 	    		break;
 	    	}
 	    	catch (Exception e) 
 	    	{
 	    		Thread.sleep(1000);
 				filter.getFilter().click();
 				filter.getAllchat().click();

                  cnt++;
                  e.printStackTrace();
 	    	}
 	    	
 	    }
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(10000);

		int ch = 1;
		switch (ch) {
		case 1:

           Thread.sleep(5000);
           
			homepge.getTextarea().sendKeys("@participant");

			Thread.sleep(5000);
			
			ut.moveToElement(driver, close.getFullAccess());

			WebDriverWait t = new WebDriverWait(driver, 100);
			t.until(ExpectedConditions.visibilityOf(close.getParticipantFull()));

			boolean b = close.getParticipantFull().getText().contains("Full Access");
			Assert.assertTrue(b);
			Reporter.log(close.getParticipantFull().getText() + " sucess", true);

			homepge.getSendbutton().click();

			break;
			
		case 2:

			homepge.getTextarea().sendKeys("@participant");

			WebDriverWait wt1 = new WebDriverWait(driver, 100);

			wt1.until(ExpectedConditions.elementToBeClickable(close.getLimitAcces()));

			ut.moveToElement(driver, close.getLimitAcces());

			WebDriverWait u = new WebDriverWait(driver, 100);
			u.until(ExpectedConditions.visibilityOf(close.getPArticipantLimit()));

			boolean b1 = close.getPArticipantLimit().getText().contains("Limited Access");

			Assert.assertTrue(b1);

			Reporter.log(close.getPArticipantLimit().getText() + " sucess", true);

			homepge.getSendbutton().click();

			Thread.sleep(10000);

			

		case 3:
			homepge.getTextarea().sendKeys("@participant");

			WebDriverWait wait22 = new WebDriverWait(driver, 100);
			wait22.until(ExpectedConditions.elementToBeClickable(close.getNoAccess()));

			ut.moveToElement(driver, close.getNoAccess());

			WebDriverWait tu = new WebDriverWait(driver, 100);
			tu.until(ExpectedConditions.visibilityOf(close.getPArticipantNo()));

			boolean b3 = close.getPArticipantNo().getText().contains("No Access");
			Assert.assertTrue(b3);
			Reporter.log(close.getPArticipantNo().getText() + " sucess", true);
			
		}
		Reporter.log("ParticipantTest TestCase is sucessfully done ################################################## TEST IS PASS",true);


	}

}
