package com.niveus;

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

		
		WebDriverWait wait00 = new WebDriverWait(driver, 10);
		wait00.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed", true);

		
		WebDriverWait wait = new WebDriverWait(driver, 10);
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
		
		boolean alert=false;
		while(alert==false)
		{
		try {
			if (logp.getloginAlert().isEnabled()) {

				if (true) {
					Reporter.log("Login Alert Popup is displayed......", true);
					

					logp.getloginAlert().click();
					
					alert=true;
					
					break;

				}

			}
		} catch (Exception e) { 
						

		}
		}
		/*
		 * 
		 * WebDriverWait wait2 = new WebDriverWait(driver, 15);
		 * 
		 * wait2.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider())
		 * );
		 * 
		 * ut.moveToElement(driver, docpage.getSubProvider());
		 * 
		 * boolean flag = docpage.getSubProvider().getText().contains("Submitter");
		 * Assert.assertTrue(flag); Reporter.log(docpage.getSubProvider().getText() +
		 * " role is selected", true);
		 * 
		 * 
		 * WebDriverWait wt = new WebDriverWait(driver, 10);
		 * wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));
		 * 
		 * logp.getproficPic().click();
		 * 
		 * 
		 * WebDriverWait wait1 = new WebDriverWait(driver, 10);
		 * wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));
		 * 
		 * Assert.assertEquals(propage.getmailId().getText(),
		 * "test2prasanna@gmail.com");
		 * 
		 * logp.getcloseProfile().click();
		 * 
		 * Reporter.log("sucessfully loged in and Home page is displayed", true);
		 * 
		 * 
		 * 
		 * wait2.until(ExpectedConditions.visibilityOf(filter.getFilter()));
		 * 
		 * boolean resl = filter.getFilter().isEnabled(); while(resl==true) { try {
		 * 
		 * 
		 * if(resl) { filter.getFilter().click();
		 * 
		 * filter.getAllchat().click();
		 * 
		 * resl=false;
		 * 
		 * break; } } catch (Exception e) {
		 * 
		 * } }
		 * 
		 * 
		 * 
		 * WebDriverWait hme = new WebDriverWait(driver, 10);
		 * 
		 * hme.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
		 * 
		 * Reporter.
		 * log("Sucessfully chat session is displayed...in close code ....>>>>>>>>>>>>>>"
		 * , true);
		 * 
		 * homepge.getChatsesion().click();
		 */
		
		Utility.isElementPresnt(driver, "//span[text()='Submitter Provider']", 10).click();

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");
		
		Assert.assertTrue(flag);
		
		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);
		
		
		
		
		Utility.isElementPresnt(driver, "//div[contains(@class,'user_name_')]", 10).click();
		
		//logp.getproficPic().click();

		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		//logp.getcloseProfile().click();
		
		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img", 10).click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);
		
		wait.until(ExpectedConditions.visibilityOf(filter.getFilter()));
	
		/*
		 * wait.until(ExpectedConditions.visibilityOf(filter.getFilter())); boolean resl
		 * = filter.getFilter().isEnabled(); while (resl == true) {
		 * 
		 * if (resl) { filter.getFilter().click(); filter.getAllchat().click();
		 * 
		 * resl = false;
		 * 
		 * break; } }
		 * 
		 * WebDriverWait hme = new WebDriverWait(driver, 10);
		 * 
		 * hme.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
		 * 
		 * Reporter.
		 * log("Sucessfully chat session is displayed...in close code ....>>>>>>>>>>>>>>"
		 * , true);
		 * 
		 * homepge.getChatsesion().click();
		 */
		
		
		Utility.isElementPresnt(driver, "//div[@role='filter_holder']/span", 10).click();
		try
		{

		Utility.isElementPresnt(driver, "//span[text()=' All Chats']", 10).click();
		
		}
		catch (Exception e)
		{
			Reporter.log("error is displaying");
		}
		   Thread.sleep(2000);
			Utility.isElementPresnt(driver, "//li[@id='chat_session_items']", 10).click();
			
			Reporter.log("chat session is sucessfully displayed in Add specialty..>>>>>>>>>>>", true);



		int ch = 1;
		switch (ch) {
		case 1:

			/*
			 * Thread.sleep(5000);
			 * 
			 * homepge.getTextarea().sendKeys("@participant");
			 */
			
          Thread.sleep(4000);
			
            Utility.isElementPresnt(driver, "//div[@id='textArea']/preceding-sibling::div/input[@type='text']", 10).sendKeys("@participant");
			/*
			 * 
			 * wait.until(ExpectedConditions.elementToBeClickable(close.getFullAccess()));
			 * ut.moveToElement(driver, close.getFullAccess());
			 */
            
            Utility.isElementPresnt(driver, "//span[text()='Full Access']/following-sibling::span[text()='Patient can submit chats']/ancestor::div[@class='middle list-sort-demo-text']", 10).click();

			/*
			 * WebDriverWait t = new WebDriverWait(driver, 10);
			 * t.until(ExpectedConditions.visibilityOf(close.getParticipantFull()));
			 */
            
            Utility.isElementPresnt(driver, "//span[text()='Full Access']", 10);
            
			boolean b = close.getParticipantFull().getText().contains("Full Access");
			Assert.assertTrue(b);
			Reporter.log(close.getParticipantFull().getText() + " sucess", true);

		
			break;
			
		case 2:

			homepge.getTextarea().sendKeys("@participant");

			WebDriverWait wt1 = new WebDriverWait(driver, 10);

			wt1.until(ExpectedConditions.elementToBeClickable(close.getLimitAcces()));

			ut.moveToElement(driver, close.getLimitAcces());

			WebDriverWait u = new WebDriverWait(driver, 10);
			u.until(ExpectedConditions.visibilityOf(close.getPArticipantLimit()));

			boolean b1 = close.getPArticipantLimit().getText().contains("Limited Access");

			Assert.assertTrue(b1);

			Reporter.log(close.getPArticipantLimit().getText() + " sucess", true);

			homepge.getSendbutton().click();

			Thread.sleep(1000);

		

		case 3:
			
			homepge.getTextarea().sendKeys("@participant");

			WebDriverWait wait22 = new WebDriverWait(driver, 10);
			wait22.until(ExpectedConditions.elementToBeClickable(close.getNoAccess()));

			ut.moveToElement(driver, close.getNoAccess());

			WebDriverWait tu = new WebDriverWait(driver, 10);
			tu.until(ExpectedConditions.visibilityOf(close.getPArticipantNo()));

			boolean b3 = close.getPArticipantNo().getText().contains("No Access");
			Assert.assertTrue(b3);
			Reporter.log(close.getPArticipantNo().getText() + " sucess", true);
			
		}
		
		Reporter.log("ParticipantTest TestCase is sucessfully done ################################################## TEST IS PASS",true);


	}

}
