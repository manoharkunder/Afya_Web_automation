package com.niveus;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ChatMemberTest extends Base{

	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public ProfilePage propage;
	public HomePage homepge;

	@Test

	public void chatMemeberValidation() throws Exception {
		
		test=extent.createTest("5.ChatMember","This test case is to check whether Chat Members are displaying");


		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("Chatmember Testcase is running............",true);
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
		
		Reporter.log("sucessfully logedin and Home page is displayed", true);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		boolean ret = docpage.getNewSubmitter().isEnabled();
         int c=0;
         while(c>=0)
         {
        	 if(ret==true)
        	 {
		docpage.getNewSubmitter().click();
		Reporter.log("click on the new button sucessfully......###########",true);
		break;
        	 }
        	 else
        	 {
        		 c++;
        	 }
         }

		docpage.getSelectDate().sendKeys("11/11/1998");
	
		docpage.getPatientSearch().sendKeys("prasad");
		
		WebDriverWait wait33 = new WebDriverWait(driver, 40);
		
		wait33.until(ExpectedConditions.elementToBeClickable(docpage.getSearchResult()));
		
		docpage.getSearchResult().click();
		
		Reporter.log("Chat Member   Test   step ....1",true);

	   WebDriverWait wa = new WebDriverWait(driver, 40);
		
		wa.until(ExpectedConditions.elementToBeClickable(docpage.getConbutton()));
		
		
		docpage.getConbutton().click();
		
		docpage.getSpeciality().sendKeys("anesthesiology");
		
		WebDriverWait wait66 = new WebDriverWait(driver, 20);
		
		wait66.until(ExpectedConditions.elementToBeClickable(docpage.getAnsthesiolgy()));
		
		docpage.getAnsthesiolgy().click();
		
		docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Reporter.log("sucessfully enter the speciality and chief complaint.........########",true);
		
		Thread.sleep(2000);
		docpage.getIcd().sendKeys("Hypertensive heart disease with heart failure");
		
		int count = 0;   
		while (count <= 90) {
			try {
                  WebDriverWait op=new WebDriverWait(driver, 5);
                 
                  op.until(ExpectedConditions.visibilityOf(docpage.getIcdHeart()));
                  
				docpage.getIcdHeart().click();
				
				Reporter.log("Icd code is sucessfully displayed............############",true);
				
				break;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				count++;
				Reporter.log("count number..."+count,true);
			}
		}
		
		Reporter.log("Chat Member   Test   step ....2",true);

 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
         
		Reporter.log("Chat Member   Test   step ....3",true);

 		WebDriverWait w = new WebDriverWait(driver, 100);
 		w.until(ExpectedConditions.visibilityOf(homepge.getBannerLang1()));

 		String lang1 = homepge.getBannerLang1().getText();
 		
		Reporter.log("Chat Member   Test   step ....4",true);


 		Date d = new Date();

 		String[] dateArr = d.toString().split(" ");

 		boolean flag3 = lang1.contains(dateArr[1]);

 		Assert.assertTrue(flag3);
 		
 		Reporter.log("Doctor is sucessfully added to the chat session", true);
 		boolean flag1 = lang1.contains(dateArr[2]);
 		Assert.assertTrue(flag1);
 		Reporter.log("Doctor is assigned to the chat session", true);
 		System.out.println(lang1);

 		Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasad");
 		
 		Reporter.log("Patient  is sucessfully added to the chat session", true);


		WebDriverWait www = new WebDriverWait(driver, 100);
		www.until(ExpectedConditions.visibilityOf(homepge.getBannerLang1()));

		String lang11 = homepge.getBannerLang1().getText();

		Date dd = new Date();

		String[] dateArr1 = dd.toString().split(" ");

		boolean flag33 = lang1.contains(dateArr1[1]);

		Assert.assertTrue(flag33);
		Reporter.log("Doctor is sucessfully added to the chat session", true);
		boolean flag11 = lang1.contains(dateArr1[2]);
		Assert.assertTrue(flag11);
		Reporter.log("DOctor is assigned to the chat session", true);
		System.out.println(lang11);

		Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasad");
		Reporter.log("Patient  is sucessgully added to the chat session", true);

		int val = 0;
		while (val <= 100) {
			try {
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", homepge.getMoreoptions());
			
				Reporter.log("Chat Member   Test   step ....5",true);

				break;

			} catch (Exception e) {

				e.printStackTrace();
				val++;
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}

		WebDriverWait rr=new WebDriverWait(driver, 20);
		rr.until(ExpectedConditions.elementToBeClickable(homepge.getChatMemeber()));
		
		homepge.getChatMemeber().click();

		WebDriverWait ww = new WebDriverWait(driver, 50);
		ww.until(ExpectedConditions.visibilityOf(docpage.getChatM()));

		String chatmemeber = docpage.getChatM().getText();
		System.out.println(chatmemeber);

		boolean flag2 = chatmemeber.contains("test2");
		boolean flag4 = chatmemeber.contains("prasad shetty");
		Assert.assertTrue(flag2);
		Reporter.log("Responder 1 name  is displayed sucessfully", true);
		Assert.assertTrue(flag4);
		Reporter.log("patient name is displayed  sucesssfully", true);
		Reporter.log("ChatMember TestCase is sucessfully done  ############################# TEST IS PASS",true);
	}
}
	