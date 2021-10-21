package katas.mcarrillo;

public class ReverseWords {
    public static String reverseWords(final String original)
    {
  String palabra = "";
  String[] cadena = original.split(" ");
  String PalabraAux = "";
        for (int i = 0; i < cadena.length ; i++) {
            PalabraAux = cadena[i];
            for (int j = PalabraAux.length() - 1; j >= 0 ; j--)
                palabra +=  PalabraAux.charAt(j);
                palabra+= " ";

        }
        return palabra.trim();
    }
}
