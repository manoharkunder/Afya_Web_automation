package com.niveus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ChatMemberTest extends Base {

	public Registeration registerp;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public ProfilePage propage;
	public HomePage homepge;
	public FilterSection filter;

	@Test()

	public void chatMemeberValidation() throws Exception {

		test = extent.createTest("5.ChatMember", "This test case is to check whether Chat Members are displaying");


		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);
	
		filter = PageFactory.initElements(driver, FilterSection.class);


		Reporter.log("Chatmember Testcase is running............", true);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		AssertJUnit.assertEquals(logp.getloginbtn().getText(), "Login");

		logp.getUsername().sendKeys("test1prasanna@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");

		logp.getpswdview().click();

		boolean flag1 = true;

		while (flag1 == true) {
			try {
				boolean res = logp.getloginbtn().isEnabled();
				if (res == true) {
					logp.getloginbtn().click();
					flag1 = false;
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		boolean alert = false;
		while (alert == false) {
			try {
				if (logp.getloginAlert().isEnabled()) {

					if (true) {
						Reporter.log("Login Alert Popup is displayed......", true);

						logp.getloginAlert().click();

						alert = true;

					}

				}
			} catch (Exception e) {

			}
		}
		
		Thread.sleep(2000);
       
		wait.until(ExpectedConditions.visibilityOf(docpage.getSubProvider()));
		
	    Utility.moveToElement(driver, docpage.getSubProvider());
	    
		boolean flag = docpage.getSubProvider().getText().contains("provider");

		AssertJUnit.assertTrue(flag);

		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			if (docpage.getSkip().isEnabled()) {
				Utility.isElementPresnt(driver, "//span[text()='Skip >']", 5).click();
			}

			else {
				Reporter.log("No Missed call Popup", true);
			}
		} catch (Exception e) {

		}

		Utility.isElementPresnt(driver, "//div[contains(@class,'user_name_')]", 10).click();

		wait.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		AssertJUnit.assertEquals(propage.getmailId().getText(), "test1prasanna@gmail.com");

		// logp.getcloseProfile().click();

		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img",
				10).click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		Utility.isElementPresnt(driver, "//img[@src='/static/add_plus.8284d929.svg']", 10).click();

		wait.until(ExpectedConditions.visibilityOf(docpage.getdMonth()));

		docpage.getdMonth().sendKeys("11");
		docpage.getDate().sendKeys("11");
		docpage.getyear().sendKeys("1998");


		wait.until(ExpectedConditions.visibilityOf(docpage.getPatientSearch()));

		docpage.getPatientSearch().sendKeys("c1");



		Utility.isElementPresnt(driver, "//span[text()=' Select']/..", 10).click();
		

		Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(docpage.getSpeciality()));
        
		docpage.getSpeciality().sendKeys("@4224244");

		
		
			Thread.sleep(2000);

			docpage.getSpeciality().clear();
			
			boolean flg=true;
			
			while (flg==true)
			{
			
				try
				{
			docpage.getChiefcomplaint().click();
			Thread.sleep(2000);
			docpage.getSpeciality().click();
			 if(docpage.getSpeclist().isEnabled())
				 docpage.getSpeclist().click();
			 flg=false;
			
			}
				catch (Exception e) {
				}
				
			}
			
			 
			docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");

			Reporter.log("Specialty and chief complaint is sucessfully displayed", true);

		
	
		 
		try {
			if (Utility.isElementPresntOnId(driver, "ICD", 10).isEnabled()) {

				
				
				boolean fg=true;
				
				while (fg==true)
				{
				
					try
					{
				docpage.getIcdCode().sendKeys("Hypertensive heart disease with heart failure");;
				
				Thread.sleep(2000);
				
				 if(docpage.getIcdHeart().isEnabled())
					 Thread.sleep(1000);
					 docpage.getIcdHeart().click();
					 
				 fg=false;
				
				}
					catch (Exception e) {
						docpage.getCptCode().click();

			      	docpage.getIcdCode().clear();
					}
					
				}
					Reporter.log("Icd code is sucessfully selected##########################", true);
					// break;
			
			}
		}

		catch (Exception e) {
			Reporter.log("No ICd code.................................", true);
		}

		try {
			if (Utility.isElementPresntOnId(driver, "CPT", 10).isEnabled()) {

				Utility.isElementPresntOnId(driver, "CPT", 10).sendKeys("A002");	

			}

		} catch (Exception e) {
			e.getMessage();
		}


		try
		{

		homepge.getConfirmPatient().submit();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
             int cnt=0;
		     while(cnt==0)
		         try
		         {
	
		        	 Thread.sleep(2000);
		        	 
	             wait.until(ExpectedConditions.visibilityOf(filter.getChatSession()));

                  filter.getChatSession().click();
                  cnt++;
		         }
		         catch(Exception e)
		         {
		        	 
		         }
             
			String lang1 = homepge.getBannerLang1().getText();

			Reporter.log(lang1 + "...........Sucess...", true);

			boolean res = docpage.getPatientInfo().getText().contains("C");
         
			AssertJUnit.assertTrue(res);
	

		Reporter.log("Patient  is sucessfully added to the chat session", true);

		for (int i = 0; i <= 15;) {
			try {

				Thread.sleep(2000);

				Reporter.log("Count in chat member>>>>>>>>" + i, true);

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='more']")));
			
				WebElement more = Utility.isElementPresnt(driver, "//span[@aria-label='more']", 10);

				more.click();

				WebElement chatmem = Utility.isElementPresnt(driver, "//span[text()='Chat members']", 15);

				chatmem.click();

				Reporter.log("Chat Member   Test   step ....5", true);
				break;

				// break;

			} catch (Exception e) {

				e.printStackTrace();
				i++;
			}
		}

		wait.until(ExpectedConditions.visibilityOf(docpage.getChatM()));

		String chatmemeber = docpage.getChatM().getText();
		System.out.println(chatmemeber);

		boolean flag2 = chatmemeber.contains("T");
		boolean flag4 = chatmemeber.contains("C");
		AssertJUnit.assertTrue(flag2);
		Reporter.log("Responder 1 name  is displayed sucessfully", true);
		AssertJUnit.assertTrue(flag4);
		Reporter.log("patient name is displayed  sucesssfully", true);

		Reporter.log("ChatMember TestCase is sucessfully done  ############################# TEST IS PASS", true);
	}

}
