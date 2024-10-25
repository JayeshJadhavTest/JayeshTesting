package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOut_Page_Two;
import pages.CheckOut_page_One;
import pages.Checkout_Complete;
import pages.InventoryPage;
import pages.Login;

public class Checkout_Complete_test extends TestBase
{
	Login login;
	InventoryPage invent;
	Cart_Page cart;
	CheckOut_page_One check;                           // CheckOut_Page_One is from pages using ctrl+space
	CheckOut_Page_Two checkTwo;
	Checkout_Complete complete;
	
	   @BeforeMethod
	   public void setUp() throws IOException
	   {
		   initialization();                          //form initilazation to check this part is known as object
		   login=new Login();
		   login.loginToApplication();
		   invent=new InventoryPage();
		   invent.add6products();
		   invent.clickonCartIcon();
		   cart=new Cart_Page();
		   cart.verifyCheckoutBtn();
		   check=new CheckOut_page_One();
		   check.InputInfo();                         //this is continueBTN method in CheckOutPage_One
		   checkTwo=new CheckOut_Page_Two();
		   checkTwo.verifyFinishBtn();
		   complete=new Checkout_Complete();
		   
	   } 
	   
	   @Test
	   public void verifySwagLabsLogotest()
	   {
		   String expLabel="Swag Labs";
		   String actLabel=complete.verifySwagLabsLogo();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyCheckouttxttest()
	   {
		   String expLabel="Checkout: Complete!";
		   String actLabel=complete.verifyCheckouttxt();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyCartBtntest()
	   {
		   String expURL="https://www.saucedemo.com/cart.html";
		   String actURL=complete.verifyCartBtn();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test
	   public void verifyCompleteLogotest()
	   {
		   boolean Result=complete.verifyCompleteLogo();
		   Assert.assertEquals(Result, true);
	   }
	   @Test
	   public void verifyThankYoutxttest()
	   {
		   String expText="Thank you for your order!";
		   String actText=complete.verifyThankYoutxt();
		   Assert.assertEquals(expText, actText);
	   }
	   @Test
	   public void verifyDispatchedtxttest()
	   {
		   String expText="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		   String actText=complete.verifyDispatchedtxt();
		   Assert.assertEquals(expText, actText);
	   }
	   @Test
	   public void verifyBackProductBtntest()
	   {
		   String expURL="https://www.saucedemo.com/inventory.html";
		   String actURL=complete.verifyBackProductBtn();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test
	   public void verifylogoTwittertest()
	   {
		   String expURL="https://www.saucedemo.com/checkout-complete.html";
		   String actURL=complete.verifylogoTwitter();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test
	   public void verifylogoFacebooktest()
	   {
		   String expURL="https://www.saucedemo.com/checkout-complete.html";  
		   String actURL=complete.verifylogoFacebook();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test
	   public void verifylogoLinkedintest()
	   {
		   String expURL="https://www.saucedemo.com/checkout-complete.html";
		   String actURL=complete.verifylogoLinkedin();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test
	   public void verifyTextFootertest()
	   {
		   boolean Result=complete.verifyTextFooter();
		   Assert.assertEquals(Result, true);
	   }
	   
	   @AfterMethod
	   public void closeBrowser()
	   {
		   report.flush();
		   driver.close();
	   }

	
}
