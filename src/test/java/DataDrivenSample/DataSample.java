package DataDrivenSample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataSample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException {
		
		// Creating array list for future use.
		ArrayList<String> a = new ArrayList();
		FileInputStream fis = new FileInputStream("C://Download//Accelerator-Test-Plans//SampleTestPlan.xlsx//");
	
		XSSFWorkbook book = new XSSFWorkbook();
		
		int sheets = book.getNumberOfSheets(); // This will get all sheets
		for(int i =0; i<sheets; i++) {
			if(book.getSheetName(i).equalsIgnoreCase("SampleTest")) {
				
			}
			XSSFSheet sheet = book.getSheetAt(i); // Here we are pulling the sheet from above
			
			// Now we will be scanning the sheet using iterator.
			
			Iterator<Row> rows = sheet.iterator();
			
			Row firstrow = rows.next();
			Iterator<Cell> ce = firstrow.cellIterator(); // using this it will iterate thorough cells
			
			int k =0;
			int column = 0;
			while(ce.hasNext()) {
				Cell value = ce.next();
				
				if(value.getStringCellValue().equalsIgnoreCase("Test Case Description")) {
					column = k;
				}
				k++;
			}
			
			System.out.println(column);
			
			while(rows.hasNext()) {
				
				Row r = rows.next();
				
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Accelerator")){
					
					
					Iterator<Cell> cv = r.cellIterator();
					
					while(cv.hasNext());
					
					Cell c =cv.next();
					
					if(c.getCellTypeEnum()==CellType.STRING) {
						
						a.add(c.getStringCellValue());
						
					}
					
					else {
						a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
				}
			}
		}
		

	}

}
