package selenium.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	Properties prop = null;
	private static WebDriver driver;

	public BaseClass() {
		prop = new Properties();
		try {
			FileInputStream input = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Start web browser
	@BeforeTest
	public void initTest() {
		setDriver(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get(prop.getProperty("URL"));
	}

	// Tear down
	@AfterClass
	public void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		BaseClass.driver = driver;
	}

}
