package Screens;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import ObjectRepository.LandingPageObjects;

public class HomePageTest extends BaseClass {
	//WebDriver driver;
	//public HomePageTest(WebDriver driver) {
	//	driver = driver;
	//}
	//landing page object reference creation
	LandingPageObjects landingpageobj = new LandingPageObjects(driver);
	
	@Test(priority=1)
	public void Homepageop() {
		Actions ac = new Actions(driver);
		WebElement wom = landingpageobj.hoverWomen();
		WebElement top = landingpageobj.hoverTops();
		WebElement jackets = landingpageobj.clickJackets();
		
		FluentWait<WebDriver> fw = new FluentWait<>(driver).withTimeout(Duration.ofMillis(5000)).pollingEvery(Duration.ofMillis(10));	
		fw.until(ExpectedConditions.elementToBeClickable(wom));
		ac.moveToElement(wom).build().perform();
		fw.until(ExpectedConditions.visibilityOf(top));
		ac.moveToElement(top).build().perform();
		fw.until(ExpectedConditions.visibilityOf(jackets));
		ac.moveToElement(jackets).click().build().perform();		
		
		
	}
	

}
