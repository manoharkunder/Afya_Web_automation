package com.niveus;

import java.util.concurrent.TimeUnit;

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

	@Test

	public void closeCodeValidationTest() throws Exception {

		test=extent.createTest("2.CloseCode","This test case is to check whether close code is working");

		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		filter = PageFactory.initElements(driver, FilterSection.class);

		close = PageFactory.initElements(driver, CloseCode.class);

		Reporter.log("Closecode Testcase is runnng..........",true);
	
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
		Thread.sleep(2000);

		WebDriverWait wait2 = new WebDriverWait(driver, 50);

		wait2.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider()));

		ut.moveToElement(driver, docpage.getSubProvider());

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");
		Assert.assertTrue(flag);
		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);

		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		Reporter.log("sucessfully logedin and HomePage is displayed", true);

         
        int count=0;
		
		
		boolean resl = filter.getFilter().isEnabled();
		while(count>=0)
		{
		
		if(resl==true)
		{

		     WebDriverWait w1=new WebDriverWait(driver, 100);
		     w1.until(ExpectedConditions.visibilityOf(filter.getFilter()));
		       filter.getFilter().click();
		       break;
		}
		else
		{
     count++;
		}
		}
	

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		filter.getAllchat().click();
		

		
		
		
		WebDriverWait hme = new WebDriverWait(driver, 100);

		hme.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
		
		homepge.getChatsesion().click();
		
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
       int ch = 1;
	
		switch (ch) {
		case 1:
			
			Thread.sleep(5000);
			
			homepge.getTextarea().sendKeys("@close");
			
			WebDriverWait wt=new WebDriverWait(driver, 100);
			
			wt.until(ExpectedConditions.elementToBeClickable(close.getCloseVideo()));
			
			WebDriverWait wtr=new WebDriverWait(driver, 20);
			wtr.until(ExpectedConditions.visibilityOf(close.getCloseComplete()));
			
			close.getCloseComplete().click();
			
             Thread.sleep(10000);			
			boolean b=close.getConsultcomplete().getText().contains("consultation as Complete");
			Assert.assertTrue(b);
			Reporter.log(close.getConsultcomplete().getText()+ " sucess",true);

			homepge.getSendbutton().click();

		case 2:

			homepge.getTextarea().sendKeys("@close");
			
             WebDriverWait wt1=new WebDriverWait(driver,100);
			
			wt1.until(ExpectedConditions.elementToBeClickable(close.getCloseInPerson()));
		
			WebDriverWait wtw=new WebDriverWait(driver, 20);
			wtw.until(ExpectedConditions.visibilityOf(close.getCloseInPerson()));
			
			close.getCloseInPerson().click();

			boolean b1=close.getInPerson().getText().contains("consultation as recommending an In Person Visit");
			Assert.assertTrue(b1);
			Reporter.log(close.getInPerson().getText()+ " sucess",true);
			
			homepge.getSendbutton().click();
			
			Reporter.log("CloseCode TestCase is sucessfully done ############################# TEST IS PASS",true);

		}
	}
	}

