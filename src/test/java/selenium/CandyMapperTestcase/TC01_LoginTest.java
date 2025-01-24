package selenium.CandyMapperTestcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.Base.BaseClass;
import selenium.CandyMapperPages.LoginPage;

public class TC01_LoginTest extends BaseClass {
	LoginPage loginPage;

	@Parameters({"url", "browser"})
	@BeforeClass
	public void setup(String url, String browserName) {
		initTest(url, browserName);
		loginPage = new LoginPage(getDriver());
		loginPage.closePopup();
		loginPage.clickJoinUsLnk();
	}

	@Test(priority = 2, description = "Log in with invalid email")
	public void loginwithinvalidemail() {
		loginPage.login("invalid@gmail.com", "112233Mo@@");
		loginPage.verifyErrorrmessageforinvaliddata();
	}

	@Test(priority = 3, description = "Log in with invalid password ")
	public void loginwithinvalidpassord() {
		loginPage.login("77mossttffaa@gmail.com", "23@56");
		loginPage.verifyErrorrmessageforinvaliddata();
	}

	@Test(priority = 4, description = "Log in with empty data ")
	public void loginwithemptyemail() {
		loginPage.login("", "");
		loginPage.verifyEmailerrormessage();
		loginPage.verifyPassworderrormessage();
	}

	@Test(priority = 5, description = "Log in with valid data")
	public void loginwithvaliddata() {
		loginPage.login("77mossttffaa@gmail.com", "112233Mo@@");
		loginPage.verifyLoginSuccess();
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		super.tearDown();
	}
}
