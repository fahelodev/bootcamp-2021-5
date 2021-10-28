package katas.bbarreto;

public class CountingDuplicates {

    public static int duplicateCount(String text) {

        //Guardar el string en un array de caracteres
        int count = 0;

        //Resetear el texto a minuscula y guardarlo
        String textoCaseSensitive = text.toLowerCase();
        //Validar si el texto ingresado cumple formato Alfanumerico
        boolean cumpleaAlfanumerico = textoCaseSensitive.matches("^[a-zA-Z0-9]+$");
        char[] palabra = textoCaseSensitive.toCharArray();

        if(cumpleaAlfanumerico){
            StringBuilder caracteresDuplicados = new StringBuilder();
            //Encontrar y comparar los duplicados
            for (int i = 0; i < palabra.length; i++) {

                for (int j = i+1; j < palabra.length; j++) {

                    if(palabra[i] == palabra[j] && !caracteresDuplicados.toString().contains(String.valueOf(palabra[i]))){
                        caracteresDuplicados.append(String.valueOf(palabra[i]));
                        count++;
                        break;
                    }
                }
            }
            return count;
        }else{
            return -1;
        }

    }
}
