package Prac.OrangeHRM;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest{
	
	
	WebDriver driver;
	AppLib ALib;
	LoginPage LP;
	Dashboard Dashbrd;
	
	
	@BeforeTest	
	public void TestSetup() throws MalformedURLException {
		ALib=new AppLib();
		driver=ALib.getDriver();
		LP=new LoginPage(driver);
		Dashbrd=new Dashboard(driver);
	}
	
	@Parameters("URLLink")
	@Test(priority=1)	
	public void LoginToAppTest(String url) throws InterruptedException {
		driver.get(url);
		LP.userName.sendKeys("Admin");
		LP.passWord.sendKeys("admin123");
		LP.loginButton.click();		
	}
	
	@Test(dependsOnMethods= {"LoginToAppTest"})
	public void VerifyLogin() {
		assertEquals(Dashbrd.getAdminLink().isDisplayed(), true);
	}
	
	
	@AfterSuite
	public void EndSession() {
		driver.quit();
	}
}
