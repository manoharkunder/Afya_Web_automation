package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PatientInfoTest extends Base {

	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public ProfilePage propage;
	public HomePage homepge;

	@Test()
	public void patientInfoValidationTest() throws Exception {

		test = extent.createTest("8.PatientInfoTest", "This test case is to check whether patientInfo is working");

		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("PatientInfo Testcase is runnng..........", true);

		WebDriverWait wait2 = new WebDriverWait(driver, 10);

		wait2.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		logp.getUsername().sendKeys("test1prasanna@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");

		logp.getpswdview().click();

		for (int i = 0; i <= 10; i++) {
			try {
				boolean res = logp.getloginbtn().isEnabled();
				if (res == true) {
					logp.getloginbtn().click();

					break;
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

						break;

					}

				}
			} catch (Exception e) {

			}
		} /*
			 * 
			 * 
			 * wait2.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider())
			 * );
			 * 
			 * ut.moveToElement(driver, docpage.getSubProvider());
			 * 
			 * boolean flag = docpage.getSubProvider().getText().contains("Submitter");
			 * Assert.assertTrue(flag); Reporter.log(docpage.getSubProvider().getText() +
			 * " role is selected", true);
			 * 
			 * WebDriverWait wt = new WebDriverWait(driver, 10);
			 * wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));
			 * 
			 * logp.getproficPic().click();
			 * 
			 * WebDriverWait wait1 = new WebDriverWait(driver, 10);
			 * wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));
			 * 
			 * Assert.assertEquals(propage.getmailId().getText(),
			 * "test1prasanna@gmail.com");
			 * 
			 * logp.getcloseProfile().click();
			 * 
			 * Reporter.log("sucessfully loged in and Home page is displayed", true);
			 * 
			 * int btn = 0; while (btn==0) {
			 * 
			 * try { docpage.getNewSubmitter().click(); break;
			 * 
			 * } catch (Exception e) { // TODO: handle exception } }
			 * 
			 * wait1.until(ExpectedConditions.visibilityOf(docpage.getdMonth()));
			 * docpage.getdMonth().sendKeys("11"); docpage.getDate().sendKeys("11");
			 * docpage.getyear().sendKeys("1998");
			 * 
			 * WebDriverWait tt = new WebDriverWait(driver, 10);
			 * 
			 * tt.until(ExpectedConditions.visibilityOf(docpage.getPatientSearch()));
			 * 
			 * docpage.getPatientSearch().sendKeys("prasanna");
			 * 
			 * wait1.until(ExpectedConditions.elementToBeClickable(docpage.getSearchResult()
			 * ));
			 * 
			 * docpage.getSearchResult().click();
			 * 
			 * Reporter.log("Addd new paient step ....1", true);
			 * 
			 * boolean flag1 = true;
			 * 
			 * while (flag1 == true) { try {
			 * 
			 * docpage.getSpeciality().sendKeys("anesthesiology");
			 * 
			 * Thread.sleep(1000);
			 * 
			 * 
			 * docpage.getAnsthesiolgy().click();
			 * 
			 * docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");
			 * 
			 * flag1 = false; break; } catch (Exception e) { } }
			 * 
			 * int count = 0; while (count <= 1) { try { if (docpage.getIcd().isEnabled()) {
			 * 
			 * docpage.getIcd().sendKeys("Hypertensive heart disease with heart failure");
			 * try { Thread.sleep(3000); docpage.getIcdHeart().click(); break;
			 * 
			 * } catch(Exception e) {
			 * 
			 * } }
			 * 
			 * } catch (Exception e) {
			 * Reporter.log("No ICd code.................................", true); count++;
			 * } }
			 * 
			 * int count1 = 0;
			 * 
			 * while (count1 <= 1) { try { if (docpage.getCpt().isEnabled()) {
			 * 
			 * docpage.getCpt().sendKeys("A002"); break;
			 * 
			 * }
			 * 
			 * } catch (Exception e) {
			 * Reporter.log("No cpt code.....................................", true);
			 * count1++; } }
			 * 
			 * try { homepge.getReg().click(); } catch(Exception e) {
			 * 
			 * }
			 * 
			 * boolean flg = true; while (flg == true) { try {
			 * homepge.getChatsesion().click();
			 * 
			 * String lang1 = homepge.getBannerLang1().getText(); Reporter.log(lang1 +
			 * "...........Sucess...", true);
			 * 
			 * Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna"); flg =
			 * false;
			 * 
			 * } catch (Exception e) { } }
			 * 
			 * Reporter.log("Patient  is sucessfully added to the chat session", true);
			 */

		Utility.isElementPresnt(driver, "//span[text()='Submitter Provider']", 10).click();

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");

		Assert.assertTrue(flag);

		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);
		/*
		 * WebDriverWait wt = new WebDriverWait(driver, 10);
		 * wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));
		 */
		Utility.isElementPresnt(driver, "//div[contains(@class,'user_name_')]", 10).click();

		// logp.getproficPic().click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test1prasanna@gmail.com");

		// logp.getcloseProfile().click();

		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img",
				10).click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		/*
		 * int btn = 0; while (btn==0) {
		 * 
		 * try { docpage.getNewSubmitter().click(); break;
		 * 
		 * } catch (Exception e) { } }
		 */

		Utility.isElementPresnt(driver, "//img[@src='/static/add_plus.8284d929.svg']", 10).click();

		wait1.until(ExpectedConditions.visibilityOf(docpage.getdMonth()));

		docpage.getdMonth().sendKeys("11");
		docpage.getDate().sendKeys("11");
		docpage.getyear().sendKeys("1998");

		WebDriverWait tt = new WebDriverWait(driver, 10);

		tt.until(ExpectedConditions.visibilityOf(docpage.getPatientSearch()));

		docpage.getPatientSearch().sendKeys("prasanna");

		// wait1.until(ExpectedConditions.elementToBeClickable(docpage.getSearchResult()));

//	/	docpage.getSearchResult().click();

		Utility.isElementPresnt(driver, "//span[text()=' Select']/..", 10).click();

		Reporter.log("Addd new paient step ....1", true);

		//boolean flag1 = true;
		/*
		 * while (flag1 == true)
		 */
			try {

				// docpage.getSpeciality().sendKeys("anesthesiology");

				Utility.isElementPresntOnId(driver, "specialty", 10).sendKeys("anesthesiology");

				// Thread.sleep(3000);

				// docpage.getAnsthesiolgy().click();

				Utility.isElementPresnt(driver, "//div[text()='Anesthesiology']", 10).click();

				docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");

				Reporter.log("specialty and chief complaint is sucessfullly displayed##################", true);

				//flag1 = false;
				//break;
			} catch (Exception e) {
			}
		
		/*
		 * int count = 0; while (count <= 1)
		 */{
			try {

				if (Utility.isElementPresntOnId(driver, "ICD", 10).isEnabled()) {

					Thread.sleep(2000);

					Utility.isElementPresntOnId(driver, "ICD", 10)
							.sendKeys("Hypertensive heart disease with heart failure");
					try {
						Thread.sleep(3000);
						WebElement icd = Utility.isElementPresnt(driver,
								"//span[text()='Hypertensive heart disease with heart failure']", 10);
						icd.click();
						
						Reporter.log("Sucessfully icd code is selected########################",true);
					//	break;

					} catch (Exception e) {
						Reporter.log("Icd code is not selected>>>>>>>>>>>>>>>>>>>", true);
						e.printStackTrace();
					}
				}

			} catch (Exception e) {
				Reporter.log("No ICd code.................................", true);
			//	count++;
			}
		}
		/*
		 * int count1 = 0;
		 * 
		 * while (count1 <= 1)
		 */ 
			try {
				if (Utility.isElementPresntOnId(driver, "CPT", 10).isEnabled()) {

					// docpage.getCpt().sendKeys("A002");
					Utility.isElementPresntOnId(driver, "CPT", 10).sendKeys("A002");
					//break;

				}

			} catch (Exception e) {
				Reporter.log("No cpt code.....................................", true);
				//count1++;
			}
		

		// homepge.getReg().click();

		Utility.isElementPresnt(driver, "//span[text()='  REGISTER ']", 10).click();

		/*
		 * boolean flg = true; while (flg == true) {
		 */
			try {
				// homepge.getChatsesion().click();
				
				Thread.sleep(2000);

				Utility.isElementPresntOnId(driver, "chat_session_items", 10).click();

				String lang1 = homepge.getBannerLang1().getText();

				Reporter.log(lang1 + "...........Sucess...", true);

				Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna");
			//	flg = false;

			} catch (Exception e) {
			}
		

		Reporter.log("Patient  is sucessfully added to the chat session", true);

		try {
				  
				  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				  
				  JavascriptExecutor executor = (JavascriptExecutor) driver;
				  executor.executeScript("arguments[0].click();", homepge.getMoreoptions());
				  
				  Reporter.log("Patien Info   Test   step ....5",true);
				  
				 

			Thread.sleep(2000);
		//	WebElement more = Utility.isElementPresnt(driver, "//span[@aria-label='more']", 10);
		//	more.click();

		} catch (Exception e) {

			e.printStackTrace();

		}

		
		  WebDriverWait wrt=new WebDriverWait(driver, 20);
		  wrt.until(ExpectedConditions.elementToBeClickable(homepge.getPatientinfo()));
		  
		  homepge.getPatientinfo().click();
		 

			/*
			 * WebElement info=Utility.isElementPresnt(driver,
			 * "//ul[@role='menu']/li[text()='Patient info']", 10); info.click();
			 */
		 /*
		 * WebDriverWait pp = new WebDriverWait(driver, 100);
		 * pp.until(ExpectedConditions.visibilityOf(homepge.getPatientDetails()));
		 */

		Utility.isElementPresnt(driver, "//div[contains(@class,'patient_info_modal_content')]", 10);

		String chatmemeber = homepge.getPatientDetails().getText();

		Reporter.log(chatmemeber + " sucess", true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean flag4 = chatmemeber.contains("Prasanna");
		Assert.assertTrue(flag4);

		Reporter.log("patient name is displayed  sucesssfully", true);

		boolean flag5 = chatmemeber.contains("11-11-1998");
		Assert.assertTrue(flag5);
		Reporter.log("patient date of birth  is displayed  sucesssfully", true);
		boolean flag6 = chatmemeber.contains("Years Old");
		Assert.assertTrue(flag6);
		Reporter.log("patient year  is displayed  sucesssfully", true);
		Reporter.log(
				"PatientInfoTest TestCase is sucessfully done ################################################## TEST IS PASS",
				true);
	}
}
