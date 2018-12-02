package Prac.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

class LoginPage{
	
	@FindBy(how=How.ID,using="txtUsername")
	WebElement userName;
	
	@FindBy(how=How.ID,using="txtPassword")
	WebElement passWord;
	
	@FindBy(how=How.ID,using="btnLogin")
	WebElement loginButton;
	
	
	//Declare other Variables under here
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		try {
			this.driver=driver;
			AjaxElementLocatorFactory Factory= new AjaxElementLocatorFactory(driver, 30);
			PageFactory.initElements(Factory, this);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebElement getUsername() {
		return userName;
	}
}