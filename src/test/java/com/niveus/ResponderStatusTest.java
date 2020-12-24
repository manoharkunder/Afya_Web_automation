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

	@Test()
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

		Reporter.log("Responder Status Testcase is runnng..........",true);

		

		WebDriverWait wait00 = new WebDriverWait(driver, 10);
		wait00.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));
		
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
		
		WebDriverWait wait11 = new WebDriverWait(driver, 50);
		wait11.until(ExpectedConditions.elementToBeClickable(docpage.getResponder()));

		ut.moveToElement(driver, docpage.getResponder());
		

		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));

		logp.getproficPic().click();

		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");
		
		logp.getcloseProfile().click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);
		
		wait.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
		
		 homepge.getResrol().click();
    
			wait.until(ExpectedConditions.elementToBeClickable(homepge.getResponderStatus()));
         
			boolean flag=true;
           
           while(flag==true)
			try
			{
			homepge.getResponderStatus().click();
			
			flag=false;
			}
			catch (Exception e)
			{
				
			}
			
			WebDriverWait ww = new WebDriverWait(driver, 20);

			ww.until(ExpectedConditions.visibilityOf(logp.getUpdateChange()));

			Reporter.log(logp.getUpdateChange().getText(), true);

			Reporter.log("status is sucessfully changed ",true);
			
		Reporter.log("ResponderStatus TestCase is sucessfully done ############################# TEST IS PASS",true);

	}

}
