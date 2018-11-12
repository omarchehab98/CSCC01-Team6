package team6.util.expressions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import team6.throwables.SymbolicBooleanExpressionException;
import team6.util.operators.comparison.EqualComparisonOperator;
import team6.util.operators.comparison.NotEqualComparisonOperator;

public class ComparisonExpressionTest {

	@Test
	public void testIsTrueTrue() {
		EqualComparisonOperator equal = new EqualComparisonOperator();
		ComparisonExpression comparison = new ComparisonExpression(equal, 2, 2);
		assertTrue(comparison.isTrue());
	}

	@Test
	public void testIsTrueFalse() {
		NotEqualComparisonOperator notEqual = new NotEqualComparisonOperator();
		ComparisonExpression comparison = new ComparisonExpression(notEqual, 2, 2);
		assertFalse(comparison.isTrue());
	}

	@Test(expected = SymbolicBooleanExpressionException.class)
	public void testIsTrueException() {
		ExpressionSymbol test = new ExpressionSymbol("wrong");
		EqualComparisonOperator equal = new EqualComparisonOperator();
		ComparisonExpression comparison = new ComparisonExpression(equal, test, 2);
		comparison.isTrue();
	}

	@Test
	public void testPopulate() {
		ExpressionSymbol lte = new ExpressionSymbol("lte");
		EqualComparisonOperator equal = new EqualComparisonOperator();
		ComparisonExpression comparison = new ComparisonExpression(equal, lte, 2);
		comparison.populate("lte", 5);
		assertEquals(5, comparison.getLhs());
	}

}
