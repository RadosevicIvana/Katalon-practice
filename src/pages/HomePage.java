package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	WebElement cartTab;
	WebElement myAccountTab;
	WebElement shopTab; 
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
}
