package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class Login extends TestBase
{
	//object repository
	@FindBy (xpath="//input[@id='user-name']") private WebElement usretxtbox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordtxtbox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginbtn;
	
	public Login()
	{
		PageFactory.initElements(driver,this);
	}
	public String loginToApplication() throws IOException
	{
		logger=report.createTest("Login to Sauce Labs");
		usretxtbox.sendKeys(ReadData.readprpertyFile("UserName"));
		logger.log(Status.INFO, "Username is entered");                    //for proper discription in report select .log(status status,String Details)
		passwordtxtbox.sendKeys(ReadData.readprpertyFile("Password"));
		logger.log(Status.INFO, "Password is entered");
		loginbtn.click();
		logger.log(Status.INFO, "Login Button is Clicked");
		logger.log(Status.PASS, "Login Sucessfull");
		return driver.getCurrentUrl(); //https://www.saucedemo.com/inventory.html 
	}
	
	public String verifyMulticreds(String Un,String Password)       //this is access specifier & here we make method parameterize because do not write all id and passwords directly get data from data provider thats why un and password are present here.
	{
		usretxtbox.sendKeys(Un);
		passwordtxtbox.sendKeys(Password);
		loginbtn.click();
		return driver.getCurrentUrl(); //https://www.saucedemo.com/inventory.html 
	}
   public String verifyURLOfApplication()
   {
	   logger=report.createTest("Getting URL");
	   logger.log(Status.INFO, "Get the URL of SauceLabs Application");
	   return driver.getCurrentUrl();
	 
   }
   public String verifyTitleOfApplication()
   {
	   logger=report.createTest("Verify Title of application");
	   logger.log(Status.INFO, "Get the Title of SauceLabs Application");
	   return driver.getTitle();
   }
}
