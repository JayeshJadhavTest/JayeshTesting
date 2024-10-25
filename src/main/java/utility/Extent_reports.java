package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class Extent_reports extends TestBase              //it is main class name
{
	static ExtentReports report;                        //it is predefined class, and select Extentreports as a class
    public static ExtentReports getreportInstance()     //select Extentreports as a class and getexetntreports is a method made by us
    {
    	if(report==null)                   //for null the report
    	{
    		String reportname=new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
    		ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("C:\\Users\\jayes\\eclipse-workspace\\4thJulyFrameWork\\extent report\\"+reportname+".html");                 //Extenthtmlreporter becz we can see report in html format and create new object 'htmlreporter' and create new folder name as extent report and give here that path
    	    report=new ExtentReports();                                                        //here we create dada
    	    report.attachReporter(htmlreporter);
    	    report.setSystemInfo("OS", "Windows");                                         //which os we can use
    	    report.setSystemInfo("Envirnoment", "SIT");                               //set the envirnoment both are static information os and this
    	    report.setSystemInfo("BuildNO", "102.51.35.165126");
    	    report.setSystemInfo("Browser", "Chrome");
    	    htmlreporter.config().setDocumentTitle("UI Testing Document");           //this  is Document Title of this report
    	    htmlreporter.config().setReportName("UI Test Report");                 //this is report name
    	}
		return report;
    	
    }
}
