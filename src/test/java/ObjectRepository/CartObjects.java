package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Screens.BaseClass;

public class CartObjects extends BaseClass {
	
	public CartObjects() {
		System.out.println("Driver in obj page:"+driver);
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	@FindBy(xpath="//button[@data-role='proceed-to-checkout']")
	private WebElement Checkout;
	
	@FindBy(xpath="//div[@aria-controls='block-summary']")
	private WebElement shippingAndTaxDropdown;
	
	@FindBy(xpath="//*[@class='field']/div/select")
	private WebElement Country;
	
	String countrySelect = "Albania";
	
	@FindBy(xpath="//*[@class='field'][3]/div/input")
	private WebElement state;
	
	@FindBy(xpath="//*[@class='field'][4]/div/input")
	private WebElement zipCode;
	
	@FindBy(xpath="//div[@class='ea-stickybox-hide']")
	private WebElement stickerHide;
	
	public void clickShip() {
		shippingAndTaxDropdown.click();
	}
	
	public WebElement selectCountry() {
		return Country;
	}
	
	public void state(String stateselect) {
		state.sendKeys(stateselect);
	}
	
	public void zip(String zipcode) {
	zipCode.sendKeys(zipcode);
	}
	
	public void clickCheckout() {
		Checkout.click();
	}
	
	public String selectCountryVal() {
		return countrySelect;
	}
	
	public void closeAd() {
		stickerHide.click();
	}
	
	public WebElement Checkout() {
		return Checkout;
	}

}
