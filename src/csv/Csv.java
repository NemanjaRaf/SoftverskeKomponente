package csv;

import java.util.ArrayList;
import java.util.List;

public class Csv {
    private List<CsvLine> csvLines = new ArrayList<>();


    public List<CsvLine> getCsvLines() {
        return csvLines;
    }

    public void setCsvLines(List<CsvLine> csvLines) {
        this.csvLines = csvLines;
    }
}
