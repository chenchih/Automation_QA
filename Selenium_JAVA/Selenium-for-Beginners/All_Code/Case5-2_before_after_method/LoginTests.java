package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class LoginTests {
	
	
	
	
	private WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	private void setUp() {
		
		// create driver

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver  = new ChromeDriver();

		
		// sleep for 3 second
		sleep(3000);

		// maximize browser window
		driver.manage().window().maximize();

	}

	
	@Test(priority =1, groups= { "postiveTests", "smokeTests" })
	public void PostiveLoginTest() {
		//create driver

		
		// open test page
		String url ="http://the-internet.herokuapp.com/login"; 
		driver.get(url);                     
		System.out.println("Page is opened");

		//sleep for 2 second
		sleep(2000);
		
		
		//enter username
		WebElement username =driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");				
		sleep(1000);
		//enter password
		WebElement password =driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		sleep(3000);
		//click login button
		WebElement logInButton =driver.findElement(By.tagName("button"));
		logInButton.click();
		sleep(5000);
		
		//verification
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
		
		//new url
		//logout button is visible
		WebElement logOutButton =driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "Log out button is not visible");
		
		//successful login message 
		WebElement successMessage =driver.findElement(By.cssSelector("#flash"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
		// Assert.assertEquals(actualMessage, expectedMessage, "Actual Message is not
		// the same as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual Message does not contain expected message.\nActual Message: " + actualMessage
						+ "\nExpectedMessage: " + expectedMessage);
		
		//close browser 
		driver.quit();
		
	}
	
	
	@Parameters({ "username", "password","expectedMessage"  })
	@Test(priority =2, groups= { "negativeTests", "smokeTests" })
	public void NegativeLoginTest(String username, String password, String expectedErrorMessage) {
				System.out.println("Starting negativeLogin Testwith "+username+"and"+password);
				
			
				// open test page
				String url = "http://the-internet.herokuapp.com/login";
				driver.get(url);
				System.out.println("Page is opened");

				// sleep for 2 second
				//sleep(2000);

				// enter username
				WebElement usernameElement = driver.findElement(By.id("username"));
				//usernameElement.sendKeys("incorrectUsername");
				usernameElement.sendKeys(username);
				//sleep(1000);
				// enter password
				WebElement passwordElement = driver.findElement(By.name("password"));
				//passwordElement.sendKeys("SuperSecretPassword!");
				passwordElement.sendKeys(password);
				sleep(3000);
				// click login button
				WebElement logInButton = driver.findElement(By.tagName("button"));
				logInButton.click();
				//sleep(5000);
				//verfication
				WebElement ErrorMessage = driver.findElement(By.id("flash"));
				//String expectedErrorMessage = "Your username is invalid!";
				String actualErrorMessage=ErrorMessage.getText();
				Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
						"Actual Error Message does not contain expected.\nActual: " + actualErrorMessage
								+ "\nExpected: " + expectedErrorMessage);
				//close browser
				driver.quit();
	}


	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod(alwaysRun=true)
	private void tearDown() {
		// close browser
		driver.quit();
	}
}
