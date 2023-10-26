package com.Actitime.Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.Pom.HomePage;
import com.Actitime.Pom.TaskPage;
@Listeners(ListenerImplementation.class)
public class CreateCustomer extends Baseclass {
	
	@Test
	public void create() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasklnk().click();
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcustomer().click();
		FileLibrary f=new FileLibrary();
	String Custname = f.readDataFromExcel("CUSTOMER", 1, 1);
		String custdesp = f.readDataFromExcel("CUSTOMER", 1, 2);
		tp.getCustomername().sendKeys(Custname);
		tp.getCustdesp().sendKeys(custdesp);
		tp.getCreatecustbtn().click();
		String expecteddata = Custname;
		String actualdata = driver.findElement(By.xpath("(//div[.='"+Custname+"'])[2]")).getText();
	SoftAssert s=new SoftAssert();
	s.assertEquals(expecteddata, actualdata);
	s.assertAll();
	
	}

}

