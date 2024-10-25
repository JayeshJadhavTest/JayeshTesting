package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;

public class Cart_Page extends TestBase
{
     @FindBy(xpath="//span[text()='Your Cart']") private WebElement cartLabel;
     @FindBy(xpath="//div[text()='QTY']") private WebElement QTYLabel;
     @FindBy(xpath="//div[text()='Description']") private WebElement descrlabel;
     @FindBy(xpath="//button[@id='checkout']") private WebElement CheckoutBtn;
     @FindBy(xpath="//button[@id='continue-shopping']") private WebElement ContinueshoppingBtn;
     @FindBy(xpath="//a[text()='Twitter']") private WebElement TwitterLogo;
 	 @FindBy(xpath="//a[text()='Facebook']") private WebElement FacebookLogo;
 	 @FindBy(xpath="//a[text()='LinkedIn']") private WebElement LinkedinLogo;
 	 @FindBy(xpath="//div[@data-test='footer-copy']") private WebElement FooteLine;
 	 @FindBy(xpath="//div[text()='Swag Labs']") private WebElement SwagLabsLogo;
     //remove product
     @FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement BikeLightRemove;
     
     public Cart_Page()
     {
    	 PageFactory.initElements(driver, this); 
     }  
     public String verifyLogo()
 	{
 		
 		return SwagLabsLogo.getText(); 
 	}
     
     public String VerifyCartLabel()
     {
    	 return cartLabel.getText();
     }
     public String VerifyQTYLabel()
     {
    	 return QTYLabel.getText();
    	 
     }
     public String VerifyDiscriptionLabel()
     {
    	 return descrlabel.getText();
     }
     public String verifyCheckoutBtn()
     {
    	 logger=report.createTest("Check Button");
 		 logger.log(Status.INFO, "Check Button is clickable");
    	 CheckoutBtn.click();
    	 return driver.getCurrentUrl();   //https://www.saucedemo.com/checkout-step-one.html
     }
     
     public String VerifyContinueshopingBtn()
     {
    	 logger=report.createTest("continue Button");
 		 logger.log(Status.INFO, "Continue button is clickable");
    	 ContinueshoppingBtn.click();
    	 return driver.getCurrentUrl();   //https://www.saucedemo.com/inventory.html
     }
     public String verifylogoT()
     {
    	 return TwitterLogo.getText();
    	 
     }
     public String verifylogoF()
     {
    	 return FacebookLogo.getText();
    	 
     }
     public String verifylogoL()
     {
    	 return LinkedinLogo.getText();
    	 
     }
     public boolean verifyTextFooter()
     {
    	 return FooteLine.isDisplayed();
    	 
    	 
     }
     public String VerifyRemovePrdct()
     {
    	 logger=report.createTest("Remove product");
 		 logger.log(Status.INFO, "Product remove sucessfully");
    	 BikeLightRemove.click();
    	 return driver.getCurrentUrl();   //https://www.saucedemo.com/cart.html
     }
}
