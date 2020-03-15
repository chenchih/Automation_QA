  
package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExceptionsTests {

	private WebDriver driver;

	
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	//private void setUp(@Optional ("") String browser) {
	private void setUp(@Optional("chrome") String browser) {

		// create driver
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Do not khow to start " + browser + ", starting chrome browser");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		}

		// sleep for 3 second
		sleep(3000);

		// maximize browser window
		driver.manage().window().maximize();
		
		//implicit method for 10second
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		


	}
	@Test
	public void notVisibleTest() {
		//open the page http://the-internet.herokuapp.com/dynamic_loading/1
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		//Find locator for start Button and click on it
		WebElement startButton=driver.findElement(By.xpath("//div[@id='start']/button"));
		startButton.click();
		
		//Get Finished element text
		WebElement finishElement =driver.findElement(By.id("finish"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(finishElement));
		
		
		
		String finishText=finishElement.getText();
		
		//compare actual finish element text with expected "Hello World!" using NG Assert class
		Assert.assertTrue(finishText.contains("Hello World!"), "Finish Text:"+ finishText);
		
		
		
		
		
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		// close browser
		driver.quit();
	}

}
