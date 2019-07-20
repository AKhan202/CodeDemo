package DataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		
		
		dataDrivenDemo1 d = new dataDrivenDemo1();
		
		//Here we are pulling and printing the data from data driven demo method.
		
		ArrayList data = d.getData("764-AboutSection"); // here it's pulling the data from excel sheet.
		
		System.out.println(data.get(0)); // Copying this and saving it in 
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println(data.get(4));
		
	}

}
