package Screens;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ObjectRepository.ShippingAddressObject;

public class ShippingAddTest extends BaseClass{
	
	@Test(priority=5)
	public void Shipadd() throws Exception {
		ShippingAddressObject shipobj = new ShippingAddressObject();
		Thread.sleep(4000);
		shipobj.firstName("Test Name");
		shipobj.lastName("Test LName");
		shipobj.company("Test Company");
		shipobj.shipAdd("Test 2-12 Address");
		shipobj.city("Test City");
		shipobj.zip("32145");
		WebElement country = shipobj.country();
		Select dd = new Select(country);
		//dd.selectByValue("Albania");
		dd.selectByIndex(3);
		shipobj.phoneNumber("876543222");
		shipobj.emailAdd("test@email.com");
		
		FluentWait<WebDriver> ft = new FluentWait<>(driver).withTimeout(Duration.ofMillis(10000)).pollingEvery(Duration.ofMillis(10)).ignoring(Throwable.class);	
		ft.until(ExpectedConditions.elementToBeClickable(shipobj.Next()));
		shipobj.clickNext();
		FluentWait<WebDriver> ft2 = new FluentWait<>(driver).withTimeout(Duration.ofMillis(10000)).pollingEvery(Duration.ofMillis(10)).ignoring(Throwable.class);
		ft2.until(ExpectedConditions.elementToBeClickable(shipobj.placeOrder()));
		Thread.sleep(3000);
		//shipobj.clickCheckbox();
		Thread.sleep(3000);
		shipobj.clickPlaceOrder();
		Thread.sleep(4000);
		SoftAssert sa = new SoftAssert();
		String success = shipobj.successTextMessage();
		sa.assertEquals("Thank you for your purchase!", success);
		sa.assertAll();
	}

}
