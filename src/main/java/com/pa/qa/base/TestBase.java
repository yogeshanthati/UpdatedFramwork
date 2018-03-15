package com.pa.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pa.qa.reportlistener.Log4j;
import com.pa.qa.util.Log;
import com.pa.qa.util.Constants;
import com.relevantcodes.extentreports.ExtentReports;



public abstract class TestBase extends Constants {	
	public static Properties prop;
	protected  abstract  void  VerifyValidPage();
	protected abstract void WaitForPageLoad();
	
	public TestBase(){
	PageFactory.initElements(driver, this);
	VerifyValidPage();
	WaitForPageLoad();
	}
	public static void Cofigurereport(){

		try {
			Log4j.createLog();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Constants.extent = new ExtentReports(System.getProperty("user.dir") + "/TestResults/Extentreports/"+Constants.TestResult_Path+"/ExtentReport.html", true);
    
	}
	public static void intialization() throws MalformedURLException{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/main/resources/testconfig.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");	
			driver = new ChromeDriver(); 
		//	DesiredCapabilities Capabilities= DesiredCapabilities.chrome();
		//	driver=new RemoteWebDriver(new URL(" http://localhost:4444/wd/hub"),Capabilities);
			Log.info("Driver Intiallized");
			driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "src/main/resources/com/pa/qa/BrowserSpecDrivers/chromedriver.exe");	
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		Log.info("Url Has Entered");
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);	
	}
	
	
}
