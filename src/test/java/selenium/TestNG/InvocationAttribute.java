package selenium.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class InvocationAttribute {
	
	@Test(invocationCount = 3, threadPoolSize = 3, invocationTimeOut = 20000)
	public void dropdownTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
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
		
		//select option using selectByVisibleText()
		sel.selectByVisibleText("Option2");
		
		driver.close();
	}

}
