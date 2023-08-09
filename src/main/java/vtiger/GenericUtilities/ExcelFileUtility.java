package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class consist of Generic Methods related to Excel File
 * @author Abhishek
 *
 */
public class ExcelFileUtility {

	
	/**
	 * This Method will read data from Excel Sheet based on sheed name, row no
	 * and cell no given by caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException 
	 */
	public String getDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This Method will write the data into Excel Sheet
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		Row rw = sh.createRow(rowNo);
		Cell cl = rw.createCell(celNo);
		cl.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IConstants.excelFilePath);
		wb.write(fos); // action
		wb.close();
		
	}
	
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum(); // Capture no of Rows
		int lastCel = sh.getRow(0).getLastCellNum(); // Capture the no of Cells
		
		Object[][] data = new Object[lastRow][lastCel];
		
		for (int i = 0; i <lastRow ; i++) // for row navigation
		{
			for (int j = 0; j < lastCel ; j++) // for cell navigation
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
}
