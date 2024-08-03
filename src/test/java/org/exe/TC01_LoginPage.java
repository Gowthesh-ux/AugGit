package org.exe;

import org.demo.BaseClass;

import org.obj.PageObjectManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC01_LoginPage extends BaseClass {

	
	public static BaseClass base = new BaseClass();
	public static PageObjectManager manager = new PageObjectManager();
	
	@Test(priority = 0)
	public static void validateBrowserLaunch() {
	try {
		base.getDriver(base.readExcel(1, 2));
		base.winMax();
		base.getUrl(base.readExcel(1, 7));
		
		if (base.readExcel(1, 7).equals(base.getCurrentUrl())) {
			System.out.println("URL Launched Successfully");
			
		} else {
			System.out.println("Url Failed to launch");

		}
		
	} catch (NoSuchSessionException  e) {
		System.out.println("check webdriver" + e.getMessage());
		base.screenCapture("no session found exception");
	}catch (WebDriverException e) {
		System.out.println("Check selenium version" + e.getMessage());
	}catch (Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		base.screenCapture("Exception message");
	}	

	}
	
	@Test(priority = 1)
	public void validatePage() {
		try {

			if (manager.getLoginpage().getTextof().isDisplayed()) {
				System.out.println("user is in Login Page");
				
				if (manager.getLoginpage().getTextof().getText().contains("Build 1")) {
					 
					System.out.println("User_Is_In_Build 1 ");
					 
				}
				}
			base.writeExcel(manager.getLoginpage().getTextof(), 5, 0);
			 base.userDefinedExcel(manager.getLoginpage().getTextof(), 4, 0, "USER IS IN LOGIN PAGE");
		 
		 
		 base.screenCapture("HomePAge");
			
			
		} catch (Exception e) {
			System.out.println("user not in login page" + e.getMessage());
			base.screenCapture("user not in login bage");
		}

	}
	@Test(priority = 2)
	public void validateLoginCred() {
		try {
			WebElement userName = manager.getLoginpage().getUserName();
			base.passKeysinElememt(userName, base.readExcel(1, 0));
			base.passKeysinElememt(manager.getLoginpage().getPassword(), base.readExcel(1, 1));
			
			
			if (manager.getLoginpage().getLoginBtn().isDisplayed()) {
				if (manager.getLoginpage().getLoginBtn().isEnabled()) {
					manager.getLoginpage().getLoginBtn().click();
				}
				
			}
			
			
		} catch (Exception e) {
			
		}

	}
	@Test(priority = 3)
	public void userIsInSearchHotelPage() {
try {

	 if (manager.getSearchHotel().getSearchPageText().isDisplayed()) {
		System.out.println("USER is on Search HotelPage");
		if (manager.getSearchHotel().getSearchPageText().getText().contains("Search Hotel ")) {
			
		}
		base.writeExcel(manager.getSearchHotel().getSearchPageText(), 6, 0);
		base.userDefinedExcel(manager.getSearchHotel().getSearchPageText(), 7, 0, "USER loged in successfully");
	}

} catch (Exception e) {
	System.out.println(e.getMessage());
	e.printStackTrace();
	base.screenCapture("user not landed in SearchHotelPage");
}

	}
}
