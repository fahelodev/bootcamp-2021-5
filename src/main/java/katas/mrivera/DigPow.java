package katas.mrivera;

public class DigPow {

    public static long digPow(int numero, int exponente) {

        char[] digitos = ("" + numero).toCharArray();

        int total = 0;

        //Recorre cada digito
        for(int i = 0; i < digitos.length; i++){
            int digito = Integer.parseInt(String.valueOf(digitos[i]));
            total += Math.pow(digito,exponente + i);
        }

        int k = total / numero;

        if(total == (numero * k)){
            return k;
        }else{
            return -1;
        }
    }
}