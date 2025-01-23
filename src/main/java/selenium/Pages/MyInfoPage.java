package selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import selenium.Utils.TestUtil;

public class MyInfoPage extends TestUtil {
	WebDriver driver;

	By myinfoHeader = By.xpath("//h6[text()='PIM']");
	By firstName = By.xpath("//input[@name='firstName']");
	By middleName = By.xpath("//input[@name='middleName']");
	By lastName = By.xpath("//input[@name='lastName']");
	By userName = By.xpath("//li[@class='oxd-userdropdown']");
	By logoutBtn = By.linkText("Logout");

	public MyInfoPage(WebDriver driver) {
		super(driver);
	}

	public void verifyMyinfopage() {
		boolean displayed = isDisplayed(myinfoHeader);
		Assert.assertEquals(displayed, true, "Dashboard Header is not displayed");
	}

	public void EnterName(String firstname, String middlename, String lastname) {
		clearAndsendKeys(firstName, firstname);
		tab(findelement(firstName));
		waitforsec(2);
		clearAndsendKeys(middleName, middlename);
		tab(findelement(middleName));
		waitforsec(2);
		clearAndsendKeys(lastName, lastname);
		waitforsec(2);
	}

	public void logout() {
		clickOn(userName);
		waitforsec(2);
		clickOn(logoutBtn);
		waitforsec(2);
	}

}
