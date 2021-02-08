package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	
	WebElement cartTab;
	WebElement myAccountTab;
	WebElement shopTab; 
	WebElement checkOutTab; 
	WebElement samplePageTab; 
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCartTab() {
		return driver.findElement(By.className("page-item-8"));
	}

	public WebElement getMyAccountTab() {
		return driver.findElement(By.className("page-item-10"));
	}

	public WebElement getShopTab() {
		return driver.findElement(By.className("page-item-7"));
	}

	public WebElement getCheckOutTab() {
		return driver.findElement(By.className("page-item-9"));
	}

	public WebElement getSamplePageTab() {
		return driver.findElement(By.className("page-item-2"));
	}
	public void cartTabClick() {
		this.getCartTab().click();
	}
	public void myAcountPageClick() {
		this.getMyAccountTab().click();
	}
	public void shopTabClick() {
		this.getShopTab().click();
	}
	
}
