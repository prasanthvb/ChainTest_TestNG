package selenium.Testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import selenium.Base.BaseClass;
import selenium.Pages.DashboardPage;
import selenium.Pages.LoginPage;

@Listeners(ChainTestListener.class)
public class TC01_Login extends BaseClass {
	LoginPage loginPage;
	DashboardPage dashboardPage;

	@BeforeClass
	public void setup() {
		loginPage = new LoginPage(getDriver());
		dashboardPage = new DashboardPage(getDriver());
	}

	@Test(priority = 0)
	public void verify_Loginpage() throws InterruptedException {
		loginPage.verifyLoginpage();	
		loginPage.login();
	}

	@Test(priority = 1, enabled = true)
	public void verify_DashboardPage() throws InterruptedException {
		dashboardPage.verifyDashboardpage();
		dashboardPage.verifypunchStatus();
		dashboardPage.clickRecruitmentLnk();

//		test.fail("The dashboard is working as expected",
//				MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.getscreenBase64(getDriver())).build());
	}
}
