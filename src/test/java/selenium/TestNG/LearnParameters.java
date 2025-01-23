package selenium.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearnParameters {

	@Parameters({"url", "email", "password"})
	@Test
	public void login(String url, String email, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String title = driver.getTitle();
		System.out.println("The title of the page is : " + title);
		
		driver.quit();

	}

}
