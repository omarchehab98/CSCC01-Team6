package team6.util.parameters;

import java.util.Arrays;
import java.util.List;

public class SelectParameter {
    public static List<String> parse(String select) {
        return Arrays.asList(select.split(","));
    }
}
