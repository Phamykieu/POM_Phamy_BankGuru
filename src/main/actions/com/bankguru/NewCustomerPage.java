package com.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.commonFunctions;

public class NewCustomerPage extends commonFunctions {

	public NewCustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String txtCustomerName = "//input[@name='name']";
	String datepickerDateOfBirth = "//input[@name='dob']";
	String lblMessageName = "//label[@id='message']";
	String txtAddressField = "//textarea[@name='addr']";
	String lblAddressMessage = "//label[@id='message3']";
	String lbEditCustomer = "//a[contains(text(), 'Edit Customer')]";
	String txtCityField = "//input[@name='city']";
	String lblCityMessage = "//label[@id='message4']";
	String txtStateField = "//input[@name='state']";
	String lblStateMessage = "//label[@id='message5']";
	String txtPinField = "//input[@name='pinno']";
	String lblPinMessage = "//label[@id='message6']";
	String txtTelephoneField = "//input[@name='telephoneno']";
	String lblTelephoneMessage = "//label[@id='message7']";
	String txtEmailField = "//input[@name='emailid']";
	String lblEmailMessage = "//label[@id='message9']";
	String txtPasswordField = "//input[@name='password']";
	String lblPasswordMessage = "//label[@id='message18']";
	String lblCustomerID = "//td[contains(text(),'Customer ID')]/following-sibling::td";
	String btnSubmit = "//input[@name='sub']";

	public EditCustomerPage clickMenuEditCustomer() {
		waitForElementVisible(lbEditCustomer);
		clickToElement(lbEditCustomer);
		return PageFactory.initElements(driver, EditCustomerPage.class);
	}

// ************** Verify Customer id *************
	// 1 Customer Name - key
	public void inputTabToNewCustomer(Keys key) {
		waitForElementVisible(txtCustomerName);
		sendKeyPress(txtCustomerName, key);

	}

	// 2 Customer String == nhap vao
	public void inputToNewCustomer(String value) {
		waitForElementVisible(txtCustomerName);
		inputElement(txtCustomerName, value);

	}

// 3 Kiem tra messsage
	public String getTextCustomer() {
		waitForElementVisible(lblMessageName);
		return getTextElement(lblMessageName);
	}

//******************Date of Birth **********************************
	public void inputDateOfBirth(String value) {
		waitForElementVisible(datepickerDateOfBirth);
		inputElement(datepickerDateOfBirth, value);
	}

//******************Address field **********************************
	// 1 - key Tab
	public void inputTabToAddressField(Keys key) {
		waitForElementVisible(txtAddressField);
		sendKeyPress(txtAddressField, key);

	}

	// 2 Address String == nhap vao
	public void inputToAddressField(String value) {
		waitForElementVisible(txtAddressField);
		inputElement(txtAddressField, value);

	}

	// 3 Kiem tra Address messsage
	public String getTextAddressMessage() {
		waitForElementVisible(lblAddressMessage);
		return getTextElement(lblAddressMessage);
	}

//******************City field **********************************

// Tab
	public void inputTabToCityField(Keys key) {
		waitForElementVisible(txtCityField);
		sendKeyPress(txtCityField, key);
	}

	// nhap vao
	public void inputToCityField(String value) {
		waitForElementVisible(txtCityField);
		inputElement(txtCityField, value);

	}

	// Kiem tra messsage
	public String getTextCityMessage() {
		waitForElementVisible(lblCityMessage);
		return getTextElement(lblCityMessage);
	}

//******************State field **********************************
	// key Tab
	public void inputTabToStateField(Keys key) {
		waitForElementVisible(txtStateField);
		sendKeyPress(txtStateField, key);
	}

	// nhap vao
	public void inputToStateField(String value) {
		waitForElementVisible(txtStateField);
		inputElement(txtStateField, value);

	}

	// Kiem tra messsage
	public String getTextStateMessage() {
		waitForElementVisible(lblStateMessage);
		return getTextElement(lblStateMessage);
	}

//******************Pin field **********************************	
	// key Tab
	public void inputTabToPinField(Keys key) {
		waitForElementVisible(txtPinField);
		sendKeyPress(txtPinField, key);
	}

	// nhap vao
	public void inputToPinField(String value) {
		waitForElementVisible(txtPinField);
		inputElement(txtPinField, value);

	}

	// Kiem tra messsage
	public String getTextPinMessage() {
		waitForElementVisible(lblPinMessage);
		return getTextElement(lblPinMessage);
	}

//******************Mobile Phone field **********************************

	// key Tab
	public void inputTabToTelephoneFiled(Keys key) {
		waitForElementVisible(txtTelephoneField);
		sendKeyPress(txtTelephoneField, key);
	}

	// nhap vao
	public void inputToTelephoneField(String value) {
		waitForElementVisible(txtTelephoneField);
		inputElement(txtTelephoneField, value);

	}

	// Kiem tra messsage
	public String getTextTelephoneMessage() {
		waitForElementVisible(lblTelephoneMessage);
		return getTextElement(lblTelephoneMessage);
	}

//******************Email field **********************************	

	// key Tab
	public void inputTabToEmailField(Keys key) {
		waitForElementVisible(txtEmailField);
		sendKeyPress(txtEmailField, key);
	}

	// nhap vao
	public void inputToEmailField(String value) {
		waitForElementVisible(txtEmailField);
		inputElement(txtEmailField, value);

	}

	// Kiem tra messsage
	public String getTextEmailMessage() {
		waitForElementVisible(lblEmailMessage);
		return getTextElement(lblEmailMessage);
	}

//******************Password field **********************************			

	// key Tab
	public void inputTabToPasswordField(Keys key) {
		waitForElementVisible(txtPasswordField);
		sendKeyPress(txtPasswordField, key);
	}

	// nhap vao
	public void inputToPasswordField(String value) {
		waitForElementVisible(txtPasswordField);
		inputElement(txtPasswordField, value);

	}

	public void clickSubmit() {
		waitForElementVisible(btnSubmit);
		clickToElement(btnSubmit);

	}

	// Kiem tra messsage
	public String getTextPasswordMessage() {
		waitForElementVisible(lblPasswordMessage);
		return getTextElement(lblPasswordMessage);
	}

	public String getCustomerId() {
		waitForElementVisible(lblCustomerID);
		return getTextElement(lblCustomerID);
	}
}
