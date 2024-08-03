package org.pag;

import org.demo.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage2 extends BaseClass{
	
	public SearchHotelPage2() {
		PageFactory.initElements(driver,this);
		}
	
	
     
	 @FindBy(xpath="//td[text()='Search Hotel ']")
	 WebElement searchPageText;
	 
	 public WebElement getSearchPageText() {
		return searchPageText;
	}
	 
	 @FindBy(xpath="//select[@id='location']")
	 WebElement location;
	 
	 public WebElement getLocation() {
		return location;
	}
	 
	 @FindBy(xpath="//select[@id='hotels']")
	 WebElement hotels;
	 
	 public WebElement getHotels() {
		return hotels;
	}
	 @FindBy(xpath="//select[@id='room_type']")
	 WebElement roomType;
	 
	 public WebElement getRoomType() {
		return roomType;
	}
	 
	 
	 @FindBy(xpath="//input[@id='Submit']")
	 WebElement search;
	 
	 public WebElement getSearch() {
		return search;
	}
	
	
	 
}
