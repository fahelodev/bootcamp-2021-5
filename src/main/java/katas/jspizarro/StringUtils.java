package katas.jspizarro;

public class StringUtils {

    public static String toAlternativeString(String string) {
        char[] words = string.toCharArray();
        String convertedWord = "";

        for (char word:words) {
            if (Character.isUpperCase(word))
                convertedWord += Character.toLowerCase(word);
            else
                convertedWord += Character.toUpperCase(word);
        }

        return convertedWord;
    }
}

