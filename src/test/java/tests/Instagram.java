package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Instagram {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void loginTest() {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		driver.findElement(By.name("Submit")).click();
		String expectedURL = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
	}
	
	@Test
	public void locateElement() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("darina_di_");
	}
	@BeforeMethod
	public void bMethod() {
		driver.get("https://www.instagram.com/accounts/login/");
	}

}
