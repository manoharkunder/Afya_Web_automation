package com.niveus;

import java.io.File;
import java.util.concurrent.TimeUnit;

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

	@Test

	public void uploadPhotoValidation() throws Exception {

		test = extent.createTest("12.UploadPhotosTest", "This test case is to check user is able to upload the photo");

		File f1 = new File("data");

		File fs = new File(f1, "res.png");

		propage = PageFactory.initElements(driver, ProfilePage.class);
		logp = PageFactory.initElements(driver, LoginPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);
		filter = PageFactory.initElements(driver, FilterSection.class);

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed", true);


		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));
		logp.getUsername().sendKeys("prasannaachar126@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");
		logp.getpswdview().click();

		for (int i = 0; i <= 10; i++) {
			try {
				logp.getloginbtn().click();
				Thread.sleep(4000);
				boolean res = logp.getloginbtn().isEnabled();
				if (res == false) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "prasannaachar126@gmail.com");

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		WebDriverWait till = new WebDriverWait(driver, 100);
		till.until(ExpectedConditions.elementToBeClickable(filter.getFilter()));

		int count = 0;

		boolean resl = filter.getFilter().isEnabled();
		while (count >= 0) {

			if (resl == true) {

				WebDriverWait w1 = new WebDriverWait(driver, 100);
				w1.until(ExpectedConditions.visibilityOf(filter.getFilter()));
				filter.getFilter().click();
				break;
			} else {
				count++;
			}
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		filter.getAllchat().click();

		WebDriverWait wait33 = new WebDriverWait(driver, 30);
		wait33.until(ExpectedConditions.elementToBeClickable(homepge.getChatsesion()));

		homepge.getChatsesion().click();

		WebDriverWait wait11 = new WebDriverWait(driver, 30);
		wait11.until(ExpectedConditions.elementToBeClickable(homepge.getPaperclip()));

		homepge.getPaperclip().click();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		homepge.getUploadPhoto().click();

		homepge.getPhotoUpload().sendKeys(fs.getAbsolutePath());

		homepge.getSubmitButton().click();

		WebDriverWait www = new WebDriverWait(driver, 50);
		www.until(ExpectedConditions.visibilityOf(logp.getSucess()));

		boolean b = logp.getSucess().getText().contains("file");

		Assert.assertTrue(b);

		Reporter.log(logp.getSucess().getText() + " sucessfully updated", true);

		Reporter.log("UploadPhotosTest is sucessfully done ############################# TEST IS PASS", true);

	}

}
