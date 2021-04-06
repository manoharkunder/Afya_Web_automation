package com.niveus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CloseCodeTest extends Base {
	public Registeration registerp;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public ProfilePage propage;
	public HomePage homepge;
	public CloseCode close;
	public FilterSection filter;

	@Test()

	public void closeCodeValidationTest() throws Exception {

		test = extent.createTest("2.CloseCode", "This test case is to check whether close code is working");

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		filter = PageFactory.initElements(driver, FilterSection.class);

		close = PageFactory.initElements(driver, CloseCode.class);

		try
		{
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

		// logp.getcloseProfile().click();

		try
		{
		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img",
				10).click();
		}
		catch (Exception e) {
		}

		Reporter.log("sucessfully loged in and Home page is displayed", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(filter.getFilter()));

			filter.getFilter().click();

			wait.until(ExpectedConditions.elementToBeClickable(filter.getAllchat()));

			filter.getAllchat().click();

		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(filter.getChatSession()));

			filter.getChatSession().click();
		} catch (Exception e) {
		}
		Reporter.log("chat session is sucessfully displayed in Add specialty..>>>>>>>>>>>", true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(filter.getFilter()));

			filter.getFilter().click();

			wait.until(ExpectedConditions.elementToBeClickable(filter.getAllchat()));

			filter.getAllchat().click();

		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(filter.getChatSession()));

		filter.getChatSession().click();

		Reporter.log("chat session is sucessfully displayed in Add specialty..>>>>>>>>>>>", true);

		int ch = 1;

		switch (ch) {

		case 1:

			Thread.sleep(4000);

			Utility.isElementPresnt(driver,
					"//div[@class='attachment___2t6lp']/ancestor::div[@class='chatinputcontainer___3NJiE']//input", 10)
					.sendKeys("@close");

			Utility.isElementPresnt(driver, "//span[text()='Consultation Complete']", 10).click();

			Utility.isElementPresnt(driver, "//div[contains(@title,' has marked this consultation as Complete, ')]",
					10);
			boolean b = close.getConsultcomplete().getText().contains("consultation as Complete");
			AssertJUnit.assertTrue(b);
			Reporter.log(close.getConsultcomplete().getText() + " sucess", true);

			Reporter.log("CloseCode TestCase is sucessfully done ############################# TEST IS PASS", true);

		}
		}
		catch (Exception e) {
		}
		
	}
}
