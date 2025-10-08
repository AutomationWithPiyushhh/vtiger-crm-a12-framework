package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement orgPlusIcon;

	@FindBy(name = "accountname")
	private WebElement orgField;

	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrgPlusIcon() {
		return orgPlusIcon;
	}

	public WebElement getOrgField() {
		return orgField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
