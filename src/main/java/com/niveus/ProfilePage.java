package com.niveus;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {
	WebDriver driver;
	Utility ut = new Utility();

	@FindBy(xpath = "//a[@href='/profile']")
	private WebElement proflehover;

	public WebElement getProfilehov() {
		return proflehover;
	}

	@FindBy(xpath = "//li[text()='sign out']")
	private WebElement sigout;

	public WebElement getSignOut()

	{
		return sigout;
	}

	@FindBy(id = "first_name")
	private WebElement fname;

	public WebElement getFname()

	{
		return fname;
	}

	@FindBy(id = "last_name")
	private WebElement lname;

	public WebElement getLastname() {
		return lname;
	}

	@FindBy(id = "dob")
	private WebElement dobid;

	public WebElement getDobirth() {
		return dobid;
	}

	@FindBy(xpath = "//div[@class='ant-select-selector']")
	private WebElement gnder;

	public WebElement getGender() {
		return gnder;
	}

	@FindBy(xpath = "//div[@id='gender']//div[1]")
	private WebElement genmale;

	public WebElement getGenMale() {
		return genmale;
	}

	@FindBy(xpath = "//div[@id='gender']//div[2]")
	private WebElement genFemale;

	public WebElement getFemale() {
		return genFemale;
	}

	@FindBy(xpath = "//div[text()='Choose not to specify']")
	private WebElement notspecify;

	public WebElement getGenNotspecify() {
		return notspecify;
	}

	@FindBy(xpath = "//input[@placeholder='Phone number']")
	private WebElement phono;

	public WebElement getPhoneNO() {
		return phono;
	}

	@FindBy(xpath = "//textarea[@id='bio']")
	private WebElement bio;

	public WebElement getBioData() {
		return bio;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement updatebtn;

	public WebElement getUpdatebtn() {
		return updatebtn;
	}

	@FindBy(xpath = "//div[@class='avatar___KHRKi']")
	private WebElement profile;

	public WebElement getProfileImage() {
		return profile;
	}

	@FindBy(xpath = "//span[text()='Uploading in progress..']")
	private WebElement updateinfo;

	public WebElement getUpdateInfo() {
		return updateinfo;
	}

	@FindBy(xpath = "//span[contains(text(),'@')]")
	private WebElement mail;

	public WebElement getmailId() {
		return mail;
	}
    @FindBy(xpath="//span[text()='information successfully Updated']")
    
    private WebElement updateprofile;
    
    public WebElement getUpdateinformtion()
    {
    	return updateprofile;
    }
    @FindBy(xpath = "//li[text()='sign out']")
    private WebElement logout;
    
    public WebElement getLog()
    {
    	return logout;
    }
	
    public  void  updateProfile(String firstname, String lastName, String gender)
			throws Exception {



    	fname.sendKeys(Keys.CONTROL, Keys.chord("a")); //select all text in textbox
    	fname.sendKeys(Keys.BACK_SPACE); //delete it
    	fname.sendKeys(firstname);

		

    	lname.sendKeys(Keys.CONTROL, Keys.chord("a")); //select all text in textbox
    	lname.sendKeys(Keys.BACK_SPACE); //delete it
    	lname.sendKeys(lastName);
    	
    	Thread.sleep(2000);
       
    	try
    	{
		
		if (gender.equals("Male")) 
		{
			if(genmale.isSelected())
				
              Utility.moveToElement(driver, genFemale);
			else
	              Utility.moveToElement(driver, genmale);
		}
    	else
    	{
            Utility.moveToElement(driver, genFemale);

    		
    	}}

		
    	catch (Exception e) {
		}

	}

}
