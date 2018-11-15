package team6.util.operators.comparison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GreaterThanComparisonOperatorTest {

	GreaterThanComparisonOperator greater = new GreaterThanComparisonOperator();

	@Test
	public void testIsTrueTrue() {
		int intTwo = 2;
		Long longThree = (long) 3;
		assertTrue(greater.isTrue(longThree, intTwo));
	}

	@Test
	public void testIsTrueFalseSameType() {
		int two = 2;
		int secondTwo = 2;
		assertFalse(greater.isTrue(two, secondTwo));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueException() {
		int two = 2;
		String notTwo = "Hello";
		greater.isTrue(two, notTwo);
	}

	@Test
	public void testIsTrueTrueNull() {
		assertTrue(greater.isTrue(null, null));
	}

	@Test
	public void testIsTrueFalseNull() {
		assertFalse(greater.isTrue(null, 2));
	}

	@Test
	public void testGetOperator() {
		assertEquals("gt", greater.getOperator());
	}
}
