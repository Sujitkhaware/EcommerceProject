package EcommerceProject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceProject.AbstractComponents.Abstractcomponent;

public class Cartpage extends Abstractcomponent {

	WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".close")
	WebElement closeNotification;

	@FindBy(css = ".ico-cart span:first-of-type")
	WebElement cartButton;

	@FindBy(css = "#termsofservice")
	WebElement acceptTerms;

	@FindBy(css = "#checkout")
	WebElement clickCheckout;

	public Checkoutpage TestOne() {
		waitforWebElementToAppear(closeNotification);
		waitforWebElementToAppear(cartButton);
		closeNotification.click();
		cartButton.click();
		acceptTerms.click();
		clickCheckout.click();

		return new Checkoutpage(driver);
	}

}
