package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//a[normalize-space()='Sign in']")
	WebElement signInBtn;
	
	public IndexPage() {
		 PageFactory.initElements(driver, this);
	 }
	
	public LoginPage clickSignIn() throws InterruptedException {
	    Action.explicitWait(driver, signInBtn, 10);
        Action.doClick(driver, signInBtn);
		return new LoginPage();
	}

}
