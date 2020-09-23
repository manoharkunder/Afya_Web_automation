package com.niveus;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssigningDoctorTest extends Base {
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	public ProfilePage propage;
	FileLib flib = new FileLib();

	@Test
	public void assigningDoctorTest() throws Exception {

		test = extent.createTest("14.AssigningDoctor",
				"This test case is to check consumer is able to Assign the Doctor");

		logp = PageFactory.initElements(driver, LoginPage.class);
		card = PageFactory.initElements(driver, Carddetails.class);
		filter = PageFactory.initElements(driver, FilterSection.class);
		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		WebDriverWait log = new WebDriverWait(driver, 20);
		log.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");
		Reporter.log("Login page is sucessfully displayed", true);
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));
		logp.getUsername().sendKeys("vigga@gmail.com");
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

		Assert.assertEquals(propage.getmailId().getText(), "vigga@gmail.com");
		Reporter.log("sucessfully loged in and Home page is displayed", true);

		WebDriverWait wait5 = new WebDriverWait(driver, 80);

		wait5.until(ExpectedConditions.elementToBeClickable(homepge.getNewbtn()));

		boolean out = homepge.getNewbtn().isEnabled();

		int countt = 0;
		while (countt >= 0) {
			if (out == true) {
				homepge.getNewbtn().click();
				break;
			} else {
				countt++;
			}
		}

		for (int i = 1; i <= 10;) {

			try

			{
				homepge.getSpeciality().click();
				driver.findElement(By.xpath(
						" //div[contains(@class,'ant-select-dropdown')]//div[contains(@class,'ant-select-item ')][" + i
								+ "]"))
						.click();

				Thread.sleep(3000);

				homepge.getChiefcomplaint().sendKeys("have a knee pain leg");

				homepge.getNewpatient().click();

				WebDriverWait wit = new WebDriverWait(driver, 200);
				wit.until(ExpectedConditions.visibilityOf(homepge.getSession()));

				boolean b = homepge.getSession().getText().contains("Session");
				if (b) {
					Reporter.log(homepge.getSession().getText() + " sucessfully created", true);

					break;
				} else {
					Reporter.log(homepge.getNoDoctor().getText() + "UnSucessfull");

					i++;

				}
			}

			catch (Exception e) {

				e.printStackTrace();

				homepge.getpopUpClose().click();

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				homepge.getNewbtn().click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}

		Thread.sleep(4000);

	WebDriverWait w = new WebDriverWait(driver, 100);

	w.until(ExpectedConditions.visibilityOf(homepge.getBannerLang1()));

	String lang1 = homepge.getBannerLang1().getText();

	Thread.sleep(5000);

	Date d = new Date();

	String[] dateArr = d.toString().split(" ");

	boolean flag = lang1.contains(dateArr[1]);

	Assert.assertTrue(flag);Reporter.log("Doctor is sucessfully added to the cht session",true);
	boolean flag1 = lang1.contains(dateArr[2]);Assert.assertTrue(flag1);Reporter.log("DOctor is assigned to the cht session",true);System.out.println(lang1);

	Reporter.log("AssigningDoctorTest TestCase is sucessfully done ############################# TEST IS PASS",true);

}

}