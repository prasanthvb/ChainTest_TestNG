package selenium.TicketNewTestcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import selenium.Base.BaseClass;
import selenium.TicketNewPages.BookingPage;
import selenium.TicketNewPages.LandingPage;
import selenium.TicketNewPages.MoviePage;

public class TC01_BookTicket extends BaseClass {
	LandingPage landingPage;
	MoviePage moviePage;
	BookingPage bookingPage;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void setup(String url, String browserName) {
		initTest(url, browserName);
		landingPage = new LandingPage(getDriver());
		moviePage = new MoviePage(getDriver());
		bookingPage = new BookingPage(getDriver());
	}

	@Test(priority = 1, description = "Select and verify the location for movie")
	public void verifyLocation() {
		landingPage.selectLocation("Chennai");
		ChainTestListener.log("Successfully selected the given location");
	}

	@Test(priority = 2, description = "Select language as English")
	public void selectLanguage() {
		landingPage.selectEnglish();
		ChainTestListener.log("Successfully selected language as English");
	}

	@Test(priority = 3, description = "Select last movie with 2D")
	public void selectLastMovieAs2D() {
		landingPage.clickLastMovie();
		moviePage.select2DMovies();
		ChainTestListener.log("Successfully selected last movie with 2D effect");
	}

	@Test(priority = 4, description = "Select first Cinema confirm timing")
	public void selectTheatreandTime() {
		moviePage.selectTheatreandTime();
		ChainTestListener.log("Successfully selected the cinema and time");
	}

	@Test(priority = 5, description = "Select 1st available seat, Verify price and book ticket")
	public void selectSeat() {
		bookingPage.clickOnFirstAvailableSeat();
		bookingPage.ClickOnBookTickets();
		ChainTestListener.log("Successfully selected a available seat and verified the price");
	}

	@Test(priority = 5, description = "Verify login model")
	public void verifyLoginModel() {
		bookingPage.verifyLoginModel("12345", "Mobile Number Incorrect.");
		ChainTestListener.log("Successfully verified login model function");
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		super.tearDown();
	}
}
