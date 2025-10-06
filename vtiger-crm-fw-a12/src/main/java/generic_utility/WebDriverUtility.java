package generic_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains reusable WebDriver utility methods such as window
 * management, waits, dropdown selections, mouse and keyboard interactions.
 * Italso includes additional utilities such as alerts, scrolling, screenshot,
 * JS execution, drag-drop, sliders, and more.
 * 
 * @version a12
 * 
 * @author Piyush Baldaniya
 */
public class WebDriverUtility {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	

	/**
	 * Maximizes the browser window.
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * Makes the browser fullscreen.
	 */
	public void fullscreenWindow() {
		driver.manage().window().fullscreen();
	}

	// ===== Basic Waits =====

	/**
	 * Applies implicit wait for the page to load.
	 */
	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * Waits explicitly until the element is visible.
	 * 
	 * @param element WebElement to wait for
	 */
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Waits explicitly until the element is clickable.
	 * 
	 * @param element        WebElement to wait for
	 */
	public void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Waits explicitly for specific text to be present in an element.
	 * 
	 * @param element        WebElement
	 * @param text           Expected text
	 */
	public void waitForTextInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * Waits for the page title to contain given text.
	 * 
	 * @param titlePart      Partial or full title text
	 */
	public void waitForTitleContains(String titlePart) {
		wait.until(ExpectedConditions.titleContains(titlePart));
	}

	/**
	 * Waits for the URL to contain given text.
	 * 
	 * @param urlFraction    Partial or full URL text
	 */
	public void waitForUrlContains(String urlFraction) {
		wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	// ===== Dropdown Select Methods =====

	/**
	 * Selects dropdown option by index.
	 * 
	 * @param element The dropdown WebElement
	 * @param index   Index of the option
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * Selects dropdown option by value.
	 * 
	 * @param element The dropdown WebElement
	 * @param value   Value of the option
	 */
	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * Selects dropdown option by visible text.
	 * 
	 * @param visibleText Text visible in dropdown
	 * @param element     The dropdown WebElement
	 */
	public void select(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	// ===== Basic Mouse Actions =====

	/**
	 * Performs mouse hover on the given element.
	 * 
	 * @param element The target WebElement
	 */
	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	/**
	 * Performs right-click on the given element.
	 * 
	 * @param element The target WebElement
	 */
	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}

	/**
	 * Performs double-click on the given element.
	 * 
	 * @param element The target WebElement
	 */
	public void doubleClickOnElement(WebElement element) {
		act.doubleClick(element).perform();
	}

	/**
	 * Clicks and holds the given element.
	 * 
	 * @param element The target WebElement
	 */
	public void clickAndHold(WebElement element) {
		act.clickAndHold(element).perform();
	}

	/**
	 * Drags source element and drops onto target element.
	 * 
	 * @param source Source element to drag
	 * @param target Target element to drop onto
	 */
	public void dragAndDrop(WebElement source, WebElement target) {
		act.dragAndDrop(source, target).perform();
	}

	/**
	 * Moves slider input element by offset.
	 * 
	 * @param slider  WebElement slider
	 * @param xOffset Horizontal offset to move
	 */
	public void moveSliderByOffset(WebElement slider, int xOffset) {
		act.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();
	}

	// ===== Scroll Methods =====

	/**
	 * Scrolls the page to bring the element into view.
	 * 
	 * @param element WebElement to scroll into view
	 */
	public void scrollIntoView(WebElement element, boolean bool) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + bool + ");", element);
	}

	/**
	 * Scrolls by the given X and Y offset.
	 * 
	 * @param x Horizontal scroll
	 * @param y Vertical scroll
	 */
	public void scrollByOffset(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	// ===== Basic Element Interactions =====

	/**
	 * Waits for an element to be clickable and clicks it.
	 * 
	 * @param element        WebElement to click
	 * @param timeoutSeconds Max wait time before clicking
	 */
	public void waitAndClick(WebElement element) {
		waitForElementClickable(element);
		element.click();
	}

	/**
	 * Sends keys to an element after clearing existing text.
	 * 
	 * @param element WebElement input
	 * @param text    Text to send
	 */
	public void clearAndSendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}


	// ===== Checkbox and Radio Button Handling =====

	/**
	 * Checks a checkbox if not already checked.
	 * 
	 * @param checkbox The checkbox WebElement
	 */
	public void checkCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	/**
	 * Unchecks a checkbox if it is currently checked.
	 * 
	 * @param checkbox The checkbox WebElement
	 */
	public void uncheckCheckbox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	
	/**
	 * Selects a radio button if not already selected.
	 * 
	 * @param radioButton The radio button WebElement
	 */
	public void selectRadioButton(WebElement radioButton) {
		if (!radioButton.isSelected()) {
			radioButton.click();
		}
	}

	// ===== Keyboard Shortcuts =====


	/**
	 * Presses Ctrl + A (Select All) on the specified element.
	 * 
	 * @param element WebElement to send Ctrl + A
	 */
	public void pressCtrlA(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	}

	/**
	 * Presses Ctrl + C (Copy) on the specified element.
	 * 
	 * @param element WebElement to send Ctrl + C
	 */
	public void pressCtrlC(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}

	/**
	 * Presses Ctrl + V (Paste) on the specified element.
	 * 
	 * @param element WebElement to send Ctrl + V
	 */
	public void pressCtrlV(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	// ===== Screenshot Methods =====

	/**
	 * Takes screenshot and stores with given name.
	 * 
	 * @param screenshotName Name * @param screenshotName Name
	 * @throws IOException if file write fails
	 */
	public void takeScreenshot(String screenshotName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + screenshotName + ".png");
		FileHandler.copy(src, dest);
	}

	

	/**
	 * Takes screenshot of webelement and stores with given name.
	 * 
	 * @param screenshotName Name * @param screenshotName Name
	 * @throws IOException if file write fails
	 */
	public void takeScreenshot(WebElement element , String ssname) throws IOException {
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + ssname + ".png");
		FileHandler.copy(src, dest);
	}

	/**
	 * Takes screenshot with time appended to the name.
	 * 
	 * @param baseName Base name of the screenshot file
	 * @throws IOException if file write fails
	 */
	public void takeScreenshotWithTime(String baseName) throws IOException {		
		takeScreenshot(baseName + "_" + JavaUtility.currentTime());
	}

// ===== JavaScript Executor Methods =====

	/**
	 * Executes JavaScript to click an element.
	 * 
	 * @param element WebElement to click
	 */
	public void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	/**
	 * Executes JavaScript to set value of an element.
	 * 
	 * @param element WebElement to set value
	 * @param value   Value to set
	 */
	public void jsSetValue(WebElement element, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
	}

	/**
	 * Executes JavaScript to get value of an element.
	 * 
	 * @param element WebElement to get value
	 * @return Value as String
	 */
	public String jsGetValue(WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", element);
	}

	/**
	 * Scrolls the page down to the bottom using JavaScript.
	 */
	public void jsScrollToBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	/**
	 * Scrolls the page up to the top using JavaScript.
	 */
	public void jsScrollToTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}

// ===== Window and Tab Handling =====

	/**
	 * Switches to a window/tab by title.
	 * 
	 * @param partialWindowTitle Partial or full window title
	 */
	public void switchToWindowByTitle(String partialWindowTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (driver.getTitle().contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * Switches to the window/tab by URL.
	 * 
	 * @param partialUrl Partial or full URL
	 */
	public void switchToWindowByUrl(String partialUrl) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}

	/**
	 * Switches to the parent window.
	 * 
	 * @param parentWindowHandle Window handle of the parent
	 */
	public void switchToParentWindow(String parentWindowHandle) {
		driver.switchTo().window(parentWindowHandle);
	}

	/**
	 * Closes all windows except parent.
	 * 
	 * @param parentWindowHandle Window handle of the parent
	 */
	public void closeAllChildWindows(String parentWindowHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handle : windowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}
}