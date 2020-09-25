package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ResponderStatusTest extends Base{

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

	@Test
	public void statusValidation() throws Exception {
		
		test=extent.createTest("11.ResponderStatus","This test case is to check Responder status");


		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		filter = PageFactory.initElements(driver, FilterSection.class);

		close = PageFactory.initElements(driver, CloseCode.class);

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
		logp.getloginbtn().click();
		Thread.sleep(4000);
		boolean res = logp.getloginbtn().isEnabled(); 
		if(res==false)
		{
			break;
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();

		}
		}		

		
		WebDriverWait wait11 = new WebDriverWait(driver, 50);
		wait11.until(ExpectedConditions.elementToBeClickable(docpage.getResponder()));

		ut.moveToElement(driver, docpage.getResponder());
		

		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		for (int i = 0; i < 3; i++) {

            Thread.sleep(10000);

			homepge.getResponderStatus().click();
			
			WebDriverWait ww = new WebDriverWait(driver, 100);

			ww.until(ExpectedConditions.visibilityOf(logp.getUpdateChange()));

			Reporter.log(logp.getUpdateChange().getText(), true);

			Reporter.log("status is sucessfully changed ",true);
			Reporter.log("ResponderStatus TestCase is sucessfully done ############################# TEST IS PASS",true);

		}
	}

}
