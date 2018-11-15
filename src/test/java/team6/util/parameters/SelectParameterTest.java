package team6.util.parameters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class SelectParameterTest {

	@Test
	public void testParse() {
		String toParse = "one,two,three";
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("one");
		expected.add("two");
		expected.add("three");
		assertEquals(expected, SelectParameter.parse(toParse));
	}
}
