package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import Core.Core;

public class ShowCartItems extends Core {
	
	public  float orderTotal;
	public  float orderQuantity; 
	public  float itemPrice;
	
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

   @FindBy(how=How.XPATH,using="//a[@id='continue-button']")
	WebElement checkBtn;
  
	@FindBy(how=How.XPATH,using ="//td[@class='cost-overview-amounts right']")
	WebElement subTotalAmount;
	
	@FindBy(how=How.XPATH,using ="//input[@name='prodQty']")
	WebElement productQuantity;
	
	@FindBy(how=How.XPATH,using ="//td[@class='right']")
	WebElement productPrice;
   
		
		public float getsubTotalAmount()
		{
			orderTotal = Float.parseFloat(subTotalAmount.getText().substring(1,subTotalAmount.getText().length()));
            return orderTotal;
			
		}
		
	
		public float getproductQuantity()
		{
			orderQuantity = Float.parseFloat(productQuantity.getAttribute("value"));	
			return orderQuantity;
			
		}

	
		public float getProductPrice()
		{
			itemPrice = Float.parseFloat(productPrice.getText().substring(1,productPrice.getText().length()));
			return itemPrice;
			
		}
		
		public void clickCheckBtn()
		{
			checkBtn.click();
		}
	
		public void DoCheckOutOrder()
		{
			getProductPrice();
			getproductQuantity();
			getsubTotalAmount();
			clickCheckBtn();		
		}


}
