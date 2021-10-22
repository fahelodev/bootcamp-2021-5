package katas.clopez;

public class DigPow {
    public static int digPow(int n, int p) {
        int resultado = 0;
        String[] arregloNumeros = String.valueOf(n).split("");
        for (int i=0;i<arregloNumeros.length;i++){
            resultado += Math.pow(Double.parseDouble(arregloNumeros[i]),(p+i));
        }

        return resultado % n == 0 ? resultado/n : -1;
    }
}
