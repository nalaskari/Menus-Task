package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core.Core;
import Pages.WelcomeScreen;

public class TC01_OpenGameCateogry extends Core{
	
	
	@Test
	public void test_001_Welcome_Screen() throws Exception
	{
	   
	    WelcomeScreen welcome =PageFactory.initElements(driver, WelcomeScreen.class);
		welcome.addGameToCart();
		log.debug("Game Added to the Cart");
		
		
	}

}
