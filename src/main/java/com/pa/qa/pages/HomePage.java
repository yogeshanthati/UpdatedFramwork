package com.pa.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pa.qa.base.TestBase;

import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends TestBase {
		
	protected static  String HOME_PAGE_TITLE="Automation Practice Site";
	
public HomePage(){
	super();
		}	
@FindBy(xpath="//a[contains(text(),'Shop')]")
private WebElement Shop;
@FindBy(xpath="//div[@id='n2-ss-6-arrow-next']")
private WebElement next;
@FindBy(xpath="//div[@id='n2-ss-6-arrow-previous']")
private WebElement previous;	
@FindBy(xpath="//a[contains(text(),'Home')]")
private WebElement Home;
@FindBy(xpath="//img[@title='Selenium Ruby']")
private WebElement ArrivalImgLink;

public  HomePage VerifyHomePageSlides(){
	Shop.click();
	Home.click();
	List <WebElement> slides=driver.findElements(By.xpath("//img[@class='n2-ss-slide-background-image n2-ss-slide-fill n2-ow']"));
	int Numslides=slides.size();
	if(Numslides==3){
		test.log(LogStatus.PASS, "Sucessfully validated the three slides ");
		
	}
	else{
		test.log(LogStatus.FAIL, "Failed To Validate three slides");
		Assert.assertTrue(false);
		
	}
	return new HomePage();
}

public HomePage verifyNewArrivals(){
	
	Shop.click();
	Home.click();
	List <WebElement> slides=driver.findElements(By.xpath("//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"));
	int NumArrivals=slides.size();
	if(NumArrivals==3){
		test.log(LogStatus.PASS, "Sucessfully validated the three arrivals ");
		
	}else{
		test.log(LogStatus.FAIL, "Failed To Validate three arrivals");
		Assert.assertTrue(false);
		
	}
	return new HomePage();
}
public SingleItemAddPage verifyNewArrivalsNavigation(){
	Shop.click();
	Home.click();
	if(	ArrivalImgLink.isEnabled()){
		ArrivalImgLink.click();
	}
	return new SingleItemAddPage();
}

@Override
protected void VerifyValidPage() {
	
		if (driver.getTitle().trim().contains(HOME_PAGE_TITLE)) {
			test.log(LogStatus.PASS, "Sucessfully validated the Page ");
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Failed To Validate The page");
			Assert.assertTrue(false);
		
			
		}
	
}
@Override
protected void WaitForPageLoad() {
	try{
		new WebDriverWait(driver,30).
		until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Shop')]")));				
	}catch(Exception e){
		System.out.println(e.getMessage());			
	}	
}


}
