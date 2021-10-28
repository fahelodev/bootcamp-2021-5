package katas.bbarreto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortColumns {
    public static String sortCsvColumns(String csvFileContent) {
        String[] rows = csvFileContent.split("\n");
        List<String[]> data = new ArrayList<>();
        String[][] columns;
        int filas = rows.length;
        int columnas;

        for (String row : rows) {
            data.add(row.split(";"));
        }
        //crear columnas
        columnas = data.get(0).length;
        columns = new String[columnas][filas];
        for (int i = 0; i < filas; i++) {
            String[] arr = data.get(i);
            for (int j = 0; j < columnas; j++) {
                columns[j][i] = arr[j];
            }
        }

        Arrays.sort(columns, (a, b) -> a[0].toLowerCase().compareTo(b[0].toLowerCase()));

        //Ordenar las columnas y las filas
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                result.append(columns[j][i]);
                if (j != columnas - 1) result.append(";");
            }
            if (i != filas - 1) result.append("\n");
        }

        return result.toString();
    }
}