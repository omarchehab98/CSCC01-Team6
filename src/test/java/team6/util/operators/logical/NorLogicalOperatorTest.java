package team6.util.operators.logical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NorLogicalOperatorTest {

	NorLogicalOperator nor = new NorLogicalOperator();

	@Test
	public void testIsTrueTrue() {
		assertTrue(nor.isTrue(false, false));
	}

	@Test
	public void testIsTrueFalse() {
		assertFalse(nor.isTrue(true, true));
	}

	@Test
	public void testGetOperator() {
		assertEquals("nor", nor.getOperator());
	}
}
