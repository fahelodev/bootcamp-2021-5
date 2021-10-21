package katas.alerey;

public class CountingDuplicates {

    public static int duplicateCount(String text) {

        //guardar el string en un array de caracteres
        int count =0;
        //resetar el texto a minusculas
        String textoCaseSensitive = text.toLowerCase();
        //validar si el texto ingresado cumple formato alfanumerico
        boolean cumpleAlfanumerico = textoCaseSensitive.matches("^[a-zA-Z0-9]+$");
        char[] palabra = textoCaseSensitive.toCharArray();

        if(cumpleAlfanumerico){
            StringBuilder caracteresDuplicados = new StringBuilder();
            //encontrar y comparar duplicados
            for (int i = 0; i < palabra.length ; i++) {
                for (int j = i+1; j < palabra.length ; j++) {
                    if(palabra[i] == palabra[j] && !caracteresDuplicados.toString().contains(String.valueOf(palabra[i]))){
                        caracteresDuplicados.append(String.valueOf(palabra[i]));
                        count++;
                        break;
                    }
                }
            }
        }else{
            return -1;
        }

        return count;
    }


}
