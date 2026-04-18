package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {

		this.driver = driver;
	}

	By sideMenuBar = By.xpath("//div[@class='bm-burger-button']");
	By logout = By.xpath("//nav//a[@id='logout_sidebar_link']");

	
	public void logout() {
		driver.findElement(sideMenuBar).click();
		driver.findElement(logout).click();
		
// without opening the sidebar - element not interactable exception is thrown
	}

}
