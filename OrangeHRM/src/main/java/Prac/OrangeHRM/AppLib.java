package Prac.OrangeHRM;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class AppLib {
	public static WebDriver driver;
	public ChromeOptions ops;
	public WebDriverWait wait;
	public DesiredCapabilities cap = DesiredCapabilities.chrome();
	public String ProjectPath = System.getProperty("user.dir");

	public AppLib() throws MalformedURLException {
		
		NormalRun();
	}

	public void NormalRun() {
		System.setProperty("webdriver.chrome.driver",ProjectPath.replace("\\", "\\\\") + "\\Drivers\\chromedriver.exe");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("--disable-infobars");
		//ops.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver = new ChromeDriver(ops);
		//wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void RunViaGrid() {
		for (int i = 0; i < 6; i++) {

			try {
				String nodeURL = "http://192.168.0.9:4445/wd/hub";
				// ChromeOptions options = new ChromeOptions();
				FirefoxOptions options = new FirefoxOptions();
				// driverOptions.setBrowserName("chrome");
				// capability.setPlatform(Platform.WIN10);
				driver = new RemoteWebDriver(new URL(nodeURL), options);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}
