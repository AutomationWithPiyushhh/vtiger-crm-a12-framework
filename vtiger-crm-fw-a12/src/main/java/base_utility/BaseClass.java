package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	public void openBro() throws IOException {
		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();
		String URL = fUtil.getDataFromPropertiesFile("url");
		driver.get("http://49.249.28.218:8888/");

		LoginPage lp = new LoginPage(driver);
		lp.login();
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
		WebElement profilePic = hp.getProfilePic();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.hover(profilePic);
		
		hp.getSignOutLink().click();
	}
	
	@AfterClass
	public void closeBro() {
		driver.quit();
	}
}
