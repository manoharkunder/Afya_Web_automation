package com.niveus;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MediaFileTest extends Base {
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	FileLib flib = new FileLib();
	public ProfilePage propage;
	public DoctorRolesPage docpage;
	Utility ut = new Utility();

	@Test(enabled = false)
	public void mediaFileValidation() throws Exception {

		test = extent.createTest("2.MediaFile", "This test case is to check whether close code is working");

		propage = PageFactory.initElements(driver, ProfilePage.class);
		logp = PageFactory.initElements(driver, LoginPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		Reporter.log("MediaFile Testcase is runnng..........", true);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		AssertJUnit.assertEquals(logp.getloginbtn().getText(), "Login");
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));

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

		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img",
				10).click();

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

		wait.until(ExpectedConditions.elementToBeClickable(filter.getChatSession()));

		filter.getChatSession().click();

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

		Reporter.log("chat session is sucessfully displayed in Media File >>>>>>>>>>>", true);

		File f1 = new File("data");

		File fs = new File(f1, "res.png");

		Utility.isElementPresnt(driver, "//div[contains(@class,'attachment___')]", 10).click();

		wait.until(ExpectedConditions.elementToBeClickable(filter.getUploadFile()));

		filter.getUploadFile().click();

		Utility.isElementPresnt(driver, "//input[@type='file']", 10).sendKeys(fs.getAbsolutePath());

		Utility.isElementPresnt(driver, "//button[text()='Submit']", 10).click();

		Thread.sleep(2000);

		Reporter.log("file has been  sucessfully updated", true);

		Reporter.log("UploadPhotosTest is sucessfully done ############################# TEST IS PASS", true);

		try {

			Thread.sleep(2000);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='more']")));

			WebElement more = Utility.isElementPresnt(driver, "//span[@aria-label='more']", 10);

			more.click();

			wait.until(ExpectedConditions.visibilityOf(homepge.getMediaFil()));

			Thread.sleep(2000);

			homepge.getMediaFil().click();

			String fle = Utility.isElementPresnt(driver, "//div[@class='ant-card-meta']", 15).getText();

			boolean f = fle.contains("Testone");

			AssertJUnit.assertTrue(f);

			Reporter.log(
					"MediaFileTest TestCase is sucessfully done ################################################## TEST IS PASS",
					true);
		} catch (Exception e) {
		}

	}
}
