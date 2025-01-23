package selenium.TestNG;

import org.testng.annotations.Test;

public class LearnAttributes {

	@Test(priority = 0,enabled = false)
	public void signup() {
		System.out.println("1 : Successfully Sign up completed");
	}
	@Test(priority = 1, description = "This test is used to login to application")
	public void login() {
		System.out.println("2 : Successfully Logged In");
		throw new RuntimeException();
	}
	
	@Test(priority = 2, alwaysRun = true, dependsOnMethods = "login" )
	public void searchItems() {
		System.out.println("3 : Searched items in search box");
	}
	
	@Test(priority = 4)
	public void addToCart() {
		System.out.println("4 : Added item to cart");
	}
	
	@Test(priority = 5)
	public void logout() {
		System.out.println("5 : Loggout of Application");
	}

}
