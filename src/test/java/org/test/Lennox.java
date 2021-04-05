package org.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.baseclass.BaseClass;
import org.datadriven.Datas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.AddLead;
import org.pages.AddLeadsDetalis;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lennox extends BaseClass{
	
	@BeforeMethod
	private void browserLaunch() {
	 launchBrowser();
	 maximizeWindow();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	
	@Test(dataProvider="data", dataProviderClass = Datas.class)
	private void test(String fName, String lName, String  phone, String email, String date, String docu, String image) throws Exception {
		launchurl("https://www.liidaveqa.com/");
		LoginPage p = new LoginPage();
		p.getSignIn().click();
		p.getUsername().sendKeys("lenproautomation8@lenqat.com");
		p.getPassword().sendKeys("Community17");
		p.getLoginSubmit().click();
		HomePage h = new HomePage();
		h.getMenu().click();
		h.getSalesTools().click();
		h.getBuildAProposal().click();
		javaScript(h.getSelectLead());
		AddLead a = new AddLead();
		a.getAddLead().click();
		AddLeadsDetalis d = new AddLeadsDetalis();
		d.getFirstName().sendKeys(fName);
		d.getLastName().sendKeys(lName);
		d.getPhone().sendKeys(phone);
		d.getEmail().sendKeys(email);
		d.getSchedulingRequestDate().click();
		selectDate(date, d.getMonth(), d.getNextMonth());
		
		d.getAddDocu().click();
		selectDocu(d.getDocutype(), "OTHER");
		String path = System.getProperty("user.dir");
		d.getSelect().sendKeys(path+docu);
		javaScript(d.getAddDocutoLead());
		d.getAddImage().sendKeys(path+image);
		javaScript(d.getSubmitLead());
		explicitWait(d.getLeadAdded(), fName);
		screenShot(fName);
		
	}
	
	@AfterMethod
	private void aftermethod() {
		
		browserQuit();
		
	}
	

}
