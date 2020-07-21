package XlxsReader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	private Workbook wb;
	static Sheet sheetName;
	private Row row; 
	static int rows;
	static int columns;
	
	public ExcelDataReader(String sheetPath)throws IOException {
		FileInputStream fis = new FileInputStream(sheetPath);
		wb = new XSSFWorkbook(fis);
	
	}
	
	public int getRowCount(String sheet_name) {
		sheetName = wb.getSheet(sheet_name);
		int lastRowNum = sheetName.getLastRowNum();
		int firstRowNum = sheetName.getFirstRowNum();
		int TotalRows = lastRowNum +1;
		System.out.println(firstRowNum+"========="+lastRowNum+"==========="+TotalRows);
		return TotalRows;
		
	}
	
	public int getColumnCount() {
		
		 row  =  sheetName.getRow(0);
		 short lastCellNum = row.getLastCellNum();
		 short firstCellNum = row.getFirstCellNum();
		 int totalCountColumn = lastCellNum - firstCellNum;
		 System.out.println(firstCellNum+"==================="+lastCellNum+"==============="+totalCountColumn);
		 return totalCountColumn;
		 
		
	}
	
	//to read data from the cell
	public String getCellData(int rNum,int cNum) {
		String cellVal = sheetName.getRow(rNum).getCell(cNum).getStringCellValue().toString();
		return cellVal;
	}
	
//	public void Values(int rows,int columns) {
//
//		for(int i=1;i<rows;i++) {
//			for(int j=0;j<columns;j++) {
//				String cellVal = sheetName.getRow(i).getCell(j).getStringCellValue().toString();
//				System.out.println("Values ===== "+cellVal);
//
//			}
//		}
//		
//	}

	public static void main(String[] args) throws IOException {
		//1.get the path of excel sheet
		String sheetPath = System.getProperty("user.dir")+"\\src\\TestData\\testData.xlsx";
		ExcelDataReader xlr = new ExcelDataReader(sheetPath);
		
		//2.to count rows
		int countR = xlr.getRowCount("Login");
		System.out.println("Total Rows "+countR);
		
		//3.to count columns
		int countCol  = xlr.getColumnCount();
		System.out.println("Total Column "+countCol);
		
		//4.read data from the cell
//		String calVal = xlr.getCellData(1, 1);
//		System.out.println(calVal);
		
		//5. to read all data from the cell
		
		for(int i=1;i<countR;i++) {
			for(int j=0;j<countCol;j++) {
				String AllValues = sheetName.getRow(i).getCell(j).getStringCellValue().toString();
				System.out.println("Values are ===== "+AllValues);

			}
		}
//		xlr.Values(countR, countCol);
		
	}

}
