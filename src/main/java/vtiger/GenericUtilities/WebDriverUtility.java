package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of all the Reusable methods related to Web Driver Actions
 * @author Abhishek
 *
 */
public class WebDriverUtility
{
	
//---->	WebDriver driver = null;  // driver wil null forever
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)   // updated driver reference
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for all findelement and Findelements
	 * operations to be performed
	 * @param driver
	 */
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method will wit until the specified element is visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle Dropdown with the help of index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle Dropdown with the help of value
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle Dropdown with the help of visible text
	 * @param element
	 * @param index
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hover action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * This method will perform double click anywhere on the web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform right click action anywhere on the web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click action on a web element
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
	}
	
	/**
	 * This method is used to move the cursor anywhere on the web page based on Offset values 
	 * @param driver
	 * @param xOffSet
	 * @param yOffSet
	 */
	public void moveAcrossWebPage(WebDriver driver, int xOffSet, int yOffSet)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xOffSet, yOffSet).click().perform();
	}
	
	/**
	 * This method will scroll vertically for 500 pixels
	 * @param driver
	 */
	 public void scrollAction(WebDriver driver)
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500);", "");
		 
	 }
	 
	 /**
	  * This method will scroll vertically untill the element reference
	  * @param driver
	  * @param element
	  */
	 public void scrollAction(WebDriver driver, WebElement element)
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 int y = element.getLocation().getY();
		 js.executeScript("window.scrollBy(0,"+y+");", element);
		 
		 // Or
		// js.executeScript("argument[0].scrollIntoView();", element);
	 }
	 
	 /**
		 * This method will accept the alert pop up
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		/**
		 * This method will cancel the confirmation pop up
		 * @param driver
		 */
		public void cancelAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * This method will enter the text in promt pop up
		 * @param driver
		 */
		public void sendTextToAlert(WebDriver driver, String text)
		{
			driver.switchTo().alert().sendKeys(text);
		}
		/**
		 * This method will capture the alert message and return to the caller
		 * @param driver
		 * @return
		 */
		public String getAlertText(WebDriver driver)
		{
			return driver.switchTo().alert().getText();
		}
		
		/**
		 * This method will handle frame based on index
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
		/**
		 * This method will handle frame based on name or ID attribute
		 * @param driver
		 * @param nameOrId
		 */
		public void handleFrame(WebDriver driver, String nameOrId)
		{
			driver.switchTo().frame(nameOrId);
		}
		
		/**
		 * This method will handle frame based on web element
		 * @param driver
		 * @param element
		 */
		public void handleFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		/**
		 * This method will help to switch the control back to immediate parent frame
		 * @param driver
		 */
		public void switchToParentFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		/**
		 * This method will switch the control to default page (Current Page)
		 * @param driver
		 */
		public void switchToDefaultPage(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		
		/**
		 * This method will switch to window based on window title
		 * @param driver
		 * @param partialWinTitle
		 */
		public void switchToWindow(WebDriver driver, String partialWinTitle)
		{
			//Step 1: Capture all the window IDs
			Set<String> allWinIDs = driver.getWindowHandles();
			
			//Step 2: Navigate to each window ID / Iterate through individual ids
			for(String winID:allWinIDs)
			{
				//Step 3: switch to each window ID and capture the title
				String currentTitle = driver.switchTo().window(winID).getTitle();
				
				//Step 4: compare the title with required title reference
				if(currentTitle.contains(partialWinTitle))
				{
					break;
				}
				
			}
			
		
		}
		
		/**
		 * This method will take screenshot and return the path of destination
		 * @param driver
		 * @param ScreenShotName
		 * @return
		 * @throws IOException
		 */
		public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
			Files.copy(src, dst); // this class is from common IO tool
			
			return dst.getAbsolutePath(); // attach the screen shot to extent Reports
			//D:/MavenProjects/AutomationFramework.QCO-SJEADD-M1/Screenshots/Name.png
			//C:\Users\Abhishek\eclipse-workspace\AutomationFramework_QCO-SJEADD-M1\Screenshots\Name.png
		}
	
}
