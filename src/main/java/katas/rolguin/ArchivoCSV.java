package katas.rolguin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArchivoCSV {
    public String ordenamientoCSV(String sinOrdenarCSV){

        String [] separado= sinOrdenarCSV.split("\n");
        List<String[]> lista= new ArrayList<>();
        String [][] columnas;
        int lineas= separado.length;
        int col;

        for (String linea : separado){
            lista.add(linea.split(";"));
        }

        //creando las columnas a partir del arraylist lista y asi reconstruir el string entregado
        col= lista.get(0).length;
        columnas = new String[col][lineas];
        for (int i = 0; i<lineas; i++){
            String [] arreglo = lista.get(i);
            for (int k =0; k<col; k++){
                columnas[k][i]=arreglo[k];
            }
        }

        Arrays.sort(columnas,(a, b)-> a[0].toLowerCase().compareTo(b[0].toLowerCase()));

        StringBuilder resultado = new StringBuilder();
        for (int i =0;i<lineas;i++){
            for (int k =0;k<col;k++){
                resultado.append(columnas[k][i]);
                if (k !=col-1){
                    resultado.append(";");
                }
            }
            if (i !=lineas-1){
                resultado.append("\n");
            }

        }

        return resultado.toString();
    }
}
