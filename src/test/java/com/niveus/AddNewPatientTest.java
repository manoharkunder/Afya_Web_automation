package com.niveus;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddNewPatientTest extends Base {
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public HomePage homepge;

	@Test
	public void addNewPatientTest() throws Exception {

		test = extent.createTest("4.AddNewPatient", "This test case is to check submitteble to add the patient");
		Reporter.log("Addnewpatient testcase is running.............############", true);
		System.out.println("enter the url sucessfully");
		logp = PageFactory.initElements(driver, LoginPage.class);
		card = PageFactory.initElements(driver, Carddetails.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

		System.out.println("sucessfully logedin");

		
		  WebDriverWait wait = new WebDriverWait(driver, 50);
		  wait.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider()));
		  
		  ut.moveToElement(driver, docpage.getSubProvider());
		 

		Thread.sleep(5000);

		WebDriverWait www = new WebDriverWait(driver, 50);

		www.until(ExpectedConditions.elementToBeClickable(docpage.getNewSubmitter()));

		docpage.getNewSubmitter().click();

		docpage.getSelectDate().sendKeys("11/11/1998");
		docpage.getPatientSearch().sendKeys("prasanna");
		
		WebDriverWait wait1 = new WebDriverWait(driver, 200);

		wait1.until(ExpectedConditions.elementToBeClickable(docpage.getSearchResult()));

		docpage.getSearchResult().click();
		
		Reporter.log("Addd new paient step ....1",true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		docpage.getConbutton().click();

		docpage.getSpeciality().sendKeys("anesthesiology");
		
	     
		/*
		 * WebDriverWait wait2 = new WebDriverWait(driver, 30);
		 * 
		 * wait2.until(ExpectedConditions.elementToBeClickable(docpage.getAnsthesiolgy()
		 * ));
		 */
		
		Thread.sleep(5000);
		
		docpage.getAnsthesiolgy().click();

		docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");
       
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		docpage.getIcd().sendKeys("Hypertensive heart disease with heart failure");


		Reporter.log("Addd new paient step ....2",true);

		int count = 0;
		while (count <= 90) {
			try {
				WebDriverWait m = new WebDriverWait(driver, 10);
				
				m.until(ExpectedConditions.visibilityOf(docpage.getIcdHeart()));

				docpage.getIcdHeart().click();
				Reporter.log("Sucessfully selected the Icd Code.........", true);
				break;
			}
			catch (Exception e) {
				e.printStackTrace();
               System.out.println("current count is for selecting Icd......."+count);
				count++;
			}
		}

		Reporter.log("Addd new paient step ....3",true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		boolean result = homepge.getReg().isEnabled();
	
		int countt = 0;
		while (countt >= 0) {
			if (result == true)
			{
				WebDriverWait kk=new WebDriverWait(driver, 20);
				kk.until(ExpectedConditions.elementToBeClickable(homepge.getReg()));
				homepge.getReg().click();
				break;
			} 
			else 
			{
				count++;
			}
		}
		WebDriverWait w = new WebDriverWait(driver, 50);

		w.until(ExpectedConditions.visibilityOf(homepge.getBannerLang1()));

		String lang1 = homepge.getBannerLang1().getText();
		
		Reporter.log(lang1 +"...........Sucess...",true);
		
		Reporter.log("Addd new paient step ....4",true);


		Date d = new Date();

		String[] dateArr = d.toString().split(" ");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		boolean flag3 = lang1.contains(dateArr[1]);

		Assert.assertTrue(flag3);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		
		Reporter.log("Doctor is sucessfully added to the chat session", true);
		
		boolean flag1 = lang1.contains(dateArr[2]);
	
		Assert.assertTrue(flag1);
		
		Reporter.log("Doctor is assigned to the chat session", true);
		System.out.println(lang1);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna");

		Reporter.log("Patient  is sucessfully added to the chat session", true);
		Reporter.log("AddNewPatientTest TestCase is sucessfully done ############################# TEST IS PASS", true);

	}

}
