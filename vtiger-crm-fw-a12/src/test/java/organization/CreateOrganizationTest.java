package organization;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;

public class CreateOrganizationTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileUtility fUtil = new FileUtility();

//		Get the data from properties file
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");

//		Get the data from excel file
		String orgName = fUtil.getStringDataFromExcelFile("org", 3, 0);

//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
//		
//		WebElement username = lp.getUn();
//		username.sendKeys(USERNAME);
//		
//		WebElement password = lp.getPwd();
//		password.sendKeys(PASSWORD);
//
//		lp.getLoginBtn().click();

		lp.login();

		Thread.sleep(3000);

//		Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		Thread.sleep(2000);
		
		OrgPage op = new OrgPage(driver);
				
		op.getOrgPlusIcon().click();

//		Filling data to the form
		WebElement orgField = op.getOrgField();
		orgField.sendKeys(orgName);

		Thread.sleep(3000);
//		Save 
		op.getSaveBtn().click();

//		Verification
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		String actOrgName = vop.getActOrgName().getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Created Organization successfully!!!!");
		} else {
			System.out.println("Failed....");
		}

//		Logout
		WebElement profilePic = hp.getProfilePic();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);

//		Actions act = new Actions(driver);
//		act.moveToElement(profilePic).build().perform();
		wdUtil.hover(profilePic);

		Thread.sleep(2000);
		hp.getSignOutLink().click();

//		Close browser
		Thread.sleep(3000);
		driver.quit();

	}
}
