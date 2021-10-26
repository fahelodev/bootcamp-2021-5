package katas.gortego;

public class DigPow {
    public long digPow(int n, int p) {
        char[] numbers = Integer.toString(n).toCharArray();
        int acum = 0;

        for (char number: numbers ) {
            acum += Math.pow(Character.getNumericValue(number),p++);
        }

        if( acum%n == 0){
            return acum/n;
        }

        return -1;
    }
}
