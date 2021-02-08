package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
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
	@Test (priority = 2)
	public void loginWrongCredentials() {
		
	}
	@Test (priority = 4)
public void loginWrongPassword() {
		
	}
	@Test (priority = 6)
	public void loginWrongUsername() {
		
	}
	@Test (priority = 8)
	public void loginNoInput() {
		
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
