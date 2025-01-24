package selenium.OrangeHRMPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import selenium.Utils.TestUtil;

public class LoginPage extends TestUtil {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	WebDriver driver;

	By loginHeader = By.xpath("//h5[text()='Login']");
	By username = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//button[@type='submit']");
	By forgetPasswordLnk = By.xpath("//*[text()='Forgot your password? ']");
	By errorMessage = By.xpath("//p[text()='Invalid credentials']");

	public void verifyLoginpage() {
		boolean displayed = isDisplayed(loginHeader);
		Assert.assertEquals(displayed, true, "Login Header is not displayed");
		Assert.assertTrue(displayed);
	}

	public void enterUsername() {
		sendKeys(username, "Admin");
	}

	public void enterPassword() {
		sendKeys(password, "admin123");
	}

	public void enterUsername(String userName) {
		sendKeys(username, userName);
	}

	public void enterPassword(String passWord) {
		sendKeys(password, passWord);
	}
	public void clickLoginBtn() {
		clickOn(loginBtn);
	}

	public void login() {
		enterUsername();
		enterPassword();
		clickLoginBtn();
	}
	
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginBtn();
	}

	public boolean verifyErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findelement(errorMessage)));
		return isDisplayed(errorMessage);
	}

}
