package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core.Core;

import Pages.GameDetails;

public class TC03_OpenGameDetailsPage extends Core {
	
	@DataProvider(name = "getQuantity")
	public String[][] testdate() throws IOException {

		String[][] data = datareader.ReadExcel(
				System.getProperty("user.dir") + "\\TestData\\TestData.xlsx", "Sheet2");

		return data;
	}
	
	@Test(dataProvider = "getQuantity")
	public void test_003_Open_Games_Details(String quantity) throws Exception
	{
	    GameDetails gameDetails =PageFactory.initElements(driver, GameDetails.class);
	    gameDetails.doGameOrder("2");
		log.debug("Open Game Detail page and select quantites");
	}
	
}
