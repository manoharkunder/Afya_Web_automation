package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ViewPatientTest extends Base {
	
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public HomePage homepge;
	public ProfilePage propage;
	
	@Test
	public void patientValidationTest()
	{
		test = extent.createTest("16.ViewPatient", "This test case is to view the added  patient");

		Reporter.log("ViewPatient testcase is running.............############", true);

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
		
		Reporter.log("Viewpatient TestCase is sucessfully done###################################", true);
	}

}
