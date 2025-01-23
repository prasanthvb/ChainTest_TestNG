package Utils;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	@DataProvider(name ="login", indices = {0,1}, parallel = true)
	public String[][] getData(){
		
		String [][] data = new String [2][2];
		data [0][0] = "Admin";
		data [0][1] = "admin123";
		
		data [1][0] = "Gomathi";
		data [1][1] = "December";
		
		return data;
	}
}
