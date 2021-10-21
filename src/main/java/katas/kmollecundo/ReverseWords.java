package katas.kmollecundo;

public class ReverseWords {
    public static String wordReverse(final String original){
        String[] CorrectString = original.split(" ");
        String ReverseString = "";
        for (int i = 0; i< CorrectString.length; i++)
        {
            String word = CorrectString[i];
            String ReverseWord = "";
            for (int j = word.length()-1; j >=0; j--) {

                ReverseWord = ReverseWord + word.charAt(j);
            }
                ReverseString = ReverseString + ReverseWord + " ";
        }
        return ReverseString.trim();
    }
}
