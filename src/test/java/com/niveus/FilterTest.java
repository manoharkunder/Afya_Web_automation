package com.niveus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class FilterTest extends Base {
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	FileLib flib = new FileLib();
	public ProfilePage propage;
	public DoctorRolesPage docpage;
	Utility ut = new Utility();

	@Test()
	public void filterValidationTest() throws Exception {

		test = extent.createTest("6.FilterTest", "This test case is to check whether Filter is working");

		logp = PageFactory.initElements(driver, LoginPage.class);
		card = PageFactory.initElements(driver, Carddetails.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		propage = PageFactory.initElements(driver, ProfilePage.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		Reporter.log("FilterTest Testcase is runnng..........", true);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		AssertJUnit.assertEquals(logp.getloginbtn().getText(), "Login");
		Reporter.log("Login page is sucessfully displayed", true);

		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));

		logp.getUsername().sendKeys("test2prasanna@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");

		logp.getpswdview().click();

		int count = 0;
		while (count == 0) {
			try {
				boolean res = logp.getloginbtn().isEnabled();
				if (res == true) {
					logp.getloginbtn().click();
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		try {
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			if (logp.getloginAlert().isEnabled()) {

				if (true) {
					Reporter.log("Login Alert Popup is displayed......", true);

					logp.getloginAlert().click();

				}

			}
		} catch (Exception e) {

			Reporter.log(e.getMessage(), true);
		}

		Reporter.log("No Alert Popup...............", true);

		wait.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider()));

		Utility.moveToElement(driver, docpage.getSubProvider());

		wait.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));

		logp.getproficPic().click();

		wait.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		AssertJUnit.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		logp.getcloseProfile().click();

		Reporter.log("sucessfully logedin and Home page is displayed", true);

		try {
			wait.until(ExpectedConditions.visibilityOf(homepge.getAllChat()));

			Utility.isElementPresnt(driver, "//span[text()='All Chats']", 12).click();
		} catch (Exception e) {

			e.getMessage();
		}

		Thread.sleep(2000);

		String chat = Utility.isElementPresnt(driver, "//li[@id='chat_session_items']", 10).getText();

		Reporter.log("chat session is sucessfully displayed in Filter Test..>>>>>>>>>>>", true);

		Reporter.log(chat, true);

		String newtime = "";
		String StrOld = "";

		if (chat.equalsIgnoreCase("ago")) {
			Reporter.log("First time stmp is  displayed........###########", true);
			Thread.sleep(2000);
			newtime = Utility.isElementPresnt(driver, "//div[@class='chatItem___1pptZ']//div[2]//div[2]", 10).getText();
		} else {
			Reporter.log("second time stamp is taken.........############", true);
			Thread.sleep(2000);
			StrOld = Utility.isElementPresnt(driver, "//div[@class='chatItem___1pptZ']//div[2]//div[2]", 10).getText();
			newtime = StrOld;

		}

		Reporter.log(newtime, true);
		try {
		} catch (Exception e) {

		}

		wait.until(ExpectedConditions.visibilityOf(filter.getSorting()));

		Utility.isElementPresnt(driver, "//img[@src='/static/sort.260d578a.svg']", 10).click();

		try {

			Utility.isElementPresnt(driver, "//span[text()='Newest']", 10).click();

		} catch (Exception e) {

		}

		Thread.sleep(2000);
		Utility.isElementPresnt(driver, "//li[@id='chat_session_items']", 10).getText();

		Reporter.log("chat session is sucessfully displayed in Filter Test..>>>>>>>>>>>", true);

		String oldtime = "";
		if (chat.contains("old")) {
			Thread.sleep(5000);
			oldtime = Utility.isElementPresnt(driver, "//div[@class='chatItem___1pptZ']//div[2]//div[2]", 10).getText();

		} else {
			Thread.sleep(5000);
			String time = Utility.isElementPresnt(driver, "//div[@class='chatItem___1pptZ']//div[2]//div[2]", 10)
					.getText();

			oldtime = time;

		}

		Reporter.log(oldtime, true);

		Assert.assertNotEquals(newtime, oldtime);

		Reporter.log("filter is sucessfully applied", true);

		Reporter.log("Filter Test is sucessfully done ############################# TEST IS PASS", true);
	}
}
