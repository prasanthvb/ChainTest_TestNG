package selenium.CandyMapperPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import selenium.Utils.TestUtil;

public class RegisterPage extends TestUtil {
	WebDriver driver;

	By createAccountHdr = By.xpath("//h1/child::span");
	By firstName = By.name("nameFirst");
	By lastName = By.name("nameLast");
	By email = By.name("email");
	By phone = By.name("phone");
	By createAccountbutton = By.xpath("//button[text()='Create Account']");

	By firstNameErrormessage = By.xpath("//input[@name='nameFirst']/following-sibling::p");
	By lastNameErrormessage = By.xpath("//input[@name='nameLast']/following-sibling::p");
	By emailErrormessage = By.xpath("//input[@name='email']/following-sibling::p");

	By signInLnk = By.linkText("Sign in");
	By confirmationMessage = By.xpath("//*[@data-aid='CREATE_ACCOUNT_DESCRIPTION_REND']");

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void verifyRegisterPage() {
		isDisplayed(createAccountHdr);
		Assert.assertEquals(getText(createAccountHdr), "Create Account", "Header is not displayed");
	}

	public void enterFirstName(String FirstName) {
		sendKeys(firstName, FirstName);
	}

	public void enterLastName(String LastName) {
		sendKeys(lastName, LastName);
	}

	public void enterEmailAddress(String EmailAddress) {
		sendKeys(email, EmailAddress);
	}

	public void enterPhoneNumber(String PhoneNumber) {
		sendKeys(phone, PhoneNumber);
	}

	public void clickcreateAccountbutton() {
		clickOn(createAccountbutton);
	}
	
	public void verifyFirstNameErrormessage() {
		Assert.assertTrue(verifyErrorMessage(firstNameErrormessage));
	}
	
	public void verifyLastNameErrormessage() {
		Assert.assertTrue(verifyErrorMessage(lastNameErrormessage));
	}

	public void verifyEmailerrormessage() {
		Assert.assertTrue(verifyErrorMessage(emailErrormessage));
	}

	public boolean verifyErrorMessage(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findelement(element)));
		return isDisplayed(element);
	}

	public void clicksignInLnk() {
		clickOn(signInLnk);
	}

	public void verifySuccessMessage(String email) {
		Assert.assertTrue(getText(confirmationMessage).contains(email), "Email address is not matching");
	}

}
