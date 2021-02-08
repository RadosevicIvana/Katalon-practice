package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccountPage {

	WebDriver driver;
	WebElement logInButton;
	WebElement usernameInputField;
	WebElement passwordInputField;
	WebElement errorCredentialsLabel;
	WebElement logOutButton;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogInButton() {
		return driver.findElement(By.name("login"));
	}

	public WebElement getUsernameInputField() {
		return driver.findElement(By.id("username"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getErrorCredentialsLabel() {
		return driver.findElement(By.className("woocommerce-error"));
	}

	public WebElement getLogOutButton() {
		return driver.findElement(By.className("woocommerce-MyAccount-navigation-link--customer-logout"));
	}

	public void insertUsername(String username) {
		this.getUsernameInputField().clear();
		this.getUsernameInputField().sendKeys(username);
	}

	public void insertPassword(String password) {
		this.getPasswordInputField().clear();
		this.getPasswordInputField().sendKeys(password);

	}
	public void loginButtonClick() {
		this.getLogInButton().click();
	}
	
	public void assertSuccessfulLogin() {
		Assert.assertEquals(true, this.getLogOutButton().isDisplayed());
	}

}
