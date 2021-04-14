package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Attachment;
//import testcases.Test1;
import io.qameta.allure.Allure;

/*
 * Reports class is responsible for generating Reports.
 * Success, failure screenshots along with text messages are captured and attached in reports.
 * Console messages are captured as well and attached in Reports.
 */

public class Reports  extends SetupPage implements ITestListener
{
	
	private static String getTestMethodName(ITestResult iTest) {
		return iTest.getMethod().getConstructorOrMethod().getName();
	}
	
	
	@Attachment (value = "screenshot", type = "image/png")
	public static File screenshot (WebDriver driver) throws IOException  {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	    Date date = new Date();
	    String fileName = sdf.format(date);
	    File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir")+"//allure-results//"+fileName+".png"));
	    Allure.addAttachment("Screenshot attached ", FileUtils.openInputStream(SrcFile));
	    return SrcFile;
	    
	}
	
	@Attachment (value = "attachment", type = "text/plain")
	public static File seleniumLog (WebDriver driver) throws IOException  {
		 File seleniumLog = new File("C://Eclipse//PageObjectModel//log//selenium.log");
		 FileUtils.copyFile(seleniumLog, new File(System.getProperty("user.dir")+"//allure-results//selenium"+".log"));
		 Allure.addAttachment("Selenium Log attached ", FileUtils.openInputStream(seleniumLog));
		 return seleniumLog;
	}
	
	
	@Attachment (value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		StringBuilder str=getConsoleLogs();
		Allure.addAttachment("Text Captured from Console ",(message+str));
		return (message+str);
	}
	
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println(iTestContext.getName() + "on start");
		iTestContext.setAttribute("WebDriver", SetupPage.driver);
	}
	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println(iTestContext.getName() + "on Finish");
	}
	@Override
	public void onTestStart(ITestResult iTest) {
		System.out.println(getTestMethodName(iTest) +"on Test Start");
	}
	@Override
	public void onTestSuccess(ITestResult iTest) {
		System.out.println(getTestMethodName(iTest) +"on Test Success");
		if (driver != null) {
			try {
				screenshot(SetupPage.driver);
				seleniumLog(SetupPage.driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
			saveTextLog("Passed Screenshot captured");
		}
		
	}
	//Logger logger ;
	@Override
	public void onTestFailure(ITestResult iTest) {
		System.out.println(getTestMethodName(iTest) +"on Test Failure");
		if (driver != null) {
			try {
				screenshot(SetupPage.driver);
				seleniumLog(SetupPage.driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
			saveTextLog("Failed Screenshot captured");
			
		}
	}
	@Override
	public void onTestSkipped(ITestResult iTest) {
		System.out.println(getTestMethodName(iTest));
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTest) {
		System.out.println(getTestMethodName(iTest));
	}
	
	public static StringBuilder getConsoleLogs() {
	LogEntries logEntries = SetupPage.driver.manage().logs().get(LogType.BROWSER);
	StringBuilder consolelogs = new StringBuilder();
	
	for (org.openqa.selenium.logging.LogEntry entry : logEntries) {
		consolelogs.append(new Date(entry.getTimestamp()) + " "
                + entry.getLevel() + " " + entry.getMessage());
		consolelogs.append(System.lineSeparator());

    	}
		return consolelogs;
	}
	
}
