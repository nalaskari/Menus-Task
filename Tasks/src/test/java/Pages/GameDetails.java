package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import Core.Core;

public class GameDetails extends Core{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 @FindBy(id="prodQuantityId")
		public WebElement prodQuantity;
		public Select getProdQuantity() {
				  return new Select(prodQuantity);
				}
	 
	 @FindBy(how=How.XPATH,using="//a[@class='add-to-cart-button-big button small-rounded-corners']")
		WebElement addToCart;

	 @FindBy(how=How.XPATH,using="//span[contains(.,'Shopping Cart (1)')]")
		WebElement CheckCart;
	 
	// @FindBy(how=How.XPATH,using="//div[@id='gallery_nav']")
		//WebElement gameGallery;
	 
	 public void OpenCart()
	 {
		 CheckCart.click();
	 }
	 public void selectQuantity(String quantity)
	 {
		 getProdQuantity().selectByVisibleText(quantity);
	 }
	 
	 public void addToCart()
	 {
		 addToCart.click();
	 }
	 
//	  public static int returnOneElement (WebDriver driver){
	// 	gallery = driver.findElements(By.cssSelector(".someSelector div"));
	  //          for (WebElement element : elements){
	    //          if(element.getTagName("a")) {
	     //              return element;
	       //         }
	         //   }    
	       //return null;
	    
	 //}
	 
	 public void doGameOrder(String quantit)
	 {
	
		 selectQuantity(quantit);
		 addToCart();
		 OpenCart();
	 }
	  
}
