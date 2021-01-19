package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LogoutTest extends Base
{
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public ProfilePage propage;


	@Test
	public void logoutValidationTest()
	{
		test = extent.createTest("13.Logout", "This test case is used to check the Logout");

		logp = PageFactory.initElements(driver, LoginPage.class);

		card = PageFactory.initElements(driver, Carddetails.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		Reporter.log("Logout Testcase is runnng..........>>>>>>>>>>>>>>>>",true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait log = new WebDriverWait(driver, 20);

		log.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed..................Pass", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));

		logp.getUsername().sendKeys("prasannaachar126@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");

		logp.getpswdview().click();

		boolean flag = true;

		while (flag) {
			try {

				boolean res = logp.getloginbtn().isEnabled();

				if (res == true) {
					logp.getloginbtn().click();

					flag = false;

					break;
				}
			} catch (Exception e) {

				e.printStackTrace();

			}
		}

		try {

			if (logp.getloginAlert().isEnabled())
			{
				Reporter.log("Login Alert Popup is displayed......", true);

				logp.loginPopUP();
			}
			
			
		}
		   catch (Exception e) {

			Reporter.log("No Alert Popup...............", true);

			WebDriverWait wt = new WebDriverWait(driver, 10);
			wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));
             
			logp.getproficPic().click();


		}
		
	

		WebDriverWait wait1 = new WebDriverWait(driver, 90);

		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "prasannaachar126@gmail.com");
		
		Reporter.log("sucessfully loged in and Home page is displayed..............Pass", true);

		
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