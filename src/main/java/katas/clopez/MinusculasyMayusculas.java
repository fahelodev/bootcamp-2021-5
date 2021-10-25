package katas.clopez;

public class MinusculasyMayusculas {
    public static String toAlternativeString(String string){
        //tomamos el string y lo pasamos a un arreglo char
        char [] frase = string.toCharArray();
        //inicializamos los stringbuilder auxiliares
        StringBuilder Caracter = new StringBuilder();
        StringBuilder Oracion = new StringBuilder();
        for (int i=0;i<string.length();i++){
            Caracter.append((frase[i]));
            boolean Letra = Caracter.toString().matches("^[a-zA-Z]+$");
            if (Letra){
                if (Caracter.toString().equals(Caracter.toString().toLowerCase())){
                    frase [i] = Character.toUpperCase(frase[i]);
                }
                else{
                    frase [i] = Character.toLowerCase(frase[i]);
                }
            }
            Caracter.setLength(0);
        }
        for (int j=0;j<string.length();j++){
            Oracion.append((frase[j]));
        }
        return Oracion.toString();
    }
}