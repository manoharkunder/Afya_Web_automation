package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddNewPatientTest extends Base {
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public HomePage homepge;
	public ProfilePage propage;

	@Test()
	public void addNewPatientTest() throws Exception {

		test = extent.createTest("4.AddNewPatient", "This test case is to check submitteble to add the patient");

		Reporter.log("Addnewpatient testcase is running.............############", true);

		Reporter.log("Enter the url sucessfully###################", true);

		logp = PageFactory.initElements(driver, LoginPage.class);
		card = PageFactory.initElements(driver, Carddetails.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		propage = PageFactory.initElements(driver, ProfilePage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);


		WebDriverWait wait00 = new WebDriverWait(driver, 10);

		wait00.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		logp.getUsername().sendKeys("test2prasanna@gmail.com");
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
		}

		/*
		 * WebDriverWait wait2 = new WebDriverWait(driver, 10);
		 * 
		 * wait2.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider())
		 * );
		 * 
		 * ut.moveToElement(driver, docpage.getSubProvider());
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
	
		//logp.getproficPic().click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		//logp.getcloseProfile().click();
		
		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img", 10).click();

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

	//	wait1.until(ExpectedConditions.elementToBeClickable(docpage.getSearchResult()));

//	/	docpage.getSearchResult().click();
		
		Utility.isElementPresnt(driver, "//span[text()=' Select']/..", 10).click();

		Reporter.log("Addd new paient step ....1", true);

		boolean flag1 = true;

		while (flag1 == true) {
			try {
				
			//	docpage.getSpeciality().sendKeys("anesthesiology");
				
            Utility.isElementPresntOnId(driver, "specialty", 10).sendKeys("anesthesiology");				
			
            //Thread.sleep(3000);

			//	docpage.getAnsthesiolgy().click();
            
            Utility.isElementPresnt(driver, "//div[text()='Anesthesiology']", 10).click();

				docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");

				flag1 = false;
				break;
			} catch (Exception e) {
			}
		}

		int count = 0;
		while (count <= 1) {
			try {
				if (Utility.isElementPresntOnId(driver, "ICD", 10).isEnabled()) 
				{

					Utility.isElementPresntOnId(driver, "ICD", 10).sendKeys("Hypertensive heart disease with heart failure");
				   try
				   {
					   Thread.sleep(3000);
				//	docpage.getIcdHeart().click();
					   
					   Utility.isElementPresnt(driver, "//span[text()='Hypertensive heart disease with heart failure']", 10).click();
					break;

				}
				catch(Exception e)
				{
					
				}
				}

			} catch (Exception e) {
				Reporter.log("No ICd code.................................", true);
				count++;
			}
		}

		int count1 = 0;

		while (count1 <= 1) {
			try {
				if (Utility.isElementPresntOnId(driver, "CPT", 10).isEnabled()) {

					//docpage.getCpt().sendKeys("A002");
					Utility.isElementPresntOnId(driver, "CPT", 10).sendKeys("A002");
					break;

				}

			} catch (Exception e) {
				Reporter.log("No cpt code.....................................", true);
				count1++;
			}
		}

		//homepge.getReg().click();
		
		Utility.isElementPresnt(driver, "//span[text()='  REGISTER ']", 10).click();

		boolean flg = true;
		while (flg == true) {
			try {
			//	homepge.getChatsesion().click();

				Utility.isElementPresntOnId(driver, "chat_session_items", 10).click();
				
				String lang1 = homepge.getBannerLang1().getText();
				
				Reporter.log(lang1 + "...........Sucess...", true);

				Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna");
				flg = false;

			} catch (Exception e) {
			}
		}

		Reporter.log("Patient  is sucessfully added to the chat session", true);
		Reporter.log("AddNewPatientTest TestCase is sucessfully done ############################# TEST IS PASS", true);

	}

}
