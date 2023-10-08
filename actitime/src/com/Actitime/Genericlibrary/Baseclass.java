package com.Actitime.Genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.Pom.LoginPage;

public class Baseclass {
	FileLibrary F=new FileLibrary();
	FileLibrary f = null;
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void dataBaseConnection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = f.readDataFromPropertyFile("url");
		 driver.get(URL);
		Reporter.log("browser lunched",true);
		
		
		
	}
	
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		 String un = f.readDataFromPropertyFile("username");
		 String pw = f.readDataFromPropertyFile("password");
		 lp.getUntbx().sendKeys(un);
		 lp.getPwtbx().sendKeys(pw);
		 lp.getLgbtn().click();
		 
		
		Reporter.log("logged in successfully",true);
	}
	
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out successfully",true);
	}
	
	@AfterClass
	public void closeBbrowser(){
		driver.close();
		Reporter.log("browser closed",true);
	}
		
	@AfterSuite
	public void dataDisconnction() {
		Reporter.log("database disconnected",true);
		
	}
	

}
