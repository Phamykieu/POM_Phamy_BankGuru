package com.bankguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.commonFunctions;

public class LoginPage extends commonFunctions {
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String lbHere = "//a[contains(text(), 'here')]";
	String txtUsername = "//input[@name='uid']";
	String txtPassword = "//input[@name='password']";
	String btnlogin = "//input[@name='btnLogin']";
	
	public RegisterPage clickHereLink() {
		waitForElementVisible(lbHere);
		clickToElement(lbHere);
		
		//Level 1
		//return new RegisterPage(driver);
		
		//Level 2
		return PageFactory.initElements(driver, RegisterPage.class);

	}

	public void inputUsername(String Username) {
		waitForElementVisible(txtUsername);
		inputElement(txtUsername, Username);
	}
	
	public void inputPassword(String Password) {
		waitForElementVisible(txtPassword);
		inputElement(txtPassword, Password);
	}
	
	public HomePage clickLogIn() {
	waitForElementVisible(btnlogin);
		clickToElement(btnlogin);
		return PageFactory.initElements(driver, HomePage.class);
	}
}
