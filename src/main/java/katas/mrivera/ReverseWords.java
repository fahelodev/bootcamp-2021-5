package katas.mrivera;

public class ReverseWords {
    private static String invertirPalabra(String palabra){
        // Convertir String en array de chars
        char[] caracteres = palabra.toCharArray();

        //Último valor
        int maxIndex = caracteres.length -1;

        //mitad de la palabra
        int mitad = caracteres.length / 2;

        //invertir palabra
        for(int j=0; j<mitad; j++){
            char temp = caracteres[j];
            caracteres[j] = caracteres[maxIndex - j];
            caracteres[maxIndex - j] = temp;
        }

        return String.copyValueOf(caracteres);
    }

    public static String reverseWords(final String original)
    {
        //separar palabras por espacio
        String[] arrayPalabras = original.split("\\s");

        if(arrayPalabras.length < 1){
            return original;
        }

        StringBuilder palabras = new StringBuilder();

        //primera palabra
        palabras.append(invertirPalabra(arrayPalabras[0]));

        for(int i = 1; i < arrayPalabras.length; i++){
            palabras.append(" ").append(invertirPalabra(arrayPalabras[i]));
        }

        return palabras.toString();

    }
}
