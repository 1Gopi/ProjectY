package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Screens.BaseClass;

public class ShippingAddressObject extends BaseClass {
	
	public ShippingAddressObject() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	@FindBy(xpath="//div[@class='control _with-tooltip']//input[@id='customer-email']")
	private WebElement EmailAddress;
	
	@FindBy(xpath="//*[@name=\"shippingAddress.firstname\"]/div/input")
	private WebElement FirstName;
	
	@FindBy(xpath="//*[@name=\"shippingAddress.lastname\"]/div/input")
	private WebElement LastName;
	
	@FindBy(xpath="//*[@name=\"shippingAddress.company\"]/div/input")
	private WebElement company;
	
	@FindBy(xpath="//*[@id=\"shipping-new-address-form\"]/fieldset/div/div/div/input")
	private WebElement ShippingAddress;
	
	@FindBy(xpath="//*[@name=\"shippingAddress.city\"]/div/input")
	private WebElement City;
	
	@FindBy(xpath="//*[@name=\"shippingAddress.postcode\"]/div/input")
	private WebElement Zip;
	
	@FindBy(xpath="//*[@name=\"shippingAddress.country_id\"]/div/select")
	private WebElement country;
	
	@FindBy(xpath="//*[@name=\"shippingAddress.telephone\"]/div/input")
	private WebElement phoneNum;
	
	@FindBy(xpath="//button[@class='button action continue primary']")
	private WebElement Next;
	
	@FindBy(xpath="//button[@title='Place Order']")
	private WebElement PlaceOrder;
	
	@FindBy(xpath="//*[@class=\"page-title-wrapper\"]/h1/span")
	private WebElement SuccessText;
	
	@FindBy(xpath="//input[@id='billing-address-same-as-shipping-checkmo']")
	private WebElement checkbox;
	
	public void firstName(String fname) {
		FirstName.sendKeys(fname);
	}
	
	public void lastName(String lname) {
		LastName.sendKeys(lname);
	}
	
	public void company(String comp) {
		company.sendKeys(comp);
	}
	
	public void shipAdd(String SAdd) {
		ShippingAddress.sendKeys(SAdd);
	}
	
	public void city(String cty) {
		City.sendKeys(cty);
	}
	
	public void zip(String zp) {
		Zip.sendKeys(zp);
	}
	public WebElement country() {
		return country;
	}
	public void phoneNumber(String phone) {
		phoneNum.sendKeys(phone);
	}
	
	public void clickNext() {
		Next.click();
	}
	
	public void emailAdd(String email) {
		EmailAddress.sendKeys(email);
	}
	
	public void clickPlaceOrder() {
		PlaceOrder.click();
	}
	public WebElement placeOrder() {
		return PlaceOrder;
	}
	
	public WebElement Next() {
		return Next;
	}
	
	public String successTextMessage() {
		return SuccessText.getText();
	}
	
	public void clickCheckbox() {
		checkbox.click();
	}
}
