package com.niveus;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UploadPhotosTest extends Base {
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	FileLib flib = new FileLib();
	public ProfilePage propage;
	public Utility ut = new Utility();
	public DoctorRolesPage docpage;

	@Test()

	public void uploadPhotoValidation() throws Exception {

		test = extent.createTest("12.UploadPhotosTest", "This test case is to check user is able to upload the photo");

		File f1 = new File("data");

		File fs = new File(f1, "res.png");

		propage = PageFactory.initElements(driver, ProfilePage.class);
		logp = PageFactory.initElements(driver, LoginPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);
		Reporter.log("UploadPhoto Testcase is runnng..........", true);

		WebDriverWait wait00 = new WebDriverWait(driver, 10);
		wait00.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

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
		 * wait2.until(ExpectedConditions.visibilityOf(filter.getFilter()));
		 * 
		 * boolean resl = filter.getFilter().isEnabled(); while(resl==true) {
		 * 
		 * try { if(resl) { filter.getFilter().click();
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
		 * 
		 * 
		 * 
		 * WebDriverWait wait11 = new WebDriverWait(driver, 10);
		 * wait11.until(ExpectedConditions.elementToBeClickable(homepge.getPaperclip()))
		 * ;
		 * 
		 * homepge.getPaperclip().click();
		 * 
		 * 
		 * driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 */
		/*
		 * homepge.getUploadPhoto().click();
		 * 
		 * Thread.sleep(3000); homepge.getPhotoUpload().sendKeys(fs.getAbsolutePath());
		 * 
		 * homepge.getSubmitButton().click();
		 * 
		 * WebDriverWait www = new WebDriverWait(driver, 50);
		 * www.until(ExpectedConditions.visibilityOf(logp.getSucess()));
		 */

		Utility.isElementPresnt(driver, "//span[text()='Submitter Provider']", 10).click();

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");

		Assert.assertTrue(flag);

		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);
		/*
		 * WebDriverWait wt = new WebDriverWait(driver, 10);
		 * wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));
		 */
		Utility.isElementPresnt(driver, "//div[contains(@class,'user_name_')]", 10).click();

		// logp.getproficPic().click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		// logp.getcloseProfile().click();

		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img",
				10).click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		/*
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(filter.getFilter()));
		 * 
		 * boolean resl = filter.getFilter().isEnabled(); while(resl==true) {
		 * 
		 * try { if(resl) { filter.getFilter().click();
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
		 * log("Sucessfully chat session is displayed Upload Doccument>>>>>>>>>>>>>>",
		 * true);
		 * 
		 * homepge.getChatsesion().click();
		 * 
		 */

		Utility.isElementPresnt(driver, "//div[@role='filter_holder']/span", 15).click();

		try {

			WebElement Allchat = Utility.isElementPresnt(driver, "//span[text()=' All Chats']", 10);
			Allchat.click();

		} catch (Exception e) {
			Reporter.log("error is displaying");
		}
		Thread.sleep(2000);
		WebElement chat = Utility.isElementPresnt(driver, "//li[@id='chat_session_items']", 15);

		chat.click();

		Reporter.log("chat session is sucessfully displayed ..>>>>>>>>>>>", true);

		Utility.isElementPresnt(driver, "//div[contains(@class,'attachment___')]", 10).click();

		/*
		 * WebDriverWait wait11 = new WebDriverWait(driver, 10);
		 * wait11.until(ExpectedConditions.elementToBeClickable(homepge.getPaperclip()))
		 * ;
		 * 
		 * homepge.getPaperclip().click();
		 * 
		 * driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 * 
		 * Thread.sleep(3000);
		 */

		Utility.isElementPresnt(driver, "//div[@role='tab' and text()='Upload Photos']", 10).click();

		Utility.isElementPresnt(driver, "(//input[@type='file'])[2]", 10).sendKeys(fs.getAbsolutePath());
//		homepge.getUploadFile().sendKeys(fs.getAbsolutePath());

//		wait.until(ExpectedConditions.elementToBeClickable(homepge.getSubmitButton()));

		// Thread.sleep(2000);

		Utility.isElementPresnt(driver, "//button[text()='Submit']", 15).click();

		// homepge.getSubmitButton().click();

		/*
		 * WebDriverWait www = new WebDriverWait(driver, 10);
		 * www.until(ExpectedConditions.visibilityOf(logp.getSucess()));
		 */

		boolean b = Utility.isElementPresnt(driver, "//span[text()='file has been successfully uploaded.']", 10)
				.isDisplayed();

		Assert.assertTrue(b);

		Reporter.log(" file  has been sucessfully updated", true);

		Reporter.log("UploadPhotosTest is sucessfully done ############################# TEST IS PASS", true);

	}

}
