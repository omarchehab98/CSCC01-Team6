package team6.util.operators.comparison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComparisonOperatorFactory {
    private static Map<String, Class> operatorStringToClass = new HashMap<>();
    static {
        operatorStringToClass.put(EqualComparisonOperator.OPERATOR, EqualComparisonOperator.class);
        operatorStringToClass.put(NotEqualComparisonOperator.OPERATOR, NotEqualComparisonOperator.class);
        operatorStringToClass.put(GreaterThanComparisonOperator.OPERATOR, GreaterThanComparisonOperator.class);
        operatorStringToClass.put(GreaterThanOrEqualComparisonOperator.OPERATOR,
                GreaterThanOrEqualComparisonOperator.class);
        operatorStringToClass.put(LessThanComparisonOperator.OPERATOR, LessThanComparisonOperator.class);
        operatorStringToClass.put(LessThanOrEqualComparisonOperator.OPERATOR, LessThanOrEqualComparisonOperator.class);
        operatorStringToClass.put(LikeComparisonOperator.OPERATOR, LikeComparisonOperator.class);
    }

    public static ComparisonOperator make(String operator) {
        if (!operatorStringToClass.containsKey(operator)) {
            throw new IllegalArgumentException();
        }
        Class comparisonOperatorClass = operatorStringToClass.get(operator);
        try {
            return (ComparisonOperator) comparisonOperatorClass.newInstance();
        } catch (IllegalAccessException | InstantiationException err) {
            throw new RuntimeException(
                    String.format("Could not instantiate ComparisonOperator \"%s\" from class \"%s\"", operator,
                            comparisonOperatorClass.getName()));
        }
    }

    public static List<String> getOperators() {
        return new ArrayList<>(operatorStringToClass.keySet());
    }
}