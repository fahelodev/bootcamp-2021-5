package katas.fcuevas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class sortCsvColumns {

    public static String sortCsvColumns(String csvFileContent)
    {

        String lineas[] = csvFileContent.split("\\r?\\n");
        String nombresColumnas [] = lineas[0].split(";");

        HashMap<String, ArrayList<String>> filasPorLetra = new HashMap<String,ArrayList<String>>();

        for(int i=0;i<nombresColumnas.length;i++){
            ArrayList<String> contenidoDeColumnas = new ArrayList <String>();
            for (int j=1;j<lineas.length;j++){
                String columnas []= lineas[j].split(";");
                contenidoDeColumnas.add(columnas[i]);
            }
            filasPorLetra.put(nombresColumnas[i], contenidoDeColumnas);
        }


        String[] nombresColumnasOrdenadas = intercambioPalabras(nombresColumnas);

        String resultado = "";

        for(int i= 0; i< nombresColumnasOrdenadas.length; i++){
            if((i-1)>=0)
                resultado = resultado + ";";
            resultado= resultado + nombresColumnasOrdenadas[i];

            if(i== nombresColumnasOrdenadas.length - 1)
                resultado = resultado + "\n";
        }

        for(int i = 1; i < lineas.length; i++ ){
            String line = "";
            for(int j= 0; j<nombresColumnasOrdenadas.length; j++){
                if((j-1)>=0)
                    line = line + ";";

                line = line + filasPorLetra.get(nombresColumnasOrdenadas[j]).get(i-1);
            }
            if((i+1)<lineas.length)
                line=line +"\n";

            resultado = resultado + line;
        }

        return resultado;
    }

    public static String[] intercambioPalabras(String lista[]){

        //Usamos un bucle anidado
        for(int i=0;i<(lista.length-1);i++){
            for(int j=i+1;j<lista.length;j++){
                if(lista[i].compareToIgnoreCase(lista[j])>0){
                    //Intercambiamos valores
                    String variableauxiliar=lista[i];
                    lista[i]=lista[j];
                    lista[j]=variableauxiliar;

                }
            }
        }

        return lista;
    }

}

