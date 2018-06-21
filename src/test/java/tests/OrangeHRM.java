package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.out.println("This is before class");
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	}
	
	@Test
	public void titleVerification() {
		String expectedTitle = "OrangeHRM";
		System.out.println("Title: " + driver.getTitle());	
		String s = "hi";
		s.equals("hello");
		Assert.assertEquals(expectedTitle, driver.getTitle());
		System.out.println("Title verification is done here");
	}
	@Test
	public void loginTest() {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		driver.findElement(By.name("Submit")).click();
		String expectedURL = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
	}

	@BeforeMethod
	public void bMethod() {
		System.out.println("Before method");
		driver.get("http://opensource.demo.orangehrmlive.com/");
	}

	@AfterClass
	public void closing() {
	driver.quit();
	}
}
