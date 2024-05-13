package WebDriverListeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
	String filepath = "D:\\Eclipse WorkSpace All\\New WorkSpace\\ProjectY\\src\\test\\resources";
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("------------Test starting--------------");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("------------Test Sucsess--------------");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("--------Test Failed------------");
		//driver = 
		 WebDriver driver = driverThreadLocal.get();
		//screenShots(WebDriver driver);
		//driver = (WebDriver)result.getName();
		 if (driver != null) {
	            // Take screenshot logic using driver
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            // ... store the screenshot (e.g., save to a file)
	            try {
	                FileUtils.copyFile(screenshot, new File(filepath));
	            } catch (IOException e) {
	                // Handle exception if file move fails
	                e.printStackTrace();
	            }
	        }
	        driverThreadLocal.remove(); // Remove for next test
	    }
		
	

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("-----------Test skipped------------");
		
	}

	

	@Override
	public void onStart(ITestContext context) {
		System.out.println("-----------Test onStart------------");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("-------------Test onFinish----------------");
		
	}

}
