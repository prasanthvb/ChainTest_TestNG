package selenium.Concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));		
		/*
		 * Select class will allow following functions: 
		 * - selectByValue 
		 * - selectByVisibleText
		 * - selectByIndex 
		 * - getOptions 
		 * - deselectAll()
		 * 
		 */
		//Create object of Select class and select option using selectByIndex()
        Select sel = new Select(driver.findElement(By.id("dropdown-class-example")));
        sel.selectByIndex(1);
        
        // select option using selectByValue()
		sel.selectByValue("option3");
		Thread.sleep(Duration.ofSeconds(2));
		
		//select option using selectByVisibleText()
		sel.selectByVisibleText("Option2");
		Thread.sleep(Duration.ofSeconds(2));
		
		driver.close();
	}

}
