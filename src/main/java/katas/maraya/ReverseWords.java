package katas.maraya;

public class ReverseWords {
    public static String reverseWords(final String original)
    {
        //Separar cadenas con split (con un espacio)
        String[] cadena= original.split(" ");
        String palabraAlreves = "";
        String palabraN = "";


        for(int i =0; i<cadena.length;i++)
        {
             palabraN = cadena[i];
            for(int j = palabraN.length() - 1; j >= 0; j--)
                //charAt revisa letra por letra
                palabraAlreves += palabraN.charAt(j);

            palabraAlreves += " ";
        }
// trim para quitar caracter inical y final o tambien puedo usar substring
        return palabraAlreves.trim();
    }

}
