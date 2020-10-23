package com.niveus;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UploadDocumentTest extends Base {
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	FileLib flib = new FileLib();
	public ProfilePage propage;
	public DoctorRolesPage docpage;
	Utility ut = new Utility();



	@Test

	public void uploadDocumentValidation() throws Exception {

		test = extent.createTest("12.UploadDocument", "This test case is to check user is able to upload the Document");

		File f = new File("data");

		File fs = new File(f, "doc.pdf");

		propage = PageFactory.initElements(driver, ProfilePage.class);
		logp = PageFactory.initElements(driver, LoginPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);


		Reporter.log("UploadDocument Testcase is runnng..........",true);

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
		
		WebDriverWait till = new WebDriverWait(driver, 100);
		till.until(ExpectedConditions.elementToBeClickable(filter.getFilter()));

		int count = 0;

		boolean resl = filter.getFilter().isEnabled();
		while (count >= 0) {

			if (resl == true) {

				WebDriverWait w1 = new WebDriverWait(driver, 100);
				w1.until(ExpectedConditions.visibilityOf(filter.getFilter()));

		
				   JavascriptExecutor ex = (JavascriptExecutor)driver;
				     ex.executeScript("arguments[0].click();", filter.getFilter());
				     
				break;
			} else {
				count++;
			}
		}
		/*
		 * WebDriverWait pp=new WebDriverWait(driver, 30);
		 * pp.until(ExpectedConditions.elementToBeClickable(filter.getAllchat()));
		 */
		
		Thread.sleep(4000);
		filter.getAllchat().click();

		WebDriverWait wait33 = new WebDriverWait(driver, 50);
		wait33.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));

		   JavascriptExecutor ex = (JavascriptExecutor)driver;
		   ex.executeScript("arguments[0].click();", homepge.getChatsesion());
		     
	//	homepge.getChatsesion().click();

		WebDriverWait wait11 = new WebDriverWait(driver, 30);
		wait11.until(ExpectedConditions.elementToBeClickable(homepge.getPaperclip()));

		homepge.getPaperclip().click();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(3000);

		homepge.getUploadFile().sendKeys(fs.getAbsolutePath());

		homepge.getSubmitButton().click();

		WebDriverWait www = new WebDriverWait(driver, 80);
		www.until(ExpectedConditions.visibilityOf(logp.getSucess()));

		boolean b = logp.getSucess().getText().contains("file");

		Assert.assertTrue(b);

		Reporter.log(logp.getSucess().getText() + " sucessfully updated", true);
	
		Reporter.log("UploadDocument Test is sucessfully done ############################# TEST IS PASS", true);
    driver.quit();

	}
}
