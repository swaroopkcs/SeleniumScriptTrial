package com.swaroop.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumScript {

	WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\QA Testing\\Lib\\ChromeDriver99\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://mousetester.com/");
		wd.manage().window().maximize();
	}

	@Test
	public void searchSomething() {
		WebElement searchBox = wd.findElement(By.name("field-keywords"));
		searchBox.sendKeys("Echo");
//		WebElement search = wd.findElement(By.id("nav-search-submit-button"));
//		search.click();
		
	}
	
	@Test
	public void clickSubmitButton() {
		searchSomething();
		WebElement search = wd.findElement(By.id("nav-search-submit-button"));
		search.click();
	}
	@Test
	public void doubleClickTest() {
		Actions actions = new Actions(wd);
		WebElement doubleClick = wd.findElement(By.cssSelector("#clickMe"));
		actions.doubleClick(doubleClick).perform();
	}
}
