package team6.util.operators.comparison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LessThanOrEqualComparisonOperatorTest {

	LessThanOrEqualComparisonOperator lessOrEqual = 
			new LessThanOrEqualComparisonOperator();

	@Test
	public void testIsTrueFalseNotEqual() {
		int intTwo = 2;
		Long longThree = (long) 3;
		assertFalse(lessOrEqual.isTrue(longThree, intTwo));
	}

	@Test
	public void testIsTrueTrueEqual() {
		int intTwo = 2;
		Long longTwo = (long) 2;
		assertTrue(lessOrEqual.isTrue(longTwo, intTwo));
	}

	@Test
	public void testIsTrueTrueSameType() {
		int two = 2;
		int three = 3;
		assertTrue(lessOrEqual.isTrue(two, three));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueException() {
		int two = 2;
		String notTwo = "Hello";
		lessOrEqual.isTrue(two, notTwo);
	}

	@Test
	public void testIsTrueTrueNull() {
		assertTrue(lessOrEqual.isTrue(null, null));
	}

	@Test
	public void testIsTrueFalseNull() {
		assertFalse(lessOrEqual.isTrue(null, 2));
	}

	@Test
	public void testGetOperator() {
		assertEquals("lte", lessOrEqual.getOperator());
	}
}
