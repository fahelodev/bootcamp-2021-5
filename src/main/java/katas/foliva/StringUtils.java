package katas.foliva;

public class StringUtils {
    public static String toAlternativeString(String text){
        StringBuilder alternativeString = new StringBuilder();
        char[] characters = text.toCharArray();


        for( char character : characters){
            if(Character.isLowerCase(character)){
                alternativeString.append( Character.toUpperCase(character));
            }else{
                alternativeString.append( Character.toLowerCase(character));
            }
        }

        return alternativeString.toString();
    }
}
