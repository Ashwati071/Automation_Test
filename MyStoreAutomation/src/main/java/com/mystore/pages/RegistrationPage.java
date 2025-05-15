package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class RegistrationPage extends BaseClass{
 
	//only mandatory fields
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement radioBtn;
	
	@FindBy(id="customer_firstname")
	WebElement firstname;
	
	@FindBy(id="customer_lastname")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement registerbtn;
	
	public RegistrationPage() {
		 PageFactory.initElements(driver, this);
	 }
	
	public HomePage registerUser(String first_name,String last_name,String emailId, String password) {
		Action.doClick(driver, radioBtn);
		Action.doSendKeys(firstname, first_name);
		Action.doSendKeys(lastname, last_name);
	    Action.sendKeysIfPrefilledMatchesOrFill(email, emailId);
        Action.doSendKeys(this.password, password);
		Action.doClick(driver, registerbtn);
		return  new HomePage();
	}
	
}
