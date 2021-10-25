package katas.bfuentes;

public class StringUtils {
    public static String toAlternativeString(String string) {
        String result = "";
        for (char c : string.toCharArray()) {
            if(Character.isUpperCase(c)) {
                result += Character.toLowerCase(c);
            } else {
                result += Character.toUpperCase(c);
            }
        }
        return result;
    }
}


 /*   String laCadena="Hola";
    StringBuffer nuevaCadena = new StringBuffer();
for (int i=0;i<laCadena.length; i++)
        {
        if (Character.isUpperCase(laCadena.charAt(i)) {
        nuevaCadena.append("+"+Character.toLowerCase(laCadena.charAt(i)));
        } else {
        nuevaCadena.append(laCadena.charAt(i));
        }
        }*/