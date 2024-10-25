package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;

public class CheckOut_Page_Two extends TestBase
{
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement SwagLabsLogo;
	@FindBy(xpath="//span[text()='Checkout: Overview']") private WebElement Overviewtxt;
	@FindBy(xpath="//div[text()='QTY']") private WebElement QTYtxt;
	@FindBy(xpath="//div[text()='Description']") private WebElement Descrptiontxt;
	@FindBy(xpath="//div[@data-test='item-quantity']") private WebElement ItemQtyNo;
	@FindBy(xpath="//div[@data-test='inventory-item-name']") private WebElement ItemNametxt;
	@FindBy(xpath="//div[@class='inventory_item_desc']") private WebElement ProductInfotxt;
	@FindBy(xpath="//div[@class='inventory_item_price']") private WebElement ProductPrice;
	@FindBy(xpath="//div[text()='Payment Information:']") private WebElement paymentInfoLabel;
	@FindBy(xpath="//div[text()='SauceCard #31337']") private WebElement PaymentInfoValue;
	@FindBy(xpath="//div[text()='Shipping Information:']") private WebElement ShippingLabel;
	@FindBy(xpath="//div[text()='Free Pony Express Delivery!']") private WebElement ShppingValue;
	@FindBy(xpath="//div[text()='Price Total']") private WebElement PriceTotalLabel;
	@FindBy(xpath="//div[@class='summary_subtotal_label']") private WebElement Pricetxt;
	@FindBy(xpath="//div[@class='summary_total_label']") private WebElement Totaltxt;
	@FindBy(xpath="//button[@id='finish']") private WebElement FinishBtn;
	@FindBy(xpath="//button[@id='cancel']") private WebElement CancleBtn;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement LinkedinLogo;
	@FindBy(xpath="//div[@data-test='footer-copy']") private WebElement FooteLine;
	
	public CheckOut_Page_Two()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyLogo()
   	{
   		return SwagLabsLogo.getText(); 
   	}
	public String verifyoverviextxt()
	{
		logger=report.createTest("overview text is enabled");
		logger.log(Status.INFO, "text is in proper format");
		return Overviewtxt.getText();
	}
	public String verifyQRTtxt()
	{
		return QTYtxt.getText();
	}
	public String verifyDiscriptiontxt()
	{
		return Descrptiontxt.getText();
	}
	public String verifyItemQtyNotxt()
	{
		return ItemQtyNo.getText();
	}
	public String verifyItemNametxt()
	{
		return ItemNametxt.getText();
	}
	public String verifyProductInfotxt()
	{
		return ProductInfotxt.getText();
	}
	public String verifyProductPrice()
	{
		return ProductPrice.getText();
	}
	public String verifypaymentInfoLabel()
	{
		return paymentInfoLabel.getText();
	}
	public String verifyPaymentInfoValue()
	{
		return PaymentInfoValue.getText();
	}
	public String verifyShippingLabel()
	{
		return ShippingLabel.getText();
	}
	public String verifyShppingValue()
	{
		return ShppingValue.getText();
	}
	public String verifyPriceTotalLabel()
	{
		return PriceTotalLabel.getText();
	}
	public String verifyPricetxt()
	{
		return Pricetxt.getText();
	}
	public String verifyTotal()
	{
		return Totaltxt.getText();
	}
	public String verifyFinishBtn()
	{
		logger=report.createTest("finish button");
		logger.log(Status.INFO, "Finish button is clickable");
		FinishBtn.click();
		return driver.getCurrentUrl();  //https://www.saucedemo.com/checkout-complete.html
	}
	public String verifyCancleBtn()
	{
		logger=report.createTest("Cancel button");
		logger.log(Status.INFO, "cancel button is clickable");
		CancleBtn.click();
		return driver.getCurrentUrl();   //https://www.saucedemo.com/inventory.html
	}
	public String verifylogoTwitter()
    {
   	 return TwitterLogo.getText();
   	 
    }
    public String verifylogoFacebook()
    {
   	 return FacebookLogo.getText();
   	 
    }
    public String verifylogoLinkedin()
    {
   	 return LinkedinLogo.getText();
   	 
    }
    public boolean verifyTextFooter()
    {
   	 return FooteLine.isDisplayed();
   	 
    }
}

