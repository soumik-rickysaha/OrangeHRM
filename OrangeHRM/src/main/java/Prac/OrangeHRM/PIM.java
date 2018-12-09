package Prac.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PIM {

	@FindBy(xpath="//*[@id='menu_pim_viewPimModule']") WebElement PIM_Module;
	//Employee List
	@FindBy(id="empsearch_employee_name_empName") WebElement Employee_Name;
	@FindBy(id="empsearch_id") WebElement id;
	@FindBy(id="empsearch_employee_status") WebElement Employee_Status;
	@FindBy(id="empsearch_termination") WebElement Include;
	@FindBy(id="empsearch_supervisor_name") WebElement Supervisor_Name;
	@FindBy(id="empsearch_job_title") WebElement Job_Title;
	@FindBy(id="empsearch_sub_unit") WebElement Sub_Unit;
	@FindBy(id="searchBtn") WebElement Search;
	@FindBy(id="resetBtn") WebElement Reset;
	//Add Employee
	@FindBy(id="menu_pim_addEmployee")WebElement Add_Employee;
	@FindBy(xpath="//input[@id='firstName']")WebElement First_Name;
	@FindBy(xpath="//input[@id='middleName']")WebElement Middle_Name;
	@FindBy(xpath="//input[@id='lastName']")WebElement Last_Name;
	@FindBy(xpath="//input[@id='employeeId']")WebElement Employee_ID;
	@FindBy(xpath="//input[@id='photofile']")WebElement Photo;
	
	WebDriver driver;
	
	public PIM(WebDriver driver){
		try {
			this.driver=driver;
			AjaxElementLocatorFactory Factory= new AjaxElementLocatorFactory(driver, 30);
			PageFactory.initElements(Factory, this);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PIM clickonPIMModule(){
		PIM_Module.click();
		return this;
	}
	public PIM setEmployeeName(String empname){
		Employee_Name.sendKeys(empname);
		return this;
	}
	public PIM setid(String id){
		this.id.sendKeys(id);
		return this;
	}
	public PIM clickSearch(){
		Search.click();
		return this;
	}
	public String getPIMtext(){
		return PIM_Module.getText();
	}
	public PIM clickOnAddEmployee(){
		Add_Employee.click();
		return this;
	}
	public PIM UploadPhoto(){
		Photo.sendKeys("F:\\abhi\\img351.jpg");
		return this;
	}
	
	
	
	
}