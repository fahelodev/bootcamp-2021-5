package katas.jspizarro;

public class kataReverseWords {

        public static String reverseWords(final String original) {
                String [] arreglo = original.split(" ");
                String palabraInv = "";
                if(arreglo.length==0)
                        return original;
                for (String palabra:arreglo) {
                        StringBuilder entrada = new StringBuilder();
                        palabraInv += entrada.append(palabra).reverse()+" ";
                }

                return palabraInv.replaceFirst(".$","");
        }
}