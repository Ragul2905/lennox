package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sign In")
	private WebElement signIn;

	@FindBy(id = "j_username")
	private WebElement username;

	@FindBy(id = "j_password")
	private WebElement password;
	
	@FindBy(id = "loginSubmit")
	private WebElement loginSubmit;

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginSubmit() {
		return loginSubmit;
	}
	
	
	

	
}