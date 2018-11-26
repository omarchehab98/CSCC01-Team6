package team6.util.parameters;

import java.util.Arrays;
import java.util.List;

public class SelectParameter {
    public static List<String> parse(String select) {
        if (select == null) {
            return null;
        }
        return Arrays.asList(select.split(","));
    }
}
