package config_ann_extra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTest {
	@BeforeClass
	public void openBro() {
		System.out.println("browser open");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("login");
	}
	
	@Test
	public void createContactTest() {
		System.out.println("create contact + verify");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("logout");
	}
	
	@AfterClass
	public void closeBro() {
		System.out.println("browser close");
	}}
