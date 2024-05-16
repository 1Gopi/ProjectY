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

import Screens.BaseClass;

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
		 //WebDriver driver = driverThreadLocal.get();
		 
		// WebDriver driver = result.getTestClass().getRealClass().g;
		 
		//screenShots(WebDriver driver);
		//driver = (WebDriver)result.getName();
		/* if (driver != null) {
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
	        driverThreadLocal.remove(); // Remove for next test */
	        
	        Class<?> failedTestClass = result.getTestClass().getRealClass();

	        // Check if the failed test class inherits from BaseClass (or your base class name)
	        if (BaseClass.class.isAssignableFrom(failedTestClass)) {

	            // If it does, access the driver instance using BaseClass.getDriver()
	            WebDriver driver = BaseClass.driver;

	            if (driver != null) {
	                // Take screenshot using the driver instance (e.g., with TestNG or a screenshot library)
	                // ... your screenshot capturing code here
	            	File fs1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            	try {
	            		FileUtils.copyFile(fs1, new File("..//src//test//java//Resources//failscrsht.png"));
	            	} catch (IOException e) {
	            		// TODO Auto-generated catch block
	            		e.printStackTrace();
	            	}
	            }
	        } else {
	            // Handle cases where the failed test class doesn't inherit from BaseClass
	            // You could log a message, throw an exception, or implement alternative logic
	            System.out.println("Failed test class '" + failedTestClass.getName() + "' doesn't inherit from BaseClass. Screenshot capture not possible.");
	        }
	        
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
