package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddLeadsDetalis extends BaseClass {
	public AddLeadsDetalis() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "phNo")
	private WebElement phone;

	@FindBy(id = "calender1")
	private WebElement schedulingRequestDate;

	@FindBy(id = "scheduleRequestTime")
	private WebElement scheduleRequestTime;

	@FindBy(xpath = "//span[@class=\"ui-datepicker-month\"]")
	private WebElement month;

	@FindBy(xpath = "//a[@class=\"ui-datepicker-next ui-corner-all\"]")
	private WebElement nextMonth;

	@FindBy(xpath = "//p[@class=\"m-0 add-document\"]")
	private WebElement addDocu;

	@FindBy(name = "documents[1].documentType")
	private WebElement docutype;

	@FindBy(id = "multipleFileSelect-1")
	private WebElement select;

	@FindBy(xpath = "//a[@class=\"btn btn-primary mr-15 add-documents-to-page mb-15\"]")
	private WebElement addDocutoLead;

	@FindBy(id = "multipleImageSelect[0]")
	private WebElement addImage;

	@FindBy(id = "btn-addLeadsForm")
	private WebElement submitLead;
	
	@FindBy(xpath = "//h1[@class=\"m-0 mb-15 leads-details-heading introjs-1\"]")
	private WebElement leadAdded;

	public WebElement getLeadAdded() {
		return leadAdded;
	}

	public WebElement getAddDocu() {
		return addDocu;
	}

	public WebElement getDocutype() {
		return docutype;
	}

	public WebElement getSelect() {
		return select;
	}

	public WebElement getAddDocutoLead() {
		return addDocutoLead;
	}

	public WebElement getAddImage() {
		return addImage;
	}

	public WebElement getSubmitLead() {
		return submitLead;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getSchedulingRequestDate() {
		return schedulingRequestDate;
	}

	public WebElement getScheduleRequestTime() {
		return scheduleRequestTime;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getNextMonth() {
		return nextMonth;
	}

}
