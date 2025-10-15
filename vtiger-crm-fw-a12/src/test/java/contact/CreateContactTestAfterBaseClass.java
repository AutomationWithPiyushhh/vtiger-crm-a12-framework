package contact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
public class CreateContactTestAfterBaseClass extends BaseClass {
	@Test
	public void createContTest() throws InterruptedException, IOException {
		FileUtility fUtil = new FileUtility();

//		Create contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		String lastName = fUtil.getStringDataFromExcelFile("contact", 13, 0);

		WebElement lastNameField = driver.findElement(By.name("lastname"));
		lastNameField.sendKeys(lastName);

//		Save 
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();

//		Verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		
		Assert.assertTrue(actLastName.equals(lastName));
		
//		if (actLastName.equals(lastName)) {
//			System.out.println("Created contact " + lastName + " successfully!!!");
//		} else {
//			System.out.println("Failed....");
//		}
	}
}
