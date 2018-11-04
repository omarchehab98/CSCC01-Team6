package team6.util.operators.logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogicalOperatorFactory {
    private static Map<String, Class> operatorStringToClass = new HashMap<>();
    static {
        operatorStringToClass.put(AndLogicalOperator.OPERATOR, AndLogicalOperator.class);
        operatorStringToClass.put(OrLogicalOperator.OPERATOR, OrLogicalOperator.class);
        operatorStringToClass.put(NorLogicalOperator.OPERATOR, NorLogicalOperator.class);
        operatorStringToClass.put(NotLogicalOperator.OPERATOR, NotLogicalOperator.class);
    }

    public static LogicalOperator make(String operator) {
        if (!operatorStringToClass.containsKey(operator)) {
            throw new IllegalArgumentException();
        }
        Class comparisonOperatorClass = operatorStringToClass.get(operator);
        try {
            return (LogicalOperator) comparisonOperatorClass.newInstance();
        } catch (IllegalAccessException | InstantiationException err) {
            throw new RuntimeException(String.format("Could not instantiate LogicalOperator \"%s\" from class \"%s\"",
                    operator, comparisonOperatorClass.getName()));
        }
    }

    public static List<String> getOperators() {
        return new ArrayList<>(operatorStringToClass.keySet());
    }
}