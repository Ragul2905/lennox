package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class=\"far fa-bars v2-hamburger-menu\"]")
	private WebElement menu;

	@FindBy(linkText = "Sales Tools")
	private WebElement salesTools ;

	@FindBy(xpath = "(//a[@data-target=\"#select-lead-model\"])[1]")
	private WebElement buildAProposal;
	
	@FindBy(xpath = "(//a[@class=\"button button-default create-lead-btn\"])[2]")
	private WebElement selectLead;

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getSalesTools() {
		return salesTools;
	}

	public WebElement getBuildAProposal() {
		return buildAProposal;
	}

	public WebElement getSelectLead() {
		return selectLead;
	}


	


}
