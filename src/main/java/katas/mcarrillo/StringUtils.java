package katas.mcarrillo;

public class StringUtils {

    public static String toAlternativeString(String string) {
        //inicializo las variables
        char letraCambiada; //variable
        String ValorNuevo="";
        char[] ch = new char[string.length()];

        // paso cada caracter a cada espacio de mi array
        for (int i = 0; i < string.length(); i++) {
            ch[i] = string.charAt(i);
        }


        //
        for (char c : ch) {
            boolean variableNumerica = Character.isDigit(c); //condicional para preguntar si el caracter es numerico
            boolean VariableMayusc = Character.isUpperCase(c); //condicional para preguntar si el caracter es numerico
            if(variableNumerica){   //cr
                ValorNuevo = ValorNuevo + c;
            }else if(VariableMayusc){
                letraCambiada = Character.toLowerCase(c);
                ValorNuevo = ValorNuevo + letraCambiada;
            }else{
                letraCambiada = Character.toUpperCase(c);
                ValorNuevo = ValorNuevo + letraCambiada;
            }
        }
        return ValorNuevo;
    }
}
