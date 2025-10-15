package working_with_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertDemo {
	@Test
	public void case1() {
		String a = "abc";
		String b = "abc";
		String c = "xyz";

		Object obj1 = null;
		Object obj2 = new Object();

		boolean status1 = a.equals(c);
		boolean status2 = b.equals(c);

		Assert.assertTrue(status2);
		Assert.assertFalse(status1);

		Assert.assertEquals(a, b);
		Assert.assertNotEquals(a, c);

		Assert.assertNull(obj1);
		Assert.assertNotNull(obj2);
	}
}
