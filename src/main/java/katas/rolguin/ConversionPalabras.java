package katas.rolguin;

public class ConversionPalabras {

    public static String reverseWords(final String palabra)
    {
        String [] palabras   = palabra.split(" ");
        String alrevesPalabras = " ";

        for (int i = 0; i<palabras.length;  i++){
            String pal = palabras[i];
            String alrevesPal=" ";
            for (int j=pal.length()-1;j>=0;j--){
                alrevesPal  = alrevesPal + pal.charAt(j);
            }
            alrevesPalabras=alrevesPalabras + alrevesPal;
        }

        return alrevesPalabras.trim();
    }
}
