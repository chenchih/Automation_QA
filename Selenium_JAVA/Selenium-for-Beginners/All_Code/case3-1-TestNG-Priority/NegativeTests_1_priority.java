package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTests {
	
	@Test(priority=1)
	public void incorrectUsernameTest() {
		//create driver
		
		//----------------Chrome-------------------------------
		//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//----------------FireFox-------------------------------
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		
		System.out.println("Starting incorrectUsernameTest ");
		
		//sleep for 3 second
		sleep(3000);
		
		// maximize browser window
		driver.manage().window().maximize();
		
		// open test page
		String url ="http://the-internet.herokuapp.com/login"; 
		driver.get(url);                     
		System.out.println("Page is opened");

		//sleep for 2 second
		sleep(2000);
		
		
		//enter username
		WebElement username =driver.findElement(By.id("username"));
		username.sendKeys("incorrectUsernameTest");				
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
		WebElement ErrorMessage = driver.findElement(By.id("flash"));
		String expectedErrorMessage = "Your username is invalid!";
		String actualErrorMessage=ErrorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual Error Message does not contain expected.\nActual: " + actualErrorMessage
						+ "\nExpected: " + expectedErrorMessage);
	
		//close browser 
		driver.quit();
		
	}
	
	
	@Test(priority=2)
	public void incorrectPasswordTest() {
		//create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Starting incorrectPasswordTest ");
		
		//sleep for 3 second
		sleep(3000);
		
		// maximize browser window
		driver.manage().window().maximize();
		
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
		password.sendKeys("incorrectPassword");
		sleep(3000);
		//click login button
		WebElement logInButton =driver.findElement(By.tagName("button"));
		logInButton.click();
		sleep(5000);
		
		//verification
		WebElement ErrorMessage = driver.findElement(By.id("flash"));
		String expectedErrorMessage = "Your password is invalid!";
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
	
}
