package com.niveus;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AddSpecialityTest extends Base {

	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public HomePage homepge;
	public CloseCode close;
	public ProfilePage propage;
	public FilterSection filter;
	WebDriverWait wait;

	@Test()
	public void addspecialityValidationTest() throws Exception {

		test = extent.createTest("3.AddSpeciality",
				"This test case is to check whether whether User is able to add the speciality");
		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		filter = PageFactory.initElements(driver, FilterSection.class);

		close = PageFactory.initElements(driver, CloseCode.class);

		Reporter.log("add specialty Testcase is runnng..........", true);

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
						Reporter.log("Login Alert Popup found !!!!!!!!!!!......", true);

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

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(filter.getFilter()));

			filter.getFilter().click();

			wait.until(ExpectedConditions.elementToBeClickable(filter.getAllchat()));

			filter.getAllchat().click();
			Thread.sleep(2000);

			wait.until(ExpectedConditions.elementToBeClickable(filter.getChatSession()));

			filter.getChatSession().click();

		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
		}

		Reporter.log("chat session   displayed in Add specialty..!!!!!.......", true);

		try {

			Thread.sleep(4000);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Utility.isElementPresnt(driver, "//input[@id='input']", 10).sendKeys("@spec");

			Utility.isElementPresnt(driver, "//div[@class='list-sort-demo-list']", 10).click();

		} catch (Exception e) {

		}

		Reporter.log("Speciality list is displaying sucessfully", true);

		try {

			boolean fg1 = Utility.isElementPresnt(driver, "//div[contains(@class,'chat_content_items_')]", 10)
					.isDisplayed();

			Assert.assertTrue(fg1);

		} catch (Exception e) {
		}

		Reporter.log("Doctor is sucessfully added to the chat session", true);

		Reporter.log("AddSpeciality TestCase is sucessfully done ############################# TEST IS PASS", true);

	}
}
