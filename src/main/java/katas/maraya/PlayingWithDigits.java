package katas.maraya;

public class PlayingWithDigits {


    public static long digPow(int n, int p) {
        // your code
        int aux = 0;
        String [] numero = String.valueOf(n).split("");
        for (int i =0;i<numero.length;i++){

            aux += Math.pow(Double.parseDouble(numero[i]), (p+i));

        }

        return aux % n ==0 ? aux / n :-1;
    }

}
