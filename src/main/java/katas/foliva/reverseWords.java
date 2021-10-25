package katas.foliva;

public class reverseWords {

    public static String reverseWordsFn(final String original)
    {
        String textWithReversedWords = original;
        String[] words = original.split(" ");

        for(String word : words){
            String reversedWord = new StringBuilder(word).reverse().toString();
            textWithReversedWords = textWithReversedWords.replace(word, reversedWord);
        }
        return textWithReversedWords;
    }
}
/*
[sihT  esac  diova   a   !elur sihT];
[Thsi  esac  diova   a   !elur Thsi]
*/