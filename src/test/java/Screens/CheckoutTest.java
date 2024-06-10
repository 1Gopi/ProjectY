package Screens;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ObjectRepository.CartObjects;
import net.bytebuddy.implementation.bytecode.Throw;

public class CheckoutTest extends BaseClass {
	
	@Test(priority=4)
	public void checkout() throws Exception {
		CartObjects cartobj = new CartObjects();
		
		cartobj.clickShip();
		cartobj.closeAd();
		WebElement selectCou = cartobj.selectCountry();
		String val = cartobj.selectCountryVal();
	
		Select dd = new Select(selectCou);
		dd.selectByIndex(3);
		//dd.selectByValue(val);
		
		cartobj.state("TestState");
		cartobj.zip("4321");
		Thread.sleep(4000);
		//WebDriverWait wt = new WebDriverWait(driver,Duration.ofMillis(4000));
		//wt.until(ExpectedConditions.elementToBeClickable(cartobj.Checkout()));
		
		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(5000)).pollingEvery(Duration.ofMillis(10)).ignoring(Throwable.class);
		fw.until(ExpectedConditions.elementToBeClickable(cartobj.Checkout()));
		cartobj.clickCheckout();
	}
}
