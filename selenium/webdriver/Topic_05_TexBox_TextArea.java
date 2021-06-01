package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_TexBox_TextArea {
	WebDriver driver;
	String emailAddress = emailRandom();
	String userId;
	String pass;
	String loginPageUrl;

	String name, birth, address, city, state, phone, pin, email, password, submit;
	String customerId;

	By nameCustomerTexBox = By.name("name");
	By genderMaleRadioBox = By.xpath("//input[@value='m']");
	By genderFeMaleRadioBox = By.xpath("//input[@value='f']");
	By birthBox = By.id("dob");
	By addressBox = By.name("addr");
	By cityBox = By.name("city");
	By stateBox = By.name("state");
	By pinBox = By.name("pinno");
	By telephoneBox = By.name("telephoneno");
	By emailBox = By.name("emailid");
	By passwordBox = By.name("password");
	By submitBox = By.name("sub");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4");
		loginPageUrl = driver.getCurrentUrl();
		name = "Ngoc Thuy";
		birth = "2001-01-01";
		address = "Nhue Giang";
		city = "Ha Noi";
		state = "Ket Hon";
		pin = "123456";
		phone = "0123456789";
		email = emailRandom();
		password = "123456";

	}

	@Test
	public void TC_01_Register() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.name("emailid")).sendKeys(emailAddress);
		driver.findElement(By.name("btnLogin")).click();
		userId = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		pass = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

	}

	@Test
	public void TC_02_Login() {
		driver.get(loginPageUrl);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userId);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@name='password']")).submit();
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(),
				"Welcome To Manager's Page of Guru99 Bank");

	}

	@Test
	public void TC_03_New_Customer() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		driver.findElement(nameCustomerTexBox).sendKeys(name);
		driver.findElement(genderMaleRadioBox).click();
		driver.findElement(birthBox).sendKeys(birth);
		driver.findElement(addressBox).sendKeys(address);
		driver.findElement(cityBox).sendKeys(city);
		driver.findElement(stateBox).sendKeys(state);
		driver.findElement(pinBox).sendKeys(pin);
		driver.findElement(telephoneBox).sendKeys(phone);
		driver.findElement(emailBox).sendKeys(email);
		driver.findElement(passwordBox).sendKeys(password);

		driver.findElement(submitBox).click();

		// Assert.assertEquals(driver.findElement(By.xpath("//p[@class='heading3']")).getText(),"Customer
		// Registered Successfully!!!");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(),
				name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(),
				birth);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),
				address);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(),
				city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),
				state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(),
				pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),
				phone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),
				email);

		 customerId = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();

	}
	@Test
	public void TC_04_Edit_Customer() {
		 driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		 driver.findElement(By.name("cusid")).sendKeys(customerId);
		 driver.findElement(By.name("AccSubmit")).click();
		 
		 Assert.assertEquals(driver.findElement(nameCustomerTexBox).getAttribute("value"),
					name);
		 Assert.assertEquals(driver.findElement(addressBox).getText(),
					address);
	}

	public String emailRandom() {
		Random random = new Random();
		return "vivashh" + random.nextInt(10000) + "@gmail.com";

	}

}
