package com.niveus;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PatientInfoTest extends Base {

	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public ProfilePage propage;
	public HomePage homepge;

	@Test(enabled=false)
	public void patientInfoValidationTest() throws Exception {
		
		test=extent.createTest("8.PatientInfoTest","This test case is to check whether patientInfo is working");

		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("PatientInfo Testcase is runnng..........",true);

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed", true);

		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));
		logp.getUsername().sendKeys("test2prasanna@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");
		logp.getpswdview().click();
	

		for(int i=0;i<=10;i++)
		{
		try
		{
		boolean res = logp.getloginbtn().isEnabled();
		if(res==true)
		{
			logp.getloginbtn().click();

			break;
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();

		}
		}

		WebDriverWait wait2 = new WebDriverWait(driver, 50);

		wait2.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider()));

		ut.moveToElement(driver, docpage.getSubProvider());

		boolean flag = docpage.getSubProvider().getText().contains("Submitter");
		Assert.assertTrue(flag);
		Reporter.log(docpage.getSubProvider().getText() + " role is selected", true);

		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "test2prasanna@gmail.com");
		Reporter.log("sucessfully loged in and Home page is displayed", true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		   JavascriptExecutor ex = (JavascriptExecutor)driver;
		     ex.executeScript("arguments[0].click();", docpage.getNewSubmitter());
		     
	//	docpage.getNewSubmitter().click();

		docpage.getSelectDate().sendKeys("11/11/1998",Keys.ENTER);	
		docpage.getPatientSearch().sendKeys("prasanna");
	
		WebDriverWait wait33 = new WebDriverWait(driver, 20);
		wait33.until(ExpectedConditions.elementToBeClickable(docpage.getSearchResult()));
		
		docpage.getSearchResult().click();
		
		Reporter.log("Patient Info  Test   step ....1",true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		docpage.getConbutton().click();
		
		docpage.getSpeciality().sendKeys("anesthesiology");
		
		/*
		 * WebDriverWait wait66 = new WebDriverWait(driver, 100);
		 * 
		 * wait66.until(ExpectedConditions.elementToBeClickable(docpage.getAnsthesiolgy(
		 * )));
		 */
		
		
		Thread.sleep(4000);
		
		docpage.getAnsthesiolgy().click();
		
		docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		docpage.getIcd().sendKeys("Hypertensive heart disease with heart failure");
		
		int count = 0;
		while (count <= 90) {
		
			try {
				
				  WebDriverWait wat=new WebDriverWait(driver, 2);
				  
				  wat.until(ExpectedConditions.visibilityOf(docpage.getIcdHeart()));
				  				 
			    docpage.getIcdHeart().click();
			
				Reporter.log("sucessfully icd code is selected.................##########",true);
				
				break;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				
				count++;
				Reporter.log("count number is ......."+count,true);
			}
		}


		Reporter.log("Patient Info  Test   step ....2",true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		boolean result = homepge.getReg().isEnabled();
		
		int countt=0;
		while(countt>=0)
		{
		if(result==true)
		{
			WebDriverWait oo=new WebDriverWait(driver, 20);
			oo.until(ExpectedConditions.elementToBeClickable(homepge.getReg()));
        homepge.getReg().click();
        break;
		}
		else
		{
			count++;
		}
		}
		
		Reporter.log("Patient Info  Test   step ....3",true);

 		WebDriverWait w = new WebDriverWait(driver, 100);
 		w.until(ExpectedConditions.visibilityOf(homepge.getBannerLang1()));

 		String lang1 = homepge.getBannerLang1().getText();

		Reporter.log("Patient Info  Test   step ....4",true);

 		Date d = new Date();

 		String[] dateArr = d.toString().split(" ");

 		boolean flag3 = lang1.contains(dateArr[1]);

 		Assert.assertTrue(flag3);
 		
 		Reporter.log("Doctor is sucessfully added to the cht session", true);
 		boolean flag1 = lang1.contains(dateArr[2]);
 		Assert.assertTrue(flag1);
 		Reporter.log("DOctor is assigned to the cht session", true);
 		System.out.println(lang1);

 		Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna");
 		
 		Reporter.log("Patien  is sucessgully added to the chat session", true);


		WebDriverWait www = new WebDriverWait(driver, 100);
		www.until(ExpectedConditions.visibilityOf(homepge.getBannerLang1()));

		String lang11 = homepge.getBannerLang1().getText();

		Date dd = new Date();

		String[] dateArr1 = dd.toString().split(" ");

		boolean flag33 = lang1.contains(dateArr1[1]);

		Assert.assertTrue(flag33);
		Reporter.log("Doctor is sucessfully added to the cht session", true);
		boolean flag11 = lang1.contains(dateArr1[2]);
		Assert.assertTrue(flag11);
		Reporter.log("DOctor is assigned to the cht session", true);
		System.out.println(lang11);

		Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna");
		Reporter.log("Patien  is sucessgully added to the chat session", true);


		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(homepge.getBannerLang1()));

		String lang16 = homepge.getBannerLang1().getText();

		Date di = new Date();

		String[] dateArro = di.toString().split(" ");

		boolean flag37 = lang1.contains(dateArro[1]);

		Assert.assertTrue(flag37);
		Reporter.log("Doctor is sucessfully added to the cht session", true);
		boolean flag10 = lang16.contains(dateArr[2]);
		Assert.assertTrue(flag10);
		Reporter.log("DOctor is assigned to the cht session", true);
		System.out.println(lang1);

		Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna");
		Reporter.log("Patien  is sucessgully added to the chat session", true);

		int val = 0;
		while (val <= 100) {
			try {
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", homepge.getMoreoptions());
			
				Reporter.log("Patien Info   Test   step ....5",true);

				break;

			} catch (Exception e) {

				e.printStackTrace();
				val++;
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}
		

		WebDriverWait wrt=new WebDriverWait(driver, 20);
		wrt.until(ExpectedConditions.elementToBeClickable(homepge.getPatientinfo()));

		homepge.getPatientinfo().click();

		WebDriverWait pp = new WebDriverWait(driver, 100);
		pp.until(ExpectedConditions.visibilityOf(homepge.getPatientDetails()));

		String chatmemeber = homepge.getPatientDetails().getText();
	

		Reporter.log(chatmemeber+" sucess",true);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean flag4 = chatmemeber.contains("Prasanna");
		Assert.assertTrue(flag4);
		
		Reporter.log("patient name is displayed  sucesssfully", true);
	   
		boolean flag5=chatmemeber.contains("11-11-1998");
		Assert.assertTrue(flag5);
		Reporter.log("patient date of birth  is displayed  sucesssfully", true);
	    boolean flag6=chatmemeber.contains("Years Old");
	    Assert.assertTrue(flag6);
		Reporter.log("patient year  is displayed  sucesssfully", true);
		Reporter.log("PatientInfoTest TestCase is sucessfully done ################################################## TEST IS PASS",true);
	}
}
