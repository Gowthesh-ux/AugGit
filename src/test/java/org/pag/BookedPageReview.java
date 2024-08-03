package org.pag;

import org.demo.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedPageReview extends BaseClass {
	public BookedPageReview() {
  PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	WebElement checkBox;
	
	public WebElement getCheckBox() {
		return checkBox;
	}
	
	
	@FindBy(xpath="//input[@value='Cancel Selected']")
	WebElement clickonPage;
	
	public WebElement getClickonPage() {
		return clickonPage;
	}
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	public WebElement getLogout() {
		return logout;
	}
}
