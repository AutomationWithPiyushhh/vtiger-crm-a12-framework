package listeners_extra;

import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic_utility.JavaUtility;

public class List_Imp implements ISuiteListener, ITestListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {

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

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "This is passing");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "This is failing");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "This is skipped");
	}

}

@Listeners(listeners_extra.List_Imp.class)
class JustToProve0 {

	@Test
	public void genRep() throws InterruptedException {
		Assert.assertTrue(false);
		Thread.sleep(2000);
	}

	@Test
	public void genRep2() throws InterruptedException {
		Assert.assertTrue(true);
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "genRep")
	public void genRep3() throws InterruptedException {
		Thread.sleep(2000);
	}
}