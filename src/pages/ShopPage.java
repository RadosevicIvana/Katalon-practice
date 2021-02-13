package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {

	WebDriver driver;
	WebElement product1;
	WebElement product2;
	WebElement product3;

	public ShopPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProduct1() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[1]/div/a[2]"));
	}

	public WebElement getProduct2() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[2]/div/a[2]"));
	}

	public WebElement getProduct3() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[3]/div/a[2]"));
	}

	public void addproduct1toCart() {
		this.getProduct1().click();
	}

	public void addproduct2toCart() {
		this.getProduct2().click();
	}

	public void addproduct3toCart() {
		this.getProduct3().click();
	}
}
