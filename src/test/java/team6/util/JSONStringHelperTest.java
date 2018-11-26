package team6.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JSONStringHelperTest {

	@Test
	public void testToString() {
		String str = "\"testing\"";
		JSONStringHelper stringHelper = new JSONStringHelper(str) ;
		assertEquals("\"\"testing\"\"", stringHelper.toString());
	}

	@Test
	public void testToStringNull() {
		String nullString = null;
		JSONStringHelper stringHelper = new JSONStringHelper(nullString);
		assertEquals("null", stringHelper.toString());
	}

}
