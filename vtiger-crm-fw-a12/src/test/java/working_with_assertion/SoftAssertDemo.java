package working_with_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {
	@Test
	public void case1() {
		String a = "abc";
		String b = "abc";
		String c = "xyz";

		Object obj1 = null;
		Object obj2 = new Object();

		boolean status1 = a.equals(c); //false
		boolean status2 = b.equals(a); //true

		SoftAssert sa = new SoftAssert();
		
		sa.assertTrue(status1);
		sa.assertFalse(status2);


		sa.assertEquals(a, c);
		sa.assertNotEquals(a, b);

		sa.assertNull(obj2);
		sa.assertNotNull(obj1);
		
		sa.assertAll();
	}
}
