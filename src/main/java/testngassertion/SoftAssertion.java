package testngassertion;

import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class SoftAssertion {
	SoftAssert sa = new SoftAssert();
	SoftAssert sa1 = new SoftAssert();

//Soft assertion-->In case of soft assertion even though the assertion statement is failed the rest of the statements will be contiued.
	@Test
	public void assetEqualsMethod() {
		// sa.assertEquals("Acutal result", "expected");
//		sa.assertEquals("Vino", "Vino"); // It should be passed but the assertTrue is executed
		sa.assertEquals("Vinothini", "Vino"); 
		sa.assertEquals("Vino", "Vino");
		// It is mandatory step
		sa.assertAll();

	}

	@Test
	public void assetEqualsMethod1() {
		// sa.assertEquals("Acutal result", "expected result");
		// By using same object for both the condtions ,expected is this is need to pass
		// ,but the result is failed
		// Overcome this problem we need to create another object and use here-->it is
		// drawback of soft assert sa.assertEquals("Vinothini", "Vinothini"); -->it should be failed because og using same object
		sa1.assertEquals("Vinothini", "Vinothini"); // It should be pass
		// It is mandatory step
		sa1.assertAll();

	}

	@Test
	public void assertTrue() {
		sa.assertTrue(true);
		sa.assertAll();
	}

}
