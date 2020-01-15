package com.bankguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.commonFunctions;

public class HomePage extends commonFunctions {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String lbWelcome = "//marquee[contains(text(),'Welcome')]";

	String lbNewCustomer = "//a[contains(text(), 'New Customer')]";

	String btnSubmit = "//input[@name='sub']";

	public String getTextWelcome() {
		waitForElementVisible(lbWelcome);
		return getTextElement(lbWelcome);

	}

	public NewCustomerPage clickMenuNewCustomer() {
		waitForElementVisible(lbNewCustomer);
		clickToElement(lbNewCustomer);
		return PageFactory.initElements(driver, NewCustomerPage.class);
	}

	public NewCustomerPage clickSubmit() {
		waitForElementVisible(btnSubmit);
		clickToElement(btnSubmit);
		return PageFactory.initElements(driver, NewCustomerPage.class);

	}

//	String lbEditCustomer = "//a[contains(text(), 'Edit Customer')]";
//	public EditCustomerPage clickMenuEditCustomer() {
//		waitForElementVisible(lbEditCustomer);
//		clickToElement(lbEditCustomer);
//		return PageFactory.initElements(driver, EditCustomerPage.class);
//	}
//	

}
