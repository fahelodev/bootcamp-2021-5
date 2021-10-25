/*
Alternating Case
Definir una funcion que convierta cada letra mayuscula en minuscula y viceversa.
Teniendo en cuenta que los caracteres numericos deben quedar tal cual estan.

PreCondiciones:
1.la funcion solo debe convertir letras minusculas en mayusculas.
2. La funcion solo debe convertir letras mayusculas en minusculas.

Acciones:
1. DatoEntradaRetornarMayus
2. DatoEntradaRetornarMinus
3. DatoEntradaRetornarAlternativeMinusMayus
4. DatoEntradaRetornarNumericosNoAlterados
5. DatoEntradaRetornarNumericosNoAlteradosMayus

PostCondiciones:
DATO > ENTRADA > SALIDA

 */
package katas.kmollecundo;

public class alternatingCase {
    public static String toAlternativeString(String string) {

    StringBuilder resultado = new StringBuilder();
     // Recorre el ciclo foreach de la cadena de caracter convertido a un arreglo de caracteres
    for (char c : string.toCharArray()){
        if(Character.isUpperCase(c)){
            resultado.append(Character.toLowerCase(c)); // metodo append para mantener al final los chars en el buffer
        }else {
            resultado.append(Character.toUpperCase(c));
        }
    }
        return resultado.toString();
    }

}