package EcommerceProject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import EcommerceProject.AbstractComponents.Abstractcomponent;

public class Registerpage extends Abstractcomponent {

	WebDriver driver;

	public Registerpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".ico-register")
	WebElement clickOnRegister;

	@FindBy(css = "#gender-male")
	WebElement gender;

	@FindBy(css = "#FirstName")
	WebElement firstName;

	@FindBy(css = "#LastName")
	WebElement lastName;

	@FindBy(name = "DateOfBirthDay")
	WebElement selectDay;

	@FindBy(name = "DateOfBirthMonth")
	WebElement selectMonth;

	@FindBy(name = "DateOfBirthYear")
	WebElement selectYear;

	@FindBy(css = "#Email")
	WebElement email;

	@FindBy(css = "#Company")
	WebElement company;

	@FindBy(css = "#Password")
	WebElement password;

	@FindBy(css = "#ConfirmPassword")
	WebElement confirmPassword;

	@FindBy(css = "#register-button")
	WebElement clickRegister;

	@FindBy(css = "span[data-valmsg-for*='Confirm']")
	WebElement Span;

//	@FindBy(css="#LastName-error")
//	WebElement lastNameVerification;

	@FindBy(css = "#Email-error")
	WebElement emailVerification;

	public void tc1Register(String FirstName, String LastName, String Email, String Company, String Password,
			String ConfirmPassword, String Day, String Month, String Year) {
		clickOnRegister.click();
		gender.click();
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);

		Select day = new Select(selectDay);
		day.selectByValue(Day);

		Select month = new Select(selectMonth);
		month.selectByVisibleText(Month);

		Select year = new Select(selectYear);
		year.selectByVisibleText(Year);

		email.sendKeys(Email);
		company.sendKeys(Company);
		password.sendKeys(Password);
		confirmPassword.sendKeys(ConfirmPassword);
		clickRegister.click();

	}

	public void tc2Register(String FirstName, String LastName, String Email, String Company, String Password,
			String ConfirmPassword, String Day, String Month, String Year) {
		clickOnRegister.click();
		gender.click();
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);

		Select day = new Select(selectDay);
		day.selectByValue(Day);

		Select month = new Select(selectMonth);
		month.selectByVisibleText(Month);

		Select year = new Select(selectYear);
		year.selectByVisibleText(Year);

		email.sendKeys(Email);
		company.sendKeys(Company);
		password.sendKeys(Password);
		confirmPassword.sendKeys(ConfirmPassword);
		clickRegister.click();
		waitforWebElementToAppear(emailVerification);
	}

	public void tc3Register(String FirstName, String LastName, String Email, String Company, String Password,
			String ConfirmPassword, String Day, String Month, String Year) {
		clickOnRegister.click();
		gender.click();
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);

		Select day = new Select(selectDay);
		day.selectByValue(Day);

		Select month = new Select(selectMonth);
		month.selectByVisibleText(Month);

		Select year = new Select(selectYear);
		year.selectByVisibleText(Year);

		email.sendKeys(Email);
		company.sendKeys(Company);
		password.sendKeys(Password);
		confirmPassword.sendKeys(ConfirmPassword);
		clickRegister.click();
		waitforWebElementToAppear(Span);
	}

	public String verifyConfirmPassword() {
		return Span.getText();
	}

//	public String verifyLastName() {
//		return lastNameVerification.getText();
//	}

	public String verifyEmail() {
		return emailVerification.getText();
	}

	public void goToURL() {
		driver.get("https://demo.nopcommerce.com/");
	}
}
