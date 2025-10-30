package advance_reports;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base_utility.BaseClass;
import generic_utility.JavaUtility;

public class SauceDemo extends BaseClass {

	@Test
	public void login1() {
		ExtentTest test = report.createTest("login1");
		test.log(Status.WARNING, "This is WARNING");
	}

//	@Test
//	public void login2() {
//		ExtentTest test = report.createTest("login2");
//		test.log(Status.PASS, "This is PASSED");
//	}
//
//	@Test
//	public void login3() {
//		ExtentTest test = report.createTest("login3");
//		test.log(Status.FAIL, "This is FAILED");
//	}
//
//	@Test
//	public void login4() {
//		ExtentTest test = report.createTest("login4");
//		test.log(Status.SKIP, "This is SKIPPED");
//	}

	@Test
	public void takeSS() throws IOException {
		ExtentTest test = report.createTest("takeSS");
		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, JavaUtility.currentTime());
	}

}
