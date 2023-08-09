package vtiger.OrganizationTests;

import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustryTest extends BaseClass {

	@Test
	public void createOrgWithIndustryTest() throws Throwable
	{
		String ORGNAME = eUtil.getDataFromExcel("Organizations", 4, 3) + jUtil.getRandomNumber();
		String INDUSTRY = eUtil.getDataFromExcel("Organizations", 4, 3);

		
		// Step 5: Click on Organizations Link
//		driver.findElement(By.linkText("Organizations")).click();
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();

		// Step 6: click on Create Organization Look Up Image
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 7: Create Organization with Mnadatory fields
//		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME, INDUSTRY);
		
		

		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(OrgHeader + " --> Organization created successfully");
		} else {
			System.out.println("Organization creation failed");
		}

		/* Create Contact Using the same Organization */
//		driver.findElement(By.linkText("Contacts")).click();

		// Step 9: Navigate create contact look up Image
//		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 10: Create Contact
//		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 11: Click on Organization look up Image
//		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();

		// Step 12: switch the control to child page
//		wUtil.switchToWindow(driver, "Accounts");

		// Step 13: search for required Org
//		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
//		driver.findElement(By.name("search")).click();

		// Step 14: click on Org
		// driver.findElement(By.linkText(ORGNAME)).click();

		// Dynamic xpath - ORGNAME is a dynamic Data
		// a[.='wipro123']
		// a[.='infy']
//		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();

		// Step 15: switch the control back to parent
//		wUtil.switchToWindow(driver, "Contacts");
//		wUtil.takeScreenShot(driver, "Contact");

		// Step 16: save
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 17: Validate
//		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if (ContactHeader.contains(LASTNAME)) {
//			System.out.println(ContactHeader + " -- PASS --");
//		} else {
//			System.out.println("-- FAIL --");
//		}
		
		//Step 18 logout
		
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wUtil.mouseHoverAction(driver, ele);
//		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
