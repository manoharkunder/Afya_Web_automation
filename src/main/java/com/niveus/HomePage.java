package com.niveus;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='  REGISTER ']")
	private WebElement reg;
	
	public WebElement getReg()
	{
		return reg;
	}
	@FindBy(xpath = "//a[@href='/chatcenter']")
	private WebElement chats;

	public WebElement getChat() {
		return chats;
	}

	@FindBy(xpath = "//a[@href='/profile']")
	private WebElement myprofile;

	public WebElement getProfile()

	{
		return myprofile;
	}

	@FindBy(xpath = "//span[@class='anticon anticon-menu-fold']")
	private WebElement fold;

	public WebElement getWindowfold() {
		return fold;
	}

	@FindBy(xpath = "//div[contains(@class,'container___2U')]//img")
	private WebElement buttonnew;

	public WebElement getNewbtn() {
		return buttonnew;
	}

	@FindBy(id = "speciality")
	private WebElement spec;

	public WebElement getSpeciality() {
		return spec;
	}

	@FindBy(id = "chiefcomplaint")
	private WebElement chief;

	public WebElement getChiefcomplaint() {
		return chief;
	}

	@FindBy(xpath = "//span[text()='Create a new chat']")
	private WebElement createnew;

	public WebElement getNewpatient() {
		return createnew;
	}

	@FindBy(xpath = "//button[@type='button']/span[text()='Create a new chat']/ancestor::span//span[text()='Cancel']")
	private WebElement cancel;

	public WebElement getCanclbtn() {
		return cancel;

	}

	@FindBy(xpath = "//input[@placeholder='Search..']")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}

	@FindBy(id = "chat_session_items")
	private WebElement chatsession;

	public WebElement getChatsesion() {
		return chatsession;

	}

	@FindBy(xpath = "//div[@id='textArea']/preceding-sibling::div/input[@type='text']")
	private WebElement textare;

	public WebElement getTextarea() {
		return textare;
	}

	@FindBy(xpath = "//img[@src='/static/sendicon.3d7dfaf1.svg']")
	private WebElement btnsend;

	public WebElement getSendbutton() {
		return btnsend;
	}

	@FindBy(xpath = "//div[contains(@class,'attachment___')]")
	private WebElement paperclip;

	public WebElement getPaperclip() {
		return paperclip;
	}

	@FindBy(xpath = "//*[@id=\"chat_area_widget\"]/div/div/div[1]/div[1]/div/span[1]/img/../following-sibling::span")
	private WebElement moreoptions;

	public WebElement getMoreoptions() {
		return moreoptions;
	}

	@FindBy(xpath = "//div[@class='videoimage___2uNRD']")
	private WebElement videocal;

	public WebElement getVideocall() {
		return videocal;
	}

	@FindBy(xpath = "//ul[@class='listitem___3W6PA']/li[3]")
	private WebElement doccument;

	public WebElement getDoc() {
		return doccument;
	}

	@FindBy(xpath = "//ul[@class='listitem___3W6PA']/li[2]")
	private WebElement Camera;

	public WebElement getCamera() {
		return Camera;
	}

	@FindBy(xpath = "//button[@type='button']/span[@aria-label='camera']")
	private WebElement click;

	public WebElement getCameraclick() {
		return click;
	}

	@FindBy(xpath = "//span[@aria-label='send']")
	private WebElement sendpic;

	public WebElement getSendpic() {
		return sendpic;
	}

	@FindBy(xpath = "//ul[@class='listitem___3W6PA']/li[1]")
	private WebElement photo;

	public WebElement getGallery() {
		return photo;
	}

	@FindBy(xpath = "//span[text()='Patient info']")
	private WebElement patientinfo;

	public WebElement getPatientinfo() {
		return patientinfo;
	}

	@FindBy(xpath = "//ul[@role='menu']/li[text()='Chat members']")
	private WebElement chatmem;

	public WebElement getChatMemeber() {
		return chatmem;
	}

	@FindBy(xpath = "//ul[@role='menu']/li[text()='Media files']")
	private WebElement media;

	public WebElement getMediafile() {
		return media;
	}

	@FindBy(xpath = "//ul[@role='menu']/li[text()='Pdf']")
	private WebElement pdf;

	public WebElement getPdf() {
		return pdf;
	}

	@FindBy(xpath = "//div[contains(@class,'note_wrapper')]")
	private WebElement lang;

	public WebElement getChatlang() {
		return lang;
	}

	@FindBy(xpath = "//a[contains(@class,'close')]")
	private WebElement close;

	public WebElement getpopUpClose() {
		return close;
	}

	@FindBy(xpath = "//div[text()='No doctors available at the moment']")
	private WebElement nodoctor;

	public WebElement getNoDoctor() {
		return nodoctor;
	}

	@FindBy(xpath = "//span[text()='Session has been created']")
	private WebElement session;

	public WebElement getSession() {
		return session;
	}

	@FindBy(xpath = "//span[@aria-label='arrow-left']")
	private WebElement back;

	public WebElement getBackclear() {
		return back;
	}

	@FindBy(xpath = "//input[@type='file']")
	private WebElement file;

	public WebElement getUploadFile() {
		return file;
	}

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement subbutton;

	public WebElement getSubmitButton() {
		return subbutton;
	}

	@FindBy(xpath = "//label[text()='Add Files']")
	private WebElement addfile;

	public WebElement getAddFiles() {
		return addfile;
	}

	@FindBy(xpath = "//div[@role='tab' and text()='Upload Photos']")
	private WebElement photo1;

	public WebElement getUploadPhoto() {
		return photo1;
	}

	@FindBy(xpath = "//div[contains(@class,'role_item_wrape')]//div[text()='LA Care']")
	private WebElement org;

	public WebElement getOrganization() {
		return org;
	}

	@FindBy(xpath = "//div[contains(@class,'role_item_wrape')]//div[text()='HubMD']")
	private WebElement org2;

	public WebElement getOraganization2() {
		return org2;
	}

	@FindBy(xpath = "//div[contains(@class,'status_container___q45qw')]")
	private WebElement status;

	public WebElement getResponderStatus() {
		return status;
	}

	@FindBy(xpath = "//div[contains(@class,'chat_content___')]")
	private WebElement banner1;

	public WebElement getBannerLang1() {
		return banner1;
	}
	@FindBy(xpath="//div[@class='ant-select-item ant-select-item-option'][1]")
	private WebElement specone;
	
	public WebElement getSpecOne()

	{
		return specone;
	}
	
	@FindBy(xpath="//span[text()='Cancel']")
	private WebElement canclbutton;
	
	public WebElement getCanelButton()
	{
		return canclbutton;
	}
	@FindBy(xpath="//div[contains(@class,'chat_content_items_')]")
	private WebElement addspec;
	
	public WebElement getAddSpec()
	{
		return addspec;
	}
	
	@FindBy(xpath="//div[contains(@class,'patient_info_modal_content')]")
	private WebElement patientdetails;
	
	public WebElement getPatientDetails()
	{
		return patientdetails;
	}
	@FindBy(xpath="(//input[@type='file'])[2]")
    private WebElement photo11;
	
	public WebElement getPhotoUpload()
	{
		return photo11;
	}
	
	
	@FindBy(xpath="//span[text()='Media files']")
	private WebElement media1;
	
	public WebElement getMediaFil()
	{
		return media1;
	}
	
	@FindBy(xpath="//div[@class='ant-card-meta-detail']")
	private WebElement files;
	
	public WebElement getFile()
	{
		return files;
	}
	@FindBy(xpath = "//li[@id='active_chat_Session_item']")
	private WebElement getsingle;
	
	public WebElement getSingleChat()
	{
		return getsingle;
	}
	
	@FindBy(xpath = "//span[@aria-label='down']/..")
	private WebElement resrole;
	
	public WebElement getResrol()
	{
		return resrole;
	}
	
	@FindBy(xpath = "//span[text()='All Chats']")
	private WebElement all;
	
	public WebElement getAllChat()
	{
		return all;
	}
	
	@FindBy(xpath = "//button[@type='submit']//span[text()='CONFIRM PATIENT']")
	private WebElement  confirm;
	
	public WebElement getConfirmPatient()
	{
		return confirm;
	}
	@FindBy(xpath  = "//input[@id='specialty']")
	private WebElement specid;
	
	public WebElement getSpecdropDown()
	{
		return specid;
	}
	@FindBy(xpath = "//div[text()='Obstetrics']")
	private WebElement dropdown;
	
	public WebElement getObstrtrics()
	{
		return dropdown;
	}
	
	public void createNewpatient(String speciality, String chiefcompliant) {
		spec.sendKeys(speciality, Keys.ENTER);
		chief.sendKeys(chiefcompliant);
		createnew.click();
	}

}
