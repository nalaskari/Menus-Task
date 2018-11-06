package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Core.Core;

public class WelcomeScreen extends Core {
	
	   Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	   @FindBy(how=How.XPATH,using="(//a[@class='menu-item rounded-corners'])[2]")
		WebElement gamePage;
	  
		@FindBy(how=How.XPATH,using ="//div[@class='item'][1]")
		WebElement gameHover;
		
		@FindBy(how=How.XPATH,using ="(//a[contains(.,'Add to Cart')])[1]")
		WebElement addToCart_btn;
		
		@FindBy(how=How.XPATH,using ="//span[contains(@tabindex,'0')])[4]")
		WebElement priceMaxSlider;
	   
		@FindBy(how=How.XPATH,using ="(//div[contains(@class,'item-buttons-container')])[1]")
		WebElement openGameDetail;
		
		@FindBy(how=How.XPATH,using ="//span[contains(.,'Shopping Cart (1)')]")
		WebElement Cart;
		
	//Adding Item to cart 
	public void addItemToCart()
	{
		addToCart_btn.click();
	}
	
	// Hovering on Game Item
	public void hoverOnGameItem ()
	{
		 js.executeScript("arguments[0].scrollIntoView();", gameHover);
		 action.moveToElement(gameHover).build().perform();
	}
	
	//Open Games category page
	public void openGamesPage()
	{
		gamePage.click();
	}

	//selecting price range 
	public void selectPrceRange()
	{
		js.executeScript("arguments[0].setAttribute('style', 'left: 67.2131%;')",priceMaxSlider);

	}
	public void openCart()
	{
		Cart.click();
	}
	
   public void openGameDetail()
	{
		openGameDetail.click();
	}

	public void addGameToCart()
	{
		openGamesPage();
	    hoverOnGameItem();
	    addItemToCart();  
	    //openGameDetail();
	    openCart();
	}

}
