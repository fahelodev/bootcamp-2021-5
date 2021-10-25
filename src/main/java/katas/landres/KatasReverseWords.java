package katas.landres;
public class KatasReverseWords {

    public static String reverse(String text) {

        char[] palabra = text.toCharArray();
        String palabrainvertida = "";


        for (int i = palabra.length - 1; i >= 0; i--) {
            palabrainvertida += palabra[i];


        }
        return palabrainvertida;
    }


    public static String reverseWords(final String original) {

        String[] palabras = original.split(" ");

        StringBuilder textoInvertido = new StringBuilder();


        for (int i = 0; i < palabras.length; i++) {

            String palabraInvertida = reverse(palabras[i]);

            textoInvertido.append(palabraInvertida+ " ");

        }

        if (palabras.length == 0) {
            return original;
        }
        return textoInvertido.toString().trim();
    }


}