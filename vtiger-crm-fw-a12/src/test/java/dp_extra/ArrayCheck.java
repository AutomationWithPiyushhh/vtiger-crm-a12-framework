package dp_extra;

import org.testng.annotations.DataProvider;

public class ArrayCheck {

	@DataProvider
	public void getData() {
		Object [][] arr = new Object[5][2];
//							  row => number of executions
//							  col => number of parameters

		arr[0][0] = "mayank";
		arr[0][1] = "gautam";
		
		arr[1][0] = "kunal";
		arr[1][1] = "badmosh";
		
		arr[2][0] = "manish";
		arr[2][1] = "sinha";
		
		arr[3][0] = "sonali";
		arr[3][1] = "bisht";

		arr[4][0] = "vishakha";
		arr[4][1] = "verma";
		
		
		
	}
}
