package katas.maraya;

public class AlternatingCase {

    public static String toAlternativeString(String string) {
        //devuelve un arreglo de caracteres
       char[] cadenaChar = string.toCharArray();
       String resultado="";
       //recorrer arreglo y veriff¿icar si es mayuscula y minuscula por caracter
        for (int i=0 ; i< cadenaChar.length;i++){
            // si el carcter es en minuscula guardar como mayuscula
           if (Character.isLowerCase(cadenaChar[i])){

               cadenaChar[i]=Character.toUpperCase(cadenaChar[i]);
               resultado+=cadenaChar[i];
           }else {
   // si es mayuscula guardar como minuscula
               cadenaChar[i]= Character.toLowerCase(cadenaChar[i]);
               resultado+=cadenaChar[i];
           }


        }

        return resultado;
        // your code here!
    }
}
