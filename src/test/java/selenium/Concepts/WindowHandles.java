package selenium.Concepts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		String mainWindow = driver.getWindowHandle();
		System.out.println("main window name : " + mainWindow);
		WebElement link = driver.findElement(By.xpath("//*[@id='openwindow']"));
		link.click();
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String childwindow : allWindows) {
			if(!childwindow.equals(mainWindow)) {
				System.out.println("child window name : " + childwindow);
				driver.switchTo().window(childwindow);
				break;
			}
		}
		
		String title = driver.getTitle();
		System.out.println("Title of the child window: " + title);
		driver.close();

		driver.switchTo().window(mainWindow);
		String title1 = driver.getTitle();
		System.out.println("Title of the main window: " + title1);
		driver.quit();
	}

}
