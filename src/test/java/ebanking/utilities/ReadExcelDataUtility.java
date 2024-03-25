package ebanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataUtility {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public int getRowCount(String filePath,String sheetName) throws IOException {
		
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);

		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		wb.close();
		fis.close();

		return rowCount;
	}

	public int getColumnCount(String filePath,String sheetName) throws IOException {

		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);

		sheet = wb.getSheet(sheetName);
		Iterator<Row> rows = sheet.rowIterator();
		Row r = rows.next();
		int columnCount = r.getLastCellNum();
		
		wb.close();
		fis.close();
		
		return columnCount;
	}
	
	public String getCellData(String filePath, String sheetName,int rowNo, int ColumnNo) throws IOException
	{
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		
		sheet = wb.getSheet(sheetName);
		Row r=sheet.getRow(rowNo);
		Cell c=r.getCell(ColumnNo);
		String data;
		
		try
		{
		DataFormatter df=new DataFormatter();
		data=df.formatCellValue(c);
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fis.close();
		
		return data;
	}

}
