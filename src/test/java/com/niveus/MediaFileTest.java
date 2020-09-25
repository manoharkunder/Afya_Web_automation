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
	@Test
	public void mediaFileValidation() throws Exception {
		
		test=extent.createTest("2.CloseCode","This test case is to check whether close code is working");

         File f1 = new  	File("data");
		
		 File fs = new File(f1, "res.png");
		
		
		propage = PageFactory.initElements(driver, ProfilePage.class);
		logp = PageFactory.initElements(driver, LoginPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
        docpage=PageFactory.initElements(driver, DoctorRolesPage.class);

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

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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
			
			
         int cnt=0;
 	    while(cnt>=0)
 	    {
 	    	try
 	    	{
 	    		homepge.getChatsesion().isDisplayed();
 	    		homepge.getChatsesion().click();
 	    		break;
 	    	}
 	    	catch (Exception e) 
 	    	{
 	    		Thread.sleep(1000);
 				filter.getFilter().click();
 				filter.getAllchat().click();

                  cnt++;
                  e.printStackTrace();
 	    	}
 	    	
 	    }

		          
		WebDriverWait wait11 = new WebDriverWait(driver, 30);
		wait11.until(ExpectedConditions.elementToBeClickable(homepge.getPaperclip()));

		homepge.getPaperclip().click();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Thread.sleep(3000);

		
		
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int val = 0;
		while (val <= 100) {
			try {
				
				homepge.getUploadPhoto().click();
				

				homepge.getPhotoUpload()
						.sendKeys(fs.getAbsolutePath());

				homepge.getSubmitButton().click();

				WebDriverWait www = new WebDriverWait(driver, 80);
				www.until(ExpectedConditions.visibilityOf(logp.getSucess()));

				boolean b = logp.getSucess().getText().contains("file");

				Assert.assertTrue(b);

				Reporter.log(logp.getSucess().getText() + " sucessfully updated", true);	
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", homepge.getMoreoptions());
				break;

			} catch (Exception e) {

				e.printStackTrace();
				val++;
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}


		WebDriverWait p=new WebDriverWait(driver, 20);
		p.until(ExpectedConditions.elementToBeClickable(homepge.getMediaFil()));
	
		homepge.getMediaFil().click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String fle = homepge.getFile().getText();

		boolean f = fle.contains("test2");

		Assert.assertTrue(f);

		Reporter.log("media file is sucessfully displayed", true);
		Reporter.log("MediaFileTest TestCase is sucessfully done ################################################## TEST IS PASS",true);

	}
}
