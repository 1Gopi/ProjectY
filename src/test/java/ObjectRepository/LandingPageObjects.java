package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Screens.BaseClass;

public class LandingPageObjects extends BaseClass{

	//private WebDriver driver;
	public LandingPageObjects() {
		//this.driver = driver;
		System.out.println("Driver in obj page:"+driver);
		PageFactory.initElements(BaseClass.driver, this);
		
		
	}
	
	@FindBy(xpath = "//a[@id='ui-id-3']//span[1]")
	private WebElement WhatsNew;
	
	@FindBy(xpath = "(//li[@class='level0 nav-2 category-item level-top parent ui-menu-item'])[1]")
	private WebElement women;
	
	String dynamicId = (String) ((JavascriptExecutor) driver).executeScript("return document.getElementById('ui-id-4').getAttribute('id')");
	WebElement product = driver.findElement(By.id(dynamicId));
	
	@FindBy(xpath = "//a[@id='ui-id-9']//span[contains(text(),'Tops')]")
	private WebElement Tops;
	
	@FindBy(xpath = "//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
	private WebElement Jackets;
	
	
	
	public void clickWhatsNew() {
		WhatsNew.click();
	}
	
	public WebElement hoverWomen() {
		return women;
	}
	
	public WebElement hoverTops() {
		return Tops;
	}
	
	public WebElement clickJackets() {
		return Jackets;
	}
	
}
