package team6.util;

public class JSONStringHelper {
    String str;
    public JSONStringHelper(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        if (str != null) {
            return '"' + str.replaceAll("\"", "\\\"") + '"';
        } else {
            return "null";
        }
    }
}