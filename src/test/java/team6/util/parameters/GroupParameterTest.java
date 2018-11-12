package team6.util.parameters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GroupParameterTest {

	@Test
	public void testParse() {
		String group = "groupName";
		assertEquals(group, GroupParameter.parse(group));
	}
}
