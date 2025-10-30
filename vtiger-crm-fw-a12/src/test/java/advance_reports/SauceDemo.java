package advance_reports;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class SauceDemo {
	ExtentReports report;

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

	@Test
	public void login1() {
		ExtentTest test = report.createTest("login1");
		test.log(Status.WARNING, "This is WARNING");
	}

	@Test
	public void login2() {
		ExtentTest test = report.createTest("login2");
		test.log(Status.PASS, "This is PASSED");
	}

	@Test
	public void login3() {
		ExtentTest test = report.createTest("login3");
		test.log(Status.FAIL, "This is FAILED");
	}

	@Test
	public void login4() {
		ExtentTest test = report.createTest("login4");
		test.log(Status.SKIP, "This is SKIPPED");
	}

	@Test
	public void takeSS() throws IOException {

		ExtentTest test = report.createTest("takeSS");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/v1/");

		TakesScreenshot tks = (TakesScreenshot) driver;

//		File src = tks.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./ad_reports/ss.png");
//		FileHandler.copy(src, dest);

//		Obtain the screenshot as base64 data.
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, JavaUtility.currentTime());
		driver.quit();
	}

	@AfterSuite
	public void repBackup() {
		report.flush();
	}
}
