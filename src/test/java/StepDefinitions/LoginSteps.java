package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Base.DriverFactory;
import Pages.LoginPage;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	LoginPage login;
	ProductPage productPage;


	@Given("user is on login page")
	public void user_is_on_login_page() {

		driver = DriverFactory.initializeDriver();

	}
	
	@Given("the user is logged in")
	public void the_user_is_logged_in() {
	    
		driver = DriverFactory.initializeDriver();
		
		login = new LoginPage(driver);
		login.userLogin("standard_user","secret_sauce");
		
	}

	@When("the user logs out")
	public void the_user_logs_out() {
	   
		productPage = new ProductPage(driver);
		productPage.logout();
	}

	@Then("the user should be redirected to the login page")
	public void the_user_should_be_redirected_to_the_login_page() {
	    
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL,"https://www.saucedemo.com/");
	}

	@When("user attempts login with username {string} and password {string}")
	public void user_attempts_login_with_username_and_password(String username, String password) {

		login = new LoginPage(driver);
		login.clearUserLogin();
		login.userLogin(username, password);
	}

	@Then("user should be navigated to products page")
	public void user_should_be_navigated_to_products_page() {

		String currentUrl = driver.getCurrentUrl();

		Assert.assertTrue(currentUrl.toLowerCase().contains("inventory"));
		DriverFactory.tearDown();

	}

	@Then("an error messege should be displayed saying {string}")
	public void an_error_messege_should_be_displayed_saying(String messege) {

		if(messege.toLowerCase().contains("username")) {
			Assert.assertTrue(login.getErrorMessege().toLowerCase().contains("username"));
			
		}
		
		if(messege.toLowerCase().contains("password")) {
			
			Assert.assertTrue(login.getErrorMessege().toLowerCase().contains("password"));
		}
		
      // this make sure that if ui error messeges changes later, then tests wont fail as this is flexible
	}

}
