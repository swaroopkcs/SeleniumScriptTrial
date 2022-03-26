package actionClassPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumMouseCommands {
	WebDriver wd;
	Actions actions;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\QA Testing\\Lib\\ChromeDriver99\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get("https://demoqa.com/buttons");
		wd.manage().window().maximize();
		actions = new Actions(wd);
	}
	
	@Test(priority = 1)
	public void verifyClickButtons() {
		
		WebElement clickButton = wd.findElement(By.cssSelector("div.mt-4:nth-of-type(3) button"));
		actions.click(clickButton).perform();
		WebElement clickMeBtn = wd.findElement(By.id("rightClickBtn"));
		actions.contextClick(clickMeBtn).perform();
		WebElement doubleClickBtn = wd.findElement(By.id("doubleClickBtn"));
		actions.doubleClick(doubleClickBtn).perform();
		WebElement successMessage = wd.findElement(By.id("dynamicClickMessage"));
		Assert.assertEquals("You have done a dynamic click", successMessage.getText());
		WebElement rightClickSuccessMessage = wd.findElement(By.id("rightClickMessage"));
		Assert.assertEquals("You have done a right click", rightClickSuccessMessage.getText());		
		WebElement doubleSuccessMessage = wd.findElement(By.id("doubleClickMessage"));
		Assert.assertEquals("You have done a double click", doubleSuccessMessage.getText());
	}
	
	@Test(priority = 2)
	public void hoverMouse() {
		wd.navigate().to("https://demoqa.com/tool-tips");
		WebElement mouseHoverElement = wd.findElement(By.id("toolTipButton"));
		actions.moveToElement(mouseHoverElement).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String attributeValue = mouseHoverElement.getAttribute("aria-describedby");
		Assert.assertEquals("buttonToolTip", attributeValue);
		
	}
	
//	@AfterMethod
//	public void tearDown() {
//		wd.quit();
//	}
	

}
