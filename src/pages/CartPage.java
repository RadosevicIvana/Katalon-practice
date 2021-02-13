package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	WebDriver driver;
	WebElement product1Label;
	WebElement product2Label;
	WebElement product3Label;
	WebElement product1Price;
	WebElement product2Price;
	WebElement product3Price;
	WebElement deleteButton;
	WebElement itemRemovedLabel;
	WebElement quantityLabel;
	WebElement cartEmptyLabel;

	public CartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProduct1Label() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[3]/a"));
	}

	public WebElement getProduct2Label() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[2]/td[3]/a"));
	}

	public WebElement getProduct3Label() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[3]/td[3]/a"));
	}

	public WebElement getProduct1Price() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[4]/span"));
	}

	public WebElement getProduct2Price() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[2]/td[4]/span"));
	}

	public WebElement getProduct3Price() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[3]/td[4]"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.className("remove"));
	}

	public WebElement getItemRemovedLabel() {
		return driver.findElement(By.className("woocommerce-message"));
	}

	public WebElement getQuantityLabel() {
		return driver.findElement(By.id("quantity_60280f1cbea34"));
	}

	public WebElement getCartEmptyLabel() {
		return driver.findElement(By.className("cart-empty"));
	}

	public void deleteButtonClick() {
		this.getDeleteButton().click();
	}
}
