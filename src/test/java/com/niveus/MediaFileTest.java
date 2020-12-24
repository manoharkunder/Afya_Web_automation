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

public class MediaFileTest extends Base{
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	FileLib flib = new FileLib();
	public ProfilePage propage;
    public DoctorRolesPage docpage;
    Utility ut=new Utility();
    
	@Test()
	public void mediaFileValidation() throws Exception {
		
		test=extent.createTest("2.MediaFile","This test case is to check whether close code is working");

         File f1 = new  	File("data");
		
		 File fs = new File(f1, "res.png");
		
		
		propage = PageFactory.initElements(driver, ProfilePage.class);
		logp = PageFactory.initElements(driver, LoginPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
        docpage=PageFactory.initElements(driver, DoctorRolesPage.class);

		Reporter.log("MediaFile Testcase is runnng..........",true);

		WebDriverWait wait9 = new WebDriverWait(driver, 10);
		wait9.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

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
		
		
			WebDriverWait wait2 = new WebDriverWait(driver, 10);

		wait2.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider()));

		ut.moveToElement(driver, docpage.getSubProvider());

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");
		Assert.assertTrue(flag);
		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);
		
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));

		logp.getproficPic().click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");
		
		logp.getcloseProfile().click();
		
		Reporter.log("sucessfully loged in and Home page is displayed", true);
		
		




        wait2.until(ExpectedConditions.visibilityOf(filter.getFilter()));
        
		boolean resl = filter.getFilter().isEnabled();
        while(resl==true)
        {
        	
       try
       {
		if(resl)
		{
		filter.getFilter().click();
	
		Thread.sleep(2000);
              		
		filter.getAllchat().click();
		

		resl=false;
			
		break;	
		}}
        catch (Exception e) 
        {
        	e.printStackTrace();
        }
		}



		WebDriverWait hme = new WebDriverWait(driver, 10);

		hme.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));

		Reporter.log("Sucessfully chat session is displayed Upload photo>>>>>>>>>>>>>>", true);

		homepge.getChatsesion().click();


		    
		WebDriverWait wait11 = new WebDriverWait(driver, 10);
		wait11.until(ExpectedConditions.elementToBeClickable(homepge.getPaperclip()));

		homepge.getPaperclip().click();


		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		homepge.getUploadPhoto().click();

		Thread.sleep(3000);
		homepge.getPhotoUpload().sendKeys(fs.getAbsolutePath());

		homepge.getSubmitButton().click();

		WebDriverWait www = new WebDriverWait(driver, 50);
		www.until(ExpectedConditions.visibilityOf(logp.getSucess()));

		boolean b = logp.getSucess().getText().contains("file");

		Assert.assertTrue(b);

		Reporter.log(logp.getSucess().getText() + " sucessfully updated", true);

		Reporter.log("UploadPhotosTest is sucessfully done ############################# TEST IS PASS", true);

		int val = 0;
		while (val <= 100) {
			try {
				
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", homepge.getMoreoptions());
				
				Reporter.log("Media File Test   step ....4",true);

				break;

			} catch (Exception e) {

				e.printStackTrace();
				val++;
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}


		WebDriverWait p=new WebDriverWait(driver, 20);
		p.until(ExpectedConditions.visibilityOf(homepge.getMediaFil()));
	
		   JavascriptExecutor ex = (JavascriptExecutor)driver;
		   ex.executeScript("arguments[0].click();", homepge.getMediaFil());
		     

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String fle = homepge.getFile().getText();

		boolean f = fle.contains("Test2");

		Assert.assertTrue(f);

		Reporter.log("media file is sucessfully displayed", true);
		
		Reporter.log("MediaFileTest TestCase is sucessfully done ################################################## TEST IS PASS",true);

	}
}
