package katas.jvega;

import java.util.ArrayList;

public class OrdenarColumna {

    public  String sortCsvColumns(String csvFileContent) {
        String cadenaFinal = "";
        int bandera = 0;
        int tamañoCabecera = 0;
        int tamañoFila = 0;

        String arregloFila[] = csvFileContent.split("\n");   //obtengo las filas en un Array

        ArrayList<String[]> contenidoFilas = new ArrayList<String[]>();


        for (String filas : arregloFila) {
            contenidoFilas.add(filas.split("[;]"));  //obtengo los elementos de las filas y ñps agregp añ arrayñist
        }

        tamañoCabecera = contenidoFilas.get(0).length;  //obtengo la cantidad de columnas
        tamañoFila = arregloFila.length;

        //ordeno en forma ascendente en  base a la primera fila "nombres"
        do {

            bandera = 0;
            for (int i = 0; i < tamañoCabecera - 1; i++) {
                int valor = contenidoFilas.get(0)[i].toLowerCase().compareTo(contenidoFilas.get(0)[i + 1].toLowerCase());

                if (valor > 0) {
                    for (int j = 0; j < tamañoFila; j++) {
                        String auxiliar = contenidoFilas.get(j)[i];
                        contenidoFilas.get(j)[i] = contenidoFilas.get(j)[i + 1];
                        contenidoFilas.get(j)[i + 1] = auxiliar;
                        bandera = 1;
                    }
                }

            }
        } while (bandera == 1);


        for (int i = 0; i < tamañoFila; i++) {
            arregloFila[i] = String.join(";", contenidoFilas.get(i));   //junto los elementos para armar cada filas con el join
        }

        cadenaFinal = String.join("\n", arregloFila);


        return cadenaFinal;
    }
}
