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
		
		test=extent.createTest("2.MediaFile","This test case is to check whether close code is working");

         File f1 = new  	File("data");
		
		 File fs = new File(f1, "res.png");
		
		
		propage = PageFactory.initElements(driver, ProfilePage.class);
		logp = PageFactory.initElements(driver, LoginPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
        docpage=PageFactory.initElements(driver, DoctorRolesPage.class);

		Reporter.log("MediaFile Testcase is runnng..........",true);

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

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Reporter.log("sucessfully loged in and Home page is displayed", true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	      int count=0;
			
			boolean resl = filter.getFilter().isEnabled();
		
			while(count>=0)
			{
			
			if(resl==true)
			{

			     WebDriverWait w1=new WebDriverWait(driver, 20);
			   
			     w1.until(ExpectedConditions.visibilityOf(filter.getFilter()));
			    
			
				   JavascriptExecutor ex = (JavascriptExecutor)driver;
				     ex.executeScript("arguments[0].click();", filter.getFilter());
				     		
			     break;
			}
			else
			{
	     count++;
			}
			}
		

			/*
			 * WebDriverWait pp=new WebDriverWait(driver, 30);
			 * 
			 * pp.until(ExpectedConditions.elementToBeClickable(filter.getAllchat()));
			 */
			
			Thread.sleep(5000);

			filter.getAllchat().click();
			
			WebDriverWait t=new WebDriverWait(driver, 30);
			t.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
		
			Reporter.log("Chat session is sucessfully  displayed in the landing page",true);
			
         int cnt=0;
 	 
         while(cnt>=0)
 	    {
 	    	try
 	    	{
 	    		WebDriverWait oo=new WebDriverWait(driver, 20);
 	    		oo.until(ExpectedConditions.elementToBeClickable(homepge.getChatsesion()));
 	    		homepge.getChatsesion().click();
 	    		break;
 	    	}
 	    	catch (Exception e) 
 	    	{
 	    		Thread.sleep(1000);
 	    		
 	    		WebDriverWait po=new WebDriverWait(driver, 20);
 	    		po.until(ExpectedConditions.elementToBeClickable(filter.getFilter()));
 			
 	    		filter.getFilter().click();
 				
 	    		
 	    		WebDriverWait uu=new WebDriverWait(driver, 20);
 	    		uu.until(ExpectedConditions.elementToBeClickable(filter.getAllchat()));
 				
 	    		filter.getAllchat().click();

                  cnt++;
                  e.printStackTrace();
 	    	}
 	    	
 	    }
			Reporter.log("Media File Test   step ....1",true);

		          
		WebDriverWait wait11 = new WebDriverWait(driver, 30);
		wait11.until(ExpectedConditions.visibilityOf(homepge.getPaperclip()));

	    
	     JavascriptExecutor ex1 = (JavascriptExecutor)driver;
	     ex1.executeScript("arguments[0].click();", homepge.getPaperclip());
	     
		
	
		Reporter.log("Media File Test   step ....2",true);

						
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int val = 0;
		while (val <= 100) {
			try {
				
				WebDriverWait ko=new WebDriverWait(driver, 20);
 	    		ko.until(ExpectedConditions.elementToBeClickable(homepge.getUploadPhoto()));
			
 	    		homepge.getUploadPhoto().click();
				

				homepge.getPhotoUpload()
						.sendKeys(fs.getAbsolutePath());
				
				WebDriverWait nn=new WebDriverWait(driver, 20);
				nn.until(ExpectedConditions.elementToBeClickable(homepge.getSubmitButton()));

				homepge.getSubmitButton().click();
			
				Reporter.log("Media File Test   step ....3",true);

				WebDriverWait www = new WebDriverWait(driver, 80);
				www.until(ExpectedConditions.visibilityOf(logp.getSucess()));

				boolean b = logp.getSucess().getText().contains("file");

				Assert.assertTrue(b);

				Reporter.log(logp.getSucess().getText() + " sucessfully updated", true);	
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				Thread.sleep(6000);
				
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
		     
		//homepge.getMediaFil().click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String fle = homepge.getFile().getText();

		boolean f = fle.contains("Test2");

		Assert.assertTrue(f);

		Reporter.log("media file is sucessfully displayed", true);
		
		Reporter.log("MediaFileTest TestCase is sucessfully done ################################################## TEST IS PASS",true);

	}
}
