package katas.mrivera;

public class AlternatingCase {
    public static String toAlternativeString(String string) {
        // Convertir String en array de chars
        char[] caracteres = string.toCharArray();

        for(int i = 0; i < caracteres.length; i++){
            //Cambia los caracters de Mayúscula a minúscula y viceversa
            if(Character.isUpperCase(caracteres[i])){
                caracteres[i]= Character.toLowerCase(caracteres[i]);
            } else{
                caracteres[i] = Character.toUpperCase(caracteres[i]);
            }
        }

        return String.copyValueOf(caracteres);
    }
}
