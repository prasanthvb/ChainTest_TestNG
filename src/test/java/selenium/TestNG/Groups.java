package selenium.TestNG;

import org.testng.annotations.Test;

public class Groups {
	
	@Test(groups = {"sanity"})
	public void signup() {
		System.out.println("1 : Successfully Sign up completed");
	}
	@Test(groups = {"regression"})
	public void login() {
		System.out.println("2 : Successfully Logged In");
	}
	
	@Test(groups = {"sanity"})
	public void searchItems() {
		System.out.println("3 : Searched items in search box");
	}
	
	@Test(groups = {"smoke"})
	public void addToCart() {
		System.out.println("4 : Added item to cart");
	}
	
	@Test(groups = {"sanity", "smoke"})
	public void logout() {
		System.out.println("5 : Loggout of Application");
	}

}
