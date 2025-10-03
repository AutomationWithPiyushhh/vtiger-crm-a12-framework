package gu_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestScript {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		wdUtil.openUrl();
		
//		driver.manage().window().maximize();
		wdUtil.winMax();
		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

//		Actions act = new Actions(driver);
//		act.moveToElement(profilePic).build().perform();
		wdUtil.hover(profilePic);
		
		
		
	}
}
