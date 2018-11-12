package team6.util.operators.comparison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LikeComparisonOperatorTest {

	LikeComparisonOperator like = new LikeComparisonOperator();

	@Test
	public void testIsTrueTrue() {
		String first = "Hello";
		String second = ".*";
		assertTrue(like.isTrue(first, second));
	}

	@Test
	public void testIsTrueFalse() {
		String first = "Hello";
		String second = "Nope";
		assertFalse(like.isTrue(first, second));
	}

	@Test
	public void testIsTrueFalseNull() {
		assertFalse(like.isTrue(null, "Hello"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueExceptionNullRegex() {
		int two = 2;
		String notTwo = "Hello";
		like.isTrue(two, notTwo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsTrueExceptionNotString() {
		int two = 2;
		String regex = "Hello";
		like.isTrue(two, regex);
	}

	@Test
	public void testGetOperator() {
		assertEquals("like", like.getOperator());
	}
}
