package org.exe;

import org.demo.BaseClass;

import org.obj.PageObjectManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC02_SearchHotelPage extends BaseClass {


	public static BaseClass base = new BaseClass();
	public static PageObjectManager manager = new PageObjectManager();
	
	@Test(priority = 4)
	public  static void validateBrowserLaunch() {
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
	
	@Test(priority = 5)
	public  void validatePage() {
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
	@Test(priority = 6)
	public  void validateLoginCred() {
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
	@Test(priority=7)
	public  void userIsInSearchHotelPage() {
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
	@Test(priority = 8)
	public static void validate_SearchHotelPage() {
		try {
			
			if (manager.getSearchHotel().getLocation().isDisplayed()) {
				base.passKeysinElememt(manager.getSearchHotel().getLocation(), base.readExcel(1, 3));
				System.out.println("location entered successfully");
				base.writeExcel(manager.getSearchHotel().getLocation(), 9, 0);
				base.userDefinedExcel(manager.getSearchHotel().getLocation(), 8, 0, "location entered successfully");
				
			}
			
			if (manager.getSearchHotel().getHotels().isDisplayed()) {
				base.passKeysinElememt(manager.getSearchHotel().getHotels(), base.readExcel(1, 4));
				System.out.println("location entered successfully");
				base.writeExcel(manager.getSearchHotel().getHotels(), 10, 0);
				base.userDefinedExcel(manager.getSearchHotel().getHotels(), 11, 0, "location entered successfully");
				
			}
			if (manager.getSearchHotel().getRoomType().isDisplayed()) {
				 base.selectByIndex(manager.getSearchHotel().getRoomType(), 2);
				 System.out.println("roomType entered successfully");
				 base.userDefinedExcel(manager.getSearchHotel().getRoomType(), 12, 0, "roomType entered successfully");
			}
	   	  
			Thread.sleep(2000);
			 if (manager.getSearchHotel().getSearch().isDisplayed()) {
				 if (manager.getSearchHotel().getSearch().isEnabled()) {
					 manager.getSearchHotel().getSearch().click();
					
					System.out.println("search btn clicked successfully");
				}
				
			} else {
				System.out.println("search btn not clicked successfully");

			}
			 

			 if (manager.getSelectHotel().getHotelText().isDisplayed()) {
				System.out.println("USer is in select hotel page");
				base.userDefinedExcel(manager.getSelectHotel().getHotelText(), 14 , 0, "USer is in select hotel page");
				
			} else {
		      System.out.println("user not entered hotel page");
			}
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			base.screenCapture("exception in Finding Location");
		}

	}
	
	
	
	
	
}
