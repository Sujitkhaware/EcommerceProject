package EcommerceProject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import EcommerceProject.AbstractComponents.Abstractcomponent;

public class Checkoutpage extends Abstractcomponent {

	WebDriver driver;

	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name*='First']")
	WebElement firstName;

	@FindBy(css = "input[name*='Last']")
	WebElement lastName;

	@FindBy(css = "input[id*='Email']")
	WebElement emailId;

	@FindBy(css = "input[id*='Company']")
	WebElement companyName;

	@FindBy(css = "select[id*='Country']")
	WebElement countryName;

	@FindBy(css = "input[id*='City']")
	WebElement cityName;

	@FindBy(css = "input[id*='1']")
	WebElement address1;

	@FindBy(css = "input[id*='2']")
	WebElement address2;

	@FindBy(css = "input[id*='Code']")
	WebElement zipCode;

	@FindBy(css = "input[id*='Phone']")
	WebElement phoneNumber;

	@FindBy(css = "input[id*='Fax']")
	WebElement faxNumber;

	@FindBy(css = "button[class*='new-address-next-step-button']")
	WebElement clickContinue;

	@FindBy(css = "label[for*='Fax']")
	WebElement waitForFax;

	@FindBy(css = ".method-name input[value*='Next']")
	WebElement shippingNext;

	@FindBy(id = "paymentmethod_0")
	WebElement paymentManual;

	@FindBy(css = ".info td p:first-of-type")
	WebElement confirm;

	@FindBy(css = ".billing-info-wrap")
	WebElement confirmBill;
	
	@FindBy(css="button[class*='shipping']")
	WebElement shippingButton;
	
	@FindBy(css="button[class*='payment-method']")
	WebElement paymentButton;
	
	@FindBy(css="button[class*='payment-info']")
	WebElement paymentInfo;
	
	@FindBy(css="button[class*='confirm-order']")
	WebElement confirmOrder;

	Select country = new Select(countryName);

	public void TestOne(String FirstName, String LastName, String Email, String Company, String Country, String City,
			String Address1, String Address2, String ZipCode, String Phone, String Fax) throws InterruptedException {
		waitforWebElementToAppear(waitForFax);
		firstName.clear();
		firstName.sendKeys(FirstName);
		lastName.clear();
		lastName.sendKeys(LastName);
		emailId.clear();
		emailId.sendKeys(Email);
		companyName.clear();
		companyName.sendKeys(Company);
		country.selectByVisibleText(Country);
		cityName.clear();
		cityName.sendKeys(City);
		address1.clear();
		address1.sendKeys(Address1);
		address2.clear();
		address2.sendKeys(Address2);
		zipCode.clear();
		zipCode.sendKeys(ZipCode);
		phoneNumber.clear();
		phoneNumber.sendKeys(Phone);
		faxNumber.clear();
		faxNumber.sendKeys(Fax);
		clickContinue.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}

	public void TestTwo(String FirstName, String LastName, String Email, String Company, String Country, String City,
			String Address1, String Address2, String ZipCode, String Phone, String Fax, String phone)
			throws InterruptedException {
		waitforWebElementToAppear(waitForFax);
		firstName.clear();
		firstName.sendKeys(FirstName);
		lastName.clear();
		lastName.sendKeys(LastName);
		emailId.clear();
		emailId.sendKeys(Email);
		companyName.clear();
		companyName.sendKeys(Company);
		country.selectByVisibleText(Country);
		cityName.sendKeys(City);
		address1.sendKeys(Address1);
		address2.sendKeys(Address2);
		zipCode.sendKeys(ZipCode);
		phoneNumber.sendKeys(Phone);
		faxNumber.sendKeys(Fax);
		phoneNumber.sendKeys(phone);
		clickContinue.click();
		waitforWebElementToAppear(shippingNext);
		shippingNext.click();
		shippingButton.click();
		waitforWebElementToAppear(paymentManual);
		paymentManual.click();
		paymentButton.click();
		waitforWebElementToAppear(confirm);
		paymentInfo.click();
		waitforWebElementToAppear(confirmBill);
		confirmOrder.click();
	}

}
