package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddSpecialityTest extends Base {

	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public HomePage landpage;
	public CloseCode close;
	public ProfilePage propage;
	public FilterSection filter;

	@Test(priority = 3)
	public void addspecialityValidationTest() throws Exception {

		test = extent.createTest("3.AddSpeciality",
				"This test case is to check whether whether User is able to add the speciality");

		filter = PageFactory.initElements(driver, FilterSection.class);

		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		close = PageFactory.initElements(driver, CloseCode.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		landpage = PageFactory.initElements(driver, HomePage.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		Reporter.log("AddSpecialty testcase is running...........", true);

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 50);
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

		try {
              Thread.sleep(2000);
			if (logp.getloginAlert().isEnabled()) {

				if (true) {
					Reporter.log("Login Alert Popup is displayed......", true);

					logp.getloginAlert().click();

				}

			}
		} catch (Exception e) { 
			

			Reporter.log("No Alert Popup...............", true);
			

		
		}

		WebDriverWait wait2 = new WebDriverWait(driver, 50);

		wait2.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider()));

		ut.moveToElement(driver, docpage.getSubProvider());

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");
		Assert.assertTrue(flag);
		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);
		WebDriverWait wt = new WebDriverWait(driver, 10);
		wt.until(ExpectedConditions.elementToBeClickable(logp.getproficPic()));

		logp.getproficPic().click();

		WebDriverWait wait4 = new WebDriverWait(driver, 90);

		wait4.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");

		logp.getcloseProfile().click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		int count = 0;
		
		wait2.until(ExpectedConditions.visibilityOf(filter.getFilter()));

		boolean resl = filter.getFilter().isEnabled();

		while (count >= 0) {

			if (resl == true) {

				Thread.sleep(2000);
				WebDriverWait w1 = new WebDriverWait(driver, 100);
				w1.until(ExpectedConditions.visibilityOf(filter.getFilter()));

				JavascriptExecutor ex = (JavascriptExecutor) driver;
				ex.executeScript("arguments[0].click();", filter.getFilter());

				break;
			} else {
				count++;
			}
		}

		Thread.sleep(4000);

		filter.getAllchat().click();

		try {
			WebDriverWait up = new WebDriverWait(driver, 30);
			up.until(ExpectedConditions.visibilityOf(landpage.getChatsesion()));
		} catch (Exception e)

		{
			e.printStackTrace();
		}
		Reporter.log("chat session is sucessfully displayed in Add specialty..>>>>>>>>>>>", true);

		WebDriverWait wait11 = new WebDriverWait(driver, 40);

		wait11.until(ExpectedConditions.elementToBeClickable(landpage.getChatsesion()));

		landpage.getChatsesion().click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (int i = 1; i <= 100; i++) {

			try {
				Thread.sleep(5000);

				landpage.getTextarea().sendKeys("@speciality");

				WebElement spcilaity = driver.findElement(By.xpath("//div[@class='list-sort-demo-list'][" + i + "]"));

				WebDriverWait itt = new WebDriverWait(driver, 10);

				itt.until(ExpectedConditions.visibilityOf(spcilaity));

				WebDriverWait waitt = new WebDriverWait(driver, 100);

				waitt.until(ExpectedConditions.elementToBeClickable(spcilaity));

				spcilaity.click();

				break;

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		Reporter.log("Speciality list is displaying sucessfully", true);

		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOf(landpage.getAddSpec()));

		String lang1 = landpage.getAddSpec().getText();

		boolean flag1 = landpage.getAddSpec().isDisplayed();

		Assert.assertTrue(flag1);

		Reporter.log("Doctor is sucessfully added to the chat session", true);

		System.out.println(lang1);

		Reporter.log("AddSpeciality TestCase is sucessfully done ############################# TEST IS PASS", true);

	}
}
