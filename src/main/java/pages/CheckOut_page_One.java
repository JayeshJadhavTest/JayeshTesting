package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;

public class CheckOut_page_One extends TestBase
{
      @FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement checkoutlabel;
      @FindBy(xpath="//input[@id='first-name']") private WebElement Firstnamebox;
      @FindBy(xpath="//input[@id='last-name']") private WebElement Lastnamebox;
      @FindBy(xpath="//input[@id='postal-code']") private WebElement Postalcodebox;
      @FindBy(xpath="//input[@id='continue']") private WebElement ContinueBtn;
      @FindBy(xpath="//button[@id='cancel']") private WebElement CancleBtn;
      @FindBy(xpath="//div[text()='Swag Labs']") private WebElement SwagLabsLogo;
      public CheckOut_page_One()
      {
    	  PageFactory.initElements(driver, this);
      }
      public String verifyLogo()
       {
   		
   		return SwagLabsLogo.getText(); 
   	   }
      public String verifychecklabel()                        //mostly used String in page 
      {
    	  logger=report.createTest("Check Label");
   	      logger.log(Status.INFO, "Get the Label of SauceLabs Application");
    	  return checkoutlabel.getText(); 
      }
      public String InputInfo()
      {
    	  logger=report.createTest("Input the Information");
   	      logger.log(Status.INFO, "insert information for checkout page");
    	  Firstnamebox.sendKeys("Tom");
    	  Lastnamebox.sendKeys("Jerry");
    	  Postalcodebox.sendKeys("424002");
    	  ContinueBtn.click();
    	  return driver.getCurrentUrl();  //https://www.saucedemo.com/checkout-step-two.html
      }
     
      public String verifyCancleBtn()
      {
    	  logger=report.createTest("Cancel button");
   	      logger.log(Status.INFO, "button is clickble");
    	  CancleBtn.click();
    	  return driver.getCurrentUrl(); //https://www.saucedemo.com/cart.html
      }
     
      
}

