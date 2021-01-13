package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CloseCodeTest extends Base {
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

	public void closeCodeValidationTest() throws Exception {

		test = extent.createTest("2.CloseCode", "This test case is to check whether close code is working");

		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		filter = PageFactory.initElements(driver, FilterSection.class);

		close = PageFactory.initElements(driver, CloseCode.class);

		Reporter.log("Closecode Testcase is runnng..........", true);

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

		boolean alert = false;
		while (alert == false) {
			try {
				if (logp.getloginAlert().isEnabled()) {

					if (true) {
						Reporter.log("Login Alert Popup is displayed......", true);

						logp.getloginAlert().click();

						alert = true;

						break;

					}

				}
			} catch (Exception e) {

			}
		}

		/*
		 * WebDriverWait wait2 = new WebDriverWait(driver, 10);
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
		 * WebDriverWait wt = new WebDriverWait(driver, 10);
		 * wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));
		 * 
		 * logp.getproficPic().click();
		 * 
		 * WebDriverWait wait1 = new WebDriverWait(driver, 90);
		 * wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));
		 * 
		 * Assert.assertEquals(propage.getmailId().getText(),
		 * "test2prasanna@gmail.com");
		 * 
		 * logp.getcloseProfile().click();
		 * 
		 * Reporter.log("sucessfully logedin and HomePage is displayed", true);
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
		   
			WebElement chat = Utility.isElementPresnt(driver, "//li[@id='chat_session_items']", 13);
			chat.click();
			
			Reporter.log("chat session is sucessfully displayed in Add specialty..>>>>>>>>>>>", true);


		int ch = 1;

		switch (ch) {

		case 1:

			Thread.sleep(4000);
			
            Utility.isElementPresnt(driver, "//div[@id='textArea']/preceding-sibling::div/input[@type='text']", 10).sendKeys("@close");
		

			/*
			 * WebDriverWait w = new WebDriverWait(driver, 10);
			 * 
			 * w.until(ExpectedConditions.elementToBeClickable(close.getCloseVideo()));
			 * 
			 * WebDriverWait wtr = new WebDriverWait(driver, 10);
			 * wtr.until(ExpectedConditions.visibilityOf(close.getCloseComplete()));
			 */

		//	close.getCloseComplete().click();
            Utility.isElementPresnt(driver, "//span[text()='Consultation Complete']", 10).click();

			/*
			 * WebDriverWait uu = new WebDriverWait(driver, 10);
			 * 
			 * uu.until(ExpectedConditions.visibilityOf(close.getConsultcomplete()));
			 */
           Utility.isElementPresnt(driver, "//div[contains(@title,' has marked this consultation as Complete, ')]", 10);
			boolean b = close.getConsultcomplete().getText().contains("consultation as Complete");
			Assert.assertTrue(b);
			Reporter.log(close.getConsultcomplete().getText() + " sucess", true);

			/*
			 * WebDriverWait pp=new WebDriverWait(driver, 10);
			 * pp.until(ExpectedConditions.elementToBeClickable(homepge.getSendbutton()));
			 * 
			 * homepge.getSendbutton().click();
			 */

			Reporter.log("close code apply sucessfully..######################", true);
			/*
			 * case 2:
			 * 
			 * Thread.sleep(1000);
			 * 
			 * homepge.getTextarea().sendKeys("@close");
			 * 
			 * WebDriverWait wtw = new WebDriverWait(driver, 10);
			 * wtw.until(ExpectedConditions.visibilityOf(close.getCloseInPerson()));
			 * 
			 * close.getCloseInPerson().click();
			 * 
			 * WebDriverWait ll = new WebDriverWait(driver, 10);
			 * 
			 * ll.until(ExpectedConditions.visibilityOf(close.getInPerson()));
			 * 
			 * boolean b1 =
			 * close.getInPerson().getText().contains("has recommended an In-Person Visit");
			 * 
			 * Assert.assertTrue(b1);
			 * 
			 * Reporter.log(close.getInPerson().getText() + " sucess", true);
			 * 
			 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 */
			Reporter.log("CloseCode TestCase is sucessfully done ############################# TEST IS PASS", true);

		}
	}
}
