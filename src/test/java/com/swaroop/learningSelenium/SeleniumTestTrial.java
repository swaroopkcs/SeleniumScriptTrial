package com.swaroop.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
		WebElement emailInput = wd.findElement(By.cssSelector("#email"));
		WebElement orderReference = wd.findElement(By.id("id_order"));
		WebElement message = wd.findElement(By.cssSelector("#message"));
		WebElement submitButton = wd.findElement(By.cssSelector("div [class ='submit']  span i[class='icon-chevron-right right']"));
		Select select = new Select(subjHandling);
		select.selectByValue("2");
		emailInput.sendKeys("458@email.com");
		orderReference.sendKeys("456789");
		message.sendKeys("Hello");
		submitButton.click();
		WebElement getSubmitMessage = wd.findElement(By.cssSelector("div [class ='alert alert-success']"));
		Assert.assertEquals(getSubmitMessage.getText(), "Your message has been successfully sent to our team.", "The test does not match");
	}
	
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
