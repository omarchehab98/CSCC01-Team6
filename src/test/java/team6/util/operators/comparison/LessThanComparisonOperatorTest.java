package team6.util.operators.comparison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LessThanComparisonOperatorTest {

	LessThanComparisonOperator lesser = new LessThanComparisonOperator();

	@Test
	public void testIsTrueTrue() {
		int intTwo = 2;
		Long longThree = (long) 3;
		assertTrue(lesser.isTrue(intTwo, longThree));
	}

	@Test
	public void testIsTrueFalseSameType() {
		int two = 2;
		int secondTwo = 2;
		assertFalse(lesser.isTrue(two, secondTwo));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueException() {
		int two = 2;
		String notTwo = "Hello";
		lesser.isTrue(two, notTwo);
	}

	@Test
	public void testIsTrueTrueNull() {
		assertTrue(lesser.isTrue(null, null));
	}

	@Test
	public void testIsTrueFalseNull() {
		assertFalse(lesser.isTrue(null, 2));
	}

	@Test
	public void testGetOperator() {
		assertEquals("lt", lesser.getOperator());
	}
}
