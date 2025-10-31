package listeners_extra;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class JustToProve3 {

	@Test
	public void case3() {
		Assert.assertTrue(false);
	}

	
	@Test(dependsOnMethods = "case3")
	public void case31() {
		Assert.assertTrue(true);
	}

}