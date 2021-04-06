package com.niveus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ResponderStatusTest extends Base {

	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public ProfilePage propage;
	public HomePage homepge;
	public CloseCode close;
	public FilterSection filter;

	@Test()
	public void statusValidation() throws Exception {

		test = extent.createTest("11.ResponderStatus", "This test case is to check Responder status");

		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		filter = PageFactory.initElements(driver, FilterSection.class);

		close = PageFactory.initElements(driver, CloseCode.class);

		Reporter.log("Responder Status Testcase is runnng..........", true);

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

		wait.until(ExpectedConditions.visibilityOf(docpage.getResponder()));

		boolean flag = docpage.getResponder().isEnabled();

		Utility.moveToElement(driver, docpage.getResponder());

		AssertJUnit.assertTrue(flag);

		Reporter.log(docpage.getResponder().getText() + " role is selected", true);

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

		Thread.sleep(2000);

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		String result = docpage.getUserstate().getText();

		wait.until(ExpectedConditions.elementToBeClickable(docpage.getStatus()));

		docpage.getStatus().click();

		Thread.sleep(3000);

		String result1 = docpage.getUserstate().getText();

		if (result1 != result) {
			Reporter.log(result + " is not equal to " + result1 + " status is sucessfully changed ", true);

		}

		Reporter.log("ResponderStatus TestCase is sucessfully done ############################# TEST IS PASS", true);

	}

}
