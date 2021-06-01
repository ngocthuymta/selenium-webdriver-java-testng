package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Web_Browser {

	WebDriver driver;
	WebElement element;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_Very_Url() {
		// open Url
		driver.get("http://live.demoguru99.com/");
		
		// Click button My Account at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		String loginPage = driver.getCurrentUrl();
		Assert.assertEquals(loginPage, "http://live.demoguru99.com/index.php/customer/account/login/");

		// Click button Create an Account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		String registerPage = driver.getCurrentUrl();
		Assert.assertEquals(registerPage, "http://live.demoguru99.com/index.php/customer/account/create/");

	}

	@Test
	public void TC_02_Verify_Title() {
		// open Url
		driver.get("http://live.demoguru99.com/");

		// Click button My Account at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertEquals(driver.getTitle(), "Customer Login");

		// Click button Create an Account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_03_Navigate() {
		// open Url
		driver.get("http://live.demoguru99.com/");

		// Click button My Account at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		// Click button Create an Account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
		driver.navigate().forward();
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_04_GetPageSource() {
		// open Url
		driver.get("http://live.demoguru99.com/");

		// Click button My Account at footer
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		// Click button Create an Account
				driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
