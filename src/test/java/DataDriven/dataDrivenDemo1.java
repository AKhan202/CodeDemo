package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Identify the test description: by scan entire row. 

public class dataDrivenDemo1 {

	public ArrayList<String> getData(String Accelerator) throws IOException { // writing the below code in this method.

		// Creating array list for future use.
		ArrayList<String> a = new ArrayList();// This will be used in later part.with cv.next().getStringCellValue()

		FileInputStream fis = new FileInputStream(
				"C://Download//Accelerator-Test-Plans//Accelerator_TestPlan_Ferrari_1.7.xlsx//");
		// Make sure to save it as xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);// We need this XSSFWorkbook object to pull the data from excel
														// sheet
		// This above method accepts file input stream argument.

		// Now in the excel sheet we need to which sheet to select

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("764-AboutSection")) {

			}
			XSSFSheet sheet = workbook.getSheetAt(i);

			// Now we are scanning throw the sheet. Idetntify testcase columnvy scanning
			// entire first row.

			Iterator<Row> rows = sheet.iterator(); // sheet is a collection of rows.

			// using this command acess to first row is done.
			Row firstrow = rows.next();// using this it moves from 1 row to another row.

			Iterator<Cell> ce = firstrow.cellIterator(); // usin ce.next u can move into cells/
			// row is collection of cells.

			// declaring a variable here.
			int k = 0;
			int coloumn = 0;
			while (ce.hasNext()) {
				Cell value = ce.next();

				if (value.getStringCellValue().equalsIgnoreCase("Accelerator Software Version")) {

					coloumn = k;

				}

				k++; // This K increments after each and every while loop.
			}

			System.out.println(coloumn); // here we will know the index.
			// Now we will get the row count of the sheet.If first row is present then go
			// inside.

			while (rows.hasNext()) { // Using the above sheet iterator rows
				Row r = rows.next(); // If there is data in sheets it will move into next sheet.

				// using r.get cell to cloumn index for that cell.
				if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Accelerator")) // Here we are only
																								// scanning the above
																								// column as from above.
				{
					// here if the above value matches then we need to grab all the values from that
					// cell
					// after you grab Accelerator software version 1.7.1 pull all the data from that
					// row.

					Iterator<Cell> cv = r.cellIterator();

					while (cv.hasNext()) {
						a.add(cv.next().getStringCellValue()); // This is used with array list which is created above.
					}
				}
				
				

			}

		}
		return a;
	}

	public static void main(String[] args) throws Exception {

	}

}
