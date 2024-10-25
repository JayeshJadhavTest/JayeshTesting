package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.Login;
import utility.ReadData;
import utility.ScreenShot;

public class LoginTest extends TestBase
{
   Login login;
   @BeforeMethod(alwaysRun = true)            //whenever we can use data provider that time always add alwaysrun in beforemethod bracate. 
   public void setUp() throws IOException
   {
	   initialization();
	   login=new Login();
	   
   }
   @Test(priority = 1,enabled = true,groups = "Sanity")
   public void verifyURLOfApplication() throws EncryptedDocumentException, IOException
   {
	   String expURL=ReadData.readexcel(0,0);    //"https://www.saucedemo.com/";(0,0)
	   String actURL=login.verifyURLOfApplication();
	   Assert.assertEquals(expURL, actURL);
	   Reporter.log("URL of Swag Labs= " + actURL); 
   }
   @Test (priority = 2, enabled = true,groups = {"Retest","Regression"}      /*dependsOnMethods = "verifyURLOfApplication"*/)
   public void verifyTitleOfApplication() throws EncryptedDocumentException, IOException
   {
	   String expURL=ReadData.readexcel(0,1);     //"Swag Labs";(0,1)
	   String actURL=login.verifyTitleOfApplication();
	   Assert.assertEquals(expURL, actURL);
	   Reporter.log("Titletext of Swag Labs= " + actURL);
   }
   @Test (priority = 3, enabled = true,groups = "Regression"     /*dependsOnMethods = "verifyURLOfApplication"*/)
   public void loginToApplication() throws IOException
   {
	   String expURL=ReadData.readexcel(0,2);        //"https://www.saucedemo.com/inventory.html";(0,2)
	   String actURL=login.loginToApplication();
	   Assert.assertEquals(expURL, actURL);
	   Reporter.log("Login Successful of Swag Labs= " + actURL);
   }
   @Test(dataProvider ="testdata")                    //in one class we can make multiple dataprovider,so always mention dataprovider name in @test method
   public void verifyMulticredstest(String Un,String Password)
   {
	   SoftAssert s=new SoftAssert();                   //softassert use because all array data are run +ve or -ve both
	   String expURL="https://www.saucedemo.com/inventory.html";
	   String actURL=login.verifyMulticreds(Un, Password);
	   s.assertEquals(expURL, actURL);
	   s.assertAll();                                     //for getting ALL assertion
   }
   @DataProvider(name="testdata")
   public Object[][] getdata()                                 //this is object method becz its parent class
   {
	   return new Object[][]                                   //first[]array for un second []array for password
			   {
		   {"standard_user","secret_sauce"},
		   {"locked_out_user","secret_sauce"},                //this testcase is fail becz it will not nevigate to next url
		   {"problem_user","secret_sauce"},
		   {"performance_glitch_user","secret_sauce"},
		   {"error_user","secret_sauce"},
		   {"visual_user","secret_sauce"}
		   
		       };
   }
   @AfterMethod(alwaysRun = true)                         //same as beforemethod dataprovider whenever we use always mention alwaysrun this in aftermethod also
   public void closeBrowser(ITestResult it) throws IOException
   {
	   if(it.FAILURE==it.getStatus())                  //ScreenShot code for fail testcases during running code
	   {
		   ScreenShot.Scrsht(it.getName());
	   }
	   report.flush();          //all information of login page methods are write here for ouput view.
	   driver.close();
   }
}
