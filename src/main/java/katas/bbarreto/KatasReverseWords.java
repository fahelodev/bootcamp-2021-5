package katas.bbarreto;

public class KatasReverseWords {

    public static String reverse(String text) {

        char[] palabra = text.toCharArray(); //guarde los caracteres en un array
        String palabrainvertida = "";

        for (int i = palabra.length - 1; i >= 0; i--) {
            palabrainvertida += palabra[i]; //le agrega un espacio a cada letra
        }
        return palabrainvertida;
    }

    public static String reverseWords(final String original) {
        //Para respetar los espacios, crear un arreglo con todas las palabras separadas por espacios
        String[] palabras = original.split(" ");
        //
        StringBuilder textoInvertido = new StringBuilder();


        for (int i = 0; i < palabras.length; i++) {

            String palabraInvertida = reverse(palabras[i]);
            textoInvertido.append(palabraInvertida+ " ");
        }
        if (palabras.length == 0) {
            return original;
        }
        //convierto en string
        return textoInvertido.toString().trim();
    }
}