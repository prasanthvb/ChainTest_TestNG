package selenium.Concepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LearnXpath {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers/bse/weekly/groupt");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		String url = driver.getCurrentUrl();
		System.out.println("The Current URL of the application is " + url);
		
		// Q: What are the different type of nodes while finding the Xpath?
		
		// Self node //*[attribute= 'value']
		String selftext =driver.findElement(By.xpath("//a[contains(text(), 'Reliance Home')]/self::a")).getText();
		System.out.println(selftext);
		
		//Parent node //*[attribute= 'value']/parent::tagname
		String parentText =driver.findElement(By.xpath("//a[contains(text(), 'Reliance Home')]/parent::td")).getText();
		System.out.println(parentText);
		
		//Ancestor node //*[attribute= 'value']/Ancestor::tagname
		String ancestorText =driver.findElement(By.xpath("//a[contains(text(), 'Reliance Home')]/ancestor::tr")).getText();
		System.out.println(ancestorText);
		
		//Child node //*[attribute= 'value']/child::tagname
		List<WebElement> childsize = driver.findElements(By.xpath("//a[contains(text(), 'Reliance Home')]/ancestor::tr/child::td"));
		System.out.println("Number of child element are " + childsize.size());
		
		// Descendant node //*[attribute= 'value']/descender::tagname
		List<WebElement> descendantsize = driver.findElements(By.xpath("//a[contains(text(), 'Reliance Home')]/ancestor::tr/descendant::*"));
		System.out.println("Number of Descendant node are" + descendantsize.size());

		//following node //*[attribute= 'value']/following::tagname
		List<WebElement> followingnodes = driver.findElements(By.xpath("//a[contains(text(), 'Reliance Home')]/ancestor::tr/following::tr"));
		System.out.println("Numbers of following nodes are" + followingnodes.size());
		
		//Preceding node //*[attribute= 'value']/preceding::tagname
		List<WebElement> precedingnodes = driver.findElements(By.xpath("//a[contains(text(), 'Reliance Home')]/ancestor::tr/preceding::tr"));
		System.out.println("Numbers of preceding nodes are" + precedingnodes.size());
		
		//Following preceding node //*[attribute= 'value']/followed-sibling: :tagname
		List<WebElement> followingsibling = driver.findElements(By.xpath("//a[contains(text(), 'Reliance Home')]/ancestor::tr/following-sibling::tr"));
		System.out.println("Numbers of following sibling nodes are "+ followingsibling.size());

		//Following Preceding node //*[attribute= 'value']/preceding-sibling::tagname
		List<WebElement> precedingsibling = driver.findElements(By.xpath("//a[contains(text(), 'Reliance Home')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Numbers of Precedings sibling nodes are " + precedingsibling.size());

		driver.quit();	
	}

}
