package selenium.TicketNewPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.Utils.TestUtil;

public class MoviePage extends TestUtil {

	public MoviePage(WebDriver driver) {
		super(driver);
	}

	WebDriver driver;

	By filterFormatButton = By.xpath("(//div[@id='filterButton'])[2]");
	By checkBox2D = By.xpath("//span[text()='2D']/preceding-sibling::span/span");
	By selectedFormat = By.xpath("(//div[@id='filterButton'])[2]/*[contains(@class,'filterValue')]");
	By closeFilter = By.xpath("(//div[@id='filterButton'])[2]//*[@class='close']");

	By getTheatreName = By.xpath("//*[contains(@class,'MovieSessionsListingDesktop_details')]/a");
	By showTimeList = By.xpath(
			"(//*[contains(@class,'MovieSessionsListingDesktop_movieSessions')])[1]/child::*//div[contains(@class,'greenCol MovieSessionsListingDesktop_time')]");

	public void select2DMovies() {
		waitForElementToBeClickable(filterFormatButton);
		javaScriptClick(filterFormatButton);
		waitForElementToBeClickable(checkBox2D);
		javaScriptClick(checkBox2D);
		Assert.assertTrue(getText(selectedFormat).contains("2D"), "2D is not selected");
		clickOn(closeFilter);
	}

	public void selectTheatreandTime() {
		List<WebElement> gettheatreName = findelements(getTheatreName);
		for (int i = 0; i <= gettheatreName.size() - 1; i++) {
			System.out.println("Cinema available in " + (i + 1) + ": " + gettheatreName.get(i).getText());
		}
		List<WebElement> showtimelist = findelements(showTimeList);
		if (!showtimelist.isEmpty()) {
			showtimelist.get(0).click();
		} else {
			System.out.println("No movies timings found.");
		}
	}

}
