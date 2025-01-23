package selenium.Concepts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * author: Prasanth V B
 */
public class SeleniumUpdate {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/radio");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Locate an Element
		WebElement element = driver.findElement(By.id("yes"));
		
		// Get DOM Attribute
		String domattribute = element.getDomAttribute("type");
		
		// Get DOM Property
		String domproperty = element.getDomProperty("checked");
		
		// Print the results
		System.out.println("DOM Attribute Value is " + domattribute);
		System.out.println("DOM Property value is " + domproperty);
		
		driver.quit();
	}
}
