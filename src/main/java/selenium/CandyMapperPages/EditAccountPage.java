package selenium.CandyMapperPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import selenium.Utils.TestUtil;

public class EditAccountPage extends TestUtil {
	WebDriver driver;

	By profileIcon = By.xpath("(//*[local-name()='svg' and @data-ux='UtilitiesMenuIcon'])[2]");
	By profileHeader = By.xpath("//div[@data-ux='Container']/child::h3");
	By profileName = By.xpath("//div[@data-ux='GridCell']/child::h3");
	By firstName = By.name("nameFirst");
	By lastName = By.name("nameLast");
	By saveBtn = By.xpath("//button[@data-ux='ButtonPrimary']");
	By myAccountBtn = By.linkText("My Account");
	By signoutBtn = By.linkText("Sign out");
	By editProfileLnk = By.linkText("Edit Profile");

	public EditAccountPage(WebDriver driver) {
		super(driver);
	}

	public void verifyProfilepage() {
		isDisplayed(profileHeader);
		Assert.assertEquals(getText(profileHeader), "Profile", "Header is not displayed");
	}

	public void EnterName(String firstname, String lastname) {
		clearAndsendKeys(firstName, firstname);
		tab(findelement(firstName));
		waitforsec(2);
		clearAndsendKeys(lastName, lastname);
		waitforsec(2);
	}
	
	public void save() {
		clickOn(saveBtn);
	}
	
	public void clickEditProfile() {
		clickOn(editProfileLnk);
	}
	
	public void verifySavedDetails(String firstname, String lastname) {
		String text = getText(profileName);
		Assert.assertTrue(text.contains(firstname));
		Assert.assertTrue(text.contains(lastname));
	}
	
	public void clickMyAccount() {
		clickOn(profileIcon);
		waitforsec(2);
		clickOn(myAccountBtn);
		waitforsec(2);
	}

	public void logout() {
		clickOn(profileIcon);
		waitforsec(2);
		clickOn(signoutBtn);
		waitforsec(2);
	}

}
