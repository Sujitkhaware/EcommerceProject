package EcommerceProject.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EcommerceProject.PageObject.Loginpage;
import EcommerceProject.TestComponent.Basetestone;
import EcommerceProject.TestComponent.Basetesttwo;

public class Loginexecution extends Basetesttwo {

	@Test(dataProvider = "getDataOne",groups= {"mainLogin"})
	public void loginTest1(HashMap<String, String> input) throws IOException, InterruptedException {
		login.tc1Login(input.get("MailId"), input.get("Password"));
	}

	@Test(dataProvider = "getDataTwo")
	public void loginTest2(HashMap<String, String> input) throws IOException, InterruptedException {
		login.tc2Login(input.get("MailId"), input.get("Password"));

		String emailValidate = login.emailValidation();
		Assert.assertEquals("Please enter a valid email address.", emailValidate);
	}

	@Test(dataProvider = "getDataThree")
	public void loginTest3(HashMap<String, String> input) throws IOException, InterruptedException {
		login.tc3Login(input.get("MailId"), input.get("Password"));

		String passwordValidate = login.passwordValidation();
		Assert.assertEquals("No customer account found", passwordValidate);
	}

	@DataProvider
	public Object[][] getDataOne() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap_BaseTestTwo(
				System.getProperty("user.dir") + "\\src\\test\\java\\EcommerceProject\\Data\\InputData.json");
		return new Object[][] { { data.get(4) } };
	}

	@DataProvider
	public Object[][] getDataTwo() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap_BaseTestTwo(
				System.getProperty("user.dir") + "\\src\\test\\java\\EcommerceProject\\Data\\InputData.json");
		return new Object[][] { { data.get(5) } };
	}

	@DataProvider
	public Object[][] getDataThree() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap_BaseTestTwo(
				System.getProperty("user.dir") + "\\src\\test\\java\\EcommerceProject\\Data\\InputData.json");
		return new Object[][] { { data.get(6) } };
	}
}
