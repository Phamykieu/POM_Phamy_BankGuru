package com.bankguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.commonFunctions;

public class RegisterPage extends commonFunctions {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String txtEmailId = "//input[@name='emailid']";
	String btnSubmit = "//input[@name='btnLogin']";
	String lbUserId = "//td[contains(text(),'User ID')]/following-sibling::td";
	String lbPassword = "//td[contains(text(), 'Password')]/following-sibling::td";

	public void inputEmailId(String emailId) {
		waitForElementVisible(txtEmailId);
		inputElement(txtEmailId, emailId);
	}

	public void clickSubmit() {
		waitForElementVisible(btnSubmit);
		clickToElement(btnSubmit);

	}

	public String getUserId() {
		waitForElementVisible(lbUserId);
		return getTextElement(lbUserId);

	}

	public String getPassword() {
		waitForElementVisible(lbPassword);
		return getTextElement(lbPassword);
	}

	public LoginPage navigateTologInPage(String urlLogIn) {
		openUrl(urlLogIn);
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
