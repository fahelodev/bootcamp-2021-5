/*
#Ordenar las columnas de un archivo csv

Obtiene una cadena con el contenido de un archivo csv. Las columnas están separadas por punto y coma.
La primera línea contiene los nombres de las columnas.
Escriba un método que ordene las columnas por los nombres de las columnas en orden alfabético y en mayúsculas.

PreCondiciones(Before):
1. La funcion debe devolver los nombres de las columnas separadas por punto y coma.

Acciones(Test):
1. DatoEntradaRetornarCsv

PostCondiciones(After):
1. La Funcion debe devolver las columnas por los nombres en orden alfabetico y en mayúsculas.
 */
package katas.kmollecundo;
import java.util.Arrays;

public class CsvFile {
    public static String sortCsvColumns(String csvFileContent)
    {
        StringBuilder resultado = new StringBuilder();
        String[] filas = csvFileContent.split("\n");
        String[] titleCopy =filas[0].split(";");
        String[][] filasSeparadas = new String[filas.length][titleCopy.length];
        for (int i = 0; i < filas.length; i++) {
            filasSeparadas[i] = filas[i].split(";");
    }
        Arrays.sort(titleCopy,String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < titleCopy.length; i++) {
            for (int j = 0; j < titleCopy.length; j++) {
                if(titleCopy[i].equals(filasSeparadas[0][j])){
                    for (int k = 0; k < filas.length; k++) {
                        String aux = filasSeparadas[k][i];
                        filasSeparadas[k][i] = filasSeparadas[k][j];
                        filasSeparadas[k][j] = aux;
                    }
                }
            }
        }
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < titleCopy.length; j++) {
                resultado.append(filasSeparadas[i][j]);
                if(j != titleCopy.length-1) {
                    resultado.append(";");
                }
            }
            if(i != filas.length - 1){
                resultado.append("\n");
            }
        }
        return resultado.toString();
    }
}
