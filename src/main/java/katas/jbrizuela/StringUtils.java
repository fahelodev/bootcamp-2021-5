package katas.jbrizuela;

import org.jetbrains.annotations.NotNull;

public class StringUtils {
    public String toAlternativeString(@NotNull String text){
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
