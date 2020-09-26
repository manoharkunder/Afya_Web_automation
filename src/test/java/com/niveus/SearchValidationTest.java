package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchValidationTest extends  Base{

	public LoginPage logp;
	public Registeration registerp;
	public Carddetails card;
	public HomePage homepge;
	public FilterSection filter;
	FileLib flib = new FileLib();
	public ProfilePage propage;

	@Test
	public void patientSearchTest() throws Exception {

		test = extent.createTest("13.SearchValidation", "This test case is to check user is able to Search");

		propage = PageFactory.initElements(driver, ProfilePage.class);
		logp = PageFactory.initElements(driver, LoginPage.class);
		homepge = PageFactory.initElements(driver, HomePage.class);

		WebDriverWait log = new WebDriverWait(driver, 20);
		log.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		Reporter.log("Login page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(logp.getUsername()));
		logp.getUsername().sendKeys("man@gmail.com");
		logp.getpassword().sendKeys("Aa123456@");
		logp.getpswdview().click();

		for (int i = 0; i <= 10; i++) {
			
			try {
				
				boolean res = logp.getloginbtn().isEnabled();
				
				if (res == true) 
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

		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(ExpectedConditions.visibilityOf(propage.getmailId()));

		Assert.assertEquals(propage.getmailId().getText(), "man@gmail.com");

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		homepge = PageFactory.initElements(driver, HomePage.class);

		WebDriverWait wait5 = new WebDriverWait(driver, 80);

		wait5.until(ExpectedConditions.elementToBeClickable(homepge.getNewbtn()));

		boolean out = homepge.getNewbtn().isEnabled();

		int countt = 0;
		while (countt >= 0) {
			if (out == true) {
				homepge.getNewbtn().click();
				Reporter.log("sucessfully clicked on New buuton",true);
				break;
			} else {
				countt++;
			}
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for (int i = 1; i <= 10;) {

			try

			{
              homepge.getSpeciality().click();
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				WebElement spec = driver.findElement(By.xpath(
						" //div[contains(@class,'ant-select-dropdown')]//div[contains(@class,'ant-select-item ')][" + i
								+ "]"));

				WebDriverWait tt=new WebDriverWait(driver, 30);
				
				tt.until(ExpectedConditions.elementToBeClickable(spec));
				
				spec.click();
				
				homepge.getChiefcomplaint().sendKeys("have a knee pain leg");

				homepge.getNewpatient().click();

				WebDriverWait wit = new WebDriverWait(driver, 100);
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
				
					WebDriverWait pp=new WebDriverWait(driver, 20);
					pp.until(ExpectedConditions.elementToBeClickable(homepge.getpopUpClose()));
			
					homepge.getpopUpClose().click();

			
					WebDriverWait ppp=new WebDriverWait(driver, 20);
					ppp.until(ExpectedConditions.elementToBeClickable(homepge.getNewbtn()));
			
					boolean b=homepge.getNewbtn().isEnabled();
					
					for(int o=0;o<=10;o++)
					{
						
					try
					{
					if(b==true)
					{
						homepge.getNewbtn().click();
	                  Reporter.log("clicked on new button............2time",true);
						break;
					}}
					catch (Exception ei) 
					{
						ei.printStackTrace();
					}
					}
			}
		
		}
		
		WebDriverWait wait11 = new WebDriverWait(driver, 100);
		
		wait11.until(ExpectedConditions.elementToBeClickable(homepge.getTextarea()));

		homepge.getTextarea().sendKeys("hello  how are u search", Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String arr[] = { "how", "hello", "are", "search" };

		for (int i = 0; i <= arr.length - 1; i++) {

			try {
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				homepge.getSearch().sendKeys(arr[i]);

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

				String chat = homepge.getChatsesion().getText();

				if (chat.contains(arr[i])) {

					Reporter.log("Search is sucessfully done", true);

				} else {
					Reporter.log("search is Unsucessfull");
				}

			} catch (Exception eo) {
				eo.printStackTrace();
			}

               WebDriverWait u=new WebDriverWait(driver, 20);
               u.until(ExpectedConditions.elementToBeClickable(homepge.getBackclear()));
		
               homepge.getBackclear().click();
			
               Reporter.log("SearchValidation TestCase is sucessfully done ############################# TEST IS PASS",
					true);
        
		}

	}
	}
