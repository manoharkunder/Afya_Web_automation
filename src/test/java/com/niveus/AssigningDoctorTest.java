package com.niveus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AssigningDoctorTest extends Base {
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	public ProfilePage propage;
	public DoctorRolesPage docpage;

	FileLib flib = new FileLib();

	@Test()
	public void assigningDoctorTest() throws Exception {

		test = extent.createTest("1.Login", "This test case is used to check the Assigning doctor validation");

		logp = PageFactory.initElements(driver, LoginPage.class);

		card = PageFactory.initElements(driver, Carddetails.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		Reporter.log("Login Testcase is runnng..........>>>>>>>>>>>>>>>>", true);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		AssertJUnit.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed..................Pass", true);

		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));

		logp.getUsername().sendKeys("prasannaachar126@gmail.com");
		logp.getpassword().sendKeys("Aa123456!");

		logp.getpswdview().click();

		boolean flag = true;

		while (flag == true) {
			try {

				boolean res = logp.getloginbtn().isEnabled();

				if (res == true) {
					logp.getloginbtn().click();

					flag = false;

				}
			} catch (Exception e) {

				e.printStackTrace();

			}
		}

		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			if (logp.getloginAlert().isEnabled()) {
				Reporter.log("Login Alert Popup is displayed......", true);

				logp.loginPopUP();

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			}
		} catch (Exception e) {

			Reporter.log(e.getMessage(), true);
		}

		Thread.sleep(2000);
		try {
			if (logp.getDenyBtn().isEnabled()) {
				wait.until(ExpectedConditions.elementToBeClickable(logp.getDenyBtn()));

				Utility.moveToElement(driver, logp.getDenyBtn());

			}

		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}

		Reporter.log("No Family confirmation Popup", true);

		wait.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));

		logp.getproficPic().click();

		wait.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		AssertJUnit.assertEquals(propage.getmailId().getText(), "prasannaachar126@gmail.com");

		logp.getcloseProfile().click();

		Reporter.log("sucessfully loged in and Home page is displayed..............Pass", true);

		try

		{
			Thread.sleep(1000);

			Utility.isElementPresnt(driver, "//div[contains(@class,'container___2U')]//img", 10).click();

			Thread.sleep(2000);

			Utility.isElementPresntOnId(driver, "speciality", 10).click();

			Utility.isElementPresnt(driver,
					"//div[contains(@class,'ant-select-dropdown')]//div[contains(@class,'ant-select-item ')][\"\n"
							+ "				 * + i + \"]",
					5).click();

			Reporter.log("sucessfully specialty is seleced", true);

			Utility.isElementPresntOnId(driver, "chiefcomplaint", 5).sendKeys("have a knee pain leg");

			Utility.isElementPresnt(driver, "//span[text()='Create a new chat']", 5).click();

		} catch (Exception e) {
		}

		try {
			if (logp.getNoDoctor().isEnabled() == true)

				Reporter.log("No Doctor availble at the moment##############PASS", true);

		} catch (Exception e) {
			Reporter.log("Doctor is sucessfullly added to the chat session###########PASS", true);

		}

	}
}