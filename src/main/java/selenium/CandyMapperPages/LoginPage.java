package selenium.CandyMapperPages;

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
	
	By popupClose = By.xpath("//*[local-name()='svg' and contains(@id, 'close-icon')]");

	By loginHeader = By.tagName("h1");
	By joinUsLnk = By.linkText("JOIN US");
	By username = By.name("email");
	By password = By.name("password");
	By signinbutton = By.tagName("button");
	By resetPasswordLnk = By.linkText("Reset password");
	By createAccountLnk = By.linkText("Create account.");
	By errorrmessageforinvaliddata = By.xpath("//button[@type='submit']/following-sibling::p");
	By emailerrormessage = By.xpath("//input[@name='email']/following-sibling::p");
	By passworderrormessage = By.xpath("//input[@name='password']/following-sibling::p");

	public void closePopup() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findelement(popupClose)));
		clickOn(popupClose);
		}catch (Exception e) {
			
		}
	}
	
	public void verifyLoginpage() {
		isDisplayed(loginHeader);
		Assert.assertEquals(getText(loginHeader), "CandyMapper: \r\n" + "The Website That Goes Wrong!",
				"Header is not displayed");
	}
	
	public void verifyLoginSuccess() {
		isDisplayed(loginHeader);
		Assert.assertEquals(getText(loginHeader), "Account Login",
				"Header is not displayed");
	}

	public void enterUsername(String userName) {
		sendKeys(username, userName);
	}

	public void enterPassword(String passWord) {
		sendKeys(password, passWord);
	}

	public void clickJoinUsLnk() {
		clickOn(joinUsLnk);
	}
	public void clickLoginBtn() {
		clickOn(signinbutton);
	}
	
	public void clickResetPasswordLnk() {
		clickOn(resetPasswordLnk);
	}
	
	public void clickCreateAccountLnk() {
		clickOn(createAccountLnk);
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginBtn();
	}

	public void verifyErrorrmessageforinvaliddata() {
		Assert.assertTrue(verifyErrorMessage(errorrmessageforinvaliddata));
	}

	public void verifyEmailerrormessage() {
		Assert.assertTrue(verifyErrorMessage(emailerrormessage));
	}

	public void verifyPassworderrormessage() {
		Assert.assertTrue(verifyErrorMessage(passworderrormessage));
	}

	public boolean verifyErrorMessage(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findelement(element)));
		return isDisplayed(element);
	}

}
