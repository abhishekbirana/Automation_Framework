package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	// Declaration
	
		@FindBy(linkText = "Calendar")
		private WebElement CalenderLnk;
		
		@FindBy(linkText = "Leads")
		private WebElement LeadsLnk;
		
		@FindBy(linkText = "Organizations")
		private WebElement OrganizationsLnk;
		
		@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
		private WebElement ContactsLnk;
		
		@FindBy(linkText = "Opportunities")
		private WebElement OpportunitiesLnk;
		
		@FindBy(linkText = "Products")
		private WebElement ProductsLnk;
		
		@FindBy(linkText = "Documents")
		private WebElement DocumentsLnk;
		
		@FindBy(linkText = "Email")
		private WebElement EmailLnk;
		
		@FindBy(linkText = "Trouble Tickets")
		private WebElement TroubleTicketsLnk;
		
		@FindBy(linkText = "Dashboard")
		private WebElement DashboardLnk;
		
		@FindBy(linkText = "More")
		private WebElement MoreLnk;

		
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement AdministratorImg;
		
		@FindBy(linkText = "Sign Out")
		private WebElement SignOutLnk;
		
		//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver , this);
		}
		
		//Utilization
		
		public WebElement getCalenderLnk() {
			return CalenderLnk;
		}

		public WebElement getLeadsLnk() {
			return LeadsLnk;
		}

		public WebElement getOrganizationsLnk() {
			return OrganizationsLnk;
		}

		public WebElement getContactsLnk() {
			return ContactsLnk;
		}

		public WebElement getOpportunitiesLnk() {
			return OpportunitiesLnk;
		}

		public WebElement getProductsLnk() {
			return ProductsLnk;
		}

		public WebElement getDocumentsLnk() {
			return DocumentsLnk;
		}

		public WebElement getEmailLnk() {
			return EmailLnk;
		}

		public WebElement getTroubleTicketsLnk() {
			return TroubleTicketsLnk;
		}

		public WebElement getDashboardLnk() {
			return DashboardLnk;
		}

		public WebElement getMoreLnk() {
			return MoreLnk;
		}

		public WebElement getAdministratorImg() {
			return AdministratorImg;
		}

		public WebElement getSignOutLnk() {
			return SignOutLnk;
		}
		
		
		
		//Business Library
		/**
		 * This method will click on Organization link
		 */
		public void clickOnOrgLink() 
		{
			OrganizationsLnk.click();
		}
		
		
		/**
		 * This method will click on Contact link
		 */
		public void clickOnContactLink()
		{
			ContactsLnk.click();
		}
		
		/**
		 * This method will logout of application
		 * @throws Throwable 
		 */
		public void logoutOfApp(WebDriver driver) throws Throwable
		{
			mouseHoverAction(driver, AdministratorImg);
			Thread.sleep(1000);
			SignOutLnk.click();
		}
		
		
}
