package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	@BeforeMethod
	public void setup() {
		driver.navigate().to("http://cms.demo.katalon.com/");
	}

	@Test(priority = 0)
	public void successfulLogin() {
		String username = excelReader.getData("Login", 2, 1);
		String password = excelReader.getData("Login", 2, 2);

		homePage.myAcountPageClick();
		myAccountPage.insertUsername(username);
		myAccountPage.insertPassword(password);
		myAccountPage.loginButtonClick();
		Assert.assertEquals(true, myAccountPage.getLogOutButton().isDisplayed());

	}

	@Test(priority = 2)
	public void loginWrongCredentials() {
		String username = excelReader.getData("WrongCredentials", 2, 1);
		String password = excelReader.getData("WrongCredentials", 2, 2);
		homePage.myAcountPageClick();
		myAccountPage.insertUsername(username);
		myAccountPage.insertPassword(password);
		myAccountPage.loginButtonClick();
		Assert.assertEquals(true, myAccountPage.getErrorCredentialsLabel().isDisplayed());
	}

	@Test(priority = 4)
	public void loginWrongPassword() {
		String username = excelReader.getData("WrongPassword", 2, 1);
		String password = excelReader.getData("WrongPassword", 2, 2);
		homePage.myAcountPageClick();
		myAccountPage.insertUsername(username);
		myAccountPage.insertPassword(password);
		myAccountPage.loginButtonClick();
		Assert.assertEquals(true, myAccountPage.getErrorCredentialsLabel().isDisplayed());
	}

	@Test(priority = 6)
	public void loginWrongUsername() {
		String username = excelReader.getData("WrongUsername", 2, 1);
		String password = excelReader.getData("WrongUsername", 2, 2);
		homePage.myAcountPageClick();
		myAccountPage.insertUsername(username);
		myAccountPage.insertPassword(password);
		myAccountPage.loginButtonClick();
		Assert.assertEquals(true, myAccountPage.getErrorCredentialsLabel().isDisplayed());
	}

	@Test(priority = 8)
	public void loginNoInput() {
		homePage.myAcountPageClick();
		myAccountPage.getUsernameInputField().clear();
		myAccountPage.getPasswordInputField().clear();
		myAccountPage.loginButtonClick();
		Assert.assertEquals(true, myAccountPage.getErrorCredentialsLabel().isDisplayed());
	}

	@Test(priority = 10)
	public void logOutConfirmation() throws InterruptedException {
		successfulLogin();
		myAccountPage.logOutButtonClick();
		Assert.assertEquals(true, myAccountPage.getLogInButton().isDisplayed());
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
