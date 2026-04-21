package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {

		this.driver = driver;
	}

	By sideMenuBar = By.xpath("//div[@class='bm-burger-button']");
	By logout = By.xpath("//nav//a[@id='logout_sidebar_link']");
	By products = By.xpath("//div[@class = 'inventory_list']/div[@class='inventory_item']");
	By cartIcon = By.xpath("//a[@class='shopping_cart_link']//span[@class='shopping_cart_badge']");

	public void logout() {
		driver.findElement(sideMenuBar).click();
		driver.findElement(logout).click();

// without opening the sidebar - element not interactable exception is thrown
	}

	public void addMultipleItemsToCart(List<String> productList) {

		List<WebElement> items = driver.findElements(products);
		int count = 0;
		for (WebElement item : items) {

			String itemName = item.findElement(By.xpath(".//div[@class = 'inventory_item_name ']")).getText();

			System.out.println(itemName);
			if (productList.contains(itemName)) {

				item.findElement(By.tagName("button")).click();
				++count;

				if (count == productList.size()) {
					break;
				}

			}

			/*
			 * .//div mean search inside the current item element, otherwise selenium will
			 * search the entire page and find the first element that match the xpath, this
			 * is only applicable if we store the parent element in a variable
			 * 
			 */

		} // close for loop

	}// close method

	public boolean isCartCountMatching(List products) {

		int addedProductQty = products.size();
		int cartItemQty = 0;

		String cartItemNum = driver.findElement(cartIcon).getText();

		if (cartItemNum.isEmpty()) {

			cartItemQty = 0;
		} else {

			cartItemQty = Integer.parseInt(cartItemNum);
		}

		return cartItemQty == addedProductQty;
	}

	public int isCartCountMatching() {

		int cartItemQty = 0;

		String cartItemNum = driver.findElement(cartIcon).getText();

		if (cartItemNum.isEmpty()) {

			cartItemQty = 0;
		} else {

			cartItemQty = Integer.parseInt(cartItemNum);
		}

		return cartItemQty;
	}
}
