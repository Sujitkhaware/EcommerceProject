package EcommerceProject.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EcommerceProject.PageObject.Cartpage;
import EcommerceProject.PageObject.Checkoutpage;
import EcommerceProject.PageObject.Mainpage;
import EcommerceProject.TestComponent.Basetesttwo;

public class Checkoutexecution extends Basetesttwo {

	@Test(dataProvider = "getDataOne")
	public void checkOutTest1(HashMap<String, String> input) throws IOException, InterruptedException {

		Mainpage main = login.tc1Login(input.get("MailId"), input.get("Password"));
		List<WebElement> lists = main.productList();
		Cartpage cart = main.TestOne(input.get("Product"));
		String productNameCheck = main.productConfim();
		Assert.assertEquals("shopping cart", productNameCheck);
		Checkoutpage checkOut = cart.TestOne();
		checkOut.TestOne(input.get("FirstName"), input.get("LastName"), input.get("Email"), input.get("Company"),
				input.get("Country"), input.get("City"), input.get("Address1"), input.get("Address2"),
				input.get("ZipCode"), input.get("Phone"), input.get("Fax"));
	}

	@Test(dataProvider = "getDataTwo")
	public void chreckOutTest2(HashMap<String, String> input) throws IOException, InterruptedException {

		Mainpage main = login.tc1Login(input.get("MailId"), input.get("Password"));
		List<WebElement> lists = main.productList();
		Cartpage cart = main.TestOne(input.get("Product"));
		String productNameCheck = main.productConfim();
		Assert.assertEquals("shopping cart", productNameCheck);
		Checkoutpage checkOut = cart.TestOne();
		checkOut.TestTwo(input.get("FirstName"), input.get("LastName"), input.get("Email"), input.get("Company"),
				input.get("Country"), input.get("City"), input.get("Address1"), input.get("Address2"),
				input.get("ZipCode"), input.get("Phone"), input.get("Fax"), input.get("Phone"));
	}

	@DataProvider
	public Object[][] getDataOne() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap_BaseTestTwo(
				System.getProperty("user.dir") + "\\src\\test\\java\\EcommerceProject\\Data\\InputData.json");
		return new Object[][] { { data.get(9) } };
	}

	@DataProvider
	public Object[][] getDataTwo() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap_BaseTestTwo(
				System.getProperty("user.dir") + "\\src\\test\\java\\EcommerceProject\\Data\\InputData.json");
		return new Object[][] { { data.get(10) } };
	}

}
