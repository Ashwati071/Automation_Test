package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.HomePage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;
import com.mystore.pages.RegistrationPage;

public class RegistrationPageTest extends BaseClass{

	IndexPage indexpage;
	LoginPage loginpage;
	RegistrationPage registrationpage;
	HomePage homepage;
	
	@Test
	public void registerUser() throws InterruptedException {
		indexpage= new IndexPage();
		loginpage=indexpage.clickSignIn();
		String randomEmail = "user" + System.currentTimeMillis() + "@test.com";
		registrationpage = loginpage.createNewAccount(randomEmail);
		homepage=registrationpage.registerUser(prop.getProperty("first_name"), 
				prop.getProperty("last_name"), randomEmail, prop.getProperty("psd"));
		boolean personalInfoVisible =homepage.validateMyPersonalInfo();
		Assert.assertTrue(personalInfoVisible, "My Personal Information section is NOT visible on HomePage.");
		homepage.signOut();
		
	}
	
}
