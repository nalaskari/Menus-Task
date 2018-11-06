package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import Core.Core;

public class CompleteAsGuest extends Core {
   	
	// Inspecting elements for the Web page 
	
	
    @FindBy(how=How.XPATH,using="//span[contains(.,'Checkout as a guest')]")
   	WebElement checkAsGuestBtn;
   	
    @FindBy(how=How.XPATH,using="//input[@value='f']")
	WebElement gender;

    @FindBy(how=How.XPATH,using="//input[@id='firstName']")
	WebElement firstName;

    @FindBy(how=How.XPATH,using="//input[@id='lastName']")
	WebElement lastName;
 
    @FindBy(how=How.XPATH,using="//input[@id='emailAddr']")
	WebElement email;

    @FindBy(how=How.XPATH,using="//input[@id='username']")
	WebElement userName;
 
    @FindBy(how=How.XPATH,using="//input[@id='company']")
	WebElement companyName;
  
    @FindBy(how=How.XPATH,using="//input[@id='streetAddress']")
	WebElement streetAddress;
 
    @FindBy(how=How.XPATH,using="//input[@id='suburb']")
	WebElement Suburb;

   @FindBy(how=How.XPATH,using="//input[@id='postcode']")
	WebElement postCode;
 
    @FindBy(how=How.XPATH,using="//input[@id='city']")
	WebElement city;

    // Make actions on the elements
    
    String Date= "22/09/1990";
    
    @FindBy(id="state")
 	public WebElement state;
	public Select getStateSelect() {
		  return new Select(state);
		}
	
    @FindBy(id="countryId")
	public WebElement country;
	public Select getCountrySelect() {
			  return new Select(country);
			}
		
	 @FindBy(how=How.XPATH,using="//input[@id='telephoneNumber']")
	 WebElement primaryTelephoneNumber;
	 
	 @FindBy(how=How.XPATH,using="//input[@id='telephoneNumber1']")
	 WebElement otherTelephoneNumber;
	 
	 @FindBy(how=How.XPATH,using="//input[@id='faxNumber']")
	 WebElement faxNumber;
	 
	 @FindBy(how=How.XPATH,using="//a[@id='continue-button']")
	 WebElement continueBtn;
	 
	 @FindBy(how=How.XPATH,using="//input[@id='datepicker']")
	 WebElement dateOfBirth;
	 
	  
	 public void ContinueAsGuest()
	 {
		 checkAsGuestBtn.click();
	 }
	 
	 public void getGender()
	 {
		 gender.click();
	 }
	
	 public void getFirstName(String FirstName)
	 {
		 firstName.sendKeys(FirstName);
	 }
	
	 public void getLastName(String LastName)
	 {
		 lastName.sendKeys(LastName);
	 }
	 
	 public void getEmail(String Email)
	 {
		 email.sendKeys(Email);
	 }
	
	 public void getUserName(String UserName)
	 {
		 userName.sendKeys(UserName);
	 }
	 
	 public void getCompanyName(String CompanyName)
	 {
		 companyName.sendKeys(CompanyName);
	 }
	 
	 public void getStreetAddress(String StreetAddress)
	 {
		 streetAddress.sendKeys(StreetAddress);
	 }
	 
	 public void getSuburb(String suburb)
	 {
		 Suburb.sendKeys(suburb);
	 }
	 
	 public void getPostCode(String PostCode)
	 {
		 postCode.sendKeys(PostCode);
	 }
	 
	 public void getCity(String City)
	 {
		 city.sendKeys(City);
	 }
	 
	 public void selectState(String State)
	 {
		 getStateSelect().selectByVisibleText(State);
	 }
	 
	 public void selectCountry()
	 {
		 getCountrySelect().getFirstSelectedOption();
	 }
	 
	 public void selectPrimaryTelephoneNumber(String PrimaryTelephoneNumber)
	 {
		 primaryTelephoneNumber.sendKeys(PrimaryTelephoneNumber);
	 }
	 
	 public void selectOtherTelephoneNumber(String OtherTelephoneNumber)
	 {
		 otherTelephoneNumber.sendKeys(OtherTelephoneNumber);
	 }
	 
	 public void selectFaxNumber(String FaxNumber)
	 {
		 faxNumber.sendKeys(FaxNumber);
	 }
	 
	 public void clickContinueBtn()
	 {
		 continueBtn.click();
	 }
	 
	 public static void selectDate (WebDriver driv, WebElement dateElement , String date)
	 {
	 JavascriptExecutor jS = ((JavascriptExecutor) driv);
	 jS.executeScript("arguments[0].setAttribute('value','"+ date +"');", dateElement);
	 }
	 
	 
	 public void DoRegister(String tFirstName,String tLastName, String tEmail, String tUserName, String tCompanyName,String tStreetAddress, String tsuburb,String tPostCode,String tCity, String tState, String tPrimaryTelephoneNumber, String tOtherTelephoneNumber, String tFaxNumber)
	 {
		 ContinueAsGuest();
		 getGender();
		 getFirstName(tFirstName);
		 getLastName(tLastName);
		 getEmail(tEmail);
		 getUserName(tUserName);
		 getCompanyName(tCompanyName);
		 getStreetAddress(tStreetAddress);
		 getSuburb(tsuburb);
		 getPostCode(tPostCode);
		 getCity(tCity);
		 selectState(tState);
		 selectCountry();
		 selectDate(driver, dateOfBirth, Date);
		 selectPrimaryTelephoneNumber(tPrimaryTelephoneNumber);
		 selectOtherTelephoneNumber(tOtherTelephoneNumber);
		 selectFaxNumber(tFaxNumber);
		 clickContinueBtn();
		 
	 }
	 
}


