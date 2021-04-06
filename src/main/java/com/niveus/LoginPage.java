package com.niveus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    Utility ut=new Utility();
	WebDriver driver;

	@FindBy(id = "userName")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement pwd;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement logbtn;

	@FindBy(xpath = "//span[text()='auto log-in']/preceding-sibling::span//input")
	private WebElement autolog;

	@FindBy(xpath = "//span[@role='img']")
	private WebElement pwdview;

	@FindBy(xpath = "//a[text()='Register account']")
	private WebElement register;

	@FindBy(xpath = "//span[text()='User status is changed to Active']")
	private WebElement statusChange;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement logpage;

	@FindBy(xpath = "//span[text()=' No']/../preceding-sibling::button")
	private WebElement getpop;

	@FindBy(xpath = "//div[contains(@class,'user_name_')]")
	private WebElement mail;

	public WebElement getproficPic() {
		return mail;
	}

	public WebElement getloginAlert() {
		return getpop;
	}

	public WebElement getlogPage() {
		return logpage;
	}

	public WebElement getStatusChange() {
		return statusChange;
	}

	public WebElement getregisteration() {
		return register;
	}

	public WebElement getpswdview() {
		return pwdview;
	}

	public WebElement getautolog() {
		return autolog;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getpassword() {
		return pwd;
	}

	public WebElement getloginbtn() {
		return logbtn;
	}

	@FindBy(xpath = "//span[contains(text(),'User status is changed to')]")
	private WebElement statuschange;

	public WebElement getUpdateChange() {
		return statuschange;
	}

	@FindBy(xpath = "//span[text()='file has been successfully uploaded.']")
	private WebElement sucess;

	public WebElement getSucess() {
		return sucess;
	}

	@FindBy(xpath = "//div[text()='User does not exist.']")
	private WebElement invalid;

	public WebElement getInvlid() {
		return invalid;
	}

	@FindBy(xpath = "//span[text()='Logout']/ancestor::div[contains(@class,'profile_wrap')]//img")
	private WebElement close;
	
	public WebElement getcloseProfile()
	{
		return close;
	}
	
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logout;
	
	public WebElement getlogout()
	{
		return logout;
	}
	public void loginPopUP() 
	{
		
			getloginAlert().click();
		    Utility.moveToElement(driver, getproficPic());
					
	}
   
	@FindBy(xpath = "//span[text()='Confirm Family Member']/../div//span[text()='Deny']")
	private WebElement deny;
	
	public WebElement getDenyBtn()
	{
		return deny;
	}
	
	
	@FindBy(xpath = "//div[text()='No doctors available at the moment']")
	private WebElement  nodoc;
	
	public WebElement getNoDoctor()
	{
		return nodoc;
	}
	public void login(String email, String password) {
		
		username.sendKeys(email);
		pwd.sendKeys(password);
		pwdview.click();
		logbtn.click();
	}
}
