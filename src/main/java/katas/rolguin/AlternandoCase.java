package katas.rolguin;

public class AlternandoCase {

    public static String ConvertirLetras(String palabra){
        char [] cadena= palabra.toCharArray();
        char caracter;
        for( int i = 0; i < cadena.length; i++) {
            if(Character.isUpperCase(cadena[i])) {
                caracter = Character.toLowerCase(cadena[i]);
                cadena[i]=caracter;
            } else {
                caracter = Character.toUpperCase(cadena[i]);
                cadena[i]=caracter;
            }
        }



        return new String(cadena);
    }


}
