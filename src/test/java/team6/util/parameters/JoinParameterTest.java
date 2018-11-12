package team6.util.parameters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JoinParameterTest {

	@Test
	public void testParse() {
		String toParse = "one,two,three";
		String[] expected = {"one", "two", "three"};
		assertEquals(expected[0], JoinParameter.parse(toParse)[0]);
		assertEquals(expected[1], JoinParameter.parse(toParse)[1]);
		assertEquals(expected[2], JoinParameter.parse(toParse)[2]);
	}
}
