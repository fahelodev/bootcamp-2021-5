package katas.mcarrillo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sortCsvColumns4 {
    public static String sortCsvColumns(String csvFileContent) {
        String[] filas = csvFileContent.split("\n"); //las separo quitandole la por /n puesto
        List<String[]> data = new ArrayList<>();
        String[][] columnas;
        int r = filas.length;
        int c;

        for (String row : filas) {
            data.add(row.split(";")); // a las columnas les quito el ;
        }
        //creo la columna rellenando dentro de data que fue inicializado al principio
        c = data.get(0).length;
        columnas = new String[c][r];
        for (int i = 0; i < r; i++) {
            String[] arr = data.get(i);
            for (int j = 0; j < c; j++) {
                columnas[j][i] = arr[j];
            }
        }
//las ordeno
        Arrays.sort(columnas, (a, b) -> a[0].toLowerCase().compareTo(b[0].toLowerCase()));

        //Se vuelve a armar
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result.append(columnas[j][i]);
                if (j != c - 1)  result.append(";");
            }
            if (i != r - 1) result.append("\n");
        }
//se retorna el resultado pasado a un string , el cual es el tipo de dato que nos piden
        return result.toString();
    }
}
