package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddLead extends BaseClass{
	
	public AddLead() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "ADD LEAD")
	private WebElement addLead;

	public WebElement getAddLead() {
		return addLead;
	}

}
