package team6.util;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

public abstract class SheetAdapter {
    /**
     * Parses a sheet document and returns a list of hashmaps.
     * 
     * Each hashmap in the list is a row in the sheet, where the keys in the
     * hashmap correspond to the column's name found in the sheet's row
     * `headerRow`.
     * 
     * @param reader
     * @param headerRow 0 based index of the sheet's header
     * @param dataStartRow 0 based index of the first data row in the sheet
     * @return
     * @throws IOException
     */
    public abstract List<HashMap<String, String>> parse(Reader reader, int headerRow, int dataStartRow) throws IOException;

    /**
     * Calls parse(reader, headerRow, headerRow + 1);
     * 
     * @param reader
     * @param headerRow 0 based index of the sheet's header
     * @return
     * @throws IOException
     */
    public List<HashMap<String, String>> parse(Reader reader, int headerRow) throws IOException {
        return this.parse(reader, headerRow, headerRow + 1);
    }

    /**
     * Calls parse(reader, 0, 1);
     * 
     * @param reader
     * @return
     * @throws IOException
     */
    public List<HashMap<String, String>> parse(Reader reader) throws IOException {
        return this.parse(reader, 0, 1);
    }
}