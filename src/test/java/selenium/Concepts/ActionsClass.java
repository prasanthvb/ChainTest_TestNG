package selenium.Concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		WebElement element = driver.findElement(By.xpath("//*[@id='opentab']"));
		
		// Actions class allows you to perform complex user gestures like drag-and-drop, hover, click-and-hold, keyboard events, and more. 
		Actions action = new Actions (driver);
		
		// Performs a single left-click at the current mouse location or on the specified element.
		action.click(element).perform(); 
		action.click().perform();
		
		//Performs a right-click at the current mouse location or on the specified element.
		action.contextClick().perform(); action.contextClick(element).perform(); 
		
		//Performs a double-click at the current mouse location or on the specified element.
		action.doubleClick().perform(); action.doubleClick(element).perform(); action.clickAndHold().perform();
		
		// Clicks (without releasing) at the current mouse location or on the specified element.
		action.clickAndHold (element).perform();
		
		//Releases the mouse button held down at the current mouse location or on the specified element.
		action.release().perform();  
		action.release(element).perform();
		
		WebElement sourceelement = driver.findElement(By.id("checkBoxOption1")); 
		WebElement targetelement = driver.findElement(By.id("checkBoxOption2"));
		
		//Drags an element from the source to the target location.
		action.dragAndDrop(sourceelement, targetelement).perform();
		
		// Drags an element from its current position to the specified offset.
		//Drag to 120px right, 60px down
		action.dragAndDropBy(element, 120, 60); 
		
		// Sends a sequence of keys to the active element.
		action.sendKeys("Automation").perform(); 
		
		//Simulates pressing and releasing a specific key.
		action.keyDown(Keys.CONTROL).sendKeys("Test").keyUp(Keys.CONTROL).perform(); 
		
		//Combines multiple actions into a single action object
		action.moveToElement(element).click().build();
		
		// Pauses the action chain for a specified duration.
		action.pause(Duration.ofSeconds(10)).perform(); 
		
		driver.close();
	}

}
