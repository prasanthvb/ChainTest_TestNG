package selenium.Concepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandles {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.id("alertButton")).click();
		
		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(Duration.ofSeconds(4));
		alert.accept(); // accept alert
		Thread.sleep(Duration.ofSeconds(4));
		
		driver.findElement(By.id("confirmButton")).click();
		String text = alert.getText(); // Text from alert
		System.out.println("Confirm Alert Text : " + text);
		
		alert.dismiss(); // dismiss alert
		
		String confirmResult = driver.findElement(By.id("confirmResult")).getText();
		System.out.println("Alert cancelled message: " + confirmResult);
		if(confirmResult.contains("Cancel")) {
			System.out.println("Alert is cancelled");
		}
		
		driver.findElement(By.id("promtButton")).click();
		String text2 = alert.getText();
		System.out.println("Promt Alert Text : " + text2);
		
		alert.sendKeys("Testing"); // Send text to alert
		alert.accept();
		
		String promptResult = driver.findElement(By.id("promptResult")).getText();
		System.out.println("prompt Result :  " + promptResult);
		if(confirmResult.contains("Prasanth")) {
			System.out.println("Name is displyed");
		}
		Thread.sleep(Duration.ofSeconds(4));
		driver.close();

	}

}
