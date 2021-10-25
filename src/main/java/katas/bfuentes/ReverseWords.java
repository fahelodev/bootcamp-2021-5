package katas.bfuentes;

public class ReverseWords {
    public static String reverseWords(final String original)
    {
        // crear variable auxiliar
        String alReves = "";
        // crear arreglo de palabras
        // palabras[0] = The
        // the = 0=7 h=1 e=2
        // palabras[1] = quick
        // palabras[2] = brown
        // palabras[3] = fox
        // palabras.length() = 4
        // palabras[palabras.length()= 4 -1] =
        String[] palabras = original.split(" ");
        // recorrer cada palabra para invertirla
        for(int i = 0; i < palabras.length; i++){
            // for para invertir  la palabra capturada
            for(int j = palabras[i].length() -1; j >= 0; j-- ){
                alReves += palabras[i].charAt(j);
            }
            if (palabras.length-1 != i){
                alReves += " ";
            }
        }
        return alReves;
    }
}
