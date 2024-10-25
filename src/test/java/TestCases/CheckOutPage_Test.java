package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOut_page_One;
import pages.InventoryPage;
import pages.Login;

public class CheckOutPage_Test extends TestBase
{
	Login login;
	InventoryPage invent;
	Cart_Page cart;
	CheckOut_page_One check;  // CheckOut_Page_One is from pages using ctrl+space
	   @BeforeMethod(alwaysRun = true)
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
		
	   }
	   @Test(groups = "Sanity")
	   public void verifyLogotest()
	   {
		   String expLabel="Swag Labs";
		   String actLabel=check.verifyLogo();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   @Test(groups = "Sanity")
	   public void verifychecklabeltest()                  //mostly used void in test
	   {
		   String expTitle="Checkout: Your Information";
		   String actTitle=check.verifychecklabel();
		   Assert.assertEquals(expTitle, actTitle);
	   }
	   @Test(groups = "Sanity")
	   public void InputInfotest()
	   {
		   String expURL="https://www.saucedemo.com/checkout-step-two.html";
		   String actURL=check.InputInfo();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test(groups = "Sanity")
	   public void verifyCancleBtntest()
	   {
		   String expURL="https://www.saucedemo.com/cart.html";
		   String actURL=check.verifyCancleBtn();
		   Assert.assertEquals(expURL, actURL);
	   }
	   
	   @AfterMethod(alwaysRun = true)
	   public void closeBrowser()
	   {
		   report.flush();  
		   driver.close();
	   }
	   
}
