package katas.kmollecundo;

public class DigPow {
    public static long digPow(int n, int p) {
        // metodo para convertir los int en cadena
        String convierteCadena = String.valueOf(n);
        int sumaGrande = 0;
        for (int i = 0; i<convierteCadena.length(); i++) {
            //utilizo metodo Math.Pow para poder elevar el exponente y retonarla como tal
            sumaGrande += Math.pow(Character.getNumericValue(convierteCadena.charAt(i)),(p + i));
        }
        if (sumaGrande % n == 0) {
            return sumaGrande / n;
        } else {
            return -1;
        }
    }
}
