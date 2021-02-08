package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CartPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.ShopPage;

public class TestBase {
	
	WebDriver driver;
	MyAccountPage myAccountPage;
	HomePage homePage;
	XSSFWorkbook wb;
	ExcelReader excelReader;
	ShopPage shopPage;
	CartPage cartPage;
	
	@BeforeClass
	public void preKlase() throws IOException {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.myAccountPage = new MyAccountPage(driver);
		this.homePage = new HomePage(driver);
		this.excelReader= new ExcelReader("Data/Katalon data.xlsx");
		this.shopPage = new ShopPage(driver); 
		this.cartPage = new CartPage(driver);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void posleKlase() throws IOException {
		driver.close();
		driver.quit();
		excelReader.fis.close();
	}


}
