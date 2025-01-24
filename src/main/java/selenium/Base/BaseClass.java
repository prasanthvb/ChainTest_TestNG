package selenium.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.chaintest.service.ChainPluginService;

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
	public void initTest(String url, String browserName) {	
		System.out.println("Launching test in : " + browserName);
        ChainPluginService.getInstance().addSystemInfo("Build#", "1.0");
        ChainPluginService.getInstance().addSystemInfo("Owner Name#", "Prasanth V B");
        switch (browserName.toLowerCase().trim()) {
            case "chrome":
            	setDriver(new ChromeDriver());
                break;
            case "firefox":
            	setDriver(new FirefoxDriver());
                break;
            case "edge":
            	setDriver(new EdgeDriver());
                break;
            case "safari":
            	setDriver(new SafariDriver());
                break;
            default:
                System.out.println("Please enter the right browser name...." + browserName);
                throw new IllegalArgumentException("Wrong Browser : " + browserName);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		getDriver().get(url);
    }
	
	// Tear down
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
