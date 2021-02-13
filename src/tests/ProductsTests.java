package tests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
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
		shopPage.addproduct1toCart();
		homePage.cartTabClick();
		excelReader.asserting("Products", 1, 1, cartPage.getProduct1Label().getText());
	}

	@Test(priority = 2)
	public void deleteFromCartAddedProduct() {
		addToCartOneProduct();
		cartPage.deleteButtonClick();
		Assert.assertEquals(true, cartPage.getCartEmptyLabel().isDisplayed());

	}

	@Test(priority = 4)
	public void addThreeProducts() {
		shopPage.addproduct1toCart();
		shopPage.addproduct2toCart();
		shopPage.addproduct3toCart();
		homePage.cartTabClick();

		excelReader.asserting("Products", 1, 1, cartPage.getProduct1Label().getText());
		excelReader.asserting("Products", 1, 2, cartPage.getProduct2Label().getText());
		excelReader.asserting("Products", 1, 3, cartPage.getProduct3Label().getText());

		excelReader.asserting("Products", 2, 1, cartPage.getProduct1Price().getText());
		excelReader.asserting("Products", 2, 2, cartPage.getProduct2Price().getText());
		excelReader.asserting("Products", 2, 3, cartPage.getProduct3Price().getText());
	}

	@Test(priority = 6)
	public void addToCartTwoItemsAndDeleteOne() {
		shopPage.addproduct1toCart();
		shopPage.addproduct2toCart();
		homePage.cartTabClick();
		cartPage.deleteButtonClick();
		excelReader.asserting("Products", 3, 1, cartPage.getItemRemovedLabel().getText());

	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
