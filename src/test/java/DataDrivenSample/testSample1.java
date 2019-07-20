package DataDrivenSample;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class testSample1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		DataSample1 d = new DataSample1();
		
		ArrayList data = d.getData("SampleTest");
		
		System.out.println(data.get(0));
		

	}

}
