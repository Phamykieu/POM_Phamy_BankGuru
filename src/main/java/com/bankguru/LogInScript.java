package com.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.commonTestcase;

public class LogInScript extends commonTestcase {

	WebDriver driver;
	LoginPage logInPage;
	RegisterPage registerPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;
	EditCustomerPage editCustomerPage;
	String userID;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openBrowser(browser, version, url);
	}

	@Parameters("url")
	@Test
	public void NC_00_Login(String url) {
//		logInPage = new LoginPage(driver);
		String emailRegister = "vunguyen" + randomNumber() + "@gmail.com";
		logInPage = PageFactory.initElements(driver, LoginPage.class);

		registerPage = logInPage.clickHereLink();

//		registerPage = new RegisterPage(driver);

		registerPage.inputEmailId(emailRegister);
		registerPage.clickSubmit();
		String username = registerPage.getUserId();
		String password = registerPage.getPassword();
		logInPage = registerPage.navigateTologInPage(url);

//		logInPage = new LoginPage(driver);

		logInPage.inputUsername(username);
		logInPage.inputPassword(password);
		homePage = logInPage.clickLogIn();

//		homePage = new HomePage(driver);

		String welcomeText = homePage.getTextWelcome();

		verifyTrue(welcomeText.contains("Welcome To Manager"));

	}

//	Verify Name Field

	/*
	 * Verify Name Field Name cannot be empty 1) Do not enter a value in NAME Field
	 * 2) Press TAB and move to next Field An error message
	 * "Customer name must not be blank" must shown
	 */

	@Test
	public void NC_01() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputTabToNewCustomer(Keys.TAB);
		String messageCustomer = newCustomerPage.getTextCustomer();
		verifyEquals("Customer name must not be blank", messageCustomer);
	}

	/*
	 * Name cannot be numeric 1) Enter numeric value in NAME Field 1234 name123 An
	 * error message "Numbers are not allowed" must be shown
	 */
	@Test
	public void NC_02() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToNewCustomer("1234");
		String messageCustomer = newCustomerPage.getTextCustomer();
		verifyEquals("Numbers are not allowed", messageCustomer);
	}

//	Name cannot have special characters 
//	1) Enter Special Character In NAME Field
//	name!@#
//	!@#
//	An error message "Special characters are not allowed" must be shown

	@Test
	public void NC_03() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToNewCustomer("name!@#");
		String messageCustomer = newCustomerPage.getTextCustomer();
		verifyEquals("Special characters are not allowed", messageCustomer);
	}

//		Name cannot have first character as blank space 
//		1) Enter First character Blank space
//		An error message "Special characters are not allowed" must be shown 

	@Test
	public void NC_04() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToNewCustomer(" name");
		String messageCustomer = newCustomerPage.getTextCustomer();
		verifyEquals("First character can not have space", messageCustomer);
	}

// Verify Address Field

//		Address cannot be empty
//		1) Do not enter a value in ADDRESS Field
//		2) Press TAB and move to next Field
//		An error message "ADDRESS cannot be empty" must be shown 

	public void NC_05() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputTabToAddressField(Keys.TAB);
		String AddressMessage = newCustomerPage.getTextAddressMessage();
		verifyEquals("Address Field must not be blank", AddressMessage);
	}

//	NC_6 Address cannot have first blank space 
//  1) Enter First character Blank
//	space An error message"First character cannot be space" must be shown

	@Test
	public void NC_06() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToAddressField(" Le Loi");
		String AddressMessage = newCustomerPage.getTextAddressMessage();
		verifyEquals("First character can not have space", AddressMessage);
	}

// Verify City Field	

//	NC_08 Verify City Field City cannot be empty
//	1) Do not enter a value in CITY Field
//	2) Press TAB and move to next Field
//	An error message "City Field must be not blank" must be shown
	@Test
	public void NC_08() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputTabToCityField(Keys.TAB);
		String messageCity = newCustomerPage.getTextCityMessage();
		verifyEquals("City Field must not be blank", messageCity);
	}

//	NC_09 City cannot be numeric 
//	1) Enter numeric value in CITY Field
//	1234
//	city123
//	An error message "Numbers are not allowed" must be shown
	@Test
	public void NC_09() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToCityField("1234");
		String messageCity = newCustomerPage.getTextCityMessage();
		verifyEquals("Numbers are not allowed", messageCity);
	}
//	NC10 City cannot have specialcharacter 
//	1) Enter Special Character In CITY Field
//	City!@#
//	!@#
//	An error message "Special characters are not allowed" must be shown

	@Test
	public void NC_10() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToCityField("City!@#");
		String messageCity = newCustomerPage.getTextCityMessage();
		verifyEquals("Special characters are not allowed", messageCity);
	}
//	NC11 City cannot have first blank space 
//	1) Enter First character Blank space
//	An error message "First character cannot be space" must be shown

	@Test
	public void NC_11() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToCityField("  City");
		String messageCity = newCustomerPage.getTextCityMessage();
		verifyEquals("First character can not have space", messageCity);
	}

// State filed

//		NC12 Verify State Field State cannot be empty
//		1) Do not enter a value in STATE Field
//		2) Press TAB and move to next Field
//		An error message "State must not be blank" must be shown
	@Test
	public void NC_12() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputTabToStateField(Keys.TAB);
		String messageState = newCustomerPage.getTextStateMessage();
		verifyEquals("State must not be blank", messageState);
	}

//		NC13 State cannot be numeric 
//		1) Enter numeric value in STATE Field
//		1234
//		State123
//		An error message "Numbers are not allowed" must be shown
	@Test
	public void NC_13() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToStateField("1234");
		String messageState = newCustomerPage.getTextStateMessage();
		verifyEquals("Numbers are not allowed", messageState);
	}

//		NC14
//		State cannot have special character
//	    1) Enter Special Character In STATE Field
//		State!@#
//		!@#
//		An error message "Special characters arenot allowed" must be shown
	@Test
	public void NC_14() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToStateField("City!@#");
		String messageState = newCustomerPage.getTextStateMessage();
		verifyEquals("Special characters are not allowed", messageState);
	}
//		NC15 
//		State cannot have first blank space 1) Enter First character Blank space
//		An error message "First character cannot be space" must be shown	

	@Test
	public void NC_15() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToStateField("  City");
		String messageState = newCustomerPage.getTextStateMessage();
		verifyEquals("First character can not have space", messageState);
	}

// PIN

//		NC16 Verify PIN Field PIN must be numeric 
//		1) Enter character value in PIN Field
//		1234
//		1234PIN
//		An error message "Characters are not allowed" must be shown
	@Test
	public void NC_16() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToPinField("1234P");
		String messagePin = newCustomerPage.getTextPinMessage();
		verifyEquals("Characters are not allowed", messagePin);
	}
//		NC17 PIN cannot be empty
//		1) Do not enter a value in PIN Field
//		2) Press TAB and move to next Field
//		An error message "PIN code must not be
//		blank" must be shown

	@Test
	public void NC_17() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputTabToPinField(Keys.TAB);
		String messagePin = newCustomerPage.getTextPinMessage();
		verifyEquals("PIN Code must not be blank", messagePin);
	}

//		NC18 PIN must have 6 digits
//		1) Enter More than 6 digit in PIN field
//		2) Enter Less Than 6 digit in PIN field
//		12
//		123
//		An error message "PIN Code must have 6
//		Digits" must be shown
	@Test
	public void NC_18() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToPinField("1234");
		String messagePin = newCustomerPage.getTextPinMessage();
		verifyEquals("PIN Code must have 6 Digits", messagePin);
	}

//		NC19 PIN cannot have special character 
//		1) Enter Special Character In PIN Field
//		!@#
//		123!@#
//		An error message "Special characters are not allowed" must be shown
	@Test
	public void NC_19() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToPinField("123!@#");
		String messagePin = newCustomerPage.getTextPinMessage();
		verifyEquals("Special characters are not allowed", messagePin);
	}

//		NC20 PIN cannot have first blank space 
//		1) Enter First character Blank space
//		An error message "First character cannot be space" must be shown
	@Test
	public void NC_20() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToPinField("  City");
		String messagePin = newCustomerPage.getTextPinMessage();
		verifyEquals("First character can not have space", messagePin);
	}
//		NC21 PIN cannot have blank space 
//		1) Enter First character Blank space
//		An error message "PIN cannot have space" must be shown		

	@Test
	public void NC_21() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToPinField(" 123");
		String messagePin = newCustomerPage.getTextPinMessage();
		verifyEquals("First character can not have space", messagePin);
	}

// TELEPHONE

//		NC22 
//		Verify Telephone Field Telephone cannot be empty
//		1) Do not enter a value in Telephone Field
//		2) Press TAB and move to next Field
//		An error message "Telephone no must not be blank" must be shown
	@Test
	public void NC_22() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputTabToTelephoneFiled(Keys.TAB);
		String messageTelephone = newCustomerPage.getTextTelephoneMessage();
		verifyEquals("Mobile no must not be blank", messageTelephone);
	}

//		NC23
//		Telephone cannot have first character as blank space 
//		1) Enter First character Blank space
//		An error message "First character cannot be space" must be shown
	@Test
	public void NC_23() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToTelephoneField(" 0123");
		String messageTelephone = newCustomerPage.getTextTelephoneMessage();
		verifyEquals("First character can not have space", messageTelephone);
	}

//		NC24 
//		Telephone cannot have spaces 
//		1) Enter Blank space in Telephone 123 123
//		An error message "Telephone cannot have space" must be shown
	public void NC_24() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToPinField("123 123");
		String messageTelephone = newCustomerPage.getTextTelephoneMessage();
		verifyEquals("Characters are not allowed", messageTelephone);
	}

//		NC25
//		Telephone cannot have special character 
//		1) Enter Special Character In Telephone Field
//		886636!@12
//		!@88662682
//		88663682!@
//		An error message "Special characters are not allowed" must be shown	
	public void NC_25() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToPinField("886636!@12");
		String messageTelephone = newCustomerPage.getTextTelephoneMessage();
		verifyEquals("Special characters are not allowed", messageTelephone);
	}

// Email

//		NC26 
//		Verify Email Field Email cannot be empty
//		1) Do not enter a value in Email Field
//		2) Press TAB and move to next Field 
//		An error message "Email ID must not be blank" must be shown
	@Test
	public void NC_26() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputTabToEmailField(Keys.TAB);
		String messageEmail = newCustomerPage.getTextEmailMessage();
		verifyEquals("Email-ID must not be blank", messageEmail);
	}

//		NC27 
//		Email must be in correct format Enter invalid email in Email field
//		guru99@gmail
//		guru99
//		Guru99@
//		guru99@gmail.
//		guru99gmail.com
//		An error message "Email-ID is not valid""must be shown
	@Test
	public void NC_27() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToEmailField("guru99@gmail");
		String messageEmail = newCustomerPage.getTextEmailMessage();
		verifyEquals("Email-ID is not valid", messageEmail);
	}

//		NC29 
//		Email cannot have space 
//		1) Enter Blank space in Email
//  	An error message "Email-ID is not valid" must be shown

	@Test
	public void NC_29() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToEmailField("mail 123@test.c");
		String messageEmail = newCustomerPage.getTextEmailMessage();
		verifyEquals("Email-ID is not valid", messageEmail);
	}

	@Test
	public void NC_30() {
		newCustomerPage = homePage.clickMenuNewCustomer();
		newCustomerPage.inputToNewCustomer("Phamy");
		newCustomerPage.inputDateOfBirth("12/12/1990");
		newCustomerPage.inputToAddressField("123 cong hoa");
		newCustomerPage.inputToCityField("HCM");
		newCustomerPage.inputToStateField("HCM");
		newCustomerPage.inputToPinField("123456");
		newCustomerPage.inputToTelephoneField("0209092039");
		newCustomerPage.inputToEmailField("phamy" + randomNumber() + "@gmail.com");
		newCustomerPage.inputToPasswordField("123456789");
		newCustomerPage.clickSubmit();
		userID = newCustomerPage.getCustomerId();

		// verifyEquals("Email-ID is not valid", messageEmail);
	}

	// Edit customer script:

	// Skip testcase 5 , 6 , 7

//	@Test
//	public void NEC_011() {
//		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
//		editCustomerPage.inputToEditCustomer(userID);
//		editCustomerPage.clickSubmitAccount();
//
//	}
// Labels

//	NC30 Verify Field Labels
//	Check all Fields name(Label) are as documented in SRS for all modules Cross check Field names with that in SRS 
//	Field names in SRS and system should match

//	------------------Edit Customer ----------------

// **** Verify Customer id ****
//	NEC_01 Verify Customer id Customer id cannot be empty
//	1) Do not enter a value in Customer id
//	Field
//	2) Press TAB and move to next Field
//	An error message "Customer ID is required" must be shown
	@Test
	public void NEC_01() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputKeysToEditCustomer(Keys.TAB);
		String messageCustomerID = editCustomerPage.getTextCustomerIDMessage();
		verifyEquals("Customer ID is required", messageCustomerID);
	}

//	NEC2 Customer id must be numeric
//	1) Enter character value in Customer id
//	Field
//	1234Acc
//	Acc123
//	An error message "Characters are not allowed" must be shown
	@Test
	public void NEC_02() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer("Acc123");
		String messageCustomerID = editCustomerPage.getTextCustomerIDMessage();
		verifyEquals("Characters are not allowed", messageCustomerID);
	}
	
//	NEC_3 Customer id cannot have special character
//	1) Enter Special Character In Customer
//	id Field
//	123!@#
//	!@#
//	An error message "Special characters are not allowed" must be shown
	@Test
	public void NEC_03() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer("!@#");
		String messageCustomerID = editCustomerPage.getTextCustomerIDMessage();
		verifyEquals("Special characters are not allowed", messageCustomerID);
	}
	
//	NEC_4 Valid Customer Id
//	1) Enter valid Customer id
//	2) Submit xyz
//	Edit Customer successfully redirect to Edit Customer Page
	@Test
	public void NEC_04() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer("xyz");
		String messageCustomerID = editCustomerPage.getTextCustomerIDMessage();
		verifyEquals("Characters are not allowed", messageCustomerID);
	}
	
// ***** Verify Name Field *****	 // Skip testcase 5 , 6 , 7
//	NEC_5 Name cannot be empty
//	1) Do not enter a value in NAME Field
//	2) Press TAB and move to next Field
//	An error message "Name cannot be empty" must be shown

//	NEC_6 Name cannot be numeric 1) Enter numeric value in NAME Field
//	1234
//	name123
//	An error message "Name cannot contain numbers" must be shown

//	NEC_7 Name cannot have special character
//	1) Enter Special Character In NAME
//	Field
//	name!@#
//	!@#
//	An error message "Name cannot contain Special Characters" must be shown

//	**** Verify Address *****
//	NEC_8 Field Address cannot be empty
//	1) Do not enter a value in ADDRESS Field
//	2) Press TAB and move to next Field
//	An error message"ADDRESS cannot be empty" must be shown
	@Test
	public void NEC_08() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputTabToAddressField(Keys.TAB);
		String messageAddress = editCustomerPage.getTextAddressMessage();
		verifyEquals("Address Field must not be blank", messageAddress);
		
	}

//	****** Verify City Field ******* 
//	NEC_9 City cannot be empty	
//	1) Do not enter a value in CITY Field
//	2) Press TAB and move to next Field
//	An error message "CITY cannot be empty" must be shown
	@Test
	public void NEC_09() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputTabToCityField(Keys.TAB);
		String messageCity = editCustomerPage.getTextCityMessage();
		verifyEquals("City Field must not be blank", messageCity);
	}
//	MEC_10 City cannot be numeric 
//	1) Enter numeric value in CITY Field
//	1234
//	city123
//	An error message "City cannot contain Number" must be shown
	@Test
	public void NEC_010() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToCityField("City123");
		String messageCity = editCustomerPage.getTextCityMessage();
		verifyEquals("Numbers are not allowed", messageCity);
	}
	
//	MEC_11 City cannot have special character 
//	1) Enter Special Character In CITY Field
//	City!@#
//	!@#
//	An error message "City cannot contain Special Characters" must be shown
	@Test
	public void NEC_011() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToCityField("City!@#");
		String messageCity = editCustomerPage.getTextCityMessage();
		verifyEquals("Special characters are not allowed", messageCity);
	}
//	
//	****** Verify State Field******* 
//	NEC_12 state cannot be empty
//	1) Do not enter a value in STATE Field
//	2) Press TAB and move to next Field
//	An error message "STATE cannot be empty" must be shown
	@Test
	public void NEC_012() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputTabToStateField(Keys.TAB);
		String messageState = editCustomerPage.getTextStateMessage();
		verifyEquals("State must not be blank", messageState);
	}
//	MEC_13 State cannot be numeric 1) Enter numeric value in STATE Field
//	1234
//	State123
//	An error message "Numbers are not allowed" must be shown
	@Test
	public void NEC_013() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToStateField("1234");
		String messageState = editCustomerPage.getTextStateMessage();
		verifyEquals("Numbers are not allowed", messageState);
	}
//	EC14 State cannot have specialcharacter
//	1) Enter Special Character In STATE Field
//	State!@#
//	!@#
//	An error message "City cannot contain Special Characters" must be shown
	@Test
	public void NEC_014() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToStateField("State!@#");
		String messageState = editCustomerPage.getTextStateMessage();
		verifyEquals("Special characters are not allowed", messageState);
	}
	
//	*******Verify PIN Field*********
//	EC15  PIN must be numeric
//	1) Enter character value in PIN Field
//	1234
//	1234PIN
//	An error message "PIN cannot contain character"must be shown
	@Test
	public void NEC_015() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToPinField("1234Pin");
		String messagePin = editCustomerPage.getTextPinMessage();
		verifyEquals("Characters are not allowed", messagePin);
	}
	
//	EC16 PIN cannot be empty
//	1) Do not enter a value in PIN Field
//	2) Press TAB and move to next Field
//	An error message "PIN cannot be empty" must be shown
	@Test
	public void NEC_016() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputTabToPinField(Keys.TAB);
		String messagePin = editCustomerPage.getTextPinMessage();
		verifyEquals("PIN Code must not be blank", messagePin);
	}
	
//	EC17 PIN must have 6 digits
//	1) Enter More than 6 digit in PIN field
//	2) Enter Less Than 6 digit in PIN field
//	1234567
//	123
//	An error message "PIN must contain 6 digit"
	@Test
	public void NEC_017() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToPinField("1234");
		String messagePin = editCustomerPage.getTextPinMessage();
		verifyEquals("PIN Code must have 6 Digits", messagePin);
	}
	
//	EC18 PIN cannot have special character 
//	1) Enter Special Character In PIN Field
//	!@#
//	123!@#
//	An error message "PIN cannot contain Special Characters" must be shown
	@Test
	public void NEC_018() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToPinField("!@#");
		String messagePin = editCustomerPage.getTextPinMessage();
		verifyEquals("Special characters are not allowed", messagePin);
	}
//	******Verify Telephone Field********
//	EC19 Telephone cannot be empty
//	1) Do not enter a value in Telephone
//	Field
//	2) Press TAB and move to next Field
//	An error message "Telephone cannot be empty" must be shown
	@Test
	public void NEC_019() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputTabToTelephoneFiled(Keys.TAB);
		String messageTelephone = editCustomerPage.getTextTelephoneMessage();
		verifyEquals("Mobile no must not be blank", messageTelephone);
	}
//	EC20 Telephone cannot have special character 
//	1) Enter Special Character In PIN Field
//	886636!@12
//	!@88662682
//	88663682!@
//	An error message "Telephone cannot contain Special Characters" must be shown
	@Test
	public void NEC_020() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToTelephoneField("886636!@12");
		String messageTelephone = editCustomerPage.getTextTelephoneMessage();
		verifyEquals("Special characters are not allowed", messageTelephone);
	}

//	******Verify Email Field********
//	EC21 Verify Email Field Email cannot be empty
//	1) Do not enter a value in Email Field
//	2) Press TAB and move to next Field An error message "Email cannot be empty" must be shown
	@Test
	public void NEC_021() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputTabToEmailFiled(Keys.TAB);
		String messageEmail = editCustomerPage.getTextEmailMessage();
		verifyEquals("Email-ID must not be blank", messageEmail);
	}

//	EC22 Email must be in format
//	career@guru99.com Enter invalid email in Email field
//	guru99@gmail
//	guru99
//	Guru99@
//	gurugmail.com
//	An error message "Email must be in format example@example.com must be shown
	@Test
	public void NEC_022() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToEmailField("uru99@gmail");
		String messageEmail = editCustomerPage.getTextEmailMessage();
		verifyEquals("Email-ID is not valid", messageEmail);
	}
//	EC23 Email must be in format
//	career@guru99.com Enter invalid email in Email field
//	guru99@gmail
//	guru99
//	Guru99@
//	guru99@gmail.
//	guru99gmail.com
//	An error message "Email must be in format Example@example.com" must be shown
	@Test
	public void NEC_023() {
		editCustomerPage = newCustomerPage.clickMenuEditCustomer();
		editCustomerPage.inputToEditCustomer(userID);
		editCustomerPage.clickSubmitAccount();
		editCustomerPage.inputToEmailField("uru99@gmail.");
		String messageEmail = editCustomerPage.getTextEmailMessage();
		verifyEquals("Email-ID is not valid", messageEmail);
	}
	@AfterClass
	public void AfterClass() {
		closeBrowser();

	}

}
