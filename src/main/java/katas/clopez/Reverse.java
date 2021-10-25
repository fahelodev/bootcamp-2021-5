package katas.clopez;

public class Reverse {
    public static String ReverseWords(final String text){
        //contiene espacios?, solo es una palabra
        boolean space = text.matches("^[a-zA-Z0-9]+$");
        //pasar el texto a un arreglo char
        char [] frase = text.toCharArray();
        //para guardar las palabras
        StringBuilder Palabra = new StringBuilder();
        //guardar letras
        StringBuilder Caracteres = new StringBuilder();

        //el string no contiene espacios?, es una sola palabra.
        if (space){
            StringBuilder Voltear = new StringBuilder(text);
            return Voltear.reverse().toString();
        }
        else{
            for (int i=0;i<frase.length;i++){
                //es un espacio?, si es positivo rotar lo anterior y agregar espacio
                if (frase[i]==' '){
                    Palabra.append(Caracteres.reverse());
                    Palabra.append(frase[i]);
                    Caracteres.setLength(0);
                }
                //no es espacio entonces agregar al string palabra para luego girar
                else{
                    Caracteres.append(frase[i]);
                }
            }
            //ultima palabra
            Palabra.append(Caracteres.reverse());
            return Palabra.toString();
        }
    }
}