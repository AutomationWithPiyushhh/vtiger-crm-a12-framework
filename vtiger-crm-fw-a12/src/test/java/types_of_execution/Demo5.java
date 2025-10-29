package types_of_execution;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic_utility.FileUtility;

public class Demo5 {
	
	
	@Parameters("bro")
	@Test
	public void case5(String Browser) throws InterruptedException, IOException {
		WebDriver driver = null;
//		String Browser = new FileUtility().getDataFromPropertiesFile("bro");
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		Thread.sleep(5000);
		driver.quit();
	}
}
