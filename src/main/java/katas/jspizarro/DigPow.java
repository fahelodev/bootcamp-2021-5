package katas.jspizarro;

public class DigPow {

    public static long digPow(int n, int p) {
        String[] digitos = Integer.toString(n).split("");
        double sumatoria = 0;
        long enteroK = 0;

        for(int i = 0; i < digitos.length; i++) {
            sumatoria = sumatoria + Math.pow(Double.parseDouble(digitos[i]),(p+i));
        }

        if(sumatoria % n == 0) {
            enteroK = (long) (sumatoria / n);
        }else enteroK = -1;

        return (long) enteroK;
    }

}
