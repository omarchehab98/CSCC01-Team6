package team6.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import team6.util.expressions.ComparisonExpression;
import team6.util.operators.comparison.EqualComparisonOperator;
import team6.util.operators.comparison.NotEqualComparisonOperator;

public class JoinTableTest {

	private EqualComparisonOperator equals;
	private ComparisonExpression comparisonExpression;
	private JoinTable joinTable;

	@Before
	public void setUp() {
		equals = new EqualComparisonOperator();
		comparisonExpression = new ComparisonExpression(equals, 2, 2);
		joinTable = new JoinTable("test", comparisonExpression);
	}

	@Test
	public void testGetEntity() {
		assertEquals("test", joinTable.getEntity());
	}

	@Test
	public void testSetEntity() {
		joinTable.setEntity("secondTest");
		assertEquals("secondTest", joinTable.getEntity());
	}

	@Test
	public void testGetCondition() {
		assertEquals(comparisonExpression, joinTable.getCondition());
	}

	@Test
	public void testSetCondition() {
		NotEqualComparisonOperator notEquals = new NotEqualComparisonOperator();
		ComparisonExpression secondComparisonExpression = new ComparisonExpression(notEquals, 3, 2);
		joinTable.setCondition(secondComparisonExpression);
		assertEquals(secondComparisonExpression, joinTable.getCondition());
	}

}
