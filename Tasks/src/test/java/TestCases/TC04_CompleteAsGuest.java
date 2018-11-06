package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core.Core;
import Pages.CompleteAsGuest;


public class TC04_CompleteAsGuest extends Core{
	
	
	@DataProvider(name = "Adddata")
	public String[][] testdate() throws IOException {

		String[][] data = datareader.ReadExcel(
				System.getProperty("user.dir") + "\\TestData\\TestData.xlsx", "Sheet1");

		return data;

	}

	@Test(dataProvider = "Adddata")
	public void test_004_Complete_As_Guest(String FirstName, String LastName,String Email,String UserName,String CompanyName,String StreetAddress,String suburb,String PostCode,String City, String State, String PrimaryTelephoneNumber,String OtherTelephoneNumber,String FaxNumber) throws Exception
	{
	    CompleteAsGuest completeAsGuest =PageFactory.initElements(driver, CompleteAsGuest.class);
	    completeAsGuest.DoRegister(FirstName, LastName, Email, UserName, CompanyName, StreetAddress, suburb, PostCode, City, State, PrimaryTelephoneNumber, OtherTelephoneNumber, FaxNumber);
		log.debug("Cart is Checked out");	
	}
}
