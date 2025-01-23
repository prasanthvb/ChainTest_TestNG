package selenium.Concepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadiobutonCheckbox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// Functions with Radio button
		WebElement radio2 = driver.findElement(By.xpath("//input[@value='radio2']"));
		boolean displayed = radio2.isDisplayed();
		System.out.println(displayed); // True / false

		boolean enabled = radio2.isEnabled();
		System.out.println(enabled); // True / false

		boolean selected = radio2.isSelected();
		System.out.println(selected); // false

		radio2.click();
		boolean selected2 = radio2.isSelected();
		System.out.println("After Selecting : " + selected2); // true

		// Functions with checkboxes
		List<WebElement> checkboxes = driver.findElements(
				By.xpath("//*[text()='Checkbox Example']/following-sibling::label/input[@type='checkbox']"));
		System.out.println("Number of checkboxes : " + checkboxes.size());
		for (int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
			// get the attribute value from DOM
			String domAttribute = checkboxes.get(i).getDomAttribute("value");
			System.out.println(domAttribute);
		}

		// Select one radio button from list of radio buttons
		List<WebElement> radiobuttons = driver.findElements(By.xpath("//input[@name='radioButton']"));
		System.out.println("Number of checkboxes : " + radiobuttons.size());
		for (int i = 0; i < radiobuttons.size(); i++) {
			String text = radiobuttons.get(i).getDomAttribute("value");
			System.out.println(text);
			if (text.contains("radio1")) {
				radiobuttons.get(i).click();
			}
		}

		driver.close();

	}

}
