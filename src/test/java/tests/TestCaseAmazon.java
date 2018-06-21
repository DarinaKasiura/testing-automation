package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseAmazon {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void searchVerification() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
		driver.findElement(By.className("nav-input")).click();
		// driver.findElement(By.id(twotabsearchtextbox)).sendKeys("iPhone" + Keys.ENTER);
		String expected = "iPhone";
		String actual = driver.findElement(By.xpath("//ul[@id='s-results-list-atf']/li/div/div/div/div[@class='a-fixed-left-grid-col a-col-right']")).getText();
		// or //ul[@id='s-results-list-atf']/li//h2 !!!
		List<WebElement> links = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li/div"));
	
		for (WebElement webElement : links) {
			if (webElement.getText().toLowerCase().contains("sponsored")) {
				continue;
			}else {
				System.out.println(webElement.getText()); // or you can put everything lowerCase() to check with 'iphone'
				System.out.println("++++++++++++++++++++++");
				
				Assert.assertTrue(actual.contains(expected));
				//	Assert.assertFalse(!(actual.contains(expected)));
			}
		}
	}
	
	@BeforeMethod
	public void getSite() {
		driver.get("http://amazon.com/");
	}

}
