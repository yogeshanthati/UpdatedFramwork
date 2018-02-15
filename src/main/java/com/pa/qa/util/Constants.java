package com.pa.qa.util;



import org.openqa.selenium.WebDriver;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Constants {
	public static int PAGE_LOAD_TIMEOUT=40;
	public static int IMPLICIT_WAIT=20;
	public static final String Path_TestData=System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.xlsx";
	public static  ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
	public static String TestResult_Path; 
	
}
