package Screens;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ObjectRepository.ProductsObjects;

public class ProductsTest extends BaseClass {
  @Test(priority = 1)
  public void product() {
	  Actions ac = new Actions(driver);
	  ProductsObjects prod = new ProductsObjects();
	  
	 ac.moveToElement(prod.hoverProd()).build().perform();
	 ac.moveToElement(prod.addtocart()).click().build().perform();
	 
	 FluentWait<WebDriver> fw = new FluentWait<>(driver).withTimeout(Duration.ofMillis(10000)).pollingEvery(Duration.ofMillis(1000)).ignoring(Throwable.class);
	fw.until(ExpectedConditions.visibilityOf(prod.prodbread())); 
	
	prod.sizeSelection();
	prod.colorSelection();
	
	String prodDescription = prod.prodDescription().getText();
	
	prod.clickCartAdd();
	
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(prod.cartSuccessmessage(),prod.validateCartAddSuccess().getText());
	
	prod.clickkMiniCart();
	
	sa.assertEquals(prod.minicartItem().getText(),prodDescription);
	
	prod.clickViewAndEditCart();
	
	File fs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(fs, new File("..//src//test//java//Resources//prodscrst.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
  }
}
