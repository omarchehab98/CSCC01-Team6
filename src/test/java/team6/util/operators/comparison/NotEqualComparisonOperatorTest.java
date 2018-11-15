package team6.util.operators.comparison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NotEqualComparisonOperatorTest {

	NotEqualComparisonOperator notEqual = new NotEqualComparisonOperator();

	@Test
	public void testIsTrueFalse() {
		int intTwo = 2;
		Long longTwo = (long) 2;
		assertFalse(notEqual.isTrue(intTwo, longTwo));
	}

	@Test
	public void testIsTrueTrueSameType() {
		int two = 2;
		int three = 3;
		assertTrue(notEqual.isTrue(two, three));
	}

	@Test
	public void testIsTrueTrueDifferentType() {
		int two = 2;
		String notTwo = "Hello";
		assertTrue(notEqual.isTrue(two, notTwo));
	}

	@Test
	public void testIsTrueFalseNull() {
		assertFalse(notEqual.isTrue(null, null));
	}

	@Test
	public void testIsTrueTrueNull() {
		assertTrue(notEqual.isTrue(null, 2));
	}

	@Test
	public void testGetOperator() {
		assertEquals("ne", notEqual.getOperator());
	}

}
