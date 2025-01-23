package selenium.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utils.DataUtils;

public class LearnDataprovider{

	@Test(dataProvider = "getData", dataProviderClass = DataUtils.class)
	public void login(String email, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String title = driver.getTitle();
		System.out.println("The title of the page is : " + title);
		
		driver.quit();
	}

}
