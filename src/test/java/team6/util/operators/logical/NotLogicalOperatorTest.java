package team6.util.operators.logical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NotLogicalOperatorTest {

	NotLogicalOperator not = new NotLogicalOperator();

	@Test
	public void testIsTrueTrue() {
		assertTrue(not.isTrue(false));
	}

	@Test
	public void testIsTrueFalse() {
		assertFalse(not.isTrue(true));
	}

	@Test
	public void testGetOperator() {
		assertEquals("not", not.getOperator());
	}
}
