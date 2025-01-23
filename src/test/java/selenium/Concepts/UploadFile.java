package selenium.Concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
		
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		
		WebElement uploadele = driver.findElement(By.xpath("//input[@type ='file']"));
		uploadele.sendKeys("C:\\PrasanthVB\\Selenium Automation\\Selenium_2024\\automation\\Upload\\Testing.DOCX");
		
		driver.close();

	}

}
