package tests;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTests extends TestBase {

	@BeforeMethod
	public void setup() {
		driver.navigate().to("http://cms.demo.katalon.com/");
		driver.manage().addCookie(new Cookie("wordpress_logged_in_4d8a854e0c8bd1c7f0585d2f4b3ad575",
				"customer%7C1612381014%7CT1n3yJJd4fWQPNuZwPghPIECEcE81u4977O0ZchwGJ9%7Cca4954042ed7a544384e3ce1c55f2f735fafecd83e2614b50aabb31e8b678d30"));
		driver.navigate().refresh();
	}

	@Test(priority = 0)
	public void addToCartOneProduct() {

	}

	@Test(priority = 2)
	public void deleteFromCartAddedProduct() {

	}

	@Test(priority = 4)
	public void addThreeProducts() {

	}

	@Test(priority = 6)
	public void addToCartTwoItemsAndDeleteOne() {

	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
