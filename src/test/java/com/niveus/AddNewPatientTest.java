package com.niveus;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddNewPatientTest extends Base{
	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public HomePage homepge;

	@Test
	public void addNewPatientTest() throws Exception {
		
		test=extent.createTest("4.AddNewPatient","This test case is to check submitteble to add the patient");
		System.out.println("browser is launhed");
		System.out.println("enter the url sucesfully");
		logp = PageFactory.initElements(driver, LoginPage.class);
		card = PageFactory.initElements(driver, Carddetails.class);
		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);
		homepge=PageFactory.initElements(driver, HomePage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);
		
 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    
		logp.getUsername().sendKeys("test2prasanna@gmail.com");
	     logp.getpassword().sendKeys("Aa123456@");
	     
	 	logp.getpswdview().click();
	
	 	for(int i=0;i<=10;i++)
		{
		try
		{
		logp.getloginbtn().click();
		Thread.sleep(4000);
		boolean res = logp.getloginbtn().isEnabled(); 
		if(res==false)
		{
			break;
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();

		}
		}
			
	     
		System.out.println("sucessfully logedin");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(docpage.getSubProvider()));
		ut.moveToElement(driver, docpage.getSubProvider());
		
		Thread.sleep(5000);
		
		WebDriverWait www=new WebDriverWait(driver, 50);
		
		www.until(ExpectedConditions.elementToBeClickable(docpage.getNewSubmitter()));
		
		docpage.getNewSubmitter().click();
		
		docpage.getSelectDate().sendKeys("11/11/1998");
		docpage.getPatientSearch().sendKeys("prasanna");
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		
		wait1.until(ExpectedConditions.elementToBeClickable(docpage.getSearchResult()));
		
		docpage.getSearchResult().click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		docpage.getConbutton().click();
		
		docpage.getSpeciality().sendKeys("anesthesiology");
		
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		
		wait2.until(ExpectedConditions.elementToBeClickable(docpage.getAnsthesiolgy()));
		
		docpage.getAnsthesiolgy().click();
		
		docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");
		
		docpage.getIcd().sendKeys("Hypertensive heart disease with heart failure");
		
		int count = 0;
		while (count <= 90) {
			try {

				docpage.getIcdHeart().click();
				break;
			} catch (Exception e) {
				e.printStackTrace();
				count++;
			}
		}


		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		boolean result = homepge.getReg().isEnabled();
		int countt=0;
		while(countt>=0)
		{
		if(result==true)
		{
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

 		Date d = new Date();

 		String[] dateArr = d.toString().split(" ");

 		boolean flag3 = lang1.contains(dateArr[1]);

 		Assert.assertTrue(flag3);
 		Reporter.log("Doctor is sucessfully added to the cht session", true);
 		boolean flag1 = lang1.contains(dateArr[2]);
 		Assert.assertTrue(flag1);
 		Reporter.log("DOctor is assigned to the cht session", true);
 		System.out.println(lang1);

 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 		
 		Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna");
 		
 		Reporter.log("Patien  is sucessgully added to the chat session", true);
		Reporter.log("AddNewPatientTest TestCase is sucessfully done ############################# TEST IS PASS",true);

	}

}
