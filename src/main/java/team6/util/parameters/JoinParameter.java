package team6.util.parameters;

public class JoinParameter {
    public static String[] parse(String join) {
        if (join == null) {
            return null;
        }
        return join.split(",");
    }
}
