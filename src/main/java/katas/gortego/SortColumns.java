package katas.gortego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortColumns {
    public static String sortCsvColumns(String csvFileContent) {
        String[] filas = csvFileContent.split("\n");
        List<String[]> datos = new ArrayList<>();
        String[][] columnas;
        int r = filas.length;
        int c;

        for (String f :filas ) {
            datos.add(f.split(";"));
        }

        c = datos.get(0).length;
        columnas = new String[c][r];
        for (int i = 0; i < r; i++) {
            String[] arr = datos.get(i);
            for (int j = 0; j < c; j++) {
                columnas[j][i] = arr[j];
            }
        }
        Arrays.sort(columnas, (a, b) -> a[0].toLowerCase().compareTo(b[0].toLowerCase()));
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                resultado.append(columnas[j][i]);
                if (j != c - 1) resultado.append(";");
            }
            if (i != r - 1) resultado.append("\n");
        }
        return resultado.toString();
    }
}