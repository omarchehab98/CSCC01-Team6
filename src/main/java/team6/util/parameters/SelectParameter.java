package team6.util.parameters;

import java.util.List;
import java.util.Arrays;

public class SelectParameter {
    public static List<String> parse(String select) {
        return Arrays.asList(select.split(","));
    }
}