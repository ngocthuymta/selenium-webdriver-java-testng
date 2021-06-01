package webdriver;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Default_DropDow {
	WebDriver driver;
	Select select, selectMonth, selectYear;
	String firstName, lastName, email, company, password, confirmPass;
	String day, month, year;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		firstName = "Ngoc";
		lastName = "Thuy";

		email = "NgocThuy122@gmail.com";
		company = "FPT";
		password = "123456";
		confirmPass = "123456";

		day = "17";
		year = "1993";
		month = "December";

	}

	public void TC_01_Register() {
		driver.get("https://demo.nopcommerce.com/register");
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Company")).sendKeys(company);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPass);

		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText("17");

		// kiem tra xem dc chon hay chua
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);

		selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		selectMonth.selectByVisibleText(month);
		selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
		selectYear.selectByVisibleText(year);

		driver.findElement(By.id("register-button")).submit();
		driver.findElement(By.className("ico-account")).click();

	}

	@Test
	public void TC_02_Multiple() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Select selectJob1 = new Select(driver.findElement(By.id("job1")));
		Assert.assertFalse(selectJob1.isMultiple());

		Select selectJob2 = new Select(driver.findElement(By.id("job2")));
		Assert.assertTrue(selectJob2.isMultiple());

		selectJob2.selectByVisibleText("Manual");
		selectJob2.selectByVisibleText("Mobile");
		selectJob2.selectByVisibleText("Desktop");
		selectJob2.selectByVisibleText("Security");

		List<String> listElement = new ArrayList<String>();

		for (WebElement element : selectJob2.getAllSelectedOptions()) {
			listElement.add(element.getText());
		}
		
		Assert.assertEquals(listElement.size(), 4);
		
		Assert.assertTrue(listElement.contains("Manual"));
		Assert.assertTrue(listElement.contains("Mobile"));
		Assert.assertTrue(listElement.contains("Desktop"));
		Assert.assertTrue(listElement.contains("Security"));

	}

	@AfterClass
	public void afterClass() {

	}

}
