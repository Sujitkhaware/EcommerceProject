package EcommerceProject.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EcommerceProject.TestComponent.Basetestone;

public class Registrationexecution extends Basetestone {

	@Test(dataProvider = "getDataOne")
	public void registerTest1(HashMap<String, String> input) throws IOException, InterruptedException {

		register.tc1Register(input.get("FirstName"), input.get("LastName"), input.get("Email"), input.get("Company"),
				input.get("Password"), input.get("ConfirmPassword"), input.get("Day"), input.get("Month"),
				input.get("Year"));
	}

	@Test(dataProvider = "getDataTwo")
	public void registerTest2(HashMap<String, String> input) throws IOException, InterruptedException {
		register.tc2Register(input.get("FirstName"), input.get("LastName"), input.get("Email"), input.get("Company"),
				input.get("Password"), input.get("ConfirmPassword"), input.get("Day"), input.get("Month"),
				input.get("Year"));

		String msgEmail = register.verifyEmail();
		Assert.assertEquals(msgEmail, "Email is required.");
	}

	@Test(dataProvider = "getDataThree")
	public void registerTest3(HashMap<String, String> input) throws IOException, InterruptedException {
		register.tc3Register(input.get("FirstName"), input.get("LastName"), input.get("Email"), input.get("Company"),
				input.get("Password"), input.get("ConfirmPassword"), input.get("Day"), input.get("Month"),
				input.get("Year"));

		String msgConfirmPassword = register.verifyConfirmPassword();
		Assert.assertEquals("The password and confirmation password do not match.", msgConfirmPassword);
	}

	@DataProvider
	public Object[][] getDataOne() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap_BaseTestOne(
				System.getProperty("user.dir") + "\\src\\test\\java\\EcommerceProject\\Data\\InputData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	@DataProvider
	public Object[][] getDataTwo() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap_BaseTestOne(
				System.getProperty("user.dir") + "\\src\\test\\java\\EcommerceProject\\Data\\InputData.json");
		return new Object[][] { { data.get(2) } };
	}

	@DataProvider
	public Object[][] getDataThree() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap_BaseTestOne(
				System.getProperty("user.dir") + "\\src\\test\\java\\EcommerceProject\\Data\\InputData.json");
		return new Object[][] { { data.get(3) } };
	}

}
