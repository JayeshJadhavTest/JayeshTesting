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
import pages.InventoryPage;
import pages.Login;

public class CheckOutpage_Two_Test extends TestBase
{
	Login login;
	InventoryPage invent;
	Cart_Page cart;
	CheckOut_page_One check;                           // CheckOut_Page_One is from pages using ctrl+space
	CheckOut_Page_Two checkTwo;
	
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
	   } 
	   @Test
	   public void verifyLogotest()
	   {
		   String expLabel="Swag Labs";
		   String actLabel=checkTwo.verifyLogo();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyoverviextxttest()
	   {
		   String expLabel="Checkout: Overview";
		   String actLabel=checkTwo.verifyoverviextxt();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyQRTtxttest()
	   {
		   String expLabel="QTY";
		   String actLabel=checkTwo.verifyQRTtxt();
		   Assert.assertEquals(expLabel, actLabel);
		
	   }
	   @Test
	   public void verifyDiscriptiontxttest()
	   {
		   String expLabel="Description";
		   String actLabel=checkTwo.verifyDiscriptiontxt();
		   Assert.assertEquals(expLabel, actLabel);
		   
	   }
	   @Test
	   public void verifyItemQtyNotxttest()
	   {
		   String expLabel="1";
		   String actLabel=checkTwo.verifyItemQtyNotxt();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyItemNametxttest()
	   {
		   String expLabel="Sauce Labs Backpack";
		   String actLabel=checkTwo.verifyItemNametxt();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyProductInfotxttest()
	   {
		   String expLabel="carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
		   String actLabel=checkTwo.verifyProductInfotxt();
		   Assert.assertEquals(expLabel,actLabel);
	   }
	   @Test
	   public void verifyProductPricetest()
	   {
		   String expLabel="$29.99";
		   String actLabel=checkTwo.verifyProductPrice();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifypaymentInfoLabeltest()
	   {
		   String expLabel="Payment Information:";
		   String actLabel=checkTwo.verifypaymentInfoLabel();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyPaymentInfoValuetest()
	   {
		   String expLabel="SauceCard #31337";
		   String actLabel=checkTwo.verifyPaymentInfoValue();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyShippingLabeltest()
	   {
		   String expLabel="Shipping Information:";
		   String actlabel=checkTwo.verifyShippingLabel();
		   Assert.assertEquals(expLabel, actlabel);
	   }
	   @Test
	   public void verifyShppingValuetest()
	   {
		   String expLabel="Free Pony Express Delivery!";
		   String actLabel=checkTwo.verifyShppingValue();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyPriceTotalLabeltest()
	   {
		   String expLabel="Price Total";
		   String actlabel=checkTwo.verifyPriceTotalLabel();
		   Assert.assertEquals(expLabel, actlabel);
	   }
	   @Test
	   public void verifyPricetxttest()
	   {
		   String expLabel="Item total: $129.94";
		   String actLabel=checkTwo.verifyPricetxt();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyTotaltest()
	   {
		   String expLabel="Total: $140.34";
		   String actLabel=checkTwo.verifyTotal();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test
	   public void verifyFinishBtntest()
	   {
		   String expURL="https://www.saucedemo.com/checkout-complete.html";
		   String actURL=checkTwo.verifyFinishBtn();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test
	   public void verifyCancleBtntest()
	   {
		   String expURL="https://www.saucedemo.com/inventory.html";
		   String actURL=checkTwo.verifyCancleBtn();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test
	   public void verifylogoTwittertest()
	   {
		   String expText="Twitter";
		   String actText=checkTwo.verifylogoTwitter();
		   Assert.assertEquals(expText, actText);
	   }
	   @Test
	   public void verifylogoFacebooktest()
	   {
		   String expText="Facebook";
		   String actText=checkTwo.verifylogoFacebook();
		   Assert.assertEquals(expText, actText);
	   }
	   @Test
	   public void verifylogoLinkedintest()
	   {
		   String expText="LinkedIn";
		   String actText=checkTwo.verifylogoLinkedin();
		   Assert.assertEquals(expText, actText);
	   }
	   @Test
	   public void verifyTextFootertest()
	   {
		       boolean Result =checkTwo.verifyTextFooter();
		       Assert.assertEquals(Result, true);
		   
	   } 
	   @AfterMethod
	   public void CloseBrowser()
	   {
		   report.flush();
		   driver.close();
	   }

	   
	   
	   
	   
}
