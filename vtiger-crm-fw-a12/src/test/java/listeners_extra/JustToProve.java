package listeners_extra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(listeners_extra.List_Imp.class)
public class JustToProve {

	@BeforeSuite
	public void bs() {
		System.out.println("i am @beforesuite");
	}

	@BeforeTest
	public void precon() {
		System.out.println("pre condition");
	}

	@BeforeClass
	public void openBro() {
		System.out.println("Open browser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("login");
	}

//	@Test
//	public void case1() {
//		System.out.println("Test method");
//	}

	@AfterMethod
	public void logout() {
		System.out.println("logout");
	}

	@AfterClass
	public void closeBro() {
		System.out.println("close the browser");
	}

	@AfterTest
	public void postCon() {
		System.out.println("post condition");
	}

	@AfterSuite
	public void as() {
		System.out.println("i am @aftersuite");
	}
}