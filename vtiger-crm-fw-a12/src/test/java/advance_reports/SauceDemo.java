package advance_reports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SauceDemo {
	@Test 
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.saucedemo.com/v1/");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./ad_reports/rep1.html");
		spark.config().setDocumentTitle("sauce demo");
		spark.config().setReportName("First Report");
		spark.config().setTheme(Theme.STANDARD);
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("key1", "value1");
		report.setSystemInfo("key2", "value2");
		report.setSystemInfo("key3", "value3");
		report.setSystemInfo("key4", "value4");
		
		ExtentTest test = report.createTest("login");
		test.log(Status.INFO, "This is information");
		test.log(Status.WARNING, "This is warning");
		test.log(Status.SKIP, "This is skipping");
		test.log(Status.PASS, "This is passing");
		test.log(Status.FAIL, "This is failing");
		
		report.flush();
		
		driver.quit();
	}
}
