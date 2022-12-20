package testngassertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
    //Mostly used
	// Hard assertion -->In the Hard assertion even though the assertion statement
	// is failed the rest of the statements will not execute.
	@Test
	public void assetEqual() {
		//assertEquals("Acutal result", "expected result");
		try {
			Assert.assertEquals("Vino", "Vino");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Assert.assertEquals("Vino", "y");//java.lang.AssertionError: expected [y] but found [Vino]-->
		                                  //should fail in this line and will not execute the rest of the statements
	    Assert.assertEquals("Gayu", "Gayu");//Is not execute because previous assert statement is failed
	}

	@Test
	public void assetTrue() {
		Assert.assertTrue(true);

	}

	@Test
	public void assetFalse() {
     //	Assert.assertFalse(true);//expected [false] but found [true]-->Fail and Exception occurs AssetionException
		//Assert.assertFalse(true);// expected [false] but found [true]-->fail
		Assert.assertFalse(false);// expected [false] but found [false]-->pass

	}

}
