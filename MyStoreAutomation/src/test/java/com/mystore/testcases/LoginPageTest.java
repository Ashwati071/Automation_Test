package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.HomePage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@Test
	public void loginTest() throws InterruptedException {
		indexpage= new IndexPage();
		loginpage=indexpage.clickSignIn();
		Thread.sleep(3000);
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		boolean personalInfoVisible =homepage.validateMyPersonalInfo();
		Assert.assertTrue(personalInfoVisible, "My Personal Information section is NOT visible on HomePage.");
		homepage.signOut();
		
	}
}
