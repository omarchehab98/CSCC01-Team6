package team6.util.operators.comparison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ComparisonOperatorFactoryTest {

	@Test
	public void testMakeSingle() {
		EqualComparisonOperator equals = 
				(EqualComparisonOperator) ComparisonOperatorFactory.make("eq");
		assertTrue(equals instanceof EqualComparisonOperator);
	}

	@Test
	public void testMakeMultiple() {
		GreaterThanComparisonOperator greaterThan = 
				(GreaterThanComparisonOperator) ComparisonOperatorFactory.make("gt");
		
		GreaterThanOrEqualComparisonOperator greaterThanEqual = 
				(GreaterThanOrEqualComparisonOperator) ComparisonOperatorFactory.make("gte");
		
		assertTrue(greaterThan instanceof GreaterThanComparisonOperator);
		assertTrue(greaterThanEqual instanceof GreaterThanOrEqualComparisonOperator);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMakeException() {
		ComparisonOperatorFactory.make("");
	}

	@Test
	public void testGetOperators() {
		Map<String, Class> expected = new HashMap<>();
		expected.put(EqualComparisonOperator.OPERATOR, 
				EqualComparisonOperator.class);
		expected.put(NotEqualComparisonOperator.OPERATOR, 
				NotEqualComparisonOperator.class);
		expected.put(GreaterThanComparisonOperator.OPERATOR, 
				GreaterThanComparisonOperator.class);
		expected.put(GreaterThanOrEqualComparisonOperator.OPERATOR, 
				GreaterThanOrEqualComparisonOperator.class);
		expected.put(LessThanComparisonOperator.OPERATOR, 
				LessThanComparisonOperator.class);
		expected.put(LessThanOrEqualComparisonOperator.OPERATOR, 
				LessThanOrEqualComparisonOperator.class);
		expected.put(LikeComparisonOperator.OPERATOR, 
				LikeComparisonOperator.class);

		List<String> expectedKeys = new ArrayList<>(expected.keySet());

		assertEquals(expectedKeys, ComparisonOperatorFactory.getOperators());
	}
}
