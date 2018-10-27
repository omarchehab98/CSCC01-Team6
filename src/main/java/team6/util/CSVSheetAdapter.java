package team6.util;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVSheetAdapter extends SheetAdapter {
    /**
     * Parses a CSV sheet.
     */
    public List<HashMap<String, String>> parse(Reader reader, int headerRow, int dataStartRow) throws IOException {
        CSVReader csvReader = new CSVReader(reader);

        List<String[]> rows = csvReader.readAll();
        String[] header = rows.get(headerRow);

        List<HashMap<String, String>> parsedRows = new ArrayList<>();

        for (int i = dataStartRow; i < rows.size(); i++) {
            String[] row = rows.get(i);
            boolean isEmpty = true;
            HashMap<String, String> parsedRow = new HashMap<>();
            for (int j = 0; j < header.length && header[j].trim().length() > 0; j++) {
                String key = header[j];
                String value = row[j];
                parsedRow.put(key, value);
                if (value.trim().length() > 0) {
                    isEmpty = false;
                }
            }
            if (!isEmpty) {
                parsedRows.add(parsedRow);
            }
        }

        csvReader.close();
        return parsedRows;
    }
}