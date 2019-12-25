package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PostiveTests {
	@Test
	public void loginTest() {
		//create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Starting login page ");
		
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
		password.sendKeys("SuperSecretPassword!");
		sleep(3000);
		//click login button
		WebElement logInButton =driver.findElement(By.tagName("button"));
		logInButton.click();
		sleep(5000);
		
		//verification
		//new url
		//logout button is visible
		WebElement logOutButton =driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		
		//successful login message 
		WebElement successMessage =driver.findElement(By.cssSelector("#flash"));
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
