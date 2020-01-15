package com.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import common.commonFunctions;

public class EditCustomerPage extends commonFunctions {

	public EditCustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String txtEditCustomer = "//a[contains(text(), 'Edit Customer') ]";
	String txtCustomerID = "//input[@name='cusid']";
	String lblCustomerIDMessage = "//label[@id='message14']";
	String txtAddressField = "//textarea[@name='addr']";
	String lblAddressMessage = "//label[@id='message3']";
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
	String btnSubmitAccount = "//input[@name='AccSubmit']";
	// ************** Verify Customer id *************

	// Tab- key
	public void inputKeysToEditCustomer(Keys key) {
		waitForElementVisible(txtCustomerID);
		clearElement(txtCustomerID);
		sendKeyPress(txtCustomerID, key);
	}

	// 2 Customer String == nhap vao
	public void inputToEditCustomer(String value) {
		waitForElementVisible(txtCustomerID);
		inputElement(txtCustomerID, value);
	}

// 3 Kiem tra messsage
	public String getTextEditCustomer() {
		waitForElementVisible(txtCustomerID);
		return getTextElement(txtCustomerID);
	}

//************Address****************************

	// Tab Key
	public void inputTabToAddressField(Keys key) {
		waitForElementVisible(txtAddressField);
		clearElement(txtAddressField);
		sendKeyPress(txtAddressField, key);
	}

	// nhap vao
	public void inputToAddressField(String value) {
		waitForElementVisible(txtAddressField);
		clearElement(txtAddressField);
		inputElement(txtAddressField, value);
	}

	// Kiểm tra messsage
	public String getTextAddressMessage() {
		waitForElementVisible(lblAddressMessage);
		return getTextElement(lblAddressMessage);
	}

//**************** City Filed ****************************

// Tab
	public void inputTabToCityField(Keys key) {
		waitForElementVisible(txtCityField);
		clearElement(txtCityField);
		sendKeyPress(txtCityField, key);
	}

	// nhap vao
	public void inputToCityField(String value) {
		waitForElementVisible(txtCityField);
		clearElement(txtAddressField);
		inputElement(txtCityField, value);

	}

	// Kiem tra messsage
	public String getTextCityMessage() {
		waitForElementVisible(lblCityMessage);
		return getTextElement(lblCityMessage);
	}

	public String getTextCustomerIDMessage() {
		waitForElementVisible(lblCustomerIDMessage);
		return getTextElement(lblCustomerIDMessage);
	}
// **************** State filed ****************************

	// key Tab
	public void inputTabToStateField(Keys key) {
		waitForElementVisible(txtStateField);
		clearElement(txtStateField);
		sendKeyPress(txtStateField, key);
	}

	// nhap vao
	public void inputToStateField(String value) {
		waitForElementVisible(txtStateField);
		clearElement(txtStateField);
		inputElement(txtStateField, value);

	}

	// Kiem tra messsage
	public String getTextStateMessage() {
		waitForElementVisible(lblStateMessage);
		return getTextElement(lblStateMessage);
	}

	// **************** PIN filed ****************************

	// key Tab
	public void inputTabToPinField(Keys key) {
		waitForElementVisible(txtPinField);
		clearElement(txtPinField);
		sendKeyPress(txtPinField, key);
	}

	// nhap vao
	public void inputToPinField(String value) {
		waitForElementVisible(txtPinField);
		clearElement(txtPinField);
		inputElement(txtPinField, value);

	}

	// Kiem tra messsage
	public String getTextPinMessage() {
		waitForElementVisible(lblPinMessage);
		return getTextElement(lblPinMessage);
	}

	// **************** Mobile Number filed ****************************

	// key Tab
	public void inputTabToTelephoneFiled(Keys key) {
		waitForElementVisible(txtTelephoneField);
		clearElement(txtTelephoneField);
		sendKeyPress(txtTelephoneField, key);
	}

	// nhap vao
	public void inputToTelephoneField(String value) {
		waitForElementVisible(txtTelephoneField);
		clearElement(txtTelephoneField);
		inputElement(txtTelephoneField, value);

	}

	// Kiem tra messsage
	public String getTextTelephoneMessage() {
		waitForElementVisible(lblTelephoneMessage);
		return getTextElement(lblTelephoneMessage);
	}

// **************** Email filed ****************************
	// key Tab
	public void inputTabToEmailFiled(Keys key) {
		waitForElementVisible(txtEmailField);
		clearElement(txtEmailField);
		sendKeyPress(txtEmailField, key);
	}

	// nhap vao
	public void inputToEmailField(String value) {
		waitForElementVisible(txtEmailField);
		clearElement(txtEmailField);
		inputElement(txtEmailField, value);

	}

	// Kiem tra messsage
	public String getTextEmailMessage() {
		waitForElementVisible(lblEmailMessage);
		return getTextElement(lblEmailMessage);
	}

	public void clickSubmitAccount() {
		waitForElementVisible(btnSubmitAccount);
		clickToElement(btnSubmitAccount);
	}
}
