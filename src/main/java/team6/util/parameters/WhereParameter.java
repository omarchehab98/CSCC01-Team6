package team6.util.parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import team6.util.expressions.BooleanExpression;
import team6.util.expressions.ComparisonExpression;
import team6.util.expressions.ExpressionSymbol;
import team6.util.expressions.LogicalExpression;
import team6.util.operators.comparison.ComparisonOperator;
import team6.util.operators.comparison.ComparisonOperatorFactory;
import team6.util.operators.logical.LogicalOperator;
import team6.util.operators.logical.LogicalOperatorFactory;

public class WhereParameter {
    public static BooleanExpression parse(String where) {
        if (where == null) {
            return null;
        }
        return parse(new JSONObject(where));
    }

    public static BooleanExpression parse(JSONObject where) {
        if (where == null) {
            return null;
        }
        for (String operator : LogicalOperatorFactory.getOperators()) {
            String operatorSymbol = "$".concat(operator);
            // Logical Expression
            if (where.has(operatorSymbol)) {
                JSONArray arr = where.getJSONArray(operatorSymbol);
                List<BooleanExpression> operands = new ArrayList<>();
                for (int i = 0; i < arr.length(); i++) {
                    BooleanExpression operand = parse(arr.getJSONObject(i));
                    operands.add(operand);
                }
                LogicalOperator logicalOperator = LogicalOperatorFactory.make(operator);
                return new LogicalExpression(logicalOperator, operands);
            }
        }

        for (String operator : ComparisonOperatorFactory.getOperators()) {
            String operatorSymbol = "$".concat(operator);
            // Logical Expression
            if (where.has(operatorSymbol)) {
                JSONArray arr = where.getJSONArray(operatorSymbol);
                ComparisonOperator comparisonOperator = ComparisonOperatorFactory.make(operator);
                List<Object> operands = arr.toList().stream().map(operand -> convertToSymbol(operand))
                        .collect(Collectors.toList());
                assert operands.size() == 2;
                return new ComparisonExpression(comparisonOperator, operands.get(0), operands.get(1));
            }
        }

        throw new IllegalArgumentException();
    }

    private static Object convertToSymbol(Object leaf) {
        if (leaf instanceof String) {
            String leafStr = (String) leaf;
            if (leafStr.startsWith("$") && leafStr.endsWith("$")) {
                return new ExpressionSymbol(leafStr.substring(1, leafStr.length() - 1));
            }
        }
        return leaf;
    }
}