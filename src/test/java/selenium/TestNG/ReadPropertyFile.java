package selenium.TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadPropertyFile {
	
	@Test
	public void getpropertyfile() {
		Properties prop = new Properties();
		try {
			FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("Browser"));
		System.out.println(prop.getProperty("URL"));
	}

}
