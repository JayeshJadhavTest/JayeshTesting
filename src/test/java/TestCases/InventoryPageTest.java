package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.InventoryPage;
import pages.Login;
import utility.ReadData;

public class InventoryPageTest extends TestBase
{
	Login login;
	InventoryPage invent;
	   @BeforeMethod(alwaysRun = true)
	   public void setUp() throws IOException
	   {
		   initialization();
		   login=new Login();
		   login.loginToApplication();
		   invent=new InventoryPage();
	   } 
	   @Test(groups = "Sanity")
	   public void verifyLogotest()
	   {
		   String expLabel="Swag Labs";
		   String actLabel=invent.verifyLogo(); 
		   Assert.assertEquals(expLabel, actLabel);  
	   }
	   @Test(groups = {"Retest","Regression"})
	   public void verifyTitleOfInventoryPageTest() throws EncryptedDocumentException, IOException 
	   {
		   String expTitle=ReadData.readexcel(0,3);   //"Swag Labs";(0,3)
		   String actTitel=invent.verifyTitleOfInventoryPage();
		   Assert.assertEquals(expTitle, actTitel);
	   }
	   
	   @Test(groups = "Sanity")
	   public void VerifyTwitterLogoTest()
	   {
	       boolean Result = invent.VerifyTwitterLogo();
	       Assert.assertEquals(Result, true);
	   }
	   
	   @Test(groups = "Sanity")
	   public void add6products() throws EncryptedDocumentException, IOException
	   {
		   String expCount=ReadData.readexcel(0,4);  //"6";(0,4)
		   String actCount= invent.add6products();
		   Assert.assertEquals(expCount, actCount);
	   }
	   
	   @Test(groups = "Sanity")
	   public void remove2products() throws EncryptedDocumentException, IOException
	   {
		   String expCount=ReadData.readexcel(0,5);   //"4";(0,5)
		   String actCount=invent.remove2products();
		   Assert.assertEquals(expCount, actCount);
		   
	   }
	   
	   @AfterMethod(alwaysRun = true)
	   public void closeBrowser()
	   {
		   report.flush();     
		   driver.close();
	   }
	   
}
