package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//span[text()='My personal information']")
	WebElement myPersonalInfo;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement signoutBtn;
	
	public HomePage() {
		 PageFactory.initElements(driver, this);

	}
	
	public boolean validateMyPersonalInfo() {
		return Action.isDisplayed(myPersonalInfo);
	}
	
	public LoginPage signOut() {
		Action.doClick(driver, signoutBtn);
		return new LoginPage();
	}

}
