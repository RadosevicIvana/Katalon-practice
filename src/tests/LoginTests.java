package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	@BeforeMethod
	public void setup(){
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
		myAccountPage.assertSuccessfulLogin();

	}

	@Test(priority = 2)
	public void loginWrongCredentials() {
		String username = excelReader.getData("WrongCredentials", 2, 1);
		String password = excelReader.getData("WrongCredentials", 2, 2);
		homePage.myAcountPageClick();
		myAccountPage.insertUsername(username);
		myAccountPage.insertPassword(password);
		myAccountPage.loginButtonClick();
		excelReader.asserting("WrongCredentials", 2, 3, myAccountPage.getErrorCredentialsLabel().getText());
	}

	@Test(priority = 4)
	public void loginWrongPassword() {
		String username = excelReader.getData("WrongPassword", 2, 1);
		String password = excelReader.getData("WrongPassword", 2, 2);
		homePage.myAcountPageClick();
		myAccountPage.insertUsername(username);
		myAccountPage.insertPassword(password);
		myAccountPage.loginButtonClick();
		excelReader.asserting("WrongPassword", 2, 3, myAccountPage.getErrorCredentialsLabel().getText());
	}

	@Test(priority = 6)
	public void loginWrongUsername() {
		String username = excelReader.getData("WrongUsername", 2, 1);
		String password = excelReader.getData("WrongUsername", 2, 2);
		homePage.myAcountPageClick();
		myAccountPage.insertUsername(username);
		myAccountPage.insertPassword(password);
		myAccountPage.loginButtonClick();
		excelReader.asserting("WrongUsername", 2, 3, myAccountPage.getErrorCredentialsLabel().getText());
	}

	@Test(priority = 8)
	public void loginNoInput() {
		homePage.myAcountPageClick();
		myAccountPage.getUsernameInputField().clear();
		myAccountPage.getPasswordInputField().clear();
		myAccountPage.loginButtonClick();
		excelReader.asserting("NoInput", 2, 3, myAccountPage.getErrorCredentialsLabel().getText());
	}

	@Test(priority = 10)
	public void logOutConfirmation() throws InterruptedException {
		successfulLogin();
		myAccountPage.logOutButtonClick();
		myAccountPage.assertSuccessfulLogout();
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
