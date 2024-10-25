package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;

public class Checkout_Complete extends TestBase
{
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement SwagLabsLogo;
	@FindBy(xpath="//span[text()='Checkout: Complete!']") private WebElement Checkouttxt;
	@FindBy(xpath="//div[@id='shopping_cart_container']") private WebElement CartBtn;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement CompleteLogo;
	@FindBy(xpath="//h2[text()='Thank you for your order!']") private WebElement ThankYoutxt;
	@FindBy(xpath="//div[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']") private WebElement Dispatchedtxt;
	@FindBy(xpath="//button[@id='back-to-products']") private WebElement BackProductBtn;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement LinkedinLogo;
	@FindBy(xpath="//div[@data-test='footer-copy']") private WebElement FooteLine;
	
	public Checkout_Complete()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifySwagLabsLogo()
	{
		return SwagLabsLogo.getText();
	}
	public String verifyCheckouttxt()
	{
		return Checkouttxt.getText();
	}
	public String verifyCartBtn()
	{
		logger=report.createTest("Cart Button");
		logger.log(Status.INFO, "Cart Button is Clickable");
		CartBtn.click();
		return driver.getCurrentUrl();   //https://www.saucedemo.com/cart.html
	}
	public boolean verifyCompleteLogo()
	{
		return CompleteLogo.isDisplayed();
	}
	public String verifyThankYoutxt()
	{
		return ThankYoutxt.getText();
	}
	public String verifyDispatchedtxt()
	{
		return Dispatchedtxt.getText();
	}
	public String verifyBackProductBtn()
	{
		logger=report.createTest("Back Button");
		logger.log(Status.INFO, "Back button is clickable");
		BackProductBtn.click();
		return driver.getCurrentUrl();   //https://www.saucedemo.com/inventory.html
	}
	public String verifylogoTwitter()
    {
   	 
		TwitterLogo.click();
		return driver.getCurrentUrl();   //https://x.com/saucelabs
   	 
    }
    public String verifylogoFacebook()
    {
   	 
    	FacebookLogo.click();
    	return driver.getCurrentUrl();    //https://www.facebook.com/saucelabs
   	 
    }
    public String verifylogoLinkedin()
    {
   	 
    	LinkedinLogo.click();
    	return driver.getCurrentUrl();     //https://www.linkedin.com/company/sauce-labs/
   	 
    }
    public boolean verifyTextFooter()
    {
    	logger=report.createTest("Footer is visible");
		logger.log(Status.INFO, "Footer is visible proper");
   	    return FooteLine.isDisplayed();
   	 
    }
}

