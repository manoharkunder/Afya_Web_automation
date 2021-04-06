package com.niveus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ViewPatientTest extends Base {

	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public HomePage homepge;
	public ProfilePage propage;

	@Test()
	public void patientValidationTest() throws Exception {
		test = extent.createTest("16.ViewPatient", "This test case is to view the added  patient");

		Reporter.log("ViewPatient testcase is running.............############", true);

		Reporter.log("Enter the url sucessfully###################", true);

		logp = PageFactory.initElements(driver, LoginPage.class);
		card = PageFactory.initElements(driver, Carddetails.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		propage = PageFactory.initElements(driver, ProfilePage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		WebDriverWait wait = new WebDriverWait(driver, 20);

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

		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img",
				10).click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		Utility.isElementPresnt(driver, "//img[@src='/static/add_plus.8284d929.svg']", 10).click();

		wait.until(ExpectedConditions.visibilityOf(docpage.getdMonth()));

		docpage.getdMonth().sendKeys("11");
		docpage.getDate().sendKeys("11");
		docpage.getyear().sendKeys("1998");

		wait.until(ExpectedConditions.visibilityOf(docpage.getPatientSearch()));

		docpage.getPatientSearch().sendKeys("prasanna ");

		Utility.isElementPresnt(driver, "//span[text()=' Select']/..", 10).click();

		Reporter.log("Viewpatient TestCase is sucessfully done###################################", true);
	}

}
