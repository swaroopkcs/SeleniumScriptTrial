package com.swaroop.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTestTrial {
	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\QA Testing\\Lib\\ChromeDriver99\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("http://automationpractice.com/index.php?controller=contact");
		wd.manage().window().maximize();
	}
	
	@Test
	public void sendAMessage() {
		WebElement subjHandling = wd.findElement(By.cssSelector("#id_contact"));
		Select select = new Select(subjHandling);
		select.selectByValue("2");
		WebElement emailInput = wd.findElement(By.cssSelector("#email"));
		emailInput.sendKeys("458@email.com");
		WebElement orderReference = wd.findElement(By.id("id_order"));
		orderReference.sendKeys("456789");
		WebElement message = wd.findElement(By.cssSelector("#message"));
		message.sendKeys("Hello");
		WebElement submitButton = wd.findElement(By.cssSelector("#submitMessage"));
		submitButton.submit();
	}
	
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
