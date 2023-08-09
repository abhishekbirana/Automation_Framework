package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	public OrganizationInfoPage(WebDriver driver)   //test script
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	//Business Library
	/**
	 * This method will capture the header text and return it to the caller
	 * @return
	 */
	public String getHeaderText()
	{
		return OrgHeaderText.getText();
	}
	
}
