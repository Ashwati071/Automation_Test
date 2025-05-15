package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	 @FindBy(id="email")
	 WebElement username;
	 
	 @FindBy(name="passwd")
	 WebElement password;
	 
	 @FindBy(id="SubmitLogin")
	 WebElement button;
	 
	 @FindBy(id="email_create")
	 WebElement emailField;
	 
	 @FindBy(id="SubmitCreate")
	 WebElement createAccBtn;
	 
	 public LoginPage() {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public HomePage login(String uname, String passwrd) {
		 Action.doSendKeys(username, uname);
		 Action.doSendKeys(password, passwrd);
		 Action.doClick(driver, button);
		 return new HomePage();
      }
	 
	 public RegistrationPage createNewAccount(String emailId) {
		 Action.doSendKeys(emailField, emailId);
		 Action.doClick(driver, createAccBtn);
		 return new RegistrationPage();
	 }
	

}
