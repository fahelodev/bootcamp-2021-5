package katas.foliva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortColumns {
    public String sortCsvColumns(String csvFileContent) {
        String[] rows = csvFileContent.split("\n");
        List<String[]> data = new ArrayList<>();
        String[][] columns;
        int r = rows.length;
        int c;

        for (String row : rows) {
            data.add(row.split(";"));
        }
        //crear columnas
        c = data.get(0).length;
        columns = new String[c][r];
        for (int i = 0; i < r; i++) {
            String[] arr = data.get(i);
            for (int j = 0; j < c; j++) {
                columns[j][i] = arr[j];
            }
        }

        Arrays.sort(columns, (a, b) -> a[0].toLowerCase().compareTo(b[0].toLowerCase()));

        //volver a armar
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result.append(columns[j][i]);
                if (j != c - 1) result.append(";");
            }
            if (i != r - 1) result.append("\n");
        }

        return result.toString();
    }
}
