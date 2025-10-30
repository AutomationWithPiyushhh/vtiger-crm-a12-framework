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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	
	public ExtentReports report;

	@BeforeSuite
	public void repConfig() {
		String rep = JavaUtility.currentTime();

		ExtentSparkReporter spark = new ExtentSparkReporter("./ad_reports/" + rep + ".html");
		spark.config().setDocumentTitle("sauce demo");
		spark.config().setReportName("First Report");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("key1", "value1");
		report.setSystemInfo("key2", "value2");
		report.setSystemInfo("key3", "value3");
		report.setSystemInfo("key4", "value4");
	}
	
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

		sdriver = driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();
		String URL = fUtil.getDataFromPropertiesFile("url");
		driver.get("http://localhost:8888/");

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
	

	@AfterSuite
	public void repBackup() {
		report.flush();
	}
}
