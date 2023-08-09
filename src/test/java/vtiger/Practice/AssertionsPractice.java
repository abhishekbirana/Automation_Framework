package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void sampleTest()
	{
		SoftAssert sa = new SoftAssert();
		
		int a=1; //expected
		int b=1;  //actual
		
		
//		if(a==b)
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
		
		System.out.println("Step 1");
		sa.assertEquals(false, true);
		
		System.out.println("Step 2");
		sa.assertEquals(false, false);
		//Assert.assertEquals(b, a, "Execution Fail"); // passed
		
		System.out.println("Step 3");
		sa.assertEquals(true, false);
		System.out.println("Step 4");
		sa.assertTrue(false);// fail
		sa.assertEquals(true, true);
		
		System.out.println("Execution and Validation Completed");
		
		sa.assertAll(); // logging all the failures
		
	}
		
		
}
