package com.pa.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pa.qa.base.TestBase;
import com.pa.qa.util.Log;
import com.relevantcodes.extentreports.LogStatus;

public class MyAccountPageRegisterAndLogin extends TestBase  {
	protected static  String LOGIN_PAGE_TITLE="Automation Practice Site";
	MyAccountPageRegisterAndLogin MyAccountPageRegisterAndLogin;
public MyAccountPageRegisterAndLogin (){
	super();
		}	
@FindBy(xpath="//a[contains(text(),'Shop')]")
private WebElement Shop;	
@FindBy(xpath="//a[contains(text(),'Home')]")
private WebElement Home;
@FindBy(xpath="//a[contains(text(),'Shop')]//following::a[1]")
private WebElement MyAccount;
@FindBy(xpath="//input[@id='username']")
private WebElement username;
@FindBy(xpath="//input[@id='password']")
private WebElement pwd;
@FindBy(xpath="//input[@name='login']")
private WebElement login;

public  MyAccountPageRegisterAndLogin  LogIn(String uname,String Pwd){
	MyAccount.click();
//	MyAccountPageRegisterAndLogin=new MyAccountPageRegisterAndLogin();
	username.sendKeys(uname);
	test.log(LogStatus.INFO, "Entered The Username As"+uname);
	pwd.sendKeys(Pwd);
	test.log(LogStatus.INFO, "Entered The Password As"+Pwd);
	login.click();
	test.log(LogStatus.INFO, "Clicked on the Login Button ");
	return new  MyAccountPageRegisterAndLogin();
}

@Override
protected void VerifyValidPage() {
	
		if (driver.getTitle().trim().contains(LOGIN_PAGE_TITLE)) { 
			test.log(LogStatus.PASS, "Sucessfully validated the Page ");
		}
		else
		{
			test.log(LogStatus.FAIL, "Failed To Validate The page");
			Assert.assertTrue(false);
		}	
}

protected void WaitForPageLoad() {
	/*try{
		new WebDriverWait(driver,30).
		until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));				
	}catch(Exception e){
		System.out.println(e.getMessage());			
	}	*/
	
	Log.info("This is log in page");
}

}
