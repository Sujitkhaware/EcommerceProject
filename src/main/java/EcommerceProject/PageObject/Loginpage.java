package EcommerceProject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceProject.AbstractComponents.Abstractcomponent;

public class Loginpage extends Abstractcomponent {

	WebDriver driver;

	public Loginpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".ico-login")
	WebElement clickLogin;

	@FindBy(css = "#Email")
	WebElement enterEmail;

	@FindBy(css = "#Password")
	WebElement enterPassword;

	@FindBy(css = "#Email-error")
	WebElement emailError;

	@FindBy(css = "div[class='message-error validation-summary-errors'] ul li")
	WebElement passError;

	@FindBy(css = ".login-button")
	WebElement loginButton;

	public Mainpage tc1Login(String MailId, String Password) {
		clickLogin.click();
		enterEmail.sendKeys(MailId);
		enterPassword.sendKeys(Password);
		loginButton.click();

		return new Mainpage(driver);
	}

	public void tc2Login(String MailId, String Password) {
		clickLogin.click();
		enterEmail.sendKeys(MailId);
		enterPassword.sendKeys(Password);
		loginButton.click();
		waitforWebElementToAppear(emailError);
	}

	public void tc3Login(String MailId, String Password) {
		clickLogin.click();
		enterEmail.sendKeys(MailId);
		enterPassword.sendKeys(Password);
		loginButton.click();
		waitforWebElementToAppear(passError);
	}

	public void goToURL() {
		driver.get("https://demo.nopcommerce.com/");
	}

	public String emailValidation() {
		return emailError.getText();
	}

	public String passwordValidation() {
		return passError.getText();
	}
}
