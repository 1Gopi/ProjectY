package Screens;

import java.time.Duration;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import WebDriverListeners.Listener;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Listener.class)

public class BaseClass {
	//String Url = ../src/test/java/Resources/config.properties;
	public static WebDriver driver;
	
	public void screenShots(WebDriver driver) {
		//TakesScreenshot ts = (driver)TakesScreenshot;
		// scc = ts.getScreenShotAs(OUTPUT.File);
		//FileUtils.
	}
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		System.out.println("In setup");
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", null);
		//driver = new ChromeDriver();
		
		String browser = System.getProperty("browser", "chrome"); //Default to chrome
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: "+ browser);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	

	

}
