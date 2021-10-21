package katas.maraya;

import java.util.ArrayList;
import java.util.Arrays;

public class SortCsvColumns {

    public static String sortCsvColumns(String csvFileContent)
    {
    String[] filas = csvFileContent.split("\n");
    ArrayList<String[]> datos = new ArrayList<>();
    String [][] columnas;
    int fila= filas.length;
    int columna;
    for (String f : filas){
        datos.add(f.split(";"));

    }
    columna=datos.get(0).length;
    columnas = new String[columna][fila];
    for (int i =0; i<fila;i++){
        String[] arr = datos.get(i);
        for (int j =0;j<columna;j++){
            columnas[j][i] = arr[j];
        }
    }
        Arrays.sort(columnas,(a,b) -> a[0].toLowerCase().compareTo(b[0].toLowerCase()));

    //volver a armar
        StringBuilder resultado = new StringBuilder();
        for (int i=0; i<fila;i++){

            for (int j=0; j<columna;j++){

                resultado.append(columnas[j][i]);
                if(j !=columna-1) {
                    resultado.append(";");
                }

                }
                if (i !=fila -1){
                    resultado.append("\n");
                }
            }
        return resultado.toString();
        }



    }

