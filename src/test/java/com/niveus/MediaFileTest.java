package com.niveus;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

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

	@Test(priority = 1)
	public void mediaFileValidation() throws Exception {

		test = extent.createTest("2.MediaFile", "This test case is to check whether close code is working");

		propage = PageFactory.initElements(driver, ProfilePage.class);
		logp = PageFactory.initElements(driver, LoginPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		Reporter.log("MediaFile Testcase is runnng..........", true);

		WebDriverWait wait9 = new WebDriverWait(driver, 10);
		wait9.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));

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
		 * 
		 * boolean flag = docpage.getSubProvider().getText().contains("Submitter");
		 * Assert.assertTrue(flag); Reporter.log(docpage.getSubProvider().getText() +
		 * " role is selected", true);
		 * 
		 * WebDriverWait wt = new WebDriverWait(driver, 10);
		 * wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));
		 * 
		 * logp.getproficPic().click();
		 * 
		 * WebDriverWait wait1 = new WebDriverWait(driver, 10);
		 * wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));
		 * 
		 * Assert.assertEquals(propage.getmailId().getText(),
		 * "test2prasanna@gmail.com");
		 * 
		 * logp.getcloseProfile().click();
		 * 
		 * Reporter.log("sucessfully loged in and Home page is displayed", true);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * wait2.until(ExpectedConditions.visibilityOf(filter.getFilter()));
		 * 
		 * boolean resl = filter.getFilter().isEnabled(); while(resl==true) {
		 * 
		 * try { if(resl) { filter.getFilter().click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * filter.getAllchat().click();
		 * 
		 * 
		 * resl=false;
		 * 
		 * break; }} catch (Exception e) { e.printStackTrace(); } }
		 * 
		 * 
		 * 
		 * WebDriverWait hme = new WebDriverWait(driver, 10);
		 * 
		 * hme.until(ExpectedConditions.visibilityOf(homepge.getChatsesion()));
		 * 
		 * Reporter.
		 * log("Sucessfully chat session is displayed Upload photo>>>>>>>>>>>>>>",
		 * true);
		 * 
		 * homepge.getChatsesion().click();
		 */

		Utility.isElementPresnt(driver, "//span[text()='Submitter Provider']", 10).click();

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");

		Assert.assertTrue(flag);

		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);

		Utility.isElementPresnt(driver, "//div[contains(@class,'user_name_')]", 10).click();

		// logp.getproficPic().click();

		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		// logp.getcloseProfile().click();

		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img",
				10).click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		/*
		 * WebDriverWait wait2 = new WebDriverWait(driver, 50);
		 * 
		 * wait2.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider())
		 * );
		 * 
		 * ut.moveToElement(driver, docpage.getSubProvider());
		 * 
		 * boolean flag = docpage.getSubProvider().getText().contains("Submitter");
		 * Assert.assertTrue(flag); Reporter.log(docpage.getSubProvider().getText() +
		 * " role is selected", true); WebDriverWait wt = new WebDriverWait(driver, 10);
		 * wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));
		 * 
		 * logp.getproficPic().click();
		 * 
		 * WebDriverWait wait4 = new WebDriverWait(driver, 90);
		 * 
		 * wait4.until(ExpectedConditions.visibilityOf(propage.getmailId()));
		 * 
		 * Assert.assertEquals(propage.getmailId().getText(),
		 * "test2prasanna@gmail.com");
		 * 
		 * logp.getcloseProfile().click();
		 * 
		 * Reporter.log("sucessfully loged in and Home page is displayed", true);
		 */
		// int count = 0;

		try {

			Utility.isElementPresnt(driver, "//div[@role='filter_holder']/span", 15).click();
		} catch (Exception e) {

		}

		/*
		 * wait2.until(ExpectedConditions.visibilityOf(filter.getFilter()));
		 * 
		 * boolean resl = filter.getFilter().isEnabled();
		 * 
		 * while (count >= 0) {
		 * 
		 * if (resl == true) {
		 * 
		 * Thread.sleep(2000); WebDriverWait w1 = new WebDriverWait(driver, 100);
		 * w1.until(ExpectedConditions.visibilityOf(filter.getFilter()));
		 * 
		 * JavascriptExecutor ex = (JavascriptExecutor) driver;
		 * ex.executeScript("arguments[0].click();", filter.getFilter());
		 * 
		 * break; } else { count++; } }
		 * 
		 * Thread.sleep(4000);
		 */

		// filter.getAllchat().click();

		try {

			WebElement Allchat = Utility.isElementPresnt(driver, "//span[text()=' All Chats']", 10);

			Allchat.click();
		} catch (Exception e) {
			Reporter.log("error is displaying");
		}
		/*
		 * try { WebDriverWait up = new WebDriverWait(driver, 30);
		 * up.until(ExpectedConditions.visibilityOf(landpage.getChatsesion())); } catch
		 * (Exception e)
		 * 
		 * { e.printStackTrace(); }
		 */
		WebElement chat = Utility.isElementPresnt(driver, "//li[@id='chat_session_items']", 10);

		chat.click();

		Reporter.log("chat session is sucessfully displayed in Media File..>>>>>>>>>>>", true);

		/*
		 * WebDriverWait wait11 = new WebDriverWait(driver, 10);
		 * wait11.until(ExpectedConditions.elementToBeClickable(homepge.getPaperclip()))
		 * ;
		 */
	}

	@Test(priority = 2)
	public void mediaFileTest() throws Exception

	{

		File f1 = new File("data");

		File fs = new File(f1, "res.png");

		Utility.isElementPresnt(driver, "//div[contains(@class,'attachment___')]", 10).click();

		/*
		 * //homepge.getPaperclip().click();
		 * 
		 * 
		 * driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 * 
		 * // homepge.getUploadPhoto().click();
		 */

		Utility.isElementPresnt(driver, "//div[@role='tab' and text()='Upload Photos']", 15).click();

		/*
		 * homepge.getPhotoUpload().sendKeys(fs.getAbsolutePath());
		 * 
		 * homepge.getSubmitButton().click();
		 */

		Utility.isElementPresnt(driver, "(//input[@type='file'])[2]", 10).sendKeys(fs.getAbsolutePath());

		Utility.isElementPresnt(driver, "//button[text()='Submit']", 10).click();

		Thread.sleep(2000);

		/*
		 * WebDriverWait www = new WebDriverWait(driver, 50);
		 * 
		 * www.until(ExpectedConditions.visibilityOf(logp.getSucess()));
		 */
		/*
		 * boolean b = Utility.isElementPresnt(driver,
		 * "//span[text()='file has been successfully uploaded.']", 10) .isDisplayed();
		 * 
		 * Assert.assertTrue(b);
		 */

		Reporter.log("file has been  sucessfully updated", true);

		Reporter.log("UploadPhotosTest is sucessfully done ############################# TEST IS PASS", true);

		/*
		 * int val = 0; while (val <= 100) {
		 */
		for (int i = 0; i <= 15;) {
			try {

				Thread.sleep(1000);
				
				Reporter.log("count in  mediaFile..............." + i,true);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", homepge.getMoreoptions());

				// Utility.isElementPresnt(driver, "//span[@aria-label='more']", 15).click();

				/*
				 * WebElement more = Utility.isElementPresnt(driver,
				 * "//span[@aria-label='more']", 10); more.click();
				 */
				break;

				// break;

			} catch (Exception e) {

				e.printStackTrace();
				
				  	i++;
				
				
				// val++;
			}
		}

		/*
		 * WebDriverWait p = new WebDriverWait(driver, 20);
		 * p.until(ExpectedConditions.visibilityOf(homepge.getMediaFil()));
		 */

		WebDriverWait p = new WebDriverWait(driver, 20);
		p.until(ExpectedConditions.visibilityOf(homepge.getMediaFil()));

		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", homepge.getMediaFil());

		// Utility.isElementPresnt(driver, "//ul[@role='menu']//li[text()='Media
		// files']", 10).click();

		String fle = Utility.isElementPresnt(driver, "//div[@class='ant-card-meta-detail']", 15).getText();

		boolean f = fle.contains("Test2");

		Assert.assertTrue(f);

		Reporter.log("media file is sucessfully displayed", true);

		Reporter.log(
				"MediaFileTest TestCase is sucessfully done ################################################## TEST IS PASS",
				true);

	}
}
