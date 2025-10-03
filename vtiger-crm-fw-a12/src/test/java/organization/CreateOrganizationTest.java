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

public class CreateOrganizationTest {
	
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileUtility fUtil = new FileUtility();
		
//		Get the data from properties file
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
//		Get the data from excel file
		String orgName = fUtil.getStringDataFromExcelFile("org", 3, 0);
		
//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login
		driver.get(URL);

		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USERNAME);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
//		Create Organization
		driver.findElement(By.linkText("Organizations")).click();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

//		Filling data to the form
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

		Thread.sleep(3000);
//		Save 
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

//		Verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Created Organization successfully!!!!");
		} else {
			System.out.println("Failed....");
		}

//		Logout
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		
//		Actions act = new Actions(driver);
//		act.moveToElement(profilePic).build().perform();
		wdUtil.hover(profilePic);

		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

//		Close browser
		Thread.sleep(3000);
		driver.quit();

	}
}
