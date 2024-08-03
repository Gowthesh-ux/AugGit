package org.pag;

import org.demo.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Existing User Login - Build 1']")
	private WebElement textof;

	public WebElement getTextof() {
		return textof;

	}

	@FindBy(xpath = "//input[@id='username']")
	 WebElement userName;

	public WebElement getUserName() {
		return userName;
	}

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(id = "login")
	WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}
}
