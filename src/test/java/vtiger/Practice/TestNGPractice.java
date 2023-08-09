package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(invocationCount = 3, priority = 1)
	public void createCustomer()
	{
		//Assert.fail();  // purposefully fail the script
		System.out.println("Customer Created");
	}
	
	@Test                        //(priority = 2)
	public void modifyCustomer()
	{
		System.out.println("Customer Modified");
	}
	
	@Test				//(enabled = false)  //(priority = 3)
	public void deleteCustomer()
	{
		System.out.println("Customer Deleted");
	}
}
