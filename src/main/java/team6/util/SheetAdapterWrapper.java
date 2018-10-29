package team6.util;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

public class SheetAdapterWrapper {
    private HashMap<String, SheetAdapter> typeToSheetAdapter;

    public SheetAdapterWrapper() {
        this.typeToSheetAdapter = new HashMap<>();
        CSVSheetAdapter csvSheetAdapter = new CSVSheetAdapter();
        typeToSheetAdapter.put("csv", csvSheetAdapter);
        typeToSheetAdapter.put(".csv", csvSheetAdapter);
        typeToSheetAdapter.put("text/csv", csvSheetAdapter);
    }

    public List<HashMap<String, String>> parse(String type, Reader reader,
        int headerRow, int dataStartRow) throws IOException {
        return this.getSheetAdapterByType(type).parse(reader, headerRow, dataStartRow);
    }

    public List<HashMap<String, String>> parse(String type, Reader reader,
        int headerRow) throws IOException {
        return this.getSheetAdapterByType(type).parse(reader, headerRow);
    }

    public List<HashMap<String, String>> parse(String type, Reader reader)
        throws IOException {
        return this.getSheetAdapterByType(type).parse(reader);
    }

    public SheetAdapter getSheetAdapterByType(String type) {
        if (!typeToSheetAdapter.containsKey(type)) {
            throw new IllegalArgumentException(String.format(
                "invalid type: %s", type));
        }
        return typeToSheetAdapter.get(type);
    }
}