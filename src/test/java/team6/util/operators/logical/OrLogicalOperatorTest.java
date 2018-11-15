package team6.util.operators.logical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrLogicalOperatorTest {

	OrLogicalOperator or = new OrLogicalOperator();

	@Test
	public void testIsTrueTrue() {
		assertTrue(or.isTrue(true, true));
	}

	@Test
	public void testIsTrueFalse() {
		assertFalse(or.isTrue(false, false));
	}

	@Test
	public void testGetOperator() {
		assertEquals("or", or.getOperator());
	}
}
