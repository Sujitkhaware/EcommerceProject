package EcommerceProject.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EcommerceProject.PageObject.Mainpage;
import EcommerceProject.TestComponent.Basetesttwo;

public class Mainexecution extends Basetesttwo {

	@Test(dataProvider = "getData")
	public void mainTest1(HashMap<String, String> input) throws IOException, InterruptedException {

		Mainpage main = login.tc1Login(input.get("MailId"), input.get("Password"));
		List<WebElement> lists = main.productList();
		main.TestOne(input.get("Product"));
		String productNameCheck = main.productConfim();
		Assert.assertEquals("shopping cart", productNameCheck);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap_BaseTestTwo(
				System.getProperty("user.dir") + "\\src\\test\\java\\EcommerceProject\\Data\\InputData.json");
		return new Object[][] { { data.get(7) } };
	}

}
