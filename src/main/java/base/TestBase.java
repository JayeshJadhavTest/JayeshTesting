package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Extent_reports;
import utility.ReadData;

public class TestBase
{
   public ExtentReports report=Extent_reports.getreportInstance();
   public ExtentTest logger;               //create object logger it is userdefined, if we want pass/fail/skip any method that information we can write with the help of extenttest.
   public static WebDriver driver;
   public void initialization() throws IOException
   {
	   String browser=ReadData.readprpertyFile("BROWSER");
	   if(browser.equals("Chrome"))
	   {
		   WebDriverManager.chromedriver(); 
		   driver=new ChromeDriver();
	   }
	   else if(browser.equals("Edge"))
	   {
		   WebDriverManager.edgedriver();
		   driver=new EdgeDriver();
	   } 
	   else if(browser.equals("Firefox"))
	   {
		   WebDriverManager.firefoxdriver();
		   driver=new FirefoxDriver();
	   }
	   driver.manage().deleteAllCookies();
	   driver.manage().window().maximize();
	   driver.get(ReadData.readprpertyFile("URL"));
   }
   
}
