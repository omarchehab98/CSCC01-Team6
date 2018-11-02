package team6.util.parameters;

import org.springframework.data.domain.Sort;

public class SortParameter {
    public static Sort parse(String sortProperties, String sortDirection) {
        assert sortDirection == null ||
            sortDirection.equals("asc") ||
            sortDirection.equals("desc");
        return new Sort(
            sortDirection == null ||
            sortDirection.equals("asc")
            ? Sort.Direction.ASC
            : Sort.Direction.DESC,
            sortProperties.split(",")
        );
    }
}
