package Prac.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

class AppLib {
	public WebDriver driver;
	public WebDriverWait wait;
	public DesiredCapabilities cap = DesiredCapabilities.chrome();
	public String ProjectPath = System.getProperty("user.dir");

	public AppLib(){
		System.setProperty("webdriver.chrome.driver", ProjectPath.replace("\\", "\\\\") + "\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
	
	public WebDriver getDriver() {
		return driver;
	}
}
