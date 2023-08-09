package vtiger.ContactsTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createContactWithOrgTest() throws Throwable {
		

				String ORGNAME = eUtil.getDataFromExcel("Organizations", 4, 3) + jUtil.getRandomNumber();
				String LASTNAME = eUtil.getDataFromExcel("Organizations", 4, 2);


				// Step 5: Click on Organizations Link
//				driver.findElement(By.linkText("Organizations")).click();
				
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();
				Reporter.log("Org link clicked");
		
		/* Create Contact using Organization */
		
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrgLookUpImg();
				Reporter.log("Create Org Lookup Image is clicked. ");
				
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createOrganization(ORGNAME);
				Reporter.log("Organization Created");
				
				//Step 8 : Validate for Organization
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getHeaderText();
				
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				System.out.println(OrgHeader);
				
		// Step 9 :Click on Contacts link - 500 - update
		hp.clickOnContactLink();
		Reporter.log("Contact link clicked");
		
		
		// Step 10 : Navigate to create contact lookup image
		//Assert.fail();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("Create Contact Look up image Clicked");
		
		// Step 11 : Create a contact with mandatory information
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, ORGNAME);
		Reporter.log("Contact is created");
		
		// Step 12 : Validate For Organization
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(ContactHeader));
		System.out.println(ContactHeader);
		
		

	}
	
	@Test(groups = "SmokeSuite")
	public void demoTest()
	{
		//Assert.fail();
		System.out.println("Demo");
	}
}
