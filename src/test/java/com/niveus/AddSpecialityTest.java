package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

	@Test
	public void addspecialityValidationTest() throws Exception 
	{

		test=extent.createTest("3.AddSpeciality","This test case is to check whether whether User is able to add the speciality");

		filter = PageFactory.initElements(driver, FilterSection.class);
		
		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		close = PageFactory.initElements(driver, CloseCode.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		landpage = PageFactory.initElements(driver, HomePage.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));

		
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
		
	
		
		int count=0;
		
		
		boolean resl = filter.getFilter().isEnabled();
		while(count>=0)
		{
		
		if(resl==true)
		{

		     WebDriverWait w1=new WebDriverWait(driver, 200);
		     w1.until(ExpectedConditions.visibilityOf(filter.getFilter()));
		       filter.getFilter().click();
		       break;
		}
		else
		{
     count++;
		}
		}
	

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		filter.getAllchat().click();

	

		WebDriverWait wait11 = new WebDriverWait(driver, 40);

		wait11.until(ExpectedConditions.elementToBeClickable(landpage.getChatsesion()));

		landpage.getChatsesion().click();
			
          Thread.sleep(10000);
      

		for (int i = 1; i <= 100; i++) 
		{
			

				try {
					landpage.getTextarea().sendKeys("@speciality");

                         Thread.sleep(10000);
                         
					WebElement spcilaity = driver.findElement(By.xpath("//div[@class='list-sort-demo-list'][" + i + "]"));
					
					WebDriverWait wt=new WebDriverWait(driver, 20);
					wt.until(ExpectedConditions.visibilityOf(spcilaity));
					
					 WebDriverWait waitt=new WebDriverWait(driver, 300);
					 
					  waitt.until(ExpectedConditions.elementToBeClickable(spcilaity));
					  
					spcilaity.click();
					
					break;
				
				}
				catch (Exception e) 
				{
					
					e.printStackTrace();
				}
				
		}
		Reporter.log("Speciality list is displaying sucessfully",true);
			
		WebDriverWait w = new WebDriverWait(driver, 100);
		w.until(ExpectedConditions.visibilityOf(landpage.getAddSpec()));

		String lang1 = landpage.getAddSpec().getText();

		boolean flag1=lang1.contains("Dr. test2 prasanna has Added Dr.");
	  
		Assert.assertTrue(flag1);
	   
		Reporter.log("Doctor is sucessfully added to the cht session", true);
		
		System.out.println(lang1);
		
		Reporter.log("AddSpeciality TestCase is sucessfully done ############################# TEST IS PASS",true);


		}
}
