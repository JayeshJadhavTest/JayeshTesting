package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.HandleDropDownList;

public class InventoryPage extends TestBase
{
    //Object repository
	//add product
	@FindBy(xpath="//span[text()='Products']") private WebElement prodlable;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpack;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement backlight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTshirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacket;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesie;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement Tshirt;
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement SwagLabsLogo;
	//remove product
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removeonesie;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeRedTShirt;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath="/a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement LinkedinLogo;
	@FindBy(xpath="//div[@data-test='footer-copy']") private WebElement FooteLine;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement DropdownBox;
	@FindBy(xpath="//span[@data-test='shopping-cart-badge']") private WebElement CartCount;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;  
	public InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyLogo()
	{
		logger=report.createTest("Logo Is visibel");
		logger.log(Status.INFO, "Swag Labs LOGO");
		return SwagLabsLogo.getText(); 
	}
	
	public String verifyTitleOfInventoryPage()

	{
		logger=report.createTest("Title of Inventory Page");
		logger.log(Status.INFO, "Get the Title of SwagLabs Application");
		return driver.getTitle();
	}
	
	public boolean VerifyTwitterLogo() 
	{
		logger=report.createTest("Twitter Logo");
		logger.log(Status.INFO, "Get the Logo of Twitter");
		return TwitterLogo.isDisplayed();
	}
	
	public String add6products()
	{
		HandleDropDownList.handlelistbox(DropdownBox, "Price (low to high)");
		backpack.click();
		backlight.click();
		boltTshirt.click();
		jacket.click();
		onesie.click();
		Tshirt.click();
		return CartCount.getText();
	}
	
	public String remove2products()
	{
		add6products(); // calling add product method
		removeonesie.click();
		removeRedTShirt.click();
		return CartCount.getText();
	}
	
	public void clickonCartIcon()
	{
		cartIcon.click();
	}

	
}
