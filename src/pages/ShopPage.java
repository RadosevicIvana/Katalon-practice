package pages;

import org.openqa.selenium.WebDriver;

public class ShopPage {
	
	WebDriver driver; 
	
	
	public ShopPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
