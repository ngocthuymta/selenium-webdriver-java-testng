package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Custom_DropDow {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 15);

		jsExecutor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_JQuery() {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		selectItemInCustomDropDown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "5");
		SleepInSecond(2);

		Assert.assertTrue(
				driver.findElement(By.xpath("//span[@class='ui-selectmenu-text' and text()='5']")).isDisplayed());
		selectItemInCustomDropDown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "18");
		SleepInSecond(2);

	}

	@Test
	public void TC_02_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		selectItemInCustomDropDown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']/li", "");
		

	}

	@Test
	public void TC_03_React() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		selectItemInCustomDropDown("//div[@class='ui fluid selection dropdown']", "//div[@role='option']//span", "Matt");
		SleepInSecond(2);
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='divider text' and text()='Matt']")).isDisplayed());
		
		
	}

	public void selectItemInCustomDropDown(String parentXpath, String childXpath, String expectedItem) {
		driver.findElement(By.xpath(parentXpath)).click();
		SleepInSecond(1);
		List<WebElement> allIems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

		for (WebElement Item : allIems) {
			if (Item.getText().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", Item);
				Item.click();
				break;
			}
		}

	}

	public void SleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
