package Prac.OrangeHRM;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_User {
	WebDriver driver;
	LoginPage LP;
	AppLib Alib;
	PIM P;
	@BeforeTest	
	public void TestSetup() throws MalformedURLException{
		Alib = new AppLib();
		driver=Alib.getDriver();
		LP=new LoginPage(driver);
		P=new PIM(driver);
	}
	@Parameters("URLLink")
	@Test(priority=1)	
	public void LoginToAppTest(String url) throws InterruptedException {
		driver.get(url);
		LP.userName.sendKeys("Admin");
		LP.passWord.sendKeys("admin123");
		LP.loginButton.click();	
		String PIMtext = P.getPIMtext();
		Assert.assertTrue(PIMtext.contains("PIM"));
	}
	@Test(enabled=false)//(dependsOnMethods= {"LoginToAppTest"})
	public void testPIMSearch(){
		P.clickonPIMModule().setEmployeeName("John").setid("0003").clickSearch();
	}
	@Test(dependsOnMethods= {"LoginToAppTest"})
	public void testAddEmployee(){
		P.clickonPIMModule().clickOnAddEmployee().UploadPhoto();
	}
	@AfterSuite(enabled=false)
	public void quitBrowser(){
		driver.quit();
	}
}
