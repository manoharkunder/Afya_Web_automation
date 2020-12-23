package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ProfileUpadateTest extends Base{
	public LoginPage logp;
	public ProfilePage profile;
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	Utility util = new Utility();
	public ProfilePage propage;

	

	@Test(priority = 4)
	public void updateProfileInformation() throws Exception {
	
		test=extent.createTest("10.ProfileUpdateTest","This test case is to check user is able to Update the Profile");

		
		propage = PageFactory.initElements(driver, ProfilePage.class);
		
		logp = PageFactory.initElements(driver, LoginPage.class);
		
		Reporter.log("ProfileUpdate Testcase is runnng..........",true);
		
		WebDriverWait wait00 = new WebDriverWait(driver, 10);
		wait00.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed", true);
		

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));
		logp.getUsername().sendKeys("pammi@gmail.com");
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
		
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));

		logp.getproficPic().click();
		

		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "pammi@gmail.com");
		
		logp.getcloseProfile().click();
		
		Reporter.log("sucessfully loged in and Home page is displayed", true);
		
		profile = PageFactory.initElements(driver, ProfilePage.class);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(profile.getProfilehov()));

		util.moveToElement(driver, profile.getProfilehov());
		
		Thread.sleep(3000);

		profile.updateProfile("M", "A", "11111999", "Female");
		
		
		for (int i = 0; i >=0;) 
		{
			profile.getUpdatebtn().click();
			i--;
		}
		
		WebDriverWait  till= new  WebDriverWait(driver, 100);
		till.until(ExpectedConditions.visibilityOf(profile.getUpdateinformtion()));
		
		Assert.assertEquals(profile.getUpdateinformtion().getText(),"information successfully Updated");
		
		Reporter.log("Profile ingormation is sucessfully updated");
		Reporter.log("ProfileUpdateTest TestCase is sucessfully done ############################# TEST IS PASS",true);
	}

}
