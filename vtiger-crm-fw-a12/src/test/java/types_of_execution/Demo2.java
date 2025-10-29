package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo2{
	@Test
	public void case20() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void case21() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void case22() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.quit();
		Assert.assertTrue(true);
	}
}
