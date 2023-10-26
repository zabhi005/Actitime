package com.Actitime.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	//decleration
	
@FindBy(xpath = "//div[.='Add New']")
private WebElement addnewbtn;

@FindBy(xpath = "//div[.='+ New Customer']")
private WebElement newcustomer;

@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
private WebElement customername;

@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
private WebElement custdesp;


@FindBy(xpath = "//div[.='Create Customer']")
private WebElement createcustbtn;


//initlization
public  TaskPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getAddnewbtn() {
	return addnewbtn;
}
public WebElement getNewcustomer() {
	return newcustomer;
}
public WebElement getCustomername() {
	return customername;
}
public WebElement getCustdesp() {
	return custdesp;
}
public WebElement getCreatecustbtn() {
	return createcustbtn;
}

}
