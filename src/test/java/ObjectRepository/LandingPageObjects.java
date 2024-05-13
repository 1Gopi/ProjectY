package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Screens.BaseClass;

public class LandingPageObjects extends BaseClass{

	private WebDriver driver;
	
	@FindBy(xpath = "//a[@id='ui-id-3']//span[1]")
	private WebElement WhatsNew;
	
	@FindBy(xpath = "a[id='ui-id-4'] span:nth-child(2)")
	private WebElement women;
	
	@FindBy(xpath = "//a[@id='ui-id-9']//span[contains(text(),'Tops')]")
	private WebElement Tops;
	
	@FindBy(xpath = "//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
	private WebElement Jackets;
	
	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
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
