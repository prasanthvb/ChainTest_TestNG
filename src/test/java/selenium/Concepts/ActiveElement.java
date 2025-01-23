package selenium.Concepts;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveElement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement activeElement = driver.switchTo().activeElement();
		activeElement.sendKeys("email", 
				Keys.TAB,
				"Password",
				Keys.ENTER);
	}

}
