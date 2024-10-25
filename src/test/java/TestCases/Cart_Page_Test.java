package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.InventoryPage;
import pages.Login;
import utility.ReadData;

public class Cart_Page_Test extends TestBase
{
	Login login;
	InventoryPage invent;
	Cart_Page cart;
	   @BeforeMethod(alwaysRun = true)
	   public void setUp() throws IOException
	   {
		   initialization();
		   login=new Login();
		   login.loginToApplication();
		   invent=new InventoryPage();
		   invent.add6products();
		   invent.clickonCartIcon();
		   cart=new Cart_Page();
	   } 
	   @Test(groups = "Sanity")
	   public void verifyLogotest()
	   {
		   String expLabel="Swag Labs";
		   String actLabel=cart.verifyLogo();
		   Assert.assertEquals(expLabel, actLabel);
	   }
	   
	   @Test(groups = "Sanity")
	   public void VerifyCartLabeltest() throws EncryptedDocumentException, IOException
	   {
		   String expTitle=ReadData.readexcel(0, 6);
		   String actTitle=cart.VerifyCartLabel();
		   Assert.assertEquals(expTitle, actTitle);
	   }
	   @Test(groups = "Sanity")
	   public void QTYLabeltest() throws EncryptedDocumentException, IOException
	   {
		   String expTitle=ReadData.readexcel(0, 7);
		   String actTitle=cart.VerifyQTYLabel();
		   Assert.assertEquals(expTitle, actTitle);
	   }
	   @Test(groups = "Sanity")
	   public void descrlabeltest() throws EncryptedDocumentException, IOException
	   {
		   String expTitle=ReadData.readexcel(0, 8);
		   String actTitle=cart.VerifyDiscriptionLabel();
		   Assert.assertEquals(expTitle, actTitle);
	   }
	   @Test(groups = "Sanity")
	   public void CheckoutBtntest() throws EncryptedDocumentException, IOException
	   {
		   String expURL=ReadData.readexcel(0, 9);
		   String actURL=cart.verifyCheckoutBtn();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test (groups = "Sanity")
	   public void VerifyContinueshopingBtntest() throws EncryptedDocumentException, IOException
	   {
		   String expURL=ReadData.readexcel(0, 10);
		   String actURL=cart.VerifyContinueshopingBtn();
		   Assert.assertEquals(expURL, actURL);
	   }
	   
	   @Test(groups = "Sanity")
	   public void VerifyRemovePrdcttest() throws EncryptedDocumentException, IOException
	   {
		   String expURL=ReadData.readexcel(0, 11);
		   String actURL=cart.VerifyRemovePrdct();
		   Assert.assertEquals(expURL, actURL);
	   }
	   @Test(groups = "Sanity")
	   public void verifylogoTtest()
	   {
		   String expText="Twitter";
		   String actText=cart.verifylogoT();
		   Assert.assertEquals(expText, actText);
	   }
	   @Test(groups = "Sanity")
	   public void verifylogoFtest()
	   {
		   String expText="Facebook";
		   String actText=cart.verifylogoF();
		   Assert.assertEquals(expText, actText);
	   }
	   @Test(groups = "Saanity")
	   public void verifylogoLTest()
	   {
		   String expText="LinkedIn";
		   String actText=cart.verifylogoL();
		   Assert.assertEquals(expText, actText);
	   }
	   @Test(groups = "Sanity")
	   public void verifyTextFootertest()
	   {
		       boolean Result =cart.verifyTextFooter();
		       Assert.assertEquals(Result, true);
		   
	   } 
	   @AfterMethod(alwaysRun = true)
	   public void closeBrowser()
	   {
		   report.flush();
		   driver.close();
	   }
	   
}
