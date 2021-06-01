package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_WebElement {
	WebDriver driver;
	By emailTextBox = By.id("mail");
	By ageUnderRadio = By.id("under_18");
	By eduTextBox = By.id("edu");
	By nameUser5Text = By.xpath("//h5[text()='Name: User5']");
	By job1Selected = By.id("job1");
	By job2Selected = By.id("job2");
	By interests = By.xpath("//label[@for='development']");
	By slider1 = By.id("slider-1");

	By languageCheckBox = By.xpath("//label[@for='java']");
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_isDisplay() {
//		// open Url
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//
//		if (isElementDisplay(emailTextBox)) {
//			driver.findElement(emailTextBox).sendKeys("Automation Testing");
//
//		}
//		if (isElementDisplay(eduTextBox)) {
//			driver.findElement(eduTextBox).sendKeys("Automation Testing");
//
//		}
//		if (isElementDisplay(ageUnderRadio)) {
//			driver.findElement(ageUnderRadio).click();
//
//		}
//		Assert.assertFalse(isElementDisplay(nameUser5Text));
//
//		sleepInSecond(5);
	}

	@Test
	public void TC_02_isEnabled() {
		// open Url
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//		Assert.assertTrue(isEnable(emailTextBox));
//		Assert.assertTrue(isEnable(ageUnderRadio));
//
//		Assert.assertTrue(isEnable(eduTextBox));
//		Assert.assertTrue(isEnable(job1Selected));
//
//		Assert.assertTrue(isEnable(job2Selected));
//		Assert.assertTrue(isEnable(interests));
//		Assert.assertTrue(isEnable(slider1));

	}

	@Test
	public void TC_03_isSelect() {
//		// open Url
//		driver.get("https://login.mailchimp.com/signup/");
//		driver.findElement(ageUnderRadio).click();
//		driver.findElement(languageCheckBox).click();
//
//		Assert.assertTrue(isSelected(ageUnderRadio));
//		Assert.assertTrue(isSelected(languageCheckBox));
//
//		driver.findElement(languageCheckBox).click();
//
//		Assert.assertFalse(isSelected(languageCheckBox));
	}

	@Test
	public void TC_04_Register() {
		// open Url
		By passWordTextBox=By.id("new_password");
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.id("email")).sendKeys("automationfc.vn@gmail.com");
		driver.findElement(By.id("new_username")).sendKeys("automationfc");
		driver.findElement(By.id("new_username")).submit();
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean isElementDisplay(By by) {
		if (driver.findElement(by).isDisplayed()) {
			System.out.println(by + "- is display");
			return true;
		} else {
			System.out.println(by + "- un-displayed");
			return false;
		}

	}

	public boolean isSelected(By by) {
		if (driver.findElement(by).isSelected()) {
			System.out.println(by + "- is selected");
			return true;
		} else {
			System.out.println(by + "- un-selected");
			return false;
		}

	}

	public boolean isEnable(By by) {
		if (driver.findElement(by).isEnabled()) {
			System.out.println(by + "- is enable");
			return true;
		} else {
			System.out.println(by + "- disable");
			return false;
		}

	}

}
