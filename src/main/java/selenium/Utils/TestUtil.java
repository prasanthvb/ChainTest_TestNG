package selenium.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	static WebDriver driver;

	public TestUtil(WebDriver driver) {
		TestUtil.driver = driver;
	}

	public static WebElement findelement(By ele) {
		WebElement element = driver.findElement(ele);
		return element;
	}

	public static List<WebElement> findelements(By ele) {
		List<WebElement> element = driver.findElements(ele);
		return element;
	}

	public void clickOn(By ele) {
		findelement(ele).click();
	}

	public void sendKeys(By ele, String value) {
		findelement(ele).sendKeys(value);
	}

	public void clearAndsendKeys(By ele, String value) {
		clearWebField(findelement(ele));
		findelement(ele).sendKeys(value);
	}

	public boolean isDisplayed(By ele) {
		boolean displayed = findelement(ele).isDisplayed();
		return displayed;
	}

	public String getText(By ele) {
		String text = findelement(ele).getText();
		return text;
	}

	public static String getscreenBase64(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

	public static String getSystemDate() {
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static void waitforsec(int sec) {
		try {
			Thread.sleep(Duration.ofSeconds(sec));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clearWebField(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
		element.sendKeys(Keys.DELETE);
	}

	public void tab(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

	// Explicit Wait for Element To Be Visible.
	public static void waitForElementToBeVisible(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}

	// Explicit Wait for Element To Be Clickable.
	public static void waitForElementToBeClickable(By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
	}

	public static void javaScriptClick(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", findelement(element));
	}

	public static void switchToframe(By element) {
		driver.switchTo().frame(findelement(element));
	}

	public static void switchTodefaultContent() {
		driver.switchTo().defaultContent();
	}
}
