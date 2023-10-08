package com.Actitime.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Taskpage {
	
	//declaration
	@FindBy (xpath="//div[.='Add New']")
	private WebElement addnew;
	
	@FindBy (xpath="//div[.='+ New Customer']")
	private WebElement newcustmer;
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Name']")
	private WebElement custdesp;
	
	@FindBy (xpath="//div[.='Create Custmer']")
	private WebElement creatwbtn;
	
	//initilization
	public Taskpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getAddnew() {
		return addnew;
	}

	public WebElement getNewcustmer() {
		return newcustmer;
	}

	public WebElement getCustdesp() {
		return custdesp;
	}

	public WebElement getCreatwbtn() {
		return creatwbtn;
	}
	

}
