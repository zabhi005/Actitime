package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.Pom.HomePage;
import com.Actitime.Pom.LoginPage;

public class Baseclass {
	FileLibrary f=new FileLibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database disconnected",true);
	}
	@BeforeClass
	public void launchBrowser() throws IOException {
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String Url = f.readDataFromProperty("url");
		 driver.get(Url);
		 Reporter.log("browser launched successfully",true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String UN = f.readDataFromProperty("un");
		lp.getUntbx().sendKeys(UN);
		String PW = f.readDataFromProperty("pw");
		lp.getPwtbx().sendKeys(PW);
		lp.getLgbtn().click();
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		HomePage hp=new HomePage(driver);
	Thread.sleep(5000);
		hp.getLogoutlnk().click();
		Reporter.log("logout successfully",true);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("browser closed successfully",true);
	}
	
	@AfterSuite
	public void databaseDisconnect() {
		Reporter.log("database disconnected",true);
	}
	

}
