package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Topic_03_Web_Browser {
	WebDriver driver;
	String projectPath=System.getProperty("user.dir");
	
	@Test
	public void TC_O1_Run_On_FireFox() {

	}
	@Test
	public void TC_O2_Run_On_Chrome() {
		System.setProperty("webdriver.chrome.driver",projectPath+"//driverBrower//chromedriver");
		System.out.printf("webdriver.chrome.driver",projectPath+"//driverBrower//chromedriver");
		
		driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.quit();
		
	}
	@Test
	public void TC_O3_Run_On_Safari() {
		
	}
}
