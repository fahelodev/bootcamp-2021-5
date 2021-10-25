package katas.jvega;

public class StringUtils {

    public  String toAlternativeString(String string) {
       char arregloPalabra[]; //declaro un arreglo de caracteres
       String palabra="";
       arregloPalabra=string.toCharArray(); //convierto el string  a chararray para  asignar al arreglo


        for (int i=0; i<arregloPalabra.length;i++){ //recorro el arreglo de caracteres

            if (Character.isUpperCase(arregloPalabra[i])){//pregunto si cada caracter esta en mayuscula
                arregloPalabra[i] = Character.toLowerCase(arregloPalabra[i]); //en caso afirmativo, lo convierto a minuscula
            }
            else if(Character.isLowerCase(arregloPalabra[i])){
                arregloPalabra[i] = Character.toUpperCase(arregloPalabra[i]);

            }

        }
        palabra= String.valueOf(arregloPalabra); // lo paso a un string porque la funcion retorna un string



        return palabra;
    }
}
