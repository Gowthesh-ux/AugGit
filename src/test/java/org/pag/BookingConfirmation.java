package org.pag;

import org.demo.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation extends BaseClass{

	
	public BookingConfirmation() {
		PageFactory.initElements(driver,this);
		
 	}
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	WebElement bookingTxt;
	public WebElement getBookingTxt() {
		return bookingTxt;
	}
	
	@FindBy(id="search_hotel")
	WebElement searchButton;
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	@FindBy(xpath="//input[@value='My Itinerary']")
	WebElement iteneraryBtn;
	
	public WebElement getIteneraryBtn() {
		return iteneraryBtn;
	}
	
	
}
