package selenium.TicketNewPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selenium.Utils.TestUtil;

public class BookingPage extends TestUtil {

	public BookingPage(WebDriver driver) {
		super(driver);
	}

	WebDriver driver;

	By exeticketPriceTitle = By.xpath("(//div[contains(@class,'FixedSeatingDesktop_detaDetail')]/div)[1]");
	By activeSeatList = By.xpath("//span[@class='available']");
	By ticketPrice = By.xpath("//div[contains(@class,'SeatLayoutFooterDesktop_ticketPrice')]");
	By bookTicketBtn = By.xpath("//button[contains(@class,'SeatLayoutFooterDesktop_bookTicket')]");

	By iframe = By.xpath("//iframe[@id='oauth-iframe']");
	By signInTab = By.xpath("//div[@oauth-id='signInTab']");
	By input_mobile = By.xpath("//input[@id='email_mobile_login']");
	By getOTPBtn = By.xpath("//button[@oauth-id='login_button']");

	By errorMessage = By.xpath("//input[@id='email_mobile_login']/following-sibling::div[2]");
	By closeModel = By.xpath("//*[contains(@class,'closeModal')]");

	public void clickOnFirstAvailableSeat() {
		String ExpectedticketPriceTitle = getText(exeticketPriceTitle);
		List<WebElement> availableSeat = findelements(activeSeatList);
		if (!availableSeat.isEmpty()) {
			availableSeat.get(0).click();
		} else {
			System.out.println("No Active seats");
		}
		Assert.assertTrue(ExpectedticketPriceTitle.contains(getText(ticketPrice)));
	}

	public void ClickOnBookTickets() {
		clickOn(bookTicketBtn);
		waitforsec(3);
	}

	public void verifyLoginModel(String number, String message) {
		switchToframe(iframe);
		waitForElementToBeVisible(signInTab);
		sendKeys(input_mobile, number);
		clickOn(getOTPBtn);
		Assert.assertEquals(message, getText(errorMessage));
		switchTodefaultContent();
		clickOn(closeModel);
	}

}
