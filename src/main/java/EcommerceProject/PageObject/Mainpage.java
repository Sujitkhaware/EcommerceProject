package EcommerceProject.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceProject.AbstractComponents.Abstractcomponent;

public class Mainpage extends Abstractcomponent {

	WebDriver driver;

	public Mainpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By productBy = By.cssSelector(".details");

	By addToCart = By.cssSelector(".product-box-add-to-cart-button");

	@FindBy(css = ".notmobile li a[href*='/computers']")
	WebElement product;

	@FindBy(css = ".last a[href*='/notebooks']")
	WebElement notebooks;

	@FindBy(css = ".details")
	List<WebElement> listOfProduct;

	@FindBy(css = "div[class*='bar-notification'] p a")
	WebElement productName_;

	// We are first capturing the list of products in a method
	public List<WebElement> productList() {
		// waitforElementToAppear(productBy);
		return listOfProduct;
	}

	// then we are filtering it out on our data
	public WebElement getProductByName(String productName) {
		WebElement list = productList().stream()
				.filter(s -> s.findElement(By.tagName("a")).getText().equals(productName)).findAny().orElse(null);
		return list;
	}

	// then one basis of the filter we are clicking on that perticular add to cart
	// button.
	public Cartpage TestOne(String productName) {
		product.click();
		notebooks.click();
		waitforElementToAppear(productBy);
		WebElement listOfProd = getProductByName(productName);
		listOfProd.findElement(addToCart).click();
		waitforWebElementToAppear(productName_);

		return new Cartpage(driver);
	}

	public String productConfim() {
		return productName_.getText();
	}

}
