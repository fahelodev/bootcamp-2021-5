package katas.bfuentes;

public class DigPow {

    public static long digPow(int n, int p) {
        // your code
        String temp = Integer.toString(n);
        int[] numbers = new int[temp.length()];
        int resultado = 0;
        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
            resultado+= Math.pow(numbers[i],p+i);
        }
        int k = resultado/n;

        return n*k == resultado ? k : -1 ;

    }

}
