package katas.acabrera;

public class Solution {

    public static String reverseWords(final String original){

        String[] cadena = original.split(" ");

        if(cadena.length == 0)
            return original;

        int i = 0;
        for(String string : cadena){
            cadena[i] = new StringBuilder(string).reverse().toString();
            i++;
        }
        return String.join(" ",cadena);
    }
}
