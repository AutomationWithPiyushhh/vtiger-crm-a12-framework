package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	WebDriver driver;
	Actions act;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
	}

	public void winMax() {
		driver.manage().window().maximize();
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
	
	
	
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void select(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	

}
