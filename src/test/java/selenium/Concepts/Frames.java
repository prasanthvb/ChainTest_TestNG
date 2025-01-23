package selenium.Concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/frame");
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element = driver.findElement(By.xpath("//*[@id='firstFr']"));
			
		/*
		 * using Index of the iframe. 
		 * using Name or Id of the iframe 
		 * And, using the Web Element object of the iframe
		 */

		//Frame 1
		driver.switchTo().frame(element);
		String text = driver.findElement(By.xpath("//*[text()='First Name']")).getText();
		System.out.println("Text From Frame 1"+text);
		
		//Frame 2
		driver.switchTo().frame(1);
		System.out.println("Switched to frame 2");
		driver.findElement(By.xpath("//*[@name= 'email']")).sendKeys("Testing@gmail.com");
		
		driver.switchTo().parentFrame(); // parent iframe tagName
		System.out.println("Switched to Frame 1 and Text From Frame 1"+text);
		
		driver.switchTo().defaultContent(); // initial driver location
		System.out.println("Switched to initial driver location");
	}
}
