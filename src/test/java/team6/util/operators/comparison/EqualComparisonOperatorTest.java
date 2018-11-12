package team6.util.operators.comparison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EqualComparisonOperatorTest {

	EqualComparisonOperator equal = new EqualComparisonOperator();

	@Test
	public void testIsTrueTrue() {
		int intTwo = 2;
		Long longTwo = (long) 2;
		assertTrue(equal.isTrue(intTwo, longTwo));
	}

	@Test
	public void testIsTrueFalseSameType() {
		int two = 2;
		int three = 3;
		assertFalse(equal.isTrue(two, three));
	}

	@Test
	public void testIsTrueFalseDifferentType() {
		int two = 2;
		String notTwo = "Hello";
		assertFalse(equal.isTrue(two, notTwo));
	}

	@Test
	public void testIsTrueTrueNull() {
		assertTrue(equal.isTrue(null, null));
	}

	@Test
	public void testIsTrueFalseNull() {
		assertFalse(equal.isTrue(null, 2));
	}

	@Test
	public void testGetOperator() {
		assertEquals("eq", equal.getOperator());
	}
}
