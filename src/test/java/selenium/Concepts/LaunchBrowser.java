package selenium.Concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[1]")).sendKeys("demosalesmanager");
		Thread.sleep(Duration.ofSeconds(2));
		driver.findElement(By.name("PASSWORD")).clear();
		driver.findElement(By.name("PASSWORD")).sendKeys("password");
		Thread.sleep(Duration.ofSeconds(2));
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.close();

	}

}
