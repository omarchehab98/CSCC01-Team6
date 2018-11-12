package team6.util.operators.logical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import team6.util.operators.comparison.ComparisonOperatorFactory;
import team6.util.operators.comparison.EqualComparisonOperator;
import team6.util.operators.comparison.GreaterThanComparisonOperator;
import team6.util.operators.comparison.GreaterThanOrEqualComparisonOperator;
import team6.util.operators.comparison.LessThanComparisonOperator;
import team6.util.operators.comparison.LessThanOrEqualComparisonOperator;
import team6.util.operators.comparison.LikeComparisonOperator;
import team6.util.operators.comparison.NotEqualComparisonOperator;

public class LogicalOperatorFactoryTest {

	@Test
	public void testMakeSingle() {
		AndLogicalOperator and = 
				(AndLogicalOperator) LogicalOperatorFactory.make("and");
		assertTrue(and instanceof AndLogicalOperator);
	}

	@Test
	public void testMakeMultiple() {
		NotLogicalOperator not = 
				(NotLogicalOperator) LogicalOperatorFactory.make("not");
		
		NorLogicalOperator nor = 
				(NorLogicalOperator) LogicalOperatorFactory.make("nor");
		
		assertTrue(not instanceof NotLogicalOperator);
		assertTrue(nor instanceof NorLogicalOperator);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMakeException() {
		LogicalOperatorFactory.make("");
	}

	@Test
	public void testGetOperators() {
		Map<String, Class> expected = new HashMap<>();
		expected.put(AndLogicalOperator.OPERATOR, 
				AndLogicalOperator.class);
		expected.put(OrLogicalOperator.OPERATOR, 
				OrLogicalOperator.class);
		expected.put(NorLogicalOperator.OPERATOR, 
				NorLogicalOperator.class);
		expected.put(NotLogicalOperator.OPERATOR, 
				NotLogicalOperator.class);

		List<String> expectedKeys = new ArrayList<>(expected.keySet());

		assertEquals(expectedKeys, LogicalOperatorFactory.getOperators());
	}
}
