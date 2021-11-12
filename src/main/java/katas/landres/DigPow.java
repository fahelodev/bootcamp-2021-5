package katas.landres;

public class DigPow {

    public static long digPow(int n, int p) {
        String number = String.valueOf(n);
        int sum = 0;
        for(int i = 0; i < number.length(); i++, p++) {
            sum += Math.pow((number.charAt(i) - '0'), p);
        }
        // your code
        return (sum % n == 0)? sum/n : -1;
    }

}