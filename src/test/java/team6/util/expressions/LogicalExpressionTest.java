package team6.util.expressions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import team6.util.operators.comparison.EqualComparisonOperator;
import team6.util.operators.logical.AndLogicalOperator;

public class LogicalExpressionTest {

	@Test
	public void testIsTrueTrue() {
		EqualComparisonOperator equal = new EqualComparisonOperator();
		ComparisonExpression expressionOne = new ComparisonExpression(equal, 2, 2);
		ComparisonExpression expressionTwo = new ComparisonExpression(equal, 3, 3);
		AndLogicalOperator and = new AndLogicalOperator();
		ArrayList<BooleanExpression> operands = new ArrayList<BooleanExpression>();
		operands.add(expressionOne);
		operands.add(expressionTwo);
		
		LogicalExpression logicalExpression = new LogicalExpression(and, operands);
		
		assertTrue(logicalExpression.isTrue());
	}

	@Test
	public void testIsTrueFalse() {
		EqualComparisonOperator equal = new EqualComparisonOperator();
		ComparisonExpression expressionOne = new ComparisonExpression(equal, 2, 2);
		ComparisonExpression expressionTwo = new ComparisonExpression(equal, 2, 3);
		AndLogicalOperator and = new AndLogicalOperator();
		ArrayList<BooleanExpression> operands = new ArrayList<BooleanExpression>();
		operands.add(expressionOne);
		operands.add(expressionTwo);
		
		LogicalExpression logicalExpression = new LogicalExpression(and, operands);
		
		assertFalse(logicalExpression.isTrue());
	}

	@Test
	public void testPopulate() {
		EqualComparisonOperator equal = new EqualComparisonOperator();
		ComparisonExpression expressionOne = new ComparisonExpression(equal, 2, 2);
		ComparisonExpression expressionTwo = new ComparisonExpression(equal, 3, 3);
		AndLogicalOperator and = new AndLogicalOperator();
		ArrayList<BooleanExpression> operands = new ArrayList<BooleanExpression>();
		operands.add(expressionOne);
		operands.add(expressionTwo);
		
		LogicalExpression logicalExpression = new LogicalExpression(and, operands);
		logicalExpression.populate("eq", 2);
		
		assertTrue(logicalExpression.isTrue());
	}

}
