package com.niveus;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ChatMemberTest extends Base {

	public Registeration registerp;
	public Carddetails card;
	FileLib flib = new FileLib();
	public DoctorRolesPage docpage;
	Utility ut = new Utility();
	public LoginPage logp;
	public ProfilePage propage;
	public HomePage homepge;

	@Test()

	public void chatMemeberValidation() throws Exception {

		test = extent.createTest("5.ChatMember", "This test case is to check whether Chat Members are displaying");

		card = PageFactory.initElements(driver, Carddetails.class);

		docpage = PageFactory.initElements(driver, DoctorRolesPage.class);

		registerp = PageFactory.initElements(driver, Registeration.class);

		propage = PageFactory.initElements(driver, ProfilePage.class);

		homepge = PageFactory.initElements(driver, HomePage.class);

		logp = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("Chatmember Testcase is running............", true);

		WebDriverWait wait00 = new WebDriverWait(driver, 10);

		wait00.until(ExpectedConditions.visibilityOf(logp.getloginbtn()));

		Assert.assertEquals(logp.getloginbtn().getText(), "Login");

		logp.getUsername().sendKeys("test1prasanna@gmail.com");
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
		} /*
			 * 
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
			 * "test1prasanna@gmail.com");
			 * 
			 * logp.getcloseProfile().click();
			 * 
			 * Reporter.log("sucessfully loged in and Home page is displayed", true);
			 * 
			 * int btn = 0; while (btn==0) {
			 * 
			 * try { docpage.getNewSubmitter().click(); break;
			 * 
			 * } catch (Exception e) { // TODO: handle exception } }
			 * 
			 * wait1.until(ExpectedConditions.visibilityOf(docpage.getdMonth()));
			 * docpage.getdMonth().sendKeys("11"); docpage.getDate().sendKeys("11");
			 * docpage.getyear().sendKeys("1998");
			 * 
			 * WebDriverWait tt = new WebDriverWait(driver, 10);
			 * 
			 * tt.until(ExpectedConditions.visibilityOf(docpage.getPatientSearch()));
			 * 
			 * docpage.getPatientSearch().sendKeys("prasanna");
			 * 
			 * wait1.until(ExpectedConditions.elementToBeClickable(docpage.getSearchResult()
			 * ));
			 * 
			 * docpage.getSearchResult().click();
			 * 
			 * Reporter.log("Addd new paient step ....1", true);
			 * 
			 * boolean flag1 = true;
			 * 
			 * while (flag1 == true) { try {
			 * 
			 * docpage.getSpeciality().sendKeys("anesthesiology");
			 * 
			 * Thread.sleep(1000);
			 * 
			 * 
			 * docpage.getAnsthesiolgy().click();
			 * 
			 * docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");
			 * 
			 * flag1 = false; break; } catch (Exception e) { } }
			 * 
			 * int count = 0; while (count <= 1) { try { if (docpage.getIcd().isEnabled()) {
			 * 
			 * docpage.getIcd().sendKeys("Hypertensive heart disease with heart failure");
			 * try { Thread.sleep(3000); docpage.getIcdHeart().click(); break;
			 * 
			 * } catch(Exception e) {
			 * 
			 * } }
			 * 
			 * } catch (Exception e) {
			 * Reporter.log("No ICd code.................................", true); count++;
			 * } }
			 * 
			 * int count1 = 0;
			 * 
			 * while (count1 <= 1) { try { if (docpage.getCpt().isEnabled()) {
			 * 
			 * docpage.getCpt().sendKeys("A002"); break;
			 * 
			 * }
			 * 
			 * } catch (Exception e) {
			 * Reporter.log("No cpt code.....................................", true);
			 * count1++; } }
			 * 
			 * try { homepge.getReg().click(); } catch(Exception e) {
			 * 
			 * }
			 * 
			 * boolean flg = true; while (flg == true) { try {
			 * homepge.getChatsesion().click();
			 * 
			 * String lang1 = homepge.getBannerLang1().getText(); Reporter.log(lang1 +
			 * "...........Sucess...", true);
			 * 
			 * Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna"); flg =
			 * false;
			 * 
			 * } catch (Exception e) { } }
			 * 
			 * Reporter.log("Patient  is sucessfully added to the chat session", true);
			 * 
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

		Assert.assertEquals(propage.getmailId().getText(), "test1prasanna@gmail.com");

		// logp.getcloseProfile().click();

		Utility.isElementPresnt(driver, "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img",
				10).click();

		Reporter.log("sucessfully loged in and Home page is displayed", true);

		/*
		 * int btn = 0; while (btn==0) {
		 * 
		 * try { docpage.getNewSubmitter().click(); break;
		 * 
		 * } catch (Exception e) { } }
		 */

		Utility.isElementPresnt(driver, "//img[@src='/static/add_plus.8284d929.svg']", 10).click();

		wait1.until(ExpectedConditions.visibilityOf(docpage.getdMonth()));

		docpage.getdMonth().sendKeys("11");
		docpage.getDate().sendKeys("11");
		docpage.getyear().sendKeys("1998");

		WebDriverWait tt = new WebDriverWait(driver, 10);

		tt.until(ExpectedConditions.visibilityOf(docpage.getPatientSearch()));

		docpage.getPatientSearch().sendKeys("prasanna");

		// wait1.until(ExpectedConditions.elementToBeClickable(docpage.getSearchResult()));

//	/	docpage.getSearchResult().click();

		Utility.isElementPresnt(driver, "//span[text()=' Select']/..", 10).click();

		Reporter.log("Addd new paient step ....1", true);

		/*
		 * boolean flag1 = true;
		 * 
		 * while (flag1 == true) {
		 */
			try {

				// docpage.getSpeciality().sendKeys("anesthesiology");

				Utility.isElementPresntOnId(driver, "specialty", 10).sendKeys("anesthesiology");

				// Thread.sleep(3000);

				// docpage.getAnsthesiolgy().click();

				Utility.isElementPresnt(driver, "//div[text()='Anesthesiology']", 10).click();

				docpage.getChiefcomplaint().sendKeys("have a knee pain in leg");
				
				Reporter.log("Specialty and chief complaint is sucessfully displayed",true);

				//flag1 = false;
			//	break;
			} catch (Exception e) {
			}
		

			/*
			 * int count = 0; while (count <= 1) {
			 */
			try {
				if (Utility.isElementPresntOnId(driver, "ICD", 10).isEnabled()) {
					
					Thread.sleep(3000);

					Utility.isElementPresntOnId(driver, "ICD", 10)
							.sendKeys("Hypertensive heart disease with heart failure");
					try {
						// docpage.getIcdHeart().click();

						Thread.sleep(3000);
						
						WebElement Icd=Utility.isElementPresnt(driver,
								"//span[text()='Hypertensive heart disease with heart failure']", 10);
						Icd.click();
						Reporter.log("Icd code is sucessfully selected##########################",true);
					//	break;

					} catch (Exception e) {
						Reporter.log("Icd code is not selected>>>>>>>>>>>>>>>>>>>>>>>>>",true);
						e.printStackTrace();
					}
				}
			}

			 catch (Exception e) {
				Reporter.log("No ICd code.................................", true);
			//	count++;
			}
		
			/*
			 * int count1 = 0;
			 * 
			 * while (count1 <= 1) {
			 */
			try {
				if (Utility.isElementPresntOnId(driver, "CPT", 10).isEnabled()) {

					// docpage.getCpt().sendKeys("A002");
					Utility.isElementPresntOnId(driver, "CPT", 10).sendKeys("A002");
					//break;

				}

			} catch (Exception e) {
				Reporter.log("No cpt code.....................................", true);
				//count1++;
			}
		

		// homepge.getReg().click();

		Utility.isElementPresnt(driver, "//span[text()='  REGISTER ']", 10).click();
		/*
		 * boolean flg = true; while (flg == true) {
		 */
			try {
				// homepge.getChatsesion().click();

				Thread.sleep(4000);
				WebElement chat = Utility.isElementPresntOnId(driver, "chat_session_items", 15);
				
				chat.click();

				String lang1 = homepge.getBannerLang1().getText();

				Reporter.log(lang1 + "...........Sucess...", true);

				Assert.assertEquals(docpage.getPatientInfo().getText(), "Prasanna");
			//	flg = false;

			} catch (Exception e) {
			}
		

		Reporter.log("Patient  is sucessfully added to the chat session", true);
		/*
		 * int val = 0; while (val <= 100) {
		 */
			try {


				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", homepge.getMoreoptions());

				Reporter.log("Chat Member   Test   step ....5", true);
				
				Thread.sleep(3000);

				//break;

			} catch (Exception e) {

				e.printStackTrace();
			//	val++;
			}
		
			/*
			 * WebDriverWait rr = new WebDriverWait(driver, 20);
			 * 
			 * rr.until(ExpectedConditions.visibilityOf(homepge.getChatMemeber()));
			 * 
			 * JavascriptExecutor ex = (JavascriptExecutor) driver;
			 * ex.executeScript("arguments[0].click();", homepge.getChatMemeber());
			 */

			 WebElement chatmem=Utility.isElementPresnt(driver, "//ul[@role='menu']/li[text()='Chat members']", 15);
		
			 chatmem.click();
		// homepge.getChatMemeber().click();

		WebDriverWait ww = new WebDriverWait(driver, 50);
		ww.until(ExpectedConditions.visibilityOf(docpage.getChatM()));

		String chatmemeber = docpage.getChatM().getText();
		System.out.println(chatmemeber);

		boolean flag2 = chatmemeber.contains("Testone");
		boolean flag4 = chatmemeber.contains("Prasanna");
		Assert.assertTrue(flag2);
		Reporter.log("Responder 1 name  is displayed sucessfully", true);
		Assert.assertTrue(flag4);
		Reporter.log("patient name is displayed  sucesssfully", true);
		Reporter.log("ChatMember TestCase is sucessfully done  ############################# TEST IS PASS", true);
	}
}
