package Base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	
	public static WebDriver driver;
	
	
	
	public static WebDriver initializeDriver() {
		
		if(driver==null) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-notifications");
			

			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.saucedemo.com/");
		}
		
		return driver;
	}
	
	
	public static void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
        
	}
}
