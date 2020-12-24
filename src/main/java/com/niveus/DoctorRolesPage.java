package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorRolesPage {
	@FindBy(xpath="//span[text()='Submitter Provider']")
	private WebElement submitter;
	
	public WebElement getSubProvider()
	
	{
		return submitter;
	}
	
	@FindBy(xpath="//span[text()='Responder Provider']")
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
	
	@FindBy(xpath="//div[contains(@class,'details_contaner')]//div/span")
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
	
	
}
