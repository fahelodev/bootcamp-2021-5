package katas.mrivera;

import java.util.ArrayList;

public class SortCsvColumns {
    public static String sortCsvColumns(String csvFileContent)
    {
        //Obtiene las filas
        String[] filas = csvFileContent.split("[\\n]+");

        ArrayList<String[]> contenido = new ArrayList<String[]>();

        //Separa las columnas por cada fila
        for (String fila: filas) {
            contenido.add(fila.split("[;]"));
        }

        ordenar(contenido);

        //Vuelve a unir las columnas
        for(int i = 0; i < filas.length; i++){
            filas[i] = String.join(";", contenido.get(i));
        }

        //Vuelve a unir el texto
        String resultado = String.join("\n", filas);

        return resultado;

    }

    private static void ordenar(ArrayList<String[]> valores){
        //Obtiene la longitud de la cabecera
        int length = valores.get(0).length;

        for(int i = 0; i < length - 1;  i++){
            intercambio(valores,i);
        }
    }

    private static ArrayList<String[]> intercambio( ArrayList<String[]> valores, int columna ) {
        if (columna < 0)
            return valores;

        //Verifica los valores de la cabecera, si es mayor al elemento siguiente.
        if(valores.get(0)[columna].toLowerCase().compareTo(valores.get(0)[columna+1].toLowerCase()) > 0){

            //Realiza el intercambio de columnas por cada fila
            for (String[] fila: valores) {
                String aux = fila[columna];
                fila[columna] = fila[columna + 1];
                fila[columna + 1] = aux;
            }

            //Vuelve a verificar si se puede hacer otro intercambio
            return intercambio(valores, columna - 1);
        }
        else
            return valores;
    }
}
