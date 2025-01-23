package selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import selenium.Utils.TestUtil;

public class DashboardPage extends TestUtil {
	WebDriver driver;

	By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	By punchStatus = By.xpath("//*[contains(@class,'attendance-card-state')]");
	By punchdetails = By.xpath("//*[contains(@class,'attendance-card-details')]");
	By recruitmentLnk = By.xpath("//span[text()='Recruitment']");
	By userName = By.xpath("//li[@class='oxd-userdropdown']");
	By logoutBtn = By.linkText("Logout");
	By myInfoLnk = By.xpath("//span[text()='My Info']");

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	public void verifyDashboardpage() {
		boolean displayed = isDisplayed(dashboardHeader);
		Assert.assertEquals(displayed, true, "Dashboard Header is not displayed");
	}

	public void verifypunchStatus() {
		String text = getText(punchStatus);
		if (text.equals("Punched In")) {
			String text2 = getText(punchdetails);
			boolean contains = text2.contains("Punched In");
			Assert.assertTrue(contains, "Punched In not displayed in details");
			System.out.println("User is punched in");
		} else {
			String text2 = getText(punchdetails);
			boolean contains = text2.contains("Punched Out");
			Assert.assertTrue(contains, "Punched out not displayed in details");
			System.out.println("User is punched out");
		}
	}

	public void clickRecruitmentLnk() {
		clickOn(recruitmentLnk);
	}

	public void clickMyinfoLnk() {
		clickOn(myInfoLnk);
	}

	public void logout() {
		clickOn(userName);
		clickOn(logoutBtn);
	}

}
