package dp_extra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayCheck {

	@Test(dataProvider = "getData")
	public void loginToSauceDemo(String username, String password) {
//		String username = "Dinga";
//		String password = "Dingi@143";
		System.out.println(username);
		System.out.println(password);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] cred = new Object[5][2];
//							  row => number of executions
//							  col => number of parameters
		cred[0][0] = "mayank";
		cred[0][1] = "Mayank@123";

		cred[1][0] = "kunal";
		cred[1][1] = "badmosh";

		cred[2][0] = "manish";
		cred[2][1] = "Manish@2588";

		cred[3][0] = "sonali";
		cred[3][1] = "Sonali@123";

		cred[4][0] = "vishakha";
		cred[4][1] = "Vishu@123";

		return cred;
	}
}
