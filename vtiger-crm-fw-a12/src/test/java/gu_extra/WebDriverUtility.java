package gu_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {

	WebDriver driver;
	Actions act;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
	}

	public void hover(WebElement targetElement) {
		act.moveToElement(targetElement).build().perform();
	}

	public void rightClick(WebElement targetElement) {
		act.contextClick(targetElement).build().perform();
	}

	public void doubleClick(WebElement targetElement) {
		act.doubleClick(targetElement).build().perform();
	}

	public void openUrl() {
		driver.get("http://localhost:8888/");
	}

	public void winMax() {
		driver.manage().window().maximize();
	}

}
