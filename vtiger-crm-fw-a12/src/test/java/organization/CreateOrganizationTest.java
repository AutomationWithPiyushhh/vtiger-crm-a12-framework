package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {
	public static void main(String[] args) throws InterruptedException {
//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//		Login
		driver.get("http://localhost:8888/");
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("password");
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
//		Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
//		Filling data to the form
		WebElement orgField = driver.findElement(By.name("accountname"));
		String orgName = "automationWithPiyush01";
		orgField.sendKeys(orgName);
		
		Thread.sleep(3000);
//		Save 
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
//		Verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if (actOrgName.equals(orgName)) {
			System.out.println("Created Organization successfully!!!!");
		}else {
			System.out.println("Failed....");
		}
		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}
}
