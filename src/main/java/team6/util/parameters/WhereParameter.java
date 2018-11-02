package team6.util.parameters;

import org.json.JSONArray;
import org.json.JSONObject;

import team6.util.expressions.BooleanExpression;
import team6.util.expressions.ComparisonExpression;
import team6.util.expressions.ExpressionSymbol;
import team6.util.expressions.LogicalExpression;
import team6.util.operators.comparison.ComparisonOperator;
import team6.util.operators.comparison.ComparisonOperatorFactory;
import team6.util.operators.comparison.EqualsComparisonOperator;
import team6.util.operators.comparison.LikeComparisonOperator;
import team6.util.operators.logical.AndLogicalOperator;
import team6.util.operators.logical.LogicalOperator;
import team6.util.operators.logical.LogicalOperatorFactory;
import team6.util.operators.logical.OrLogicalOperator;

public class WhereParameter {
    private static String[] LOGICAL_OPERATORS = {
        AndLogicalOperator.OPERATOR,
        OrLogicalOperator.OPERATOR,
    };

    private static String[] COMPARISON_OPERATORS = {
        EqualsComparisonOperator.OPERATOR,
        LikeComparisonOperator.OPERATOR,
    };

    public static BooleanExpression parse(String where) {
        return parse(new JSONObject(where));
    }

    public static BooleanExpression parse(JSONObject where) {
        for (String OPERATOR : LOGICAL_OPERATORS) {
            String operator = "$".concat(OPERATOR);
            // Logical Expression
            if (where.has(operator)) {
                JSONArray arr = where.getJSONArray(operator);
                BooleanExpression lhs = parse(arr.getJSONObject(0));
                BooleanExpression rhs = parse(arr.getJSONObject(1));
                LogicalOperator logicalOperator = LogicalOperatorFactory.make(OPERATOR);
                return new LogicalExpression(logicalOperator, lhs, rhs);
            }
        }
        
        for (String OPERATOR : COMPARISON_OPERATORS) {
            String operator = "$".concat(OPERATOR);
            // Logical Expression
            if (where.has(operator)) {
                JSONArray arr = where.getJSONArray(operator);
                Object lhs = makeIfSymbol(arr.getString(0));
                Object rhs = arr.get(1);
                ComparisonOperator comparisonOperator = ComparisonOperatorFactory.make(OPERATOR);
                return new ComparisonExpression(comparisonOperator, lhs, rhs);
            }
        }

        throw new IllegalArgumentException();
    }

    private static Object makeIfSymbol(String leaf) {
        if (leaf.startsWith("$") && leaf.endsWith("$")) {
            return new ExpressionSymbol(leaf.substring(1, leaf.length() - 1));
        }
        return leaf;
    }
}