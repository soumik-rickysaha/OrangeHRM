package Prac.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Dashboard {

	@FindBy(how=How.XPATH,using="//*[@id=\"menu_admin_viewAdminModule\"]/b")
	WebElement Admin;
	
	
	
	
	
	
//	####################################################
//				Variable Declaration
//	####################################################
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
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
