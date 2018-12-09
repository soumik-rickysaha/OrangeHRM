package Prac.OrangeHRM;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.DataProviderHolder;

public class Create_Admin_User{
	
	
	WebDriver driver;
	AppLib ALib;
	LoginPage LP;
	Admin Dashbrd;
	
	
	@BeforeTest	
	public void TestSetup() throws MalformedURLException {
		ALib=new AppLib();
		driver=ALib.getDriver();
		LP=new LoginPage(driver);
		Dashbrd=new Admin(driver);
	}
	
	@Parameters("URLLink")
	@Test(priority=1)	
	public void LoginToAppTest(String url) throws InterruptedException {
		driver.get(url);
		LP.userName.sendKeys("Admin");
		LP.passWord.sendKeys("admin123");   
		LP.loginButton.click();	
		assertEquals(Dashbrd.getAdminLink().isDisplayed(), true);
	}
	
	@Test(dependsOnMethods= {"LoginToAppTest"})
	public void VerifyLogin() {
		Dashbrd.Admin.click();
		Actions ac= new Actions(driver);
		Action soa=ac.moveToElement(Dashbrd.UserManagement).moveToElement(Dashbrd.User).click().build();
		soa.perform();
		Dashbrd.Add.click();
		Select UserRole= new Select(Dashbrd.User_Role);
		UserRole.selectByValue("1");
		Dashbrd.Employee_Name.sendKeys("Kinley");
		Dashbrd.Username_Name.sendKeys("Kinley2018");
		Select status= new Select(Dashbrd.Status);
		status.selectByValue("1");
		Dashbrd.Password.sendKeys("Kinley12345");
		Dashbrd.ConfirmPassword.sendKeys("Kinley12345");
		Dashbrd.Save.click();
	}
	
	
	@AfterSuite
	public void EndSession() {
		driver.quit();
	}
}
