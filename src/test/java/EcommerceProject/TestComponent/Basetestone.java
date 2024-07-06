package EcommerceProject.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import EcommerceProject.PageObject.Loginpage;
import EcommerceProject.PageObject.Registerpage;

public class Basetestone {

	public WebDriver driver;
	public Registerpage register;

	public WebDriver openBrowser() throws IOException {

		// Define global property
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\EcommerceProject\\Resources\\GlobalData.properties");
		prop.load(file);

		String Browser = prop.getProperty("browser");

		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		return driver;
	}

	// We shall define the Browser URL opening.

	@BeforeMethod(alwaysRun = true)
	public Registerpage openURL() throws IOException {
		driver = openBrowser();
		register = new Registerpage(driver);
		register.goToURL();
		return register;
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}

	public List<HashMap<String, String>> getJsonDataToMap_BaseTestOne(String FilePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

}
