package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Screens.BaseClass;

public class ProductsObjects {
	
	
	
	@FindBy(xpath = "//img[@alt='Olivia 1/4 Zip Light Jacket']")
	private WebElement Product;
	
	@FindBy(xpath = "//div[@class='products wrapper grid products-grid']//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]")
	private WebElement AddtoCart;
	
	@FindBy(xpath = "//div[@id='option-label-size-143-item-166']")
	private WebElement sizexs;
	
	@FindBy(xpath = "//div[@id='option-label-color-93-item-50']")
	private WebElement color;
	
	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	private WebElement cartAdd;
	
	private String AddtoCartSuccess = "You added Olivia 1/4 Zip Light Jacket to your shopping cart.";
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement addTocartSuccessMessage;
	
	@FindBy(xpath = "//a[@class='action showcart']")
	private WebElement minicart;
	
	@FindBy(xpath = "//a[@data-bind='attr: {href: product_url}, html: product_name']")
	private WebElement miniCartItem;
	
	@FindBy(xpath="//span[@class='base']")
	private WebElement prodDes;
	
	@FindBy(xpath = "//span[normalize-space()='View and Edit Cart']")
	private WebElement viewAndEditCart;
	
	@FindBy(xpath = "//li[@class='item product']//strong[contains(text(),'Olivia 1/4 Zip Light Jacket')]")
	private WebElement prodbreadcrumb;
	
	public ProductsObjects() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public WebElement hoverProd() {
		return Product;
	}
	
	public WebElement addtocart() {
		return AddtoCart;
	}
	
	public void sizeSelection() {
		sizexs.click();
	}
	
	public void colorSelection() {
		color.click();
	}
	
	public void clickCartAdd() {
		cartAdd.click();
	}
	
	public String cartSuccessmessage() {
		return AddtoCartSuccess;
	}
	
	public WebElement validateCartAddSuccess() {
		return addTocartSuccessMessage;
	}
	
	public void clickkMiniCart() {
		minicart.click();
	}
	
	public WebElement minicartItem() {
		return miniCartItem;
	}
	
	public WebElement prodDescription() {
		return prodDes;
	}
	
	public void clickViewAndEditCart() {
		viewAndEditCart.click();
	}

	public WebElement prodbread() {
		return prodbreadcrumb;
	}
}
