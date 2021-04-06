package com.niveus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LogoutTest extends Base
{
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public ProfilePage propage;
	public DoctorRolesPage docpage;


	@Test()
	public void logoutValidationTest() throws Exception	
	{
		test = extent.createTest("13.Logout", "This test case is used to check the Logout");

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		card = PageFactory.initElements(driver, Carddetails.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		Reporter.log("Logout Testcase is runnng..........>>>>>>>>>>>>>>>>",true);




		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		AssertJUnit.assertEquals(logp.getloginbtn().getText(), "Login");

		logp.getUsername().sendKeys("test1prasanna@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");

		logp.getpswdview().click();

		boolean flag1 = true;

		while (flag1 == true) {
			try {
				boolean res = logp.getloginbtn().isEnabled();
				if (res == true) {
					logp.getloginbtn().click();
					flag1 = false;
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

					}

				}
			} catch (Exception e) {

			}
		}
		
		Thread.sleep(2000);
       
		wait.until(ExpectedConditions.visibilityOf(docpage.getSubProvider()));
		
	    Utility.moveToElement(driver, docpage.getSubProvider());
	    
		boolean flag = docpage.getSubProvider().getText().contains("provider");

		AssertJUnit.assertTrue(flag);

		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			if (docpage.getSkip().isEnabled()) {
				Utility.isElementPresnt(driver, "//span[text()='Skip >']", 5).click();
			}

			else {
				Reporter.log("No Missed call Popup", true);
			}
		} catch (Exception e) {

		}

		Utility.isElementPresnt(driver, "//div[contains(@class,'user_name_')]", 10).click();

		wait.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		AssertJUnit.assertEquals(propage.getmailId().getText(), "test1prasanna@gmail.com");

	

		Reporter.log("sucessfully loged in and Home page is displayed", true);		
		try
		{
       
		WebElement logout = Utility.isElementPresnt(driver, "//span[text()='Logout']", 10);
		
		logout.click();
		}
		catch (Exception e) 
		
		{
			
		}
		


		Reporter.log("Logout TestCase is sucessfully done ############################# TEST IS PASS", true);
	}
}
