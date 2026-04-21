package StepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.DriverFactory;
import Pages.LoginPage;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

	WebDriver driver = DriverFactory.getDriver(); // driver is initialized in a step def of login class
	ProductPage product;
	List<String> productList;

	@When("User adds multiple products to cart")
	public void user_clicks_on_add_to_cart_button_on_multiple_items() {
	    
		
		productList = new ArrayList<>();
		productList.add("Sauce Labs Backpack");
		productList.add("Sauce Labs Bike Light");
		productList.add("Sauce Labs Onesie");
		productList.add("Sauce Labs Fleece Jacket");
		
		product = new ProductPage(driver);
		product.addMultipleItemsToCart(productList);
		
		
	}

	@Then("cart icon should display the total number of items added")
	public void cart_icon_should_display_the_total_number_of_items_added() {
	   
		Assert.assertTrue(product.isCartCountMatching(productList));
	}


}
