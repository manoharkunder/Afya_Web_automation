package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorRolesPage {
	@FindBy(xpath="//div/img[@src='/static/submitterprovider.7a03b2fc.png']/../following-sibling::div")
	private WebElement submitter;
	
	public WebElement getSubProvider()
	
	{
		return submitter;
	}
	//img[@src='/static/responderprovider.fe25027c.png']
	@FindBy(xpath="	//span[text()='Respond to chats submitted to you']/..//span")
	
	private WebElement responder;
	
	public WebElement getResponder()
	{
		return responder;
	}
	
	@FindBy(xpath="//div[text()='Choose your role.']")
	private WebElement roles;
	
	public WebElement getRoles()
	{
		return roles;
	}
	
	@FindBy(xpath="//span[text()='Switch Roles']")
	private WebElement switchrole;
	
	public WebElement getSwitchRole()
	{
		return switchrole;
	}
	
	@FindBy(id="dob")
	private WebElement  selectdate;
	
	public WebElement getSelectDate()
	{
		return selectdate;
	}
	
	@FindBy(id="patient_search")
	private WebElement patientsearch;
	
	public WebElement getPatientSearch()
	{
		return patientsearch;
	}
	
	
	@FindBy(xpath="//span[text()=' Select']/..")
	private WebElement searchres;
	
	public WebElement getSearchResult()
	{
		return searchres;
	}
	
	
	@FindBy(id="specialty")
	private WebElement spec;
	
	public  WebElement getSpeciality()
	{
		return spec;
	}
	
	@FindBy(xpath = "//span[text()='Specialty']")
	private WebElement dropdown;
	
	public WebElement getSpecdrop()
	{
		return dropdown;
	}
	@FindBy(id="chief_complaint")
	private WebElement chiefcomplaint;
	
	public WebElement getChiefcomplaint()
	{
		return chiefcomplaint;
	}
	
	@FindBy(id="ICD")
	private WebElement icd;
	
	public  WebElement getIcd()
	{
		return icd;
	}
	
	@FindBy(id="CPT")
	private WebElement cpt;
	
	public WebElement getCpt()
	{
		return cpt;
	}
	
	@FindBy(xpath="//span[text()='Add Patient']")
	private WebElement addPatient;
	
	
	public WebElement getAddPatient()
	{
		return addPatient;
	}
	
	
	@FindBy(xpath="//img[@src='/static/add_plus.8284d929.svg']")
	private WebElement subNew;
	
	public WebElement getNewSubmitter()
	{
		return subNew;
	}
	
	@FindBy(xpath="//button[@type='button']/span[text()='Confirm']")
	private WebElement  confirm;
	
	public WebElement getConfirmbutton()
	{
		return confirm;
	}
	
	@FindBy(xpath="//div[text()='Anesthesiology']")
	private WebElement anesthe;
	
	public  WebElement getAnsthesiolgy()
	{
		return anesthe;
	}
	
	@FindBy(xpath="//span[text()='Hypertensive heart disease with heart failure']")
	private WebElement heart;
	
	public WebElement getIcdHeart()
	{
		return heart;
	}
	
	@FindBy(xpath="//button[@type='submit']/span[text()='Register']")
	private WebElement regbutton;
	
	public WebElement getRegisterBtn()
	{               
		return regbutton;
	}
	
	@FindBy(xpath="//div[contains(@class,'details_contaner')]")
	private WebElement patient;
	
	public WebElement getPatientInfo()
	{
		 return patient;
	}
	@FindBy(xpath="//span[text()=' Confirm']/..")
	private WebElement confim;
	
	public WebElement getConbutton()
	{
		return confim;
	}
	
	@FindBy(xpath="//div[@class='ant-modal-body']")
	private WebElement chat;
	
	public WebElement getChatM()
	{
		return chat;
    }
	@FindBy(name = "month")
	private WebElement mon;
	
	public WebElement getdMonth()
	{
		return mon;
	}
	@FindBy(name = "date")
	private WebElement dDate;
	
	public WebElement getDate()
	{
		return dDate;
	}
	@FindBy(id = "year")
	private WebElement yaer;
	
	public WebElement getyear()
	{
		return yaer;
	}
	
	@FindBy(xpath = "//span[text()='Skip >']")
	private WebElement skip;
	
	public WebElement getSkip()
	{
		return skip;
	}
   
	@FindBy(xpath = "//div[text()='Anesthesiology']")
	private WebElement specialty;
	
	public WebElement getspec()
	{
		return specialty;
	}
	
	@FindBy(xpath = "//div[contains(@class,'item-option-content')]")
	private WebElement list;
	
	public WebElement getSpeclist()
	{
		return list;
	}
	
	@FindBy(id = "ICD")
	private WebElement icddrop;
	
	public WebElement getIcdCode()
	{
		return icddrop;
	}
	
	
	@FindBy(id = "CPT")
	private WebElement cptdrop;
	
	public WebElement getCptCode()
	{
		return cptdrop;
	}
	
	////div[@id='ICD_list']/div[@role='option']
	

	@FindBy(xpath = "//div[@class='ant-select-item-option-content']//span")
	private WebElement icdselect;
	
	public WebElement getSelectICD()
	{
		return icdselect;
	}

	@FindBy(xpath = "//span[@role='user_status_value']/img")
	
	private WebElement staus;
	
	public WebElement getStatus()
	{
		return staus;
	}
	
	@FindBy(xpath = "//span[@role='user_status']")
	private WebElement state;
	
	public WebElement getUserstate()
	{
		return state;
	}
}
