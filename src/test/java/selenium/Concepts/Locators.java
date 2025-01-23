package selenium.Concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		// Class Name
		// <input id="name" name="enter-name" class="inputs" placeholder="Enter Your Name" type="text">
		WebElement classname = driver.findElement(By.className("inputs"));
		classname.sendKeys("Automation Testing");
		
		//id
		// <input id="checkBoxOption1" value="option1" name="checkBoxOption1" type="checkbox"> 
		WebElement id = driver.findElement(By.id("checkBoxOption1"));
		id.click();
		
		// .class
		// <input value="radio1" name="radioButton" class="radioButton" type="radio"> 
		WebElement dotcss = driver.findElement(By.cssSelector(".radioButton"));
		dotcss.click();
		
		// #id
		//<input type="text" id="autocomplete" class="inputs ul-autocomplete-input" placeholder "Type to Select Countries" auteconolete="off"> 
		WebElement hashcss = driver.findElement(By.cssSelector("#autocomplete"));
		hashcss.clear();

		// cssSelector
		//<a id="opentab" class="btn-style class1 class2" href "https://www.qaclickacademy.com" target="_blank">Open Tab</a>
		driver.findElement(By.cssSelector("/a[id='opentab']")).click();
		
		// LinkText
		//<button class="btn btn-primary">Practice</button> 
		driver.findElement(By.linkText("Practice")).click();
		
		// partialLinkText
		//<a target="_blank" href="https://qasummit.org/" class="blinkingText">QA Meetup with Rahul Shetty @Bangalore Limited Seats! Book Now!</a> 
		driver.findElement(By.partialLinkText("QA Meetup with Rahul Shetty")).click();
		
		// name
		//<input id="name" name="enter-name" class="inputs" placeholder="Enter Your Name" type="text">
		driver.findElement(By.name("enter-name"));
		
		// tagname
		//<input id="hide-textbox" class="btn-style class2" value="Hide" onclick="hideElement()" type="submit">
		driver.findElement(By.tagName("input")).sendKeys("Hello");
		
		// Xpath
		//<button id="openwindow" class="btn-style class1" onclick="openwindow()">Open Window</button> 
		driver.findElement(By.xpath("//button[@id='openwindow']"));
		
		// Xpath (text)
		driver.findElement(By.xpath("//a[text()='Open Window']"));
		
		//Xpath (Contains)
		driver.findElement(By.xpath("//button[contains(text(), 'Open Window')]"));
		
		driver.close();
	}

}
