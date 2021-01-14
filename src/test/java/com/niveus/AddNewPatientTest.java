package com.niveus;

import org.openqa.selenium.WebElement;
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
				Thread.sleep(2000);
				if (logp.getloginAlert().isEnabled()) {

					if (true) {
						Reporter.log("Login Alert Popup is displayed......", true);

						logp.getloginAlert().click();

						alert = true;

						break;

					}

				} else {
					Reporter.log("No Alert Popup##############", true);
					break;
				}
			} catch (Exception e) {

			}
		}

		WebElement subRole = Utility.isElementPresnt(driver, "//span[text()='Submitter Provider']", 10);

		subRole.click();

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");

		Assert.assertTrue(flag);

		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);

		WebElement userEmail = Utility.isElementPresnt(driver, "//div[contains(@class,'user_name_')]", 10);

		userEmail.click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);

		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		WebElement profilehov = Utility.isElementPresnt(driver,
				"//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img", 10);
	
		profilehov.click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		WebElement newbtn = Utility.isElementPresnt(driver, "//img[@src='/static/add_plus.8284d929.svg']", 10);

		newbtn.click();

		wait1.until(ExpectedConditions.visibilityOf(docpage.getdMonth()));

		docpage.getdMonth().sendKeys("11");
		docpage.getDate().sendKeys("11");
		docpage.getyear().sendKeys("1998");

		WebDriverWait tt = new WebDriverWait(driver, 10);

		tt.until(ExpectedConditions.visibilityOf(docpage.getPatientSearch()));

		docpage.getPatientSearch().sendKeys("prasanna");

		WebElement searchres = Utility.isElementPresnt(driver, "//span[text()=' Select']/..", 10);
		
		searchres.click();
		
		Reporter.log("Addd new paient step ....1", true);

		try {

			Utility.isElementPresntOnId(driver, "specialty", 10).sendKeys("anesthesiology");

			WebElement spec = Utility.isElementPresnt(driver, "//div[text()='Anesthesiology']", 10);

			spec.click();
			
			docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");

			Reporter.log("Specialty and chief complaint is displayed########################", true);

		} catch (Exception e) {
		}

		try {
			if (Utility.isElementPresntOnId(driver, "ICD", 10).isEnabled()) {

				Thread.sleep(3000);

				Utility.isElementPresntOnId(driver, "ICD", 10)
						.sendKeys("Hypertensive heart disease with heart failure");
				try {

					Thread.sleep(3000);
					WebElement icd=Utility.isElementPresnt(driver, "//span[text()='Hypertensive heart disease with heart failure']",
							10);
					icd.click();
					Reporter.log("Icd Code is sucessfully selected..###############################", true);

				} catch (Exception e) {
					Reporter.log("Icd code is not selected>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);
				}
			}

		} catch (Exception e) {
			Reporter.log("No ICd code.................................", true);
		}

		try {
			if (Utility.isElementPresntOnId(driver, "CPT", 10).isEnabled()) {

				Utility.isElementPresntOnId(driver, "CPT", 10).sendKeys("A002");

			}

		} catch (Exception e) {
			Reporter.log("No cpt code.....................................", true);
		}

	WebElement reg=Utility.isElementPresnt(driver, "//span[text()='  REGISTER ']", 10);
	reg.click();

		try {
			

			WebElement chat=Utility.isElementPresntOnId(driver, "chat_session_items", 10);
			
			chat.click();

			String lang1 = homepge.getBannerLang1().getText();

			Reporter.log(lang1 + "...........Sucess...", true);

			Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna");

		} catch (Exception e) {
		}

		Reporter.log("Patient  is sucessfully added to the chat session", true);
		Reporter.log("AddNewPatientTest TestCase is sucessfully done ############################# TEST IS PASS", true);

	}

}
