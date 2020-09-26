package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends Base{
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public ProfilePage propage;

	@Test()
	public void loginPageTest() {
		test=extent.createTest("1.Login","This test case is to check login");
		logp = PageFactory.initElements(driver, LoginPage.class);
		card = PageFactory.initElements(driver, Carddetails.class);
		propage = PageFactory.initElements(driver, ProfilePage.class);
		
		WebDriverWait log=new WebDriverWait(driver, 20);
		log.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");
	
		Reporter.log("Login page is sucessfully displayed", true);
	
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));
		logp.getUsername().sendKeys("alvin@wise.healthcare");
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

		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "alvin@wise.healthcare");
		Reporter.log("sucessfully loged in and Home page is displayed", true);
		Reporter.log("Login TestCase is sucessfully done ############################# TEST IS PASS",true);
	}

}
