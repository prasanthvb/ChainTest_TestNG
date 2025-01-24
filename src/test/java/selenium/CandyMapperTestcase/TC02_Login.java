package selenium.CandyMapperTestcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium.Base.BaseClass;
import selenium.OrangeHRMPages.DashboardPage;
import selenium.OrangeHRMPages.LoginPage;

public class TC02_Login extends BaseClass {
	LoginPage loginPage;
	DashboardPage dashboardPage;

	@BeforeClass
	public void setup() {
		loginPage = new LoginPage(getDriver());
		dashboardPage = new DashboardPage(getDriver());
	}

	@Test(priority = 0, description = "TC01 Login to Application and Logout")
	public void verify_ValidCredentials() throws InterruptedException {		
		loginPage.verifyLoginpage();
		loginPage.login();
		dashboardPage.logout();
		loginPage.verifyLoginpage();	
	}

	@Test(priority = 1, enabled = true, description = "TC02 Verify invalid user error message")
	public void verify_InalidCredentials() throws InterruptedException {		
		loginPage.login("AdminTest", "TestUser");
		Assert.assertFalse(loginPage.verifyErrorMessage());	
	}
}
