package team6.util.operators.logical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AndLogicalOperatorTest {

	AndLogicalOperator and = new AndLogicalOperator();

	@Test
	public void testIsTrueTrue() {
		assertTrue(and.isTrue(true, true));
	}

	@Test
	public void testIsTrueFalse() {
		assertFalse(and.isTrue(true, false));
	}

	@Test
	public void testGetOperator() {
		assertEquals("and", and.getOperator());
	}
}
