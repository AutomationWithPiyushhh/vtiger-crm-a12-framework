package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	@FindBy(name = "user_name")
//	private WebElement un;

//	@FindBys({
//		@FindBy(name = "user_name"), 
//		@FindBy(css = "input[type='text']"),
//		@FindBy(xpath = "//input[@type='text']")
//	})
//	private WebElement un;
	
//	Auto - Healing
	@FindAll({
		@FindBy(name = "user_name"), 
		@FindBy(css = "input[type='text']"),
		@FindBy(xpath = "//input[@type='text']")
	})
	private WebElement un;
	
	
	
	@FindBy(name = "user_password")
	private WebElement pwd;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUn() {
		return un;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

//	Business utility
	public void login() throws IOException {
		FileUtility fUtil = new FileUtility();
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		un.sendKeys(USERNAME);
		pwd.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
