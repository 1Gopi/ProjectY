package Screens;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import WebDriverListeners.Listener;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Listener.class)

public class BaseClass {
	//String Url = ../src/test/java/Resources/config.properties;
	public static WebDriver driver;
	
	Properties prop = new Properties();
	File file = new File("..\\src\\test\\java\\Resources\\config.properties");

	
	
	
	
	ExtentReports extent = new ExtentReports();
	File file1 = new File(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\ereport.html");
	ExtentSparkReporter spark = new ExtentSparkReporter(file1);
	ExtentTest exnt = extent.createTest("BaseClass");
	public void screenShots(WebDriver driver) {
		File ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyDirectory(ts, new File("..\\src\\test\\java\\Resources"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeSuite(alwaysRun = true)
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
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	

	

}
