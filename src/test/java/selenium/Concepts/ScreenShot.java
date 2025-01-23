package selenium.Concepts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver; 
		File src = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File dest =  new File("./ScreenShot/img1.png");
		
		FileUtils.copyFile(src, dest);
		
		driver.close();

	}

}
