package team6.util.operators.comparison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GreaterThanOrEqualComparisonOperatorTest {

	GreaterThanOrEqualComparisonOperator greaterOrEqual = 
			new GreaterThanOrEqualComparisonOperator();

	@Test
	public void testIsTrueTrueNotEqual() {
		int intTwo = 2;
		Long longThree = (long) 3;
		assertTrue(greaterOrEqual.isTrue(longThree, intTwo));
	}

	@Test
	public void testIsTrueTrueEqual() {
		int intTwo = 2;
		Long longTwo = (long) 2;
		assertTrue(greaterOrEqual.isTrue(longTwo, intTwo));
	}

	@Test
	public void testIsTrueFalseSameType() {
		int two = 2;
		int three = 3;
		assertFalse(greaterOrEqual.isTrue(two, three));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueException() {
		int two = 2;
		String notTwo = "Hello";
		greaterOrEqual.isTrue(two, notTwo);
	}

	@Test
	public void testIsTrueTrueNull() {
		assertTrue(greaterOrEqual.isTrue(null, null));
	}

	@Test
	public void testIsTrueFalseNull() {
		assertFalse(greaterOrEqual.isTrue(null, 2));
	}

	@Test
	public void testGetOperator() {
		assertEquals("gte", greaterOrEqual.getOperator());
	}

}
