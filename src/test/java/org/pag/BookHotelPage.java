package org.pag;

import org.demo.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass{
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
    WebElement textofHotel;
	public WebElement getTextofHotel() {
		return textofHotel;
	}
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	public WebElement getFirstName() {
		return firstName;
	}
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastName;
	public WebElement getLastName() {
		return lastName;
	}
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement address;
	public WebElement getAddress() {
		return address;
	}
	
	@FindBy(xpath="//input[@name='cc_num']")
	WebElement creditCard;
	public WebElement getCreditCard() {
		return creditCard;
	}
	
	
	@FindBy(xpath="//select[@id='cc_type']")
	WebElement creditType;
	public WebElement getCreditType() {
		return creditType;
	}
	@FindBy(xpath="//select[@id='cc_exp_month']")
	WebElement expDate1;
	public WebElement getExpDate1() {
		return expDate1;
	}
	@FindBy(xpath="//select[@id='cc_exp_year']")
	WebElement expYear;
	public WebElement getExpYear() {
		return expYear;
	}
	@FindBy(xpath="//input[@id='cc_cvv']")
	WebElement cvv;
	public WebElement getCvv() {
		return cvv;
	}
	
	@FindBy(xpath="(//input[@type='button'])[1]")
	WebElement submitBtn;
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
}
