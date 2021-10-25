package katas.clopez;

import java.util.Arrays;

public class CSV {
    public static String sortCsvColumns(String csvFileContent)
    {
        //variables usadas para ordenar el array final
        String aux1;
        int filas = 0;
        int var = 0;
        int salto = 0;
        // variables usadas para transformar el array
        StringBuilder entrega = new StringBuilder();
        String [] arreglo = csvFileContent.split("\n");
        StringBuilder Prueba = new StringBuilder();
        // total de filas del array modificado
        int cantN = arreglo.length;
        // agregamos ; al final de cada fila, excepto la ultima
        for (int i=0;i<arreglo.length;i++){
            Prueba.append(arreglo[i]);
            if (i<arreglo.length-1){
                Prueba.append(";");
            }
        }
        // pasamos el stringbuilder modificado a string
        String Lista = new String(Prueba.toString());
        // creamos el arreglo string
        String [] fin = Lista.split(";");
        // calculamos el largo del string y lo guardamos en la variable largoFinal
        int largoFinal = fin.length;
        // calculamos la cantidad de elementos de la primera linea
        int primeraLinea = largoFinal/cantN;
        // inicializamos un arreglo string para guardar toda la primera linea
        String [] orden = new String[primeraLinea];
        // ORDENAR ARREGLO
        // guardar los elementos de la primera linea en el arreglo string
        // sort ordena mayusculas y minusculas por separado
        // entonces debemos cambiar todas las letras a una mista forma
        for (int i=0;i<primeraLinea;i++){
            // todos los elementos del arreglo orden a minusculas
            orden[i] = fin[i].toLowerCase();
        }
        // ordenamos usando sort
        Arrays.sort(orden);
        // ordenamos la siguientes lineas dependiendo el patron de la primera
        for (int i=0;i<primeraLinea;i++){
            for (int j=1;j<primeraLinea-1;j++){
                if (orden[i].equals(fin[j].toLowerCase())){
                    while (filas < cantN){
                        aux1 = fin[i+var];
                        fin[i+var] = fin[j+var];
                        fin[j+var] = aux1;
                        filas++;
                        var = var + primeraLinea;
                    }
                    var = 0;
                    filas = 0;
                }
            }
        }
        // agregamos los elementos al string final de entrega
        for (int i=0;i<fin.length;i++){
            if (i == (primeraLinea-1)+salto){
               entrega.append(fin[i]);
               salto = salto + primeraLinea;
               if (i!=(fin.length-1)){
                   entrega.append("\n");
               }
            }
            else{
                entrega.append(fin[i]);
                entrega.append(";");
            }
        }
        return entrega.toString();
    }
}