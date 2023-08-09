package vtiger.Practice;

import java.io.IOException;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		JavaUtility jUtil = new JavaUtility();
		int value = jUtil.getRandomNumber();
		System.out.println(value);
		
		System.out.println(jUtil.getSystemDate());
		
		System.out.println(jUtil.getSystemDateInFormat());
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value1 = pUtil.getDataFromPropertyFile("username");
		System.out.println(value1);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.getDataFromExcel("Organizations", 1, 2);
		System.out.println(data);
		
		eUtil.writeDataIntoExcel("sample", 3, 4, "Batman");
		System.out.println("Data Added");
		
	}
}
