package pages;

import org.openqa.selenium.WebDriver;

public class CartPage {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
