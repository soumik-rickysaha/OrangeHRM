package Prac.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Admin {

	@FindBy(how=How.XPATH,using="//*[@id=\"menu_admin_viewAdminModule\"]/b")
	WebElement Admin;
	
	@FindBy(how=How.ID,using="menu_admin_UserManagement")
	WebElement UserManagement;
	
	@FindBy(how=How.ID,using="menu_admin_viewSystemUsers")
	WebElement User;
	
	@FindBy(how=How.ID,using="btnAdd")
	WebElement Add;
	
	@FindBy(how=How.ID,using="systemUser_userType")
	WebElement User_Role;
	
	@FindBy(how=How.ID,using="systemUser_employeeName_empName") WebElement Employee_Name;
	@FindBy(how=How.ID,using="systemUser_userName") WebElement Username_Name;
	@FindBy(how=How.ID,using="systemUser_status") WebElement Status;
	@FindBy(how=How.ID,using="systemUser_password") WebElement Password;
	@FindBy(how=How.ID,using="systemUser_confirmPassword") WebElement ConfirmPassword;
	@FindBy(how=How.ID,using="btnSave") WebElement Save;	
	
//	####################################################
//				Variable Declaration
//	####################################################
	
	WebDriver driver;
	
	public Admin(WebDriver driver) {
		try {
			this.driver=driver;
			AjaxElementLocatorFactory Factory=new AjaxElementLocatorFactory(driver, 30);
			PageFactory.initElements(Factory, this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebElement getAdminLink() {
		return Admin;
	}
}
