package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By username = By.id("user-name");
	By passWord = By.id("password");
	By submit = By.id("login-button");
	By errorMessage = By.xpath("//div[@class='error-message-container error']/h3");

	public void userLogin(String user, String password) {

		driver.findElement(username).sendKeys(user);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(submit).click();

	}

	public String getErrorMessege() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();

		return error;
	};

}
