package org.pag;

import org.demo.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotePage extends BaseClass{
	
	public SelectHotePage() { 
		
		PageFactory.initElements(driver, this);
 	}
	
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	WebElement hotelText;
	
	public WebElement getHotelText() {
		return hotelText;
	}
	
	 @FindBy(xpath="//input[@type='radio']")
	 WebElement radiobtn;
	 
	 public WebElement getRadiobtn() {
		return radiobtn;
	}
	 @FindBy(id="continue")
	 WebElement btnContinue;
	 
	 public WebElement getBtnContinue() {
		return btnContinue;
	}
	 

}
