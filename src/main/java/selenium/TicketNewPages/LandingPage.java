package selenium.TicketNewPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.Utils.TestUtil;

public class LandingPage extends TestUtil {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	WebDriver driver;

	By locationtxt = By.xpath("//input[@type='search']");
	By locationList = By.xpath("//*[contains(@class,'DesktopMovieCitySelector_searchedArea')]");
	By selectedLocation = By.xpath("//i[@class='location-big']/following-sibling::span");

	By englishBtn = By.xpath("//*[@id='English']");

	By moviesName = By.xpath("//*[contains(@class,'DesktopRunningMovie_movTitle')]");
	
	public void selectLocation(String location) {
		waitForElementToBeVisible(locationtxt);
		sendKeys(locationtxt, location);
		waitforsec(2);
		waitForElementToBeVisible(locationList);
		javaScriptClick(locationList);
		waitForElementToBeVisible(selectedLocation);
		String actualLocation = getText(selectedLocation);
		Assert.assertEquals(actualLocation, location);
	}

	public void selectEnglish() {
		waitForElementToBeClickable(englishBtn);
		javaScriptClick(englishBtn);
	}

	public void clickLastMovie() {
		List<WebElement> elements = findelements(moviesName);
		for (int i = 0; i < elements.size() - 2; i++) {
			System.out.println("Movie Number " + (i + 1) + ": " + elements.get(i).getText());
		}
		if (!elements.isEmpty()) {
			elements.get(elements.size() - 3).click();
			System.out.println("Clicked on the last Movie.");
		} else {
			System.out.println("No Movies found.");
		}
	}

}
