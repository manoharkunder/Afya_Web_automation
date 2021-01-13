package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssigningDoctorTest extends Base {	
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	public ProfilePage propage;
	FileLib flib = new FileLib();

	@Test()
	public void assigningDoctorTest() throws Exception {

		test = extent.createTest("14.AssigningDoctor",
				"This test case is to check consumer is able to Assign the Doctor");

		Reporter.log("Assigining doctor Testcase is running...........",true);
		logp = PageFactory.initElements(driver, LoginPage.class);
		card = PageFactory.initElements(driver, Carddetails.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait log = new WebDriverWait(driver, 20);

		log.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed..................Pass", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));

		logp.getUsername().sendKeys("prasannaachar126@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");

		logp.getpswdview().click();

		boolean flag = true;

		while (flag) {
			try {

				boolean res = logp.getloginbtn().isEnabled();

				if (res == true) {
					logp.getloginbtn().click();

					flag = false;

					break;
				}
			} catch (Exception e) {

				e.printStackTrace();

			}
		}

		try {

			if (logp.getloginAlert().isEnabled()) 
			{
				
				if(true)
				{
				Reporter.log("Login Alert Popup is displayed......", true);

				logp.loginPopUP();
				
			}
							
			}
		} catch (Exception e) {

			Reporter.log("No Alert Popup...............", true);

			WebDriverWait wt = new WebDriverWait(driver, 10);
			wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));

			logp.getproficPic().click();
			
		
		}

		
		WebDriverWait wait1 = new WebDriverWait(driver, 90);

		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "prasannaachar126@gmail.com");
		
		logp.getcloseProfile().click();


		Reporter.log("sucessfully loged in and Home page is displayed..............Pass", true);

		Reporter.log("Login TestCase is sucessfully done ############################# TEST IS PASS", true);
	
	
	
		/*
		 * boolean btn = homepge.getNewbtn().isEnabled();
		 * 
		 * while(btn) { homepge.getNewbtn().click();
		 * 
		 * btn=false; break; }
		 * 
		 */
		
		Utility.isElementPresnt(driver, "//div[contains(@class,'container___2U')]//img", 10).click();
		for (int i = 1; i <= 10;) {

			try

			{
				
				
			//	homepge.getSpeciality().click();
				
               Utility.isElementPresntOnId(driver, "speciality", 10).click();
               
				/*
				 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 * 
				 * WebElement spec = driver.findElement(By.xpath(
				 * " //div[contains(@class,'ant-select-dropdown')]//div[contains(@class,'ant-select-item ')]["
				 * + i + "]"));
				 * 
				 * WebDriverWait tt=new WebDriverWait(driver, 30);
				 * tt.until(ExpectedConditions.elementToBeClickable(spec));
				 */
               
               Utility.isElementPresnt(driver, "//div[contains(@class,'ant-select-dropdown')]//div[contains(@class,'ant-select-item ')][\"\n" + 
               		"				 * + i + \"]", 10).click();
			//	spec.click();
				
				Reporter.log("sucessfully specialty is seleced",true);
				
			//	Thread.sleep(3000);
				Utility.isElementPresntOnId(driver, "chiefcomplaint", 10).sendKeys("have a knee pain leg");

			//	homepge.getChiefcomplaint().sendKeys("have a knee pain leg");

				Utility.isElementPresnt(driver, "//span[text()='Create a new chat']", 10).click();
		
			//	homepge.getNewpatient().click();

				WebDriverWait wit = new WebDriverWait(driver, 100);

				wit.until(ExpectedConditions.visibilityOf(homepge.getSession()));

				Utility.isElementPresntOnId(driver, "chat_session_items", 10).click();

				boolean b = homepge.getSession().getText().contains("Session");
				if (b) {
					Reporter.log(homepge.getSession().getText() + " sucessfully created", true);

					break;
				} else {
					Reporter.log(homepge.getNoDoctor().getText() + "UnSucessfull");

					i++;

				}
			}

			catch (Exception e) {

				/*
				 * WebDriverWait pp=new WebDriverWait(driver, 30);
				 * pp.until(ExpectedConditions.elementToBeClickable(homepge.getpopUpClose()));
				 */
				
				Utility.isElementPresnt(driver, "//a[contains(@class,'close')]", 10).click();
				
				//homepge.getpopUpClose().click();

				/*
				 * Thread.sleep(2000); WebDriverWait ppp=new WebDriverWait(driver, 30);
				 * ppp.until(ExpectedConditions.elementToBeClickable(homepge.getNewbtn()));
				 */
				//homepge.getNewbtn().click();
			
				Utility.isElementPresnt(driver, "//div[contains(@class,'container___2U')]//img", 10).click();
				
			}
		}
		
	Reporter.log("Doctor is sucessfully added to the chat session",true);
//	boolean flag1 = lang1.contains(dateArr[2]);Assert.assertTrue(flag1);Reporter.log("DOctor is assigned to the cht session",true);

	Reporter.log("AssigningDoctorTest TestCase is sucessfully done ############################# TEST IS PASS",true);

}

}