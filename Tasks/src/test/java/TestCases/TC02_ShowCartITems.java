package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Core.Core;
import Pages.ShowCartItems;


public class TC02_ShowCartITems extends Core{

	@Test
	public void test_002_Show_Cart_Items() throws Exception
	{
	   
	    ShowCartItems cartItems =PageFactory.initElements(driver, ShowCartItems.class);
	    cartItems.DoCheckOutOrder();
		log.debug("Cart is Checked out");
		
		
	}
}
